package com.ruoyi.shzj.controller;

import java.util.List;

import com.ruoyi.shzj.service.IShzjCityService;
import com.ruoyi.shzj.service.IShzjTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.shzj.domain.ShzjContent;
import com.ruoyi.shzj.service.IShzjContentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 内容信息Controller
 * 
 * @author ruoyi
 * @date 2020-07-13
 */
@Controller
@RequestMapping("/shzj/content")
@Api(tags = "content")
public class ShzjContentController extends BaseController
{
    private String prefix = "shzj/content";

    @Autowired
    private IShzjContentService shzjContentService;
    @Autowired
    private IShzjCityService shzjCityService;
    @Autowired
    private IShzjTypeService shzjTypeService;
    @Autowired
    private ShzjLikeController shzjLikeController;

    @RequiresPermissions("shzj:content:view")
    @GetMapping()
    public String content()
    {
        return prefix + "/content";
    }

    @GetMapping("/like")
    @ResponseBody
    @ApiOperation("like")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户编号",paramType = "query"),
            @ApiImplicitParam(name = "contentId",value = "内容编号",paramType = "query")
    })
    public AjaxResult like(@RequestParam("userId")Integer userId,
                           @RequestParam("contentId")Integer contentId){
        return shzjLikeController.contentLike(userId,contentId);
    }
    @GetMapping("/dislike")
    @ResponseBody
    @ApiOperation("dislike")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户编号",paramType = "query"),
            @ApiImplicitParam(name = "contentId",value = "内容编号",paramType = "query")
    })
    public AjaxResult dislike(@RequestParam("userId")Integer userId,
                              @RequestParam("contentId")Integer contentId){
        return shzjLikeController.contentDislike(userId,contentId);
    }

    /**
     * 查询内容信息列表
     */
    @RequiresPermissions("shzj:content:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjContent shzjContent)
    {
        startPage();
        List<ShzjContent> list = shzjContentService.selectShzjContentList(shzjContent);
        for (ShzjContent i : list) {
            i.setCityName(shzjCityService.selectShzjCityById(i.getConCity()).getCityName());
            i.setTypeName(shzjTypeService.selectShzjTypeById(i.getConType()).getTypeName());
        }
        return getDataTable(list);
    }

    /**
     * 导出内容信息列表
     */
    @RequiresPermissions("shzj:content:export")
    @Log(title = "内容信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjContent shzjContent)
    {
        List<ShzjContent> list = shzjContentService.selectShzjContentList(shzjContent);
        ExcelUtil<ShzjContent> util = new ExcelUtil<ShzjContent>(ShzjContent.class);
        return util.exportExcel(list, "content");
    }

    /**
     * 新增内容信息
     */
    @GetMapping("/add")
    public String add(Model model)
    {
        model.addAttribute("cities",shzjCityService.selectShzjCityList(null));
        model.addAttribute("types",shzjTypeService.selectShzjTypeList(null));
        return prefix + "/add";
    }

    /**
     * 新增保存内容信息
     */
    @RequiresPermissions("shzj:content:add")
    @Log(title = "内容信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjContent shzjContent)
    {
        return toAjax(shzjContentService.insertShzjContent(shzjContent));
    }

    /**
     * 修改内容信息
     */
    @GetMapping("/edit/{conId}")
    public String edit(@PathVariable("conId") Integer conId, ModelMap mmap)
    {
        ShzjContent shzjContent = shzjContentService.selectShzjContentById(conId);
        mmap.put("shzjContent", shzjContent);
        mmap.put("cities",shzjCityService.selectShzjCityList(null));
        mmap.put("types",shzjTypeService.selectShzjTypeList(null));
        return prefix + "/edit";
    }

    /**
     * 修改保存内容信息
     */
    @RequiresPermissions("shzj:content:edit")
    @Log(title = "内容信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjContent shzjContent)
    {
        return toAjax(shzjContentService.updateShzjContent(shzjContent));
    }

    /**
     * 删除内容信息
     */
    @RequiresPermissions("shzj:content:remove")
    @Log(title = "内容信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjContentService.deleteShzjContentByIds(ids));
    }
}
