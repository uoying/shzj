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
import com.ruoyi.shzj.domain.ShzjSilk;
import com.ruoyi.shzj.service.IShzjSilkService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 锦囊信息Controller
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
@Controller
@RequestMapping("/shzj/silk")
public class ShzjSilkController extends BaseController
{
    private String prefix = "shzj/silk";

    @Autowired
    private IShzjSilkService shzjSilkService;

    @RequiresPermissions("shzj:silk:view")
    @GetMapping()
    public String silk()
    {
        return prefix + "/silk";
    }

    /**
     * 查询锦囊信息列表
     */
    @RequiresPermissions("shzj:silk:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjSilk shzjSilk)
    {
        startPage();
        List<ShzjSilk> list = shzjSilkService.selectShzjSilkList(shzjSilk);
        return getDataTable(list);
    }

    /**
     * 导出锦囊信息列表
     */
    @RequiresPermissions("shzj:silk:export")
    @Log(title = "锦囊信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjSilk shzjSilk)
    {
        List<ShzjSilk> list = shzjSilkService.selectShzjSilkList(shzjSilk);
        ExcelUtil<ShzjSilk> util = new ExcelUtil<ShzjSilk>(ShzjSilk.class);
        return util.exportExcel(list, "silk");
    }

    /**
     * 新增锦囊信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存锦囊信息
     */
    @RequiresPermissions("shzj:silk:add")
    @Log(title = "锦囊信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjSilk shzjSilk)
    {
        return toAjax(shzjSilkService.insertShzjSilk(shzjSilk));
    }

    /**
     * 修改锦囊信息
     */
    @GetMapping("/edit/{silkId}")
    public String edit(@PathVariable("silkId") Integer silkId, ModelMap mmap)
    {
        ShzjSilk shzjSilk = shzjSilkService.selectShzjSilkById(silkId);
        mmap.put("shzjSilk", shzjSilk);
        return prefix + "/edit";
    }

    /**
     * 修改保存锦囊信息
     */
    @RequiresPermissions("shzj:silk:edit")
    @Log(title = "锦囊信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjSilk shzjSilk)
    {
        return toAjax(shzjSilkService.updateShzjSilk(shzjSilk));
    }

    /**
     * 删除锦囊信息
     */
    @RequiresPermissions("shzj:silk:remove")
    @Log(title = "锦囊信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjSilkService.deleteShzjSilkByIds(ids));
    }
}
