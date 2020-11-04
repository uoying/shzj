package com.ruoyi.shzj.controller;

import java.util.List;

import com.ruoyi.shzj.domain.DTO.ImageDTO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.shzj.domain.ShzjImage;
import com.ruoyi.shzj.service.IShzjImageService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 图像识别:图片Controller
 * 
 * @author ruoyi
 * @date 2020-10-09
 */
@Controller
@RequestMapping("/shzj/image")
public class ShzjImageController extends BaseController
{
    private String prefix = "shzj/image";

    @Autowired
    private IShzjImageService shzjImageService;

    @RequiresPermissions("shzj:image:view")
    @GetMapping()
    public String image()
    {
        return prefix + "/image";
    }

    /**
     * 查询图像识别:图片列表
     */
    @RequiresPermissions("shzj:image:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjImage shzjImage)
    {
        startPage();
        List<ImageDTO> list = shzjImageService.selectShzjImage();
        return getDataTable(list);
    }

    /**
     * 导出图像识别:图片列表
     */
    @RequiresPermissions("shzj:image:export")
    @Log(title = "图像识别:图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjImage shzjImage)
    {
        List<ShzjImage> list = shzjImageService.selectShzjImageList(shzjImage);
        ExcelUtil<ShzjImage> util = new ExcelUtil<ShzjImage>(ShzjImage.class);
        return util.exportExcel(list, "image");
    }

    /**
     * 新增图像识别:图片
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存图像识别:图片
     */
    @RequiresPermissions("shzj:image:add")
    @Log(title = "图像识别:图片", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjImage shzjImage)
    {
        return toAjax(shzjImageService.insertShzjImage(shzjImage));
    }

    /**
     * 修改图像识别:图片
     */
    @GetMapping("/edit/{imageId}")
    public String edit(@PathVariable("imageId") Integer imageId, ModelMap mmap)
    {
        ShzjImage shzjImage = shzjImageService.selectShzjImageById(imageId);
        mmap.put("shzjImage", shzjImage);
        return prefix + "/edit";
    }

    /**
     * 修改保存图像识别:图片
     */
    @RequiresPermissions("shzj:image:edit")
    @Log(title = "图像识别:图片", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjImage shzjImage)
    {
        return toAjax(shzjImageService.updateShzjImage(shzjImage));
    }

    /**
     * 删除图像识别:图片
     */
    @RequiresPermissions("shzj:image:remove")
    @Log(title = "图像识别:图片", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjImageService.deleteShzjImageByIds(ids));
    }
}
