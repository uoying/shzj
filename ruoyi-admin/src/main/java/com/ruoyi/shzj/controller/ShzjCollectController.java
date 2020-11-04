package com.ruoyi.shzj.controller;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.shzj.domain.ShzjContent;
import com.ruoyi.shzj.service.IShzjContentService;
import com.ruoyi.shzj.util.VariableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.shzj.domain.ShzjCollect;
import com.ruoyi.shzj.service.IShzjCollectService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 收藏列表Controller
 *
 * @author ruoyi
 * @date 2020-08-24
 */
@Controller
@RequestMapping("/shzj/collect")
@Api(tags = "collect")
public class ShzjCollectController extends BaseController {
    private String prefix = "shzj/collect";

    @Autowired
    private IShzjCollectService shzjCollectService;
    @Autowired
    private IShzjContentService shzjContentService;

    @RequiresPermissions("shzj:collect:view")
    @GetMapping()
    public String collect() {
        return prefix + "/collect";
    }

    /**
     * 查询收藏列表列表
     */
    @RequiresPermissions("shzj:collect:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjCollect shzjCollect) {
        startPage();
        List<ShzjCollect> list = shzjCollectService.selectShzjCollectList(shzjCollect);
        return getDataTable(list);
    }

    @GetMapping("/cancelCollect")
    @ResponseBody
    @ApiOperation("cancelCollect")
    @ApiImplicitParam(name = "shzjCollect", value = "诗画浙江收藏", paramType = "body")
    public AjaxResult cancelCollect(ShzjCollect shzjCollect) {
        Integer id=shzjCollectService.selectShzjCollectList(shzjCollect).get(0).getId();
        return shzjCollectService.deleteShzjCollectById(id) == 1 ? success("取消收藏成功!") : error("取消收藏失败!");
    }


    @PostMapping("/isCollect")
    @ResponseBody
    @ApiOperation("isCollect")
    @ApiImplicitParam(name = "shzjCollect", value = "诗画浙江收藏", paramType = "body")
    public AjaxResult isCollect(ShzjCollect shzjCollect){
        return shzjCollectService.selectShzjCollectList(shzjCollect).size()==0?success("0"):success("1");
    }

    @PostMapping("/addCollect")
    @ResponseBody
    @ApiOperation("addCollect")
    @ApiImplicitParam(name = "shzjCollect", value = "诗画浙江收藏", paramType = "body")
    public AjaxResult addCollect(ShzjCollect shzjCollect) {
        return shzjCollectService.insertShzjCollect(shzjCollect) == 1 ? success("收藏成功!") : error("收藏失败!");
    }

    @PostMapping("/getCollect")
    @ResponseBody
    @ApiOperation("getCollect")
    @ApiImplicitParam(name = "shzjCollect", value = "诗画浙江收藏", paramType = "body")
    public AjaxResult getCollect(ShzjCollect shzjCollect) {
        List<ShzjCollect> shzjCollects = shzjCollectService.selectShzjCollectList(shzjCollect);
        List<Object>result=new ArrayList<>();
        switch (shzjCollect.getCollectType()){
            case "content":
                for(ShzjCollect i:shzjCollects){
                    ShzjContent shzjContent = shzjContentService.selectShzjContentById(i.getCollectId());
                    shzjContent.setConPicture(VariableName.domain+shzjContent.getConPicture());
                    result.add(shzjContent);
                }
                break;
        }
        return AjaxResult.success(result);
    }

    /**
     * 导出收藏列表列表
     */
    @RequiresPermissions("shzj:collect:export")
    @Log(title = "收藏列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjCollect shzjCollect) {
        List<ShzjCollect> list = shzjCollectService.selectShzjCollectList(shzjCollect);
        ExcelUtil<ShzjCollect> util = new ExcelUtil<ShzjCollect>(ShzjCollect.class);
        return util.exportExcel(list, "collect");
    }

    /**
     * 新增收藏列表
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存收藏列表
     */
    @RequiresPermissions("shzj:collect:add")
    @Log(title = "收藏列表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjCollect shzjCollect) {
        return toAjax(shzjCollectService.insertShzjCollect(shzjCollect));
    }

    /**
     * 修改收藏列表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        ShzjCollect shzjCollect = shzjCollectService.selectShzjCollectById(id);
        mmap.put("shzjCollect", shzjCollect);
        return prefix + "/edit";
    }

    /**
     * 修改保存收藏列表
     */
    @RequiresPermissions("shzj:collect:edit")
    @Log(title = "收藏列表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjCollect shzjCollect) {
        return toAjax(shzjCollectService.updateShzjCollect(shzjCollect));
    }

    /**
     * 删除收藏列表
     */
    @RequiresPermissions("shzj:collect:remove")
    @Log(title = "收藏列表", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(shzjCollectService.deleteShzjCollectByIds(ids));
    }
}
