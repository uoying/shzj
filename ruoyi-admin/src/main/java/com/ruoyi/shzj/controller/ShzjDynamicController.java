package com.ruoyi.shzj.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.shzj.domain.*;
import com.ruoyi.shzj.service.*;
import com.ruoyi.shzj.util.VariableName;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import oshi.util.StringUtil;

import javax.servlet.http.HttpSession;

/**
 * 动态信息Controller
 *
 * @author ruoyi
 * @date 2020-08-13
 */
@Controller
@RequestMapping("/shzj/dynamic")
@Api(tags = "dynamic")
public class ShzjDynamicController extends BaseController {
    private String prefix = "shzj/dynamic";

    @Autowired
    private IShzjDynamicService shzjDynamicService;
    @Autowired
    private IShzjUserService shzjUserService;
    @Autowired
    private IShzjCityService shzjCityService;
    @Autowired
    private ShzjLikeController shzjLikeController;
    @Autowired
    private IShzjTopicService shzjTopicService;
    @Autowired
    private IShzjActionService shzjActionService;

    @RequiresPermissions("shzj:dynamic:view")
    @GetMapping()
    public String dynamic() {
        return prefix + "/dynamic";
    }

    /**
     * 查询动态信息列表
     */
    @RequiresPermissions("shzj:dynamic:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjDynamic shzjDynamic) {
        startPage();
        List<ShzjDynamic> list = shzjDynamicService.selectShzjDynamicList(shzjDynamic);
        return getDataTable(list);
    }

