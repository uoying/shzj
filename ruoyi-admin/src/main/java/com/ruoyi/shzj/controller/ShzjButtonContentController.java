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
import com.ruoyi.shzj.domain.ShzjButtonContent;
import com.ruoyi.shzj.service.IShzjButtonContentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 按钮内容Controller
 * 
 * @author ruoyi
 * @date 2020-08-25
 */
@Controller
@RequestMapping("/shzj/buttonContent")
public class ShzjButtonContentController extends BaseController
{
    private String prefix = "shzj/buttonContent";

    @Autowired
    private IShzjButtonContentService shzjButtonContentService;

    @RequiresPermissions("shzj:buttonContent:view")
    @GetMapping()
    public String buttonContent()
    {
        return prefix + "/buttonContent";
    }

    /**
     * 查询按钮内容列表
     */
    @RequiresPermissions("shzj:buttonContent:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjButtonContent shzjButtonContent)
    {
        startPage();
        List<ShzjButtonContent> list = shzjButtonContentService.selectShzjButtonContentList(shzjButtonContent);
        return getDataTable(list);
    }

    /**
     * 导出按钮内容列表
     */
    @RequiresPermissions("shzj:buttonContent:export")
    @Log(title = "按钮内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjButtonContent shzjButtonContent)
    {
        List<ShzjButtonContent> list = shzjButtonContentService.selectShzjButtonContentList(shzjButtonContent);
        ExcelUtil<ShzjButtonContent> util = new ExcelUtil<ShzjButtonContent>(ShzjButtonContent.class);
        return util.exportExcel(list, "buttonContent");
    }

    /**
     * 新增按钮内容
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存按钮内容
     */
    @RequiresPermissions("shzj:buttonContent:add")
    @Log(title = "按钮内容", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjButtonContent shzjButtonContent)
    {
        return toAjax(shzjButtonContentService.insertShzjButtonContent(shzjButtonContent));
    }

    /**
     * 修改按钮内容
     */
    @GetMapping("/edit/{buttonConId}")
    public String edit(@PathVariable("buttonConId") Integer buttonConId, ModelMap mmap)
    {
        ShzjButtonContent shzjButtonContent = shzjButtonContentService.selectShzjButtonContentById(buttonConId);
        mmap.put("shzjButtonContent", shzjButtonContent);
        return prefix + "/edit";
    }

    /**
     * 修改保存按钮内容
     */
    @RequiresPermissions("shzj:buttonContent:edit")
    @Log(title = "按钮内容", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjButtonContent shzjButtonContent)
    {
        return toAjax(shzjButtonContentService.updateShzjButtonContent(shzjButtonContent));
    }

    /**
     * 删除按钮内容
     */
    @RequiresPermissions("shzj:buttonContent:remove")
    @Log(title = "按钮内容", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjButtonContentService.deleteShzjButtonContentByIds(ids));
    }
}
