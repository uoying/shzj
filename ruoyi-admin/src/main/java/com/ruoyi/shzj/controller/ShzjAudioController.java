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
import com.ruoyi.shzj.domain.ShzjAudio;
import com.ruoyi.shzj.service.IShzjAudioService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 音频信息Controller
 * 
 * @author ruoyi
 * @date 2020-07-16
 */
@Controller
@RequestMapping("/shzj/audio")
public class ShzjAudioController extends BaseController
{
    private String prefix = "shzj/audio";

    @Autowired
    private IShzjAudioService shzjAudioService;

    @RequiresPermissions("shzj:audio:view")
    @GetMapping()
    public String audio()
    {
        return prefix + "/audio";
    }

    /**
     * 查询音频信息列表
     */
    @RequiresPermissions("shzj:audio:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjAudio shzjAudio)
    {
        startPage();
        List<ShzjAudio> list = shzjAudioService.selectShzjAudioList(shzjAudio);
        return getDataTable(list);
    }

    /**
     * 导出音频信息列表
     */
    @RequiresPermissions("shzj:audio:export")
    @Log(title = "音频信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjAudio shzjAudio)
    {
        List<ShzjAudio> list = shzjAudioService.selectShzjAudioList(shzjAudio);
        ExcelUtil<ShzjAudio> util = new ExcelUtil<ShzjAudio>(ShzjAudio.class);
        return util.exportExcel(list, "audio");
    }

    /**
     * 新增音频信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存音频信息
     */
    @RequiresPermissions("shzj:audio:add")
    @Log(title = "音频信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjAudio shzjAudio)
    {
        return toAjax(shzjAudioService.insertShzjAudio(shzjAudio));
    }

    /**
     * 修改音频信息
     */
    @GetMapping("/edit/{audioId}")
    public String edit(@PathVariable("audioId") Integer audioId, ModelMap mmap)
    {
        ShzjAudio shzjAudio = shzjAudioService.selectShzjAudioById(audioId);
        mmap.put("shzjAudio", shzjAudio);
        return prefix + "/edit";
    }

    /**
     * 修改保存音频信息
     */
    @RequiresPermissions("shzj:audio:edit")
    @Log(title = "音频信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjAudio shzjAudio)
    {
        return toAjax(shzjAudioService.updateShzjAudio(shzjAudio));
    }

    /**
     * 删除音频信息
     */
    @RequiresPermissions("shzj:audio:remove")
    @Log(title = "音频信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjAudioService.deleteShzjAudioByIds(ids));
    }
}
