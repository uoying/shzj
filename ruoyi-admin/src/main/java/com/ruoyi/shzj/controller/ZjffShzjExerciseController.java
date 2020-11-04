package com.ruoyi.shzj.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.shzj.domain.*;
import com.ruoyi.shzj.domain.DTO.*;
import com.ruoyi.shzj.domain.vo.AnswerVO;
import com.ruoyi.shzj.service.impl.*;
import com.ruoyi.shzj.util.VariableName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("shzj/exercise")
public class ZjffShzjExerciseController {

    @Autowired
    ShzjExerciseServiceImpl shzjExerciseService;

    @Autowired
    ShzjUserServiceImpl shzjUserService;

    @Autowired
    ShzjCouponServiceImpl shzjCouponService;

    @Autowired
    ShzjCouponGiftServiceImpl shzjCouponGiftService;

    @RequestMapping("/getExercise")
    public AjaxResult toExercise(int judge) {
        Random random = new Random();
        List<ExerciseDTO> list = shzjExerciseService.selectShzjExercise(judge);
        int a = random.nextInt(list.size());
        return AjaxResult.success(list.get(a));
    }

    @RequestMapping("/doExercise")
    public AjaxResult exercise(@RequestParam(value = "id", required = true) String id,
                               @RequestParam(value = "answer", required = true) String answer,
                               @RequestParam("userId")int userId) {
        AnswerDTO answerDTO = shzjExerciseService.selectShzjAnswerById(Integer.parseInt(id));
        if (answer.equals(answerDTO.getAnswer().trim().toUpperCase())) {
            shzjUserService.updateShzjUserAnswer(userId);
            return AjaxResult.success("1", answerDTO);
        }
        return AjaxResult.success("0", answerDTO);
    }

    @RequestMapping("endOfAnswer")
    public AjaxResult endOfAnswer(@RequestParam("userId")int userId){
        Integer[] answerMax = {0, 20, 50, 100};
        int count=0;
        Random random=new Random();
        String actionForce = String.valueOf(random.nextInt(30)+70);
       HeadPortraitDTO headPortraitDTO= shzjUserService.selectShzjHeadPortrait(userId);
        AnswerVO answerVO=new AnswerVO();
        for (int i = 0; i <answerMax.length ; i++) {
            if (Integer.parseInt(headPortraitDTO.getAnswerNumber())>=answerMax[i]){
            count++;
            }
        }
        answerVO.setActionForce(actionForce);
        answerVO.setGradeUrl(VariableName.domain +"/grade_v" + count);
        answerVO.setHeadPortrait(VariableName.domain+headPortraitDTO.getHeadPortrait());
        return AjaxResult.success("答题结束", answerVO);
    }

    @RequestMapping("/reward")
    public AjaxResult reward(@RequestParam(value = "reward", required = false) String reward, @RequestParam("userId")int userId ) {
        if (reward != null) {
            int a = shzjUserService.updateShzjUserReward(userId, Integer.parseInt(reward));
        }
        return AjaxResult.success();
    }

    @RequestMapping("coupon")
    public AjaxResult coupon(){
        ShzjCoupon shzjCoupon=new ShzjCoupon();
        List<ShzjCoupon> list= shzjCouponService.selectShzjCouponList(shzjCoupon);
        return AjaxResult.success();
    }


    @RequestMapping("/fabutimu")
    public  AjaxResult fabutimu(String subject,String choiceA,String choiceB,String choiceC,String choiceD,String answer ,String parse,int judge,@RequestParam("userId")int userId){
        shzjUserService.updateShzjUserQuiz(userId);
        return  AjaxResult.success(shzjExerciseService.updateShzjtiExercise(subject,choiceA,choiceB,choiceC,choiceD,answer,parse,userId,judge));
    }

    @RequestMapping("/phb")
    public  AjaxResult phb(){
      List<PhbDTO> phbDTO= shzjUserService.selectShzjUserAnswerPhb();
        return AjaxResult.success(phbDTO);
    }

    @RequestMapping("exchange")
    public  AjaxResult exchange(CouponDTO couponDTO){
        int jif= couponDTO.getExchange();
        shzjUserService.updateShzjSubtract(couponDTO.getUserId(),jif);
        shzjCouponGiftService.insertShzjMyCouponGift(couponDTO);
//         ShzjGift shzjGift=new ShzjGift();
//         shzjGift.setGiftInfo(giftInfo);
//         shzjGift.setGiftTitle(giftTitle);
//         shzjGift.setUserId(userId);
//        shzjCouponGiftService.insertShzjGift(shzjGift);
        return AjaxResult.success();
    }

}
