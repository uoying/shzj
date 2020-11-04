package com.ruoyi.shzj.controller;

import java.util.List;
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
import com.ruoyi.shzj.domain.ShzjImageContent;
import com.ruoyi.shzj.service.IShzjImageContentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 图像识别:图片信息Controller
 * 
 * @author ruoyi
 * @date 2020-10-09
 */
@Controller
@RequestMapping("/shzj/ImageContent")
public class ShzjImageContentController extends BaseController
{
    private String prefix = "shzj/ImageContent";

    @Autowired
    private IShzjImageContentService shzjImageContentService;

    @RequiresPermissions("shzj:ImageContent:view")
    @GetMapping()
    public String ImageContent()
    {
        return prefix + "/ImageContent";
    }

    /**
     * 查询图像识别:图片信息列表
     */
    @RequiresPermissions("shzj:ImageContent:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjImageContent shzjImageContent)
    {
        startPage();
        List<ShzjImageContent> list = shzjImageContentService.selectShzjImageContentList(shzjImageContent);
        return getDataTable(list);
    }

    /**
     * 导出图像识别:图片信息列表
     */
    @RequiresPermissions("shzj:ImageContent:export")
    @Log(title = "图像识别:图片信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjImageContent shzjImageContent)
    {
        List<ShzjImageContent> list = shzjImageContentService.selectShzjImageContentList(shzjImageContent);
        ExcelUtil<ShzjImageContent> util = new ExcelUtil<ShzjImageContent>(ShzjImageContent.class);
        return util.exportExcel(list, "ImageContent");
    }

    /**
     * 新增图像识别:图片信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存图像识别:图片信息
     */
    @RequiresPermissions("shzj:ImageContent:add")
    @Log(title = "图像识别:图片信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjImageContent shzjImageContent)
    {
        return toAjax(shzjImageContentService.insertShzjImageContent(shzjImageContent));
    }

    /**
     * 修改图像识别:图片信息
     */
    @GetMapping("/edit/{imageContentId}")
    public String edit(@PathVariable("imageContentId") Integer imageContentId, ModelMap mmap)
    {
        ShzjImageContent shzjImageContent = shzjImageContentService.selectShzjImageContentById(imageContentId);
        mmap.put("shzjImageContent", shzjImageContent);
        return prefix + "/edit";
    }

    /**
     * 修改保存图像识别:图片信息
     */
    @RequiresPermissions("shzj:ImageContent:edit")
    @Log(title = "图像识别:图片信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjImageContent shzjImageContent)
    {
        return toAjax(shzjImageContentService.updateShzjImageContent(shzjImageContent));
    }

    /**
     * 删除图像识别:图片信息
     */
    @RequiresPermissions("shzj:ImageContent:remove")
    @Log(title = "图像识别:图片信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjImageContentService.deleteShzjImageContentByIds(ids));
    }
}
