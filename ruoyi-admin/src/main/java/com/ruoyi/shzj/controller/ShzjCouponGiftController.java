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
import com.ruoyi.shzj.domain.ShzjCouponGift;
import com.ruoyi.shzj.service.IShzjCouponGiftService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 兑换卷(已兑换)Controller
 * 
 * @author ruoyi
 * @date 2020-08-19
 */
@Controller
@RequestMapping("/shzj/couponGift")
public class ShzjCouponGiftController extends BaseController
{
    private String prefix = "shzj/couponGift";

    @Autowired
    private IShzjCouponGiftService shzjCouponGiftService;

    @RequiresPermissions("shzj:couponGift:view")
    @GetMapping()
    public String couponGift()
    {
        return prefix + "/couponGift";
    }

    /**
     * 查询兑换卷(已兑换)列表
     */
    @RequiresPermissions("shzj:couponGift:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjCouponGift shzjCouponGift)
    {
        startPage();
        List<ShzjCouponGift> list = shzjCouponGiftService.selectShzjCouponGiftList(shzjCouponGift);
        return getDataTable(list);
    }

    /**
     * 导出兑换卷(已兑换)列表
     */
    @RequiresPermissions("shzj:couponGift:export")
    @Log(title = "兑换卷(已兑换)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjCouponGift shzjCouponGift)
    {
        List<ShzjCouponGift> list = shzjCouponGiftService.selectShzjCouponGiftList(shzjCouponGift);
        ExcelUtil<ShzjCouponGift> util = new ExcelUtil<ShzjCouponGift>(ShzjCouponGift.class);
        return util.exportExcel(list, "couponGift");
    }

    /**
     * 新增兑换卷(已兑换)
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存兑换卷(已兑换)
     */
    @RequiresPermissions("shzj:couponGift:add")
    @Log(title = "兑换卷(已兑换)", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjCouponGift shzjCouponGift)
    {
        return toAjax(shzjCouponGiftService.insertShzjCouponGift(shzjCouponGift));
    }

    /**
     * 修改兑换卷(已兑换)
     */
    @GetMapping("/edit/{couponId}")
    public String edit(@PathVariable("couponId") Integer couponId, ModelMap mmap)
    {
        ShzjCouponGift shzjCouponGift = shzjCouponGiftService.selectShzjCouponGiftById(couponId);
        mmap.put("shzjCouponGift", shzjCouponGift);
        return prefix + "/edit";
    }

    /**
     * 修改保存兑换卷(已兑换)
     */
    @RequiresPermissions("shzj:couponGift:edit")
    @Log(title = "兑换卷(已兑换)", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjCouponGift shzjCouponGift)
    {
        return toAjax(shzjCouponGiftService.updateShzjCouponGift(shzjCouponGift));
    }

    /**
     * 删除兑换卷(已兑换)
     */
    @RequiresPermissions("shzj:couponGift:remove")
    @Log(title = "兑换卷(已兑换)", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjCouponGiftService.deleteShzjCouponGiftByIds(ids));
    }
}
