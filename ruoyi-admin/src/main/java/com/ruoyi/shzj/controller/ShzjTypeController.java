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
import com.ruoyi.shzj.domain.ShzjType;
import com.ruoyi.shzj.service.IShzjTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 类别Controller
 * 
 * @author ruoyi
 * @date 2020-07-13
 */
@Controller
@RequestMapping("/shzj/type")
public class ShzjTypeController extends BaseController
{
    private String prefix = "shzj/type";

    @Autowired
    private IShzjTypeService shzjTypeService;

    @RequiresPermissions("shzj:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询类别列表
     */
    @RequiresPermissions("shzj:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjType shzjType)
    {
        startPage();
        List<ShzjType> list = shzjTypeService.selectShzjTypeList(shzjType);
        return getDataTable(list);
    }

    /**
     * 导出类别列表
     */
    @RequiresPermissions("shzj:type:export")
    @Log(title = "类别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjType shzjType)
    {
        List<ShzjType> list = shzjTypeService.selectShzjTypeList(shzjType);
        ExcelUtil<ShzjType> util = new ExcelUtil<ShzjType>(ShzjType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增类别
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存类别
     */
    @RequiresPermissions("shzj:type:add")
    @Log(title = "类别", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjType shzjType)
    {
        return toAjax(shzjTypeService.insertShzjType(shzjType));
    }

    /**
     * 修改类别
     */
    @GetMapping("/edit/{typeId}")
    public String edit(@PathVariable("typeId") Integer typeId, ModelMap mmap)
    {
        ShzjType shzjType = shzjTypeService.selectShzjTypeById(typeId);
        mmap.put("shzjType", shzjType);
        return prefix + "/edit";
    }

    /**
     * 修改保存类别
     */
    @RequiresPermissions("shzj:type:edit")
    @Log(title = "类别", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjType shzjType)
    {
        return toAjax(shzjTypeService.updateShzjType(shzjType));
    }

    /**
     * 删除类别
     */
    @RequiresPermissions("shzj:type:remove")
    @Log(title = "类别", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjTypeService.deleteShzjTypeByIds(ids));
    }
}