    @GetMapping("/like")
    @ResponseBody
    @ApiOperation("like")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户编号", paramType = "query"),
            @ApiImplicitParam(name = "dynamicId", value = "动态编号", paramType = "query")
    })
    public AjaxResult like(@RequestParam("userId") Integer userId,
                           @RequestParam("dynamicId") Integer dynamicId) {
        return shzjLikeController.dynamicLike(userId, dynamicId);
    }

    @GetMapping("/dislike")
    @ResponseBody
    @ApiOperation("dislike")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户编号", paramType = "query"),
            @ApiImplicitParam(name = "dynamicId", value = "动态编号", paramType = "query")
    })
    public AjaxResult dislike(@RequestParam("userId") Integer userId,
                              @RequestParam("dynamicId") Integer dynamicId) {
        return shzjLikeController.dynamicDislike(userId, dynamicId);
    }

    @ApiOperation("attentionList")
    @GetMapping("/attentionList")
    @ApiImplicitParam(name = "userId", value = "用户编号", paramType = "query")
    @ResponseBody
    public AjaxResult attentionList(@RequestParam("userId") int userId) {
        Integer[] authorIds = shzjActionService.selectAuthorIdsInAttention(userId);
        List<ShzjDynamic> shzjDynamics = shzjDynamicService.selectShzjDynamicListByAuthorId(authorIds);
        for (ShzjDynamic shzjDynamic : shzjDynamics) {
            ShzjUser shzjUser = shzjUserService.selectShzjUserById(shzjDynamic.getAuthorId());
            shzjDynamic.setAuthorName(shzjUser.getUserName());
            shzjDynamic.setHeadPortrait(VariableName.domain + shzjUser.getHeadPortrait());
            String[] split = shzjDynamic.getDynamicPic().trim().split("\\s+");
            shzjDynamic.setDynamicPic(VariableName.domain + split[0]);
        }
        return AjaxResult.success(shzjDynamics);
    }

    @ApiOperation("cityList")
    @ApiImplicitParam(name = "cityName", value = "城市名称", paramType = "query")
    @PostMapping("/cityList")
    @ResponseBody
    public AjaxResult cityList(@RequestParam("cityName") String cityName) {
        ShzjCity shzjCity = new ShzjCity();
        shzjCity.setCityName(cityName);
        ShzjDynamic dynamic = new ShzjDynamic();
        dynamic.setCityId(shzjCityService.selectShzjCityList(shzjCity).get(0).getCityId());
        List<ShzjDynamic> dynamics = shzjDynamicService.selectShzjDynamicList(dynamic);
        for (ShzjDynamic shzjDynamic : dynamics) {
            ShzjUser shzjUser = shzjUserService.selectShzjUserById(shzjDynamic.getAuthorId());
            shzjDynamic.setAuthorName(shzjUser.getUserName());
            shzjDynamic.setHeadPortrait(VariableName.domain + shzjUser.getHeadPortrait());
            String[] split = shzjDynamic.getDynamicPic().trim().split("\\s+");
            shzjDynamic.setDynamicPic(VariableName.domain + split[0]);
        }
        return AjaxResult.success(dynamics);
    }

    @ApiOperation("dynamicListByTopic")
    @PostMapping("/dynamicListByTopic")
    @ApiImplicitParam(name = "topicId", value = "话题", paramType = "query")
    @ResponseBody
    public AjaxResult dynamicListByTopic(@RequestParam("topicId") Integer topicId) {
        ShzjTopic topic=shzjTopicService.selectShzjTopicById(topicId);
        ShzjAction shzjAction=new ShzjAction();
        shzjAction.setContent("topic");
        shzjAction.setContentid(topicId);
        topic.setActionNum(shzjActionService.selectShzjActionList(shzjAction).size());
        topic.setBrowseNum(topic.getBrowseNum()+1);
        shzjTopicService.updateShzjTopic(topic);
        List<ShzjDynamic> dynamics=shzjDynamicService.selectShzjDynamicListByDynamicTopic(topic.getTopicName());
        topic.setArticleNum(dynamics.size());
        List<Object> list = new ArrayList<>();
        list.add(topic);
        list.add(dynamics);
        list.add(shzjDynamicService.selectShzjDynamicListByDynamicTopicByHot(topic.getTopicName()));
        return AjaxResult.success(list);
    }


    @ApiOperation("dynamicList")
    @GetMapping("/dynamicList")
    @ResponseBody
    public AjaxResult dynamicList(ShzjDynamic dynamic) {
        List<ShzjDynamic> list = shzjDynamicService.selectShzjDynamicList(dynamic);
        ShzjDynamic[][] shzjDynamics = new ShzjDynamic[list.size() % 5 == 0 ? list.size() / 5 : list.size() / 5 + 1][5];
        int i = 0;
        int j = 0;
        for (ShzjDynamic shzjDynamic : list) {
            ShzjUser shzjUser = shzjUserService.selectShzjUserById(shzjDynamic.getAuthorId());
            shzjDynamic.setAuthorName(shzjUser.getUserName());
            shzjDynamic.setHeadPortrait(VariableName.domain + shzjUser.getHeadPortrait());
            String[] split = shzjDynamic.getDynamicPic().trim().split("\\s+");
            shzjDynamic.setDynamicPic(VariableName.domain + split[0]);
            shzjDynamics[i][j] = shzjDynamic;
            if (++j == 5) {
                i++;
                j = 0;
            }
        }
        return AjaxResult.success(shzjDynamics);
    }

    /**
     * 导出动态信息列表
     */
    @RequiresPermissions("shzj:dynamic:export")
    @Log(title = "动态信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjDynamic shzjDynamic) {
        List<ShzjDynamic> list = shzjDynamicService.selectShzjDynamicList(shzjDynamic);
        ExcelUtil<ShzjDynamic> util = new ExcelUtil<ShzjDynamic>(ShzjDynamic.class);
        return util.exportExcel(list, "dynamic");
    }

    /**
     * 新增动态信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存动态信息
     */
    @RequiresPermissions("shzj:dynamic:add")
    @Log(title = "动态信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjDynamic shzjDynamic) {
        return toAjax(shzjDynamicService.insertShzjDynamic(shzjDynamic));
    }

    /**
     * 修改动态信息
     */
    @GetMapping("/edit/{dynamicId}")
    public String edit(@PathVariable("dynamicId") Integer dynamicId, ModelMap mmap) {
        ShzjDynamic shzjDynamic = shzjDynamicService.selectShzjDynamicById(dynamicId);
        mmap.put("shzjDynamic", shzjDynamic);
        return prefix + "/edit";
    }

    /**
     * 修改保存动态信息
     */
    @RequiresPermissions("shzj:dynamic:edit")
    @Log(title = "动态信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjDynamic shzjDynamic) {
        return toAjax(shzjDynamicService.updateShzjDynamic(shzjDynamic));
    }

    /**
     * 删除动态信息
     */
    @RequiresPermissions("shzj:dynamic:remove")
    @Log(title = "动态信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(shzjDynamicService.deleteShzjDynamicByIds(ids));
    }
}
