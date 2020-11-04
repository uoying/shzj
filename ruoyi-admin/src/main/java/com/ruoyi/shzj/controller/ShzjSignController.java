package com.ruoyi.shzj.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.shzj.domain.ShzjSign;
import com.ruoyi.shzj.service.IShzjSignService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;


/**
 * 签到信息Controller
 * 
 * @author ruoyi
 * @date 2020-07-28
 */
@Controller
@RequestMapping("/shzj/sign")
public class ShzjSignController extends BaseController
{
    private String prefix = "shzj/sign";

    @Autowired
    private IShzjSignService shzjSignService;

    @RequiresPermissions("shzj:sign:view")
    @GetMapping()
    public String sign()
    {
        return prefix + "/sign";
    }

    /**
     * 签到日志
     * @param year 年
     * @param mouth 月
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public AjaxResult info(@RequestParam("userId")int userId, @RequestParam("year")String year, @RequestParam("mouth")String mouth){
        if(mouth.length()==1)
            mouth=0+mouth;
        String date=year+"-"+mouth+"%";
        ShzjSign shzjSign=new ShzjSign();
        shzjSign.setUserId(userId);
        shzjSign.setSignTime(date);
        List<ShzjSign> shzjSigns = shzjSignService.selectShzjSignList(shzjSign);
        for (ShzjSign i:shzjSigns) {
            String signTime = i.getSignTime();
            signTime=signTime.split(" ")[0].split("-")[2];
            i.setSignTime(Integer.parseInt(signTime)+"");
        }
        return AjaxResult.success(shzjSigns);
    }

    @RequestMapping("/signIn")
    @ResponseBody
    public AjaxResult signIn(@RequestParam("userId")int userId){
        ShzjSign sign=new ShzjSign();
        sign.setUserId(userId);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        sign.setSignTime(df.format(new Date())+"%");
        List<ShzjSign> shzjSigns = shzjSignService.selectShzjSignList(sign);
        if(shzjSigns.size()==1){
            return error("今日已签到!");
        }
        sign=new ShzjSign();
        sign.setUserId(userId);
        return shzjSignService.insertShzjSign(sign)==1?success("签到成功"):error("签到失败");
    }

    /**
     * 查询签到信息列表
     */
    @RequiresPermissions("shzj:sign:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjSign shzjSign)
    {
        startPage();
        List<ShzjSign> list = shzjSignService.selectShzjSignList(shzjSign);
        return getDataTable(list);
    }

    /**
     * 导出签到信息列表
     */
    @RequiresPermissions("shzj:sign:export")
    @Log(title = "签到信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjSign shzjSign)
    {
        List<ShzjSign> list = shzjSignService.selectShzjSignList(shzjSign);
        ExcelUtil<ShzjSign> util = new ExcelUtil<ShzjSign>(ShzjSign.class);
        return util.exportExcel(list, "sign");
    }

    /**
     * 新增签到信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存签到信息
     */
    @RequiresPermissions("shzj:sign:add")
    @Log(title = "签到信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjSign shzjSign)
    {
        return toAjax(shzjSignService.insertShzjSign(shzjSign));
    }

    /**
     * 修改签到信息
     */
    @GetMapping("/edit/{signId}")
    public String edit(@PathVariable("signId") Integer signId, ModelMap mmap)
    {
        ShzjSign shzjSign = shzjSignService.selectShzjSignById(signId);
        mmap.put("shzjSign", shzjSign);
        return prefix + "/edit";
    }

    /**
     * 修改保存签到信息
     */
    @RequiresPermissions("shzj:sign:edit")
    @Log(title = "签到信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjSign shzjSign)
    {
        return toAjax(shzjSignService.updateShzjSign(shzjSign));
    }

    /**
     * 删除签到信息
     */
    @RequiresPermissions("shzj:sign:remove")
    @Log(title = "签到信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjSignService.deleteShzjSignByIds(ids));
    }
}
