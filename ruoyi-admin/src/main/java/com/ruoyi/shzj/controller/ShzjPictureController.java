package com.ruoyi.shzj.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.shzj.util.QiniuUpload;
import com.ruoyi.shzj.util.VariableName;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.shzj.domain.ShzjPicture;
import com.ruoyi.shzj.service.IShzjPictureService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 图片信息Controller
 * 
 * @author ruoyi
 * @date 2020-07-13
 */
@Controller
@RequestMapping("/shzj/picture")
public class ShzjPictureController extends BaseController
{
    private String prefix = "shzj/picture";

    @Autowired
    private IShzjPictureService shzjPictureService;

    @RequiresPermissions("shzj:picture:view")
    @GetMapping()
    public String picture()
    {
        return prefix + "/picture";
    }

    /**
     * 查询图片信息列表
     */
    @RequiresPermissions("shzj:picture:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjPicture shzjPicture)
    {
        startPage();
        List<ShzjPicture> list = shzjPictureService.selectShzjPictureList(shzjPicture);
        for (ShzjPicture i :
                list) {
            i.setPicUrl(VariableName.domain + i.getPicUrl());
        }
        return getDataTable(list);
    }

    /**
     * 导出图片信息列表
     */
    @RequiresPermissions("shzj:picture:export")
    @Log(title = "图片信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjPicture shzjPicture)
    {
        List<ShzjPicture> list = shzjPictureService.selectShzjPictureList(shzjPicture);
        ExcelUtil<ShzjPicture> util = new ExcelUtil<ShzjPicture>(ShzjPicture.class);
        return util.exportExcel(list, "picture");
    }

    /**
     * 新增图片信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存图片信息
     */
    @RequiresPermissions("shzj:picture:add")
    @Log(title = "图片信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HttpServletRequest request, HttpServletResponse response)
    {
        Map<String,Object> result= new HashMap<String, Object>();
        // 转型为MultipartHttpRequest：
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获得文件：
        MultipartFile imgFile= multipartRequest.getFile("pictures");
        QiniuUpload qiniuUpload=new QiniuUpload();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String fileName=imgFile.toString().split("@")[1]+formatter.format(date);
        try {
            qiniuUpload.updateFile(imgFile,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ShzjPicture shzjPicture=new ShzjPicture();
        shzjPicture.setPicUrl("/"+fileName);
        return toAjax(shzjPictureService.insertShzjPicture(shzjPicture));
    }

    /**
     * 修改图片信息
     */
    @GetMapping("/edit/{picId}")
    public String edit(@PathVariable("picId") Integer picId, ModelMap mmap)
    {
        ShzjPicture shzjPicture = shzjPictureService.selectShzjPictureById(picId);
        mmap.put("shzjPicture", shzjPicture);
        return prefix + "/edit";
    }

    /**
     * 修改保存图片信息
     */
    @RequiresPermissions("shzj:picture:edit")
    @Log(title = "图片信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjPicture shzjPicture)
    {
        return toAjax(shzjPictureService.updateShzjPicture(shzjPicture));
    }

    /**
     * 删除图片信息
     */
    @RequiresPermissions("shzj:picture:remove")
    @Log(title = "图片信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjPictureService.deleteShzjPictureByIds(ids));
    }
}
