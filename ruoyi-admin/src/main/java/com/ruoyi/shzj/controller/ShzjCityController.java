package com.ruoyi.shzj.controller;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.shzj.util.VariableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.shzj.domain.ShzjCity;
import com.ruoyi.shzj.service.IShzjCityService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 城市信息Controller
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
@Controller
@RequestMapping("/shzj/city")
@Api(tags = "city")
public class ShzjCityController extends BaseController
{
    private String prefix = "shzj/city";

    @Autowired
    private IShzjCityService shzjCityService;

    @RequiresPermissions("shzj:city:view")
    @GetMapping()
    public String city()
    {
        return prefix + "/city";
    }

    /**
     * 查询城市信息列表
     */
    @RequiresPermissions("shzj:city:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjCity shzjCity)
    {
        startPage();
        List<ShzjCity> list = shzjCityService.selectShzjCityList(shzjCity);
        return getDataTable(list);
    }
    @GetMapping("/cityList")
    @ResponseBody
    @ApiOperation("cityList")
    public AjaxResult cityList(){
        List<ShzjCity> shzjCities = shzjCityService.selectShzjCityList(null);
        List<CityResult> cityResults=new ArrayList<>();
        for (ShzjCity shzjCity:shzjCities) {
            CityResult cityResult=new CityResult();
            cityResult.setCityId(shzjCity.getCityId());
            cityResult.setCityName(shzjCity.getCityName());
            cityResults.add(cityResult);
        }
        return AjaxResult.success(cityResults);
    }
    class CityResult{
        private Integer cityId;
        private String cityName;

        public Integer getCityId() {
            return cityId;
        }

        public void setCityId(Integer cityId) {
            this.cityId = cityId;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }
    }

    @RequestMapping("/feaCity")
    @ResponseBody
    public AjaxResult feaCity(){
        List<ShzjCity> shzjCities = shzjCityService.selectShzjFeaCityList();
        for(ShzjCity i:shzjCities)
            i.setPicUrl(VariableName.domain+i.getPicUrl());
        return AjaxResult.success(shzjCities);
    }
    /**
     * 导出城市信息列表
     */
    @RequiresPermissions("shzj:city:export")
    @Log(title = "城市信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjCity shzjCity)
    {
        List<ShzjCity> list = shzjCityService.selectShzjCityList(shzjCity);
        ExcelUtil<ShzjCity> util = new ExcelUtil<ShzjCity>(ShzjCity.class);
        return util.exportExcel(list, "city");
    }

    /**
     * 新增城市信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存城市信息
     */
    @RequiresPermissions("shzj:city:add")
    @Log(title = "城市信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjCity shzjCity)
    {
        return toAjax(shzjCityService.insertShzjCity(shzjCity));
    }

    /**
     * 修改城市信息
     */
    @GetMapping("/edit/{cityId}")
    public String edit(@PathVariable("cityId") Integer cityId, ModelMap mmap)
    {
        ShzjCity shzjCity = shzjCityService.selectShzjCityById(cityId);
        mmap.put("shzjCity", shzjCity);
        return prefix + "/edit";
    }

    /**
     * 修改保存城市信息
     */
    @RequiresPermissions("shzj:city:edit")
    @Log(title = "城市信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjCity shzjCity)
    {
        return toAjax(shzjCityService.updateShzjCity(shzjCity));
    }

    /**
     * 删除城市信息
     */
    @RequiresPermissions("shzj:city:remove")
    @Log(title = "城市信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjCityService.deleteShzjCityByIds(ids));
    }
}
