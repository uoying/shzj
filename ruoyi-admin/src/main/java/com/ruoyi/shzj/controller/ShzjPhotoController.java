package com.ruoyi.shzj.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruoyi.shzj.domain.ShzjPicture;
import com.ruoyi.shzj.util.QiniuUpload;
import com.ruoyi.shzj.util.VariableName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.shzj.domain.ShzjPhoto;
import com.ruoyi.shzj.service.IShzjPhotoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 照片信息Controller
 * 
 * @author ruoyi
 * @date 2020-07-30
 */
@Controller
@RequestMapping("/shzj/photo")
public class ShzjPhotoController extends BaseController
{
    private String prefix = "shzj/photo";

    @Autowired
    private IShzjPhotoService shzjPhotoService;

    @RequiresPermissions("shzj:photo:view")
    @GetMapping()
    public String photo()
    {
        return prefix + "/photo";
    }

    @RequestMapping("/photoList")
    @ResponseBody
    public AjaxResult photoList(@RequestParam("userId")int userId){
        ShzjPhoto shzjPhoto=new ShzjPhoto();
        shzjPhoto.setUserId(userId);
        List<ShzjPhoto> shzjPhotos = shzjPhotoService.selectShzjPhotoList(shzjPhoto);
        for(ShzjPhoto i:shzjPhotos){
            i.setPhotoUrl(VariableName.domain+i.getPhotoUrl());
        }
        return AjaxResult.success(shzjPhotos);
    }
    @RequestMapping("/addPhoto")
    @ResponseBody
    public AjaxResult addPhoto(@RequestParam("userId")int userId, HttpServletRequest request, HttpServletResponse response){
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获得文件：
        MultipartFile imgFile= multipartRequest.getFile("photos");
        QiniuUpload qiniuUpload=new QiniuUpload();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String fileName=imgFile.toString().split("@")[1]+formatter.format(date);
        try {
            qiniuUpload.updateFile(imgFile,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ShzjPhoto shzjPhoto=new ShzjPhoto();
        shzjPhoto.setUserId(userId);
        shzjPhoto.setPhotoUrl("/"+fileName);
        shzjPhotoService.insertShzjPhoto(shzjPhoto);
        return success(VariableName.domain+shzjPhoto.getPhotoUrl());
    }
    @RequestMapping("/deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(){
        List<ShzjPhoto> shzjPhotos=shzjPhotoService.selectShzjPhotoList(null);
        for (ShzjPhoto shzjPhoto:shzjPhotos){
            shzjPhotoService.deleteShzjPhotoById(shzjPhoto.getPhotoId());
            QiniuUpload.deletePic(shzjPhoto.getPhotoUrl().substring(1));
        }
        return success();
    }
    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delete(@RequestParam("url")String url){
        ShzjPhoto shzjPhoto=new ShzjPhoto();
        shzjPhoto.setPhotoUrl(url);
        QiniuUpload.deletePic(shzjPhoto.getPhotoUrl().substring(1));
        return success(shzjPhotoService.deleteShzjPhotoById(shzjPhotoService.selectShzjPhotoList(shzjPhoto).get(0).getPhotoId())+"");
    }
    /**
     * 查询照片信息列表
     */
    @RequiresPermissions("shzj:photo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjPhoto shzjPhoto)
    {
        startPage();
        List<ShzjPhoto> list = shzjPhotoService.selectShzjPhotoList(shzjPhoto);
        return getDataTable(list);
    }

    /**
     * 导出照片信息列表
     */
    @RequiresPermissions("shzj:photo:export")
    @Log(title = "照片信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjPhoto shzjPhoto)
    {
        List<ShzjPhoto> list = shzjPhotoService.selectShzjPhotoList(shzjPhoto);
        ExcelUtil<ShzjPhoto> util = new ExcelUtil<ShzjPhoto>(ShzjPhoto.class);
        return util.exportExcel(list, "photo");
    }

    /**
     * 新增照片信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存照片信息
     */
    @RequiresPermissions("shzj:photo:add")
    @Log(title = "照片信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjPhoto shzjPhoto)
    {
        return toAjax(shzjPhotoService.insertShzjPhoto(shzjPhoto));
    }

    /**
     * 修改照片信息
     */
    @GetMapping("/edit/{photoId}")
    public String edit(@PathVariable("photoId") Integer photoId, ModelMap mmap)
    {
        ShzjPhoto shzjPhoto = shzjPhotoService.selectShzjPhotoById(photoId);
        mmap.put("shzjPhoto", shzjPhoto);
        return prefix + "/edit";
    }

    /**
     * 修改保存照片信息
     */
    @RequiresPermissions("shzj:photo:edit")
    @Log(title = "照片信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjPhoto shzjPhoto)
    {
        return toAjax(shzjPhotoService.updateShzjPhoto(shzjPhoto));
    }

    /**
     * 删除照片信息
     */
    @RequiresPermissions("shzj:photo:remove")
    @Log(title = "照片信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjPhotoService.deleteShzjPhotoByIds(ids));
    }
}
