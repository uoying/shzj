package com.ruoyi.shzj.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ruoyi.shzj.domain.ShzjButtonContent;
import com.ruoyi.shzj.domain.ShzjCity;
import com.ruoyi.shzj.service.IShzjButtonContentService;
import com.ruoyi.shzj.service.IShzjCityService;
import com.ruoyi.shzj.util.VariableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.shzj.domain.ShzjCustomization;
import com.ruoyi.shzj.service.IShzjCustomizationService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 定制信息Controller
 * 
 * @author ruoyi
 * @date 2020-08-25
 */
@Controller
@RequestMapping("/shzj/customization")
@Api(tags = "customization")
public class ShzjCustomizationController extends BaseController
{
    private String prefix = "shzj/customization";

    @Autowired
    private IShzjCustomizationService shzjCustomizationService;
    @Autowired
    private IShzjButtonContentService shzjButtonContentService;
    @Autowired
    private IShzjCityService shzjCityService;

    @RequiresPermissions("shzj:customization:view")
    @GetMapping()
    public String customization()
    {
        return prefix + "/customization";
    }

    @PostMapping("/getCustom")
    @ApiOperation("getCustom")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startCity",value = "出发城市" ,paramType = "query"),
            @ApiImplicitParam(name = "endCity",value = "终点城市" ,paramType = "query"),
            @ApiImplicitParam(name = "passCity",value = "途径城市" ,paramType = "query"),
            @ApiImplicitParam(name = "type",value = "定制类型" ,paramType = "query")
    })
    @ResponseBody
    public AjaxResult getCustom(@RequestParam("startCity") String startCity,
                                @RequestParam("endCity")String endCity,
                                @RequestParam("passCity")String passCity,
                                @RequestParam("type")String type){
        ArrayList<ShzjCustomization>customizations=new ArrayList<>();
        ArrayList<String>cityList=new ArrayList<>();
        cityList.add("萧山");cityList.add("柯桥");
        cityList.add("上虞");cityList.add("余姚");
        cityList.add("嵊州");cityList.add("新昌");
        cityList.add("天台");cityList.add("临海");
        Set<String>cities=new HashSet<>();
        cities.add(startCity);
        for(String i:passCity.trim().split("\\s+"))
            cities.add(i);
        cities.add(endCity);
        for(String city:cities){
            ShzjCustomization shzjCustomization=new ShzjCustomization();
            shzjCustomization.setCity(city);
            shzjCustomization.setCustomType(type);
            List<ShzjCustomization> shzjCustomizations = shzjCustomizationService.selectShzjCustomizationList(shzjCustomization);
            for (ShzjCustomization customization : shzjCustomizations) {
                customization.setCustomPic(VariableName.domain+customization.getCustomPic());
                if(customization.getIsbutton()==1){
                    List<ShzjButtonContent>contents=new ArrayList<>();
                    String[] split = customization.getButtonContents().trim().split("\\s+");
                    for(String i:split){
                        ShzjButtonContent shzjButtonContent = shzjButtonContentService.selectShzjButtonContentById(Integer.parseInt(i));
                        shzjButtonContent.setConPic(VariableName.domain+shzjButtonContent.getConPic());
                        contents.add(shzjButtonContent);
                    }
                    customization.setContents(contents);
                }
                customizations.add(customization);
            }
        }
        return AjaxResult.success(customizations);
    }



    /**
     * 查询定制信息列表
     */
    @RequiresPermissions("shzj:customization:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjCustomization shzjCustomization)
    {
        startPage();
        List<ShzjCustomization> list = shzjCustomizationService.selectShzjCustomizationList(shzjCustomization);
        return getDataTable(list);
    }

    /**
     * 导出定制信息列表
     */
    @RequiresPermissions("shzj:customization:export")
    @Log(title = "定制信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjCustomization shzjCustomization)
    {
        List<ShzjCustomization> list = shzjCustomizationService.selectShzjCustomizationList(shzjCustomization);
        ExcelUtil<ShzjCustomization> util = new ExcelUtil<ShzjCustomization>(ShzjCustomization.class);
        return util.exportExcel(list, "customization");
    }

    /**
     * 新增定制信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmp)
    {
        List<ShzjCity> shzjCities = shzjCityService.selectShzjCityList(null);
        mmp.addAttribute("cities",shzjCities);
        return prefix + "/add";
    }
    @GetMapping("/conInfo")
    public String conInfo(@RequestParam("conId")Integer conId,ModelMap mmp){
        ShzjButtonContent shzjButtonContent = shzjButtonContentService.selectShzjButtonContentById(conId);
        shzjButtonContent.setConPic(VariableName.domain+shzjButtonContent.getConPic());
        mmp.addAttribute("con",shzjButtonContent);
        return prefix+"/add1";
    }
    /**
     * 新增保存定制信息
     */
    @RequiresPermissions("shzj:customization:add")
    @Log(title = "定制信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjCustomization shzjCustomization)
    {
        return toAjax(shzjCustomizationService.insertShzjCustomization(shzjCustomization));
    }

    /**
     * 修改定制信息
     */
    @GetMapping("/edit/{customId}")
    public String edit(@PathVariable("customId") Integer customId, ModelMap mmap)
    {
        ShzjCustomization shzjCustomization = shzjCustomizationService.selectShzjCustomizationById(customId);
        mmap.put("shzjCustomization", shzjCustomization);
        return prefix + "/edit";
    }

    /**
     * 修改保存定制信息
     */
    @RequiresPermissions("shzj:customization:edit")
    @Log(title = "定制信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjCustomization shzjCustomization)
    {
        return toAjax(shzjCustomizationService.updateShzjCustomization(shzjCustomization));
    }

    /**
     * 删除定制信息
     */
    @RequiresPermissions("shzj:customization:remove")
    @Log(title = "定制信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjCustomizationService.deleteShzjCustomizationByIds(ids));
    }
}
