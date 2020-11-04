package com.ruoyi.shzj.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.shzj.domain.*;
import com.ruoyi.shzj.service.*;
import com.ruoyi.shzj.util.VariableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/shzj/search")
@Api(tags = "search")
public class ShzjSearchController {
    @Autowired
    private IShzjTopicService shzjTopicService;
    @Autowired
    private IShzjDynamicService shzjDynamicService;
    @Autowired
    private IShzjUserService shzjUserService;
    @Autowired
    private IShzjStrategyService shzjStrategyService;
    @Autowired
    private IShzjContentService shzjContentService;
    @Autowired
    private IShzjPictureService shzjPictureService;

    @ApiOperation("searchAll")
    @PostMapping("/searchAll")
    @ApiImplicitParam(name = "searchStr",value = "检索关键词,检索结果集合分别为景点、攻略、动态、话题",paramType = "query")
    @ResponseBody
    public AjaxResult searchAll(@RequestParam("searchStr") String searchStr){
        List<Object> results=new ArrayList<>();
        ShzjContent content=new ShzjContent();
        content.setConTitile(searchStr);
        List<ShzjContent> shzjContents = shzjContentService.selectShzjContentList(content);
        List<ContentResult>contentResults=new ArrayList<>();
        for (ShzjContent shzjContent:shzjContents){
            ContentResult contentResult=new ContentResult();
            contentResult.setContentId(shzjContent.getConId());
            contentResult.setContentTitle(shzjContent.getConTitile());
            contentResult.setPicUrl(VariableName.domain+shzjPictureService.selectShzjPictureById(Integer.parseInt(shzjContent.getConPicture().split("\\s+")[0])).getPicUrl());
            contentResult.setConScore(shzjContent.getConScore());
            contentResults.add(contentResult);
        }
        ShzjTopic shzjTopic=new ShzjTopic();
        shzjTopic.setTopicName(searchStr);
        List<ShzjTopic> shzjTopics = shzjTopicService.selectShzjTopicList(shzjTopic);
        for (ShzjTopic i:shzjTopics)
            i.setPicUrl(VariableName.domain+i.getPicUrl());
        ShzjDynamic dynamic=new ShzjDynamic();
        dynamic.setDynamicTitle(searchStr);
        List<ShzjDynamic> shzjDynamics = shzjDynamicService.selectShzjDynamicList(dynamic);
        for(ShzjDynamic shzjDynamic:shzjDynamics){
            ShzjUser shzjUser=shzjUserService.selectShzjUserById(shzjDynamic.getAuthorId());
            shzjDynamic.setAuthorName(shzjUser.getUserName());
            shzjDynamic.setHeadPortrait(VariableName.domain+shzjUser.getHeadPortrait());
            String[] split = shzjDynamic.getDynamicPic().trim().split("\\s+");
            shzjDynamic.setDynamicPic(VariableName.domain+split[0]);
        }
        ShzjStrategy shzjStrategy=new ShzjStrategy();
        shzjStrategy.setStrategyTitle(searchStr);
        List<ShzjStrategy> shzjStrategies = shzjStrategyService.selectShzjStrategyList(shzjStrategy);
        for(ShzjStrategy strategy:shzjStrategies)
            strategy.setPicUrl(VariableName.domain+strategy.getPicUrl());
        results.add(contentResults);
        results.add(shzjStrategies);
        results.add(shzjDynamics);
        results.add(shzjTopics);
        return AjaxResult.success(results);
    }


    @ApiOperation("searchByTopic")
    @PostMapping("/searchByTopic")
    @ApiImplicitParam(name = "searchStr",value = "检索关键词",paramType = "query")
    @ResponseBody
    public AjaxResult searchByTopic(@RequestParam("searchStr") String searchStr ){
        ShzjTopic shzjTopic=new ShzjTopic();
        shzjTopic.setTopicName(searchStr);
        List<ShzjTopic> shzjTopics = shzjTopicService.selectShzjTopicList(shzjTopic);
        for (ShzjTopic i:shzjTopics)
            i.setPicUrl(VariableName.domain+i.getPicUrl());

        return AjaxResult.success(shzjTopics);
    }
    @ApiOperation("searchByDynamic")
    @PostMapping("/searchByDynamic")
    @ApiImplicitParam(name = "searchStr",value = "检索关键词",paramType = "query")
    @ResponseBody
    public AjaxResult searchByDynamic(@RequestParam("searchStr") String searchStr ){
        ShzjDynamic dynamic=new ShzjDynamic();
        dynamic.setDynamicTitle(searchStr);
        List<ShzjDynamic> shzjDynamics = shzjDynamicService.selectShzjDynamicList(dynamic);
        for(ShzjDynamic shzjDynamic:shzjDynamics){
            ShzjUser shzjUser=shzjUserService.selectShzjUserById(shzjDynamic.getAuthorId());
            shzjDynamic.setAuthorName(shzjUser.getUserName());
            shzjDynamic.setHeadPortrait(VariableName.domain+shzjUser.getHeadPortrait());
            String[] split = shzjDynamic.getDynamicPic().trim().split("\\s+");
            shzjDynamic.setDynamicPic(VariableName.domain+split[0]);
        }
        return AjaxResult.success(shzjDynamics);
    }

    @ApiOperation("searchByStrategy")
    @PostMapping("/searchByStrategy")
    @ApiImplicitParam(name = "searchStr",value = "检索关键词",paramType = "query")
    @ResponseBody
    public AjaxResult searchByStrategy(@RequestParam("searchStr") String searchStr ){
        ShzjStrategy shzjStrategy=new ShzjStrategy();
        shzjStrategy.setStrategyTitle(searchStr);
        List<ShzjStrategy> shzjStrategies = shzjStrategyService.selectShzjStrategyList(shzjStrategy);
        for(ShzjStrategy strategy:shzjStrategies)
            strategy.setPicUrl(VariableName.domain+strategy.getPicUrl());
        return AjaxResult.success(shzjStrategies);
    }
    class ContentResult{
        private Integer contentId;
        private String picUrl;
        private String contentTitle;
        private Integer conScore;

        public Integer getContentId() {
            return contentId;
        }

        public void setContentId(Integer contentId) {
            this.contentId = contentId;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getContentTitle() {
            return contentTitle;
        }

        public void setContentTitle(String contentTitle) {
            this.contentTitle = contentTitle;
        }

        public Integer getConScore() {
            return conScore;
        }

        public void setConScore(Integer conScore) {
            this.conScore = conScore;
        }
    }
}
