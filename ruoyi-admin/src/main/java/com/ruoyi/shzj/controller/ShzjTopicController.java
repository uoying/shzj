package com.ruoyi.shzj.controller;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.shzj.domain.ShzjAction;
import com.ruoyi.shzj.service.IShzjActionService;
import com.ruoyi.shzj.util.VariableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.shzj.domain.ShzjTopic;
import com.ruoyi.shzj.service.IShzjTopicService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 话题信息Controller
 * 
 * @author ruoyi
 * @date 2020-08-13
 */
@Controller
@RequestMapping("/shzj/topic")
@Api(tags = "topic")
public class ShzjTopicController extends BaseController
{
    private String prefix = "shzj/topic";

    @Autowired
    private IShzjTopicService shzjTopicService;
    @Autowired
    private IShzjActionService shzjActionService;

    @RequiresPermissions("shzj:topic:view")
    @GetMapping()
    public String topic()
    {
        return prefix + "/topic";
    }

    @GetMapping("/topicType")
    @ResponseBody
    @ApiOperation("topicType")
    public AjaxResult topicType(){
        List<String> topicType=shzjTopicService.selectShzjTopicTypeList();
        return AjaxResult.success(topicType);
    }
    @GetMapping("/topTopic")
    @ApiOperation("topTopic")
    @ResponseBody
    public AjaxResult topTopic(){
        List<ShzjTopic>shzjTopics=shzjTopicService.selectShzjTopicListTop(5);
        List<TopTopicResult>topTopicResults=new ArrayList<>();
        for(ShzjTopic shzjTopic:shzjTopics){
            TopTopicResult topTopicResult=new TopTopicResult();
            topTopicResult.setTopicId(shzjTopic.getTopicId());
            topTopicResult.setTopicName(shzjTopic.getTopicName());
            topTopicResults.add(topTopicResult);
        }
        return  AjaxResult.success(topTopicResults);
    }
    class TopTopicResult{
        private Integer topicId;
        private  String topicName;

        public Integer getTopicId() {
            return topicId;
        }

        public void setTopicId(Integer topicId) {
            this.topicId = topicId;
        }

        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }
    }
    @PostMapping("/topicByType")
    @ApiOperation("topicByType")
    @ResponseBody
    @ApiImplicitParam(name = "topicType",value = "话题类型",paramType = "query")
    public AjaxResult topicByType(@RequestParam("topicType") String topicType){
        ShzjTopic shzjTopic=new ShzjTopic();
        shzjTopic.setTopicType(topicType);
        List<ShzjTopic>shzjTopics=topicType.equals("最热")?shzjTopicService.selectShzjTopicListTop(4):shzjTopicService.selectShzjTopicList(shzjTopic);
        for (ShzjTopic i:shzjTopics)
            i.setPicUrl(VariableName.domain+i.getPicUrl());
        return AjaxResult.success(shzjTopics);
    }

    /**
     * 话题前端展示0
     * @return
     */
    @GetMapping("/topicList")
    @ResponseBody
    @ApiOperation("topicList")
    public AjaxResult topicList(){
        List<ShzjTopic> list = shzjTopicService.selectShzjTopicList(null);
        ShzjTopic shzjTopic= list.get(list.size()-1);
        shzjTopic.setPicUrl(VariableName.domain+shzjTopic.getPicUrl());
        List<ShzjTopic> shzjTopics = shzjTopicService.selectShzjTopicListOrderByArticleNum(null);
        for (ShzjTopic i:shzjTopics){
            i.setPicUrl(VariableName.domain+i.getPicUrl());
        }
        List<Object> result=new ArrayList<>();
        result.add(shzjTopic);
        result.add(shzjTopics);
        return AjaxResult.success(result);
    }
    @PostMapping("/actionTopics")
    @ResponseBody
    @ApiOperation("actionTopics")
    public AjaxResult actionTopics(@RequestParam("userId")int userId){
        ShzjAction shzjAction=new ShzjAction();
        shzjAction.setContent("topic");
        shzjAction.setUserId(userId);
        List<ShzjTopic> list = new ArrayList<>();
        List<ShzjAction> shzjActions = shzjActionService.selectShzjActionList(shzjAction);
        for (ShzjAction action : shzjActions) {
            list.add(shzjTopicService.selectShzjTopicById(action.getContentid()));
        }
        return AjaxResult.success(list);
    }


    /**
     * 查询话题信息列表
     */
    @RequiresPermissions("shzj:topic:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjTopic shzjTopic)
    {
        startPage();
        List<ShzjTopic> list = shzjTopicService.selectShzjTopicList(shzjTopic);
        return getDataTable(list);
    }

    /**
     * 导出话题信息列表
     */
    @RequiresPermissions("shzj:topic:export")
    @Log(title = "话题信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjTopic shzjTopic)
    {
        List<ShzjTopic> list = shzjTopicService.selectShzjTopicList(shzjTopic);
        ExcelUtil<ShzjTopic> util = new ExcelUtil<ShzjTopic>(ShzjTopic.class);
        return util.exportExcel(list, "topic");
    }

    /**
     * 新增话题信息
     */
    @GetMapping("/add")
    public String add(ModelMap mmp)
    {
        mmp.addAttribute("type",shzjTopicService.selectShzjTopicTypeList()) ;
        return prefix + "/add";
    }

    /**
     * 新增保存话题信息
     */
    @RequiresPermissions("shzj:topic:add")
    @Log(title = "话题信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjTopic shzjTopic)
    {
        return toAjax(shzjTopicService.insertShzjTopic(shzjTopic));
    }

    /**
     * 修改话题信息
     */
    @GetMapping("/edit/{topicId}")
    public String edit(@PathVariable("topicId") Integer topicId, ModelMap mmap)
    {
        ShzjTopic shzjTopic = shzjTopicService.selectShzjTopicById(topicId);
        mmap.put("shzjTopic", shzjTopic);
        return prefix + "/edit";
    }

    /**
     * 修改保存话题信息
     */
    @RequiresPermissions("shzj:topic:edit")
    @Log(title = "话题信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjTopic shzjTopic)
    {
        return toAjax(shzjTopicService.updateShzjTopic(shzjTopic));
    }

    /**
     * 删除话题信息
     */
    @RequiresPermissions("shzj:topic:remove")
    @Log(title = "话题信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjTopicService.deleteShzjTopicByIds(ids));
    }
}
