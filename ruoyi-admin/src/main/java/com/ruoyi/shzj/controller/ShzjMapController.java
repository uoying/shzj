package com.ruoyi.shzj.controller;

import java.util.List;

import com.ruoyi.shzj.domain.ShzjCity;
import com.ruoyi.shzj.domain.ShzjContent;
import com.ruoyi.shzj.service.IShzjCityService;
import com.ruoyi.shzj.service.IShzjContentService;
import com.ruoyi.shzj.util.VariableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.shzj.domain.ShzjMap;
import com.ruoyi.shzj.service.IShzjMapService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 地图信息Controller
 * 
 * @author ruoyi
 * @date 2020-09-13
 */
@Controller
@RequestMapping("/shzj/map")
@Api(tags = "map")
public class ShzjMapController extends BaseController
{
    private String prefix = "shzj/map";

    @PostMapping("/mapListByType")
    @ResponseBody
    @ApiOperation("mapListByType")
    @ApiImplicitParam(name = "shzjMap" ,value = "诗画浙江地图",paramType = "body")
    public AjaxResult mapListByType(ShzjMap shzjMap){
        List<ShzjMap> shzjMaps = shzjMapService.selectShzjMapList(shzjMap);
        for(ShzjMap map:shzjMaps){
            map.setPicUrl(VariableName.domain+map.getPicUrl());
        }
        return AjaxResult.success(shzjMaps);
    }

    @Autowired
    private IShzjMapService shzjMapService;
    @Autowired
    private IShzjCityService shzjCityService;
    @Autowired
    private IShzjContentService shzjContentService;

    @RequiresPermissions("shzj:map:view")
    @GetMapping()
    public String map()
    {
        return prefix + "/map";
    }

    /**
     * 查询地图信息列表
     */
    @RequiresPermissions("shzj:map:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjMap shzjMap)
    {
        startPage();
        List<ShzjMap> list = shzjMapService.selectShzjMapList(shzjMap);
        for (ShzjMap map : list) {
            map.setMapCity(shzjCityService.selectShzjCityById(Integer.parseInt(map.getMapCity())).getCityName());
        }
        return getDataTable(list);
    }

    /**
     * 导出地图信息列表
     */
    @RequiresPermissions("shzj:map:export")
    @Log(title = "地图信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjMap shzjMap)
    {
        List<ShzjMap> list = shzjMapService.selectShzjMapList(shzjMap);
        ExcelUtil<ShzjMap> util = new ExcelUtil<ShzjMap>(ShzjMap.class);
        return util.exportExcel(list, "map");
    }

    /**
     * 新增地图信息
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        List<ShzjCity> shzjCities = shzjCityService.selectShzjCityList(null);
        List<ShzjContent> shzjContents = shzjContentService.selectShzjContentList(null);
        modelMap.addAttribute("cityList",shzjCities);
        modelMap.addAttribute("contentList",shzjContents);
        return prefix + "/add";
    }

    /**
     * 新增保存地图信息
     */
    @RequiresPermissions("shzj:map:add")
    @Log(title = "地图信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjMap shzjMap)
    {
        return toAjax(shzjMapService.insertShzjMap(shzjMap));
    }

    /**
     * 修改地图信息
     */
    @GetMapping("/edit/{mapId}")
    public String edit(@PathVariable("mapId") Integer mapId, ModelMap mmap)
    {
        ShzjMap shzjMap = shzjMapService.selectShzjMapById(mapId);
        List<ShzjCity> shzjCities = shzjCityService.selectShzjCityList(null);
        List<ShzjContent> shzjContents = shzjContentService.selectShzjContentList(null);
        mmap.put("shzjMap", shzjMap);
        mmap.put("cityList",shzjCities);
        mmap.put("contentList",shzjContents);
        return prefix + "/edit";
    }

    /**
     * 修改保存地图信息
     */
    @RequiresPermissions("shzj:map:edit")
    @Log(title = "地图信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjMap shzjMap)
    {
        return toAjax(shzjMapService.updateShzjMap(shzjMap));
    }

    /**
     * 删除地图信息
     */
    @RequiresPermissions("shzj:map:remove")
    @Log(title = "地图信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjMapService.deleteShzjMapByIds(ids));
    }
}
