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
import com.ruoyi.shzj.domain.ShzjStrategy;
import com.ruoyi.shzj.service.IShzjStrategyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 攻略信息Controller
 * 
 * @author ruoyi
 * @date 2020-08-05
 */
@Controller
@RequestMapping("/shzj/strategy")
public class ShzjStrategyController extends BaseController
{
    private String prefix = "shzj/strategy";

    @Autowired
    private IShzjStrategyService shzjStrategyService;

    @RequiresPermissions("shzj:strategy:view")
    @GetMapping()
    public String strategy()
    {
        return prefix + "/strategy";
    }

    /**
     * 查询攻略信息列表
     */
    @RequiresPermissions("shzj:strategy:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjStrategy shzjStrategy)
    {
        startPage();
        List<ShzjStrategy> list = shzjStrategyService.selectShzjStrategyList(shzjStrategy);
        return getDataTable(list);
    }

    /**
     * 导出攻略信息列表
     */
    @RequiresPermissions("shzj:strategy:export")
    @Log(title = "攻略信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjStrategy shzjStrategy)
    {
        List<ShzjStrategy> list = shzjStrategyService.selectShzjStrategyList(shzjStrategy);
        ExcelUtil<ShzjStrategy> util = new ExcelUtil<ShzjStrategy>(ShzjStrategy.class);
        return util.exportExcel(list, "strategy");
    }

    /**
     * 新增攻略信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存攻略信息
     */
    @RequiresPermissions("shzj:strategy:add")
    @Log(title = "攻略信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjStrategy shzjStrategy)
    {
        return toAjax(shzjStrategyService.insertShzjStrategy(shzjStrategy));
    }

    /**
     * 修改攻略信息
     */
    @GetMapping("/edit/{strategyId}")
    public String edit(@PathVariable("strategyId") Integer strategyId, ModelMap mmap)
    {
        ShzjStrategy shzjStrategy = shzjStrategyService.selectShzjStrategyById(strategyId);
        mmap.put("shzjStrategy", shzjStrategy);
        return prefix + "/edit";
    }

    /**
     * 修改保存攻略信息
     */
    @RequiresPermissions("shzj:strategy:edit")
    @Log(title = "攻略信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjStrategy shzjStrategy)
    {
        return toAjax(shzjStrategyService.updateShzjStrategy(shzjStrategy));
    }

    /**
     * 删除攻略信息
     */
    @RequiresPermissions("shzj:strategy:remove")
    @Log(title = "攻略信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjStrategyService.deleteShzjStrategyByIds(ids));
    }
}
