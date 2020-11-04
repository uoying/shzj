package com.ruoyi.shzj.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.controller.BaseDataInfo;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.shzj.domain.ShzjCity;
import com.ruoyi.shzj.domain.ShzjContent;
import com.ruoyi.shzj.domain.ShzjPicture;
import com.ruoyi.shzj.domain.ShzjPoem;
import com.ruoyi.shzj.service.*;
import com.ruoyi.shzj.util.VariableName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/shzj/index")
public class ShzjIndexController extends BaseController {
    private String prefix = "shzj/index";

    @Autowired
    private IShzjPictureService shzjPictureService;
    @Autowired
    private IShzjCityService shzjCityService;
    @Autowired
    private IShzjPoemService shzjPoemService;
    @Autowired
    private IShzjContentService shzjContentService;
    @Autowired
    private IShzjAudioService shzjAudioService;

    String domain= VariableName.domain;

    @RequestMapping("/info")
    @ResponseBody
    public BaseDataInfo indexInfo() {
        List<Object> list = new ArrayList<>();
        List<ShzjPicture> pictures = new ArrayList<>();
        ShzjPicture shzjPicture=shzjPictureService.selectShzjPictureById(4);
        shzjPicture.setPicUrl(domain+shzjPicture.getPicUrl());
        pictures.add(shzjPicture);
        list.add(pictures);

        List<ShzjPoem> shzjPoems = shzjPoemService.selectShzjPoemList(null);
        ShzjPoem poem = shzjPoemService.selectShzjPoemById(shzjPoems.get(shzjPoems.size() - 1).getPoemId());
        list.add(poem);
        List<ShzjCity> cities = shzjCityService.selectShzjCityList(null);
        list.add(cities);
        ShzjContent content = new ShzjContent();
        content.setIsRecommend(1);
        List<ShzjContent> shzjRecommendContents = shzjContentService.selectShzjContentList(content);
        for (ShzjContent i : shzjRecommendContents)
            i.setConPicture(VariableName.domain+i.getConPicture());
        ShzjContent todayContent = shzjRecommendContents.get(shzjRecommendContents.size() - 1);
        list.add(todayContent);
        List<ShzjContent>agoContent=shzjRecommendContents;
        agoContent.remove(shzjRecommendContents.get(shzjRecommendContents.size() - 1));
        list.add(agoContent);
        List<Object> contents = new ArrayList<>();
        content=new ShzjContent();
        for (ShzjCity c : cities) {
            List<Object>obj=new ArrayList<>();
            obj.add(c);
            content.setConCity(c.getCityId());
            List<ShzjContent>shzjContents=shzjContentService.selectShzjContentList(content);
            for (ShzjContent i : shzjContents) {
                i.setConPicture(VariableName.domain+i.getConPicture());
            }
            obj.add(shzjContents);
            contents.add(obj);
        }
        list.add(contents);

        return getBaseDataInfo(list);
    }
}
