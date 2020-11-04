package com.ruoyi.shzj.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.shzj.domain.ShzjGift;
import com.ruoyi.shzj.service.IShzjGiftService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.servlet.http.HttpSession;

/**
 * 礼包信息Controller
 *
 * @author ruoyi
 * @date 2020-07-29
 */
@Controller
@RequestMapping("/shzj/gift")
public class ShzjGiftController extends BaseController {
    private String prefix = "shzj/gift";

    @Autowired
    private IShzjGiftService shzjGiftService;

    @RequiresPermissions("shzj:gift:view")
    @GetMapping()
    public String gift() {
        return prefix + "/gift";
    }

    /**
     * 用户优惠券列表
     *
     * @return
     */
    @RequestMapping("/giftList")
    @ResponseBody
    public AjaxResult giftList(@RequestParam("userId")int userId) {
        ShzjGift shzjGift = new ShzjGift();
        shzjGift.setUserId(userId);
        List<ShzjGift> shzjGifts = shzjGiftService.selectShzjGiftList(shzjGift);
        return AjaxResult.success(shzjGifts);
    }

    /**
     * 查询礼包信息列表
     */
    @RequiresPermissions("shzj:gift:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjGift shzjGift) {
        startPage();
        List<ShzjGift> list = shzjGiftService.selectShzjGiftList(shzjGift);
        return getDataTable(list);
    }

    /**
     * 导出礼包信息列表
     */
    @RequiresPermissions("shzj:gift:export")
    @Log(title = "礼包信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjGift shzjGift) {
        List<ShzjGift> list = shzjGiftService.selectShzjGiftList(shzjGift);
        ExcelUtil<ShzjGift> util = new ExcelUtil<ShzjGift>(ShzjGift.class);
        return util.exportExcel(list, "gift");
    }

    /**
     * 新增礼包信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存礼包信息
     */
    @RequiresPermissions("shzj:gift:add")
    @Log(title = "礼包信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjGift shzjGift) {
        return toAjax(shzjGiftService.insertShzjGift(shzjGift));
    }

    /**
     * 修改礼包信息
     */
    @GetMapping("/edit/{giftId}")
    public String edit(@PathVariable("giftId") Integer giftId, ModelMap mmap) {
        ShzjGift shzjGift = shzjGiftService.selectShzjGiftById(giftId);
        mmap.put("shzjGift", shzjGift);
        return prefix + "/edit";
    }

    /**
     * 修改保存礼包信息
     */
    @RequiresPermissions("shzj:gift:edit")
    @Log(title = "礼包信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjGift shzjGift) {
        return toAjax(shzjGiftService.updateShzjGift(shzjGift));
    }

    /**
     * 删除礼包信息
     */
    @RequiresPermissions("shzj:gift:remove")
    @Log(title = "礼包信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(shzjGiftService.deleteShzjGiftByIds(ids));
    }
}
