package com.ruoyi.shzj.controller;

import java.util.List;

import com.ruoyi.shzj.domain.DTO.CouponGiftDTO;
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
import com.ruoyi.shzj.domain.ShzjCouponGift1;
import com.ruoyi.shzj.service.IShzjCouponGift1Service;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 兑换卷信息Controller
 * 
 * @author ruoyi
 * @date 2020-08-25
 */
@Controller
@RequestMapping("/shzj/gift1")
public class ShzjCouponGift1Controller extends BaseController
{
    private String prefix = "shzj/gift1";

    @Autowired
    private IShzjCouponGift1Service shzjCouponGift1Service;

    @RequiresPermissions("shzj:gift1:view")
    @GetMapping()
    public String gift1()
    {
        return prefix + "/gift1";
    }

    /**
     * 查询兑换卷信息列表
     */
    @RequiresPermissions("shzj:gift1:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjCouponGift1 shzjCouponGift1)
    {
        startPage();
        List<CouponGiftDTO> list = shzjCouponGift1Service.selectShzjCouponGift1();
        return getDataTable(list);
    }

    /**
     * 导出兑换卷信息列表
     */
    @RequiresPermissions("shzj:gift1:export")
    @Log(title = "兑换卷信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjCouponGift1 shzjCouponGift1)
    {
        List<ShzjCouponGift1> list = shzjCouponGift1Service.selectShzjCouponGift1List(shzjCouponGift1);
        ExcelUtil<ShzjCouponGift1> util = new ExcelUtil<ShzjCouponGift1>(ShzjCouponGift1.class);
        return util.exportExcel(list, "gift1");
    }

    /**
     * 新增兑换卷信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存兑换卷信息
     */
    @RequiresPermissions("shzj:gift1:add")
    @Log(title = "兑换卷信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjCouponGift1 shzjCouponGift1)
    {
        return toAjax(shzjCouponGift1Service.insertShzjCouponGift1(shzjCouponGift1));
    }

    /**
     * 修改兑换卷信息
     */
    @GetMapping("/edit/{coupongiftId}")
    public String edit(@PathVariable("coupongiftId") Integer coupongiftId, ModelMap mmap)
    {
        ShzjCouponGift1 shzjCouponGift1 = shzjCouponGift1Service.selectShzjCouponGift1ById(coupongiftId);
        mmap.put("shzjCouponGift1", shzjCouponGift1);
        return prefix + "/edit";
    }

    /**
     * 修改保存兑换卷信息
     */
    @RequiresPermissions("shzj:gift1:edit")
    @Log(title = "兑换卷信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjCouponGift1 shzjCouponGift1)
    {
        return toAjax(shzjCouponGift1Service.updateShzjCouponGift1(shzjCouponGift1));
    }

    /**
     * 删除兑换卷信息
     */
    @RequiresPermissions("shzj:gift1:remove")
    @Log(title = "兑换卷信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjCouponGift1Service.deleteShzjCouponGift1ByIds(ids));
    }
}
