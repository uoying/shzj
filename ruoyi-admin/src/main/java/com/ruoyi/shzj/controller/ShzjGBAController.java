package com.ruoyi.shzj.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.controller.BaseDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.shzj.domain.ShzjFeatures;
import com.ruoyi.shzj.domain.ShzjFeaturesType;
import com.ruoyi.shzj.domain.ShzjSilk;
import com.ruoyi.shzj.domain.ShzjStrategy;
import com.ruoyi.shzj.service.*;
import com.ruoyi.shzj.util.VariableName;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/shzj/gba")
public class ShzjGBAController extends BaseController {
    private final String DOMAIN=VariableName.domain;
    @Autowired
    private IShzjFeaturesTypeService shzjFeaturesTypeService;
    @Autowired
    private IShzjFeaturesService shzjFeaturesService;
    @Autowired
    private IShzjStrategyService shzjStrategyService;
    @Autowired
    private IShzjCityService shzjCityService;
    @Autowired
    private IShzjSilkService shzjSilkService;

    @RequestMapping("/infoByCity")
    @ResponseBody
    public AjaxResult infoByCity(@RequestParam("cityId")int cityId){
        List<Object> result=new ArrayList<>();
        result.add(shzjCityService.selectShzjCityById(cityId).getCityName());//录入城市名
        List<StrategyResult> strategyResults=new ArrayList<>();
        List<String> types= shzjStrategyService.selectStrategyTypeList();
        for(String i : types){
            StrategyResult strategyResult=new StrategyResult();
            strategyResult.setStrategyType(i);
            ShzjStrategy shzjStrategy=new ShzjStrategy();
            shzjStrategy.setStrategyType(i);
            shzjStrategy.setCityId(cityId);
            List<ShzjStrategy> shzjStrategies = shzjStrategyService.selectShzjStrategyList(shzjStrategy);
            for(ShzjStrategy j:shzjStrategies)
                j.setPicUrl(DOMAIN+j.getPicUrl());
            strategyResult.setStrategies(shzjStrategies);
            strategyResults.add(strategyResult);
        }
        result.add(strategyResults);//录入地点
        ShzjSilk shzjSilk=new ShzjSilk();
        shzjSilk.setCityId(cityId);
        List<ShzjSilk> selectShzjSilkList = shzjSilkService.selectShzjSilkList(shzjSilk);
        for(ShzjSilk i:selectShzjSilkList)
            i.setSilkPic(DOMAIN+i.getSilkPic());
        result.add(selectShzjSilkList);
        return AjaxResult.success(result);
    }

    @RequestMapping("/info")
    @ResponseBody
    public AjaxResult info(){
        List<Object> result=new ArrayList<>();
        List<StrategyResult> strategyResults=new ArrayList<>();
        List<String> types= shzjStrategyService.selectStrategyTypeList();
        for(String i : types){
            StrategyResult strategyResult=new StrategyResult();
            strategyResult.setStrategyType(i);
            ShzjStrategy shzjStrategy=new ShzjStrategy();
            shzjStrategy.setStrategyType(i);
            List<ShzjStrategy> shzjStrategies = shzjStrategyService.selectShzjStrategyList(shzjStrategy);
            for(ShzjStrategy j:shzjStrategies)
                j.setPicUrl(DOMAIN+j.getPicUrl());
            strategyResult.setStrategies(shzjStrategies);
            strategyResults.add(strategyResult);
        }
        result.add(strategyResults);
        List<FeaturesResult> featuresResults=new ArrayList<>();
        List<ShzjFeaturesType> shzjFeaturesTypes = shzjFeaturesTypeService.selectShzjFeaturesTypeList(null);
        for (ShzjFeaturesType i:shzjFeaturesTypes) {
            FeaturesResult featuresResult=new FeaturesResult();
            featuresResult.setFeaturesType(i.getFeaturesName());
            ShzjFeatures shzjFeatures=new ShzjFeatures();
            shzjFeatures.setFeaType(i.getFeaturesName());
            List<ShzjFeatures> featuresList = shzjFeaturesService.selectShzjFeaturesList(shzjFeatures);
            for(ShzjFeatures j:featuresList)
                j.setPicUrl(DOMAIN+j.getPicUrl());

            featuresResult.setShzjFeaturesList(featuresList);
            featuresResults.add(featuresResult);
        }
        result.add(featuresResults);
        return AjaxResult.success(result);
    }
    public class StrategyResult{
        private String strategyType;
        private List<ShzjStrategy> strategies;
        public String getStrategyType() {
            return strategyType;
        }

        public void setStrategyType(String strategyType) {
            this.strategyType = strategyType;
        }

        public List<ShzjStrategy> getStrategies() {
            return strategies;
        }

        public void setStrategies(List<ShzjStrategy> strategies) {
            this.strategies = strategies;
        }
    }
    public class FeaturesResult{
        private String featuresType;
        private List<ShzjFeatures> shzjFeaturesList;
        public String getFeaturesType() {
            return featuresType;
        }

        public void setFeaturesType(String featuresType) {
            this.featuresType = featuresType;
        }

        public List<ShzjFeatures> getShzjFeaturesList() {
            return shzjFeaturesList;
        }

        public void setShzjFeaturesList(List<ShzjFeatures> shzjFeaturesList) {
            this.shzjFeaturesList = shzjFeaturesList;
        }
    }
}
