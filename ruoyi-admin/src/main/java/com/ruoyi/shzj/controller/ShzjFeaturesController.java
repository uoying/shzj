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
import com.ruoyi.shzj.domain.ShzjFeatures;
import com.ruoyi.shzj.service.IShzjFeaturesService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 专题信息Controller
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
@Controller
@RequestMapping("/shzj/features")
public class ShzjFeaturesController extends BaseController
{
    private String prefix = "shzj/features";

    @Autowired
    private IShzjFeaturesService shzjFeaturesService;

    @RequiresPermissions("shzj:features:view")
    @GetMapping()
    public String features()
    {
        return prefix + "/features";
    }

    /**
     * 查询专题信息列表
     */
    @RequiresPermissions("shzj:features:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjFeatures shzjFeatures)
    {
        startPage();
        List<ShzjFeatures> list = shzjFeaturesService.selectShzjFeaturesList(shzjFeatures);
        return getDataTable(list);
    }

    /**
     * 导出专题信息列表
     */
    @RequiresPermissions("shzj:features:export")
    @Log(title = "专题信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjFeatures shzjFeatures)
    {
        List<ShzjFeatures> list = shzjFeaturesService.selectShzjFeaturesList(shzjFeatures);
        ExcelUtil<ShzjFeatures> util = new ExcelUtil<ShzjFeatures>(ShzjFeatures.class);
        return util.exportExcel(list, "features");
    }

    /**
     * 新增专题信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存专题信息
     */
    @RequiresPermissions("shzj:features:add")
    @Log(title = "专题信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjFeatures shzjFeatures)
    {
        return toAjax(shzjFeaturesService.insertShzjFeatures(shzjFeatures));
    }

    /**
     * 修改专题信息
     */
    @GetMapping("/edit/{conId}")
    public String edit(@PathVariable("conId") Integer conId, ModelMap mmap)
    {
        ShzjFeatures shzjFeatures = shzjFeaturesService.selectShzjFeaturesById(conId);
        mmap.put("shzjFeatures", shzjFeatures);
        return prefix + "/edit";
    }

    /**
     * 修改保存专题信息
     */
    @RequiresPermissions("shzj:features:edit")
    @Log(title = "专题信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjFeatures shzjFeatures)
    {
        return toAjax(shzjFeaturesService.updateShzjFeatures(shzjFeatures));
    }

    /**
     * 删除专题信息
     */
    @RequiresPermissions("shzj:features:remove")
    @Log(title = "专题信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjFeaturesService.deleteShzjFeaturesByIds(ids));
    }
}
