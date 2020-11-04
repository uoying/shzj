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
import com.ruoyi.shzj.domain.ShzjFeaturesType;
import com.ruoyi.shzj.service.IShzjFeaturesTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 专题类型Controller你
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
@Controller
@RequestMapping("/shzj/feaType")
public class ShzjFeaturesTypeController extends BaseController
{
    private String prefix = "shzj/feaType";

    @Autowired
    private IShzjFeaturesTypeService shzjFeaturesTypeService;

    @RequiresPermissions("shzj:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询专题类型列表
     */
    @RequiresPermissions("shzj:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjFeaturesType shzjFeaturesType)
    {
        startPage();
        List<ShzjFeaturesType> list = shzjFeaturesTypeService.selectShzjFeaturesTypeList(shzjFeaturesType);
        return getDataTable(list);
    }

    /**
     * 导出专题类型列表
     */
    @RequiresPermissions("shzj:type:export")
    @Log(title = "专题类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjFeaturesType shzjFeaturesType)
    {
        List<ShzjFeaturesType> list = shzjFeaturesTypeService.selectShzjFeaturesTypeList(shzjFeaturesType);
        ExcelUtil<ShzjFeaturesType> util = new ExcelUtil<ShzjFeaturesType>(ShzjFeaturesType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增专题类型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存专题类型
     */
    @RequiresPermissions("shzj:type:add")
    @Log(title = "专题类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjFeaturesType shzjFeaturesType)
    {
        return toAjax(shzjFeaturesTypeService.insertShzjFeaturesType(shzjFeaturesType));
    }

    /**
     * 修改专题类型
     */
    @GetMapping("/edit/{featuresId}")
    public String edit(@PathVariable("featuresId") Integer featuresId, ModelMap mmap)
    {
        ShzjFeaturesType shzjFeaturesType = shzjFeaturesTypeService.selectShzjFeaturesTypeById(featuresId);
        mmap.put("shzjFeaturesType", shzjFeaturesType);
        return prefix + "/edit";
    }

    /**
     * 修改保存专题类型
     */
    @RequiresPermissions("shzj:type:edit")
    @Log(title = "专题类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjFeaturesType shzjFeaturesType)
    {
        return toAjax(shzjFeaturesTypeService.updateShzjFeaturesType(shzjFeaturesType));
    }

    /**
     * 删除专题类型
     */
    @RequiresPermissions("shzj:type:remove")
    @Log(title = "专题类型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjFeaturesTypeService.deleteShzjFeaturesTypeByIds(ids));
    }
}
