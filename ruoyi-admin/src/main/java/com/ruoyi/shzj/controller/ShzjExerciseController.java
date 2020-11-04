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
import com.ruoyi.shzj.domain.ShzjExercise;
import com.ruoyi.shzj.service.IShzjExerciseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 答题信息Controller
 * 
 * @author ruoyi
 * @date 2020-07-21
 */
@Controller
@RequestMapping("/shzj/exercise")
public class ShzjExerciseController extends BaseController
{
    private String prefix = "shzj/exercise";

    @Autowired
    private IShzjExerciseService shzjExerciseService;

    @RequiresPermissions("shzj:exercise:view")
    @GetMapping()
    public String exercise()
    {
        return prefix + "/exercise";
    }

    /**
     * 查询答题信息列表
     */
    @RequiresPermissions("shzj:exercise:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjExercise shzjExercise)
    {
        startPage();
        List<ShzjExercise> list = shzjExerciseService.selectShzjExerciseList(shzjExercise);
        return getDataTable(list);
    }

    /**
     * 导出答题信息列表
     */
    @RequiresPermissions("shzj:exercise:export")
    @Log(title = "答题信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjExercise shzjExercise)
    {
        List<ShzjExercise> list = shzjExerciseService.selectShzjExerciseList(shzjExercise);
        ExcelUtil<ShzjExercise> util = new ExcelUtil<ShzjExercise>(ShzjExercise.class);
        return util.exportExcel(list, "exercise");
    }

    /**
     * 新增答题信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存答题信息
     */
    @RequiresPermissions("shzj:exercise:add")
    @Log(title = "答题信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjExercise shzjExercise)
    {
        return toAjax(shzjExerciseService.insertShzjExercise(shzjExercise));
    }

    /**
     * 修改答题信息
     */
    @GetMapping("/edit/{exeId}")
    public String edit(@PathVariable("exeId") Integer exeId, ModelMap mmap)
    {
        ShzjExercise shzjExercise = shzjExerciseService.selectShzjExerciseById(exeId);
        mmap.put("shzjExercise", shzjExercise);
        return prefix + "/edit";
    }

    /**
     * 修改保存答题信息
     */
    @RequiresPermissions("shzj:exercise:edit")
    @Log(title = "答题信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjExercise shzjExercise)
    {
        return toAjax(shzjExerciseService.updateShzjExercise(shzjExercise));
    }

    /**
     * 删除答题信息
     */
    @RequiresPermissions("shzj:exercise:remove")
    @Log(title = "答题信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjExerciseService.deleteShzjExerciseByIds(ids));
    }
}
