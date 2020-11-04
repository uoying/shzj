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
import com.ruoyi.shzj.domain.ShzjCoupon;
import com.ruoyi.shzj.service.IShzjCouponService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 兑换卷Controller
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
@Controller
@RequestMapping("/shzj/coupon")
public class ShzjCouponController extends BaseController
{
    private String prefix = "shzj/coupon";

    @Autowired
    private IShzjCouponService shzjCouponService;

    @RequiresPermissions("shzj:coupon:view")
    @GetMapping()
    public String coupon()
    {
        return prefix + "/coupon";
    }

    /**
     * 查询兑换卷列表
     */
    @RequiresPermissions("shzj:coupon:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjCoupon shzjCoupon)
    {
        startPage();
        List<ShzjCoupon> list = shzjCouponService.selectShzjCouponList(shzjCoupon);
        return getDataTable(list);
    }

    /**
     * 导出兑换卷列表
     */
    @RequiresPermissions("shzj:coupon:export")
    @Log(title = "兑换卷", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjCoupon shzjCoupon)
    {
        List<ShzjCoupon> list = shzjCouponService.selectShzjCouponList(shzjCoupon);
        ExcelUtil<ShzjCoupon> util = new ExcelUtil<ShzjCoupon>(ShzjCoupon.class);
        return util.exportExcel(list, "coupon");
    }

    /**
     * 新增兑换卷
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存兑换卷
     */
    @RequiresPermissions("shzj:coupon:add")
    @Log(title = "兑换卷", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjCoupon shzjCoupon)
    {
        return toAjax(shzjCouponService.insertShzjCoupon(shzjCoupon));
    }

    /**
     * 修改兑换卷
     */
    @GetMapping("/edit/{couponId}")
    public String edit(@PathVariable("couponId") Integer couponId, ModelMap mmap)
    {
        ShzjCoupon shzjCoupon = shzjCouponService.selectShzjCouponById(couponId);
        mmap.put("shzjCoupon", shzjCoupon);
        return prefix + "/edit";
    }

    /**
     * 修改保存兑换卷
     */
    @RequiresPermissions("shzj:coupon:edit")
    @Log(title = "兑换卷", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjCoupon shzjCoupon)
    {
        return toAjax(shzjCouponService.updateShzjCoupon(shzjCoupon));
    }

    /**
     * 删除兑换卷
     */
    @RequiresPermissions("shzj:coupon:remove")
    @Log(title = "兑换卷", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjCouponService.deleteShzjCouponByIds(ids));
    }
}
