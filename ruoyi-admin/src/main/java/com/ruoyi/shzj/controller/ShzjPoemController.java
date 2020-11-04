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
import com.ruoyi.shzj.domain.ShzjPoem;
import com.ruoyi.shzj.service.IShzjPoemService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 诗词信息Controller
 * 
 * @author ruoyi
 * @date 2020-07-13
 */
@Controller
@RequestMapping("/shzj/poem")
public class ShzjPoemController extends BaseController
{
    private String prefix = "shzj/poem";

    @Autowired
    private IShzjPoemService shzjPoemService;

    @RequiresPermissions("shzj:poem:view")
    @GetMapping()
    public String poem()
    {
        return prefix + "/poem";
    }

    /**
     * 查询诗词信息列表
     */
    @RequiresPermissions("shzj:poem:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjPoem shzjPoem)
    {
        startPage();
        List<ShzjPoem> list = shzjPoemService.selectShzjPoemList(shzjPoem);
        return getDataTable(list);
    }

    /**
     * 导出诗词信息列表
     */
    @RequiresPermissions("shzj:poem:export")
    @Log(title = "诗词信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjPoem shzjPoem)
    {
        List<ShzjPoem> list = shzjPoemService.selectShzjPoemList(shzjPoem);
        ExcelUtil<ShzjPoem> util = new ExcelUtil<ShzjPoem>(ShzjPoem.class);
        return util.exportExcel(list, "poem");
    }

    /**
     * 新增诗词信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存诗词信息
     */
    @RequiresPermissions("shzj:poem:add")
    @Log(title = "诗词信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjPoem shzjPoem)
    {
        return toAjax(shzjPoemService.insertShzjPoem(shzjPoem));
    }

    /**
     * 修改诗词信息
     */
    @GetMapping("/edit/{poemId}")
    public String edit(@PathVariable("poemId") Integer poemId, ModelMap mmap)
    {
        ShzjPoem shzjPoem = shzjPoemService.selectShzjPoemById(poemId);
        mmap.put("shzjPoem", shzjPoem);
        return prefix + "/edit";
    }

    /**
     * 修改保存诗词信息
     */
    @RequiresPermissions("shzj:poem:edit")
    @Log(title = "诗词信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjPoem shzjPoem)
    {
        return toAjax(shzjPoemService.updateShzjPoem(shzjPoem));
    }

    /**
     * 删除诗词信息
     */
    @RequiresPermissions("shzj:poem:remove")
    @Log(title = "诗词信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjPoemService.deleteShzjPoemByIds(ids));
    }
}
