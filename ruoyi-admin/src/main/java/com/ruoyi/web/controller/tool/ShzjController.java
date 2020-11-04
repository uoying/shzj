package com.ruoyi.web.controller.tool;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.shzj.domain.*;
import com.ruoyi.shzj.domain.DTO.*;
import com.ruoyi.shzj.domain.vo.AnswerVO;
import com.ruoyi.shzj.mapper.ShzjCouponMapper;
import com.ruoyi.shzj.service.impl.*;
import com.ruoyi.shzj.util.VariableName;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * swagger 用户测试方法
 * 
 * @author ruoyi
 */
@Api("答题")
@RestController
@RequestMapping("/shzj/exercise/api")
public class ShzjController extends BaseController {

    @Autowired
    ShzjExerciseServiceImpl shzjExerciseService;

    @Autowired
    ShzjUserServiceImpl shzjUserService;

    @Autowired
    ShzjGiftServiceImpl shzjGiftService;

    @Autowired
    ShzjCouponServiceImpl shzjCouponService;

    @Autowired
    ShzjCouponGift1ServiceImpl shzjCouponGift1;

    @ApiOperation("获取题目")
    @ApiImplicitParam(name = "judge", value = "题目类型", required = true, paramType = "query")
    @GetMapping("/getExercise")
    public AjaxResult toExercise(int judge) {
        Random random = new Random();
        List<ExerciseDTO> list = shzjExerciseService.selectShzjExercise(judge);
        int a = random.nextInt(list.size());
        return AjaxResult.success(list.get(a));
    }

    @ApiOperation("判断并加分")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "题目ID", required = true, paramType = "query"),
            @ApiImplicitParam(name = "answer", value = "答案", paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "userId", paramType = "query")
    })
    @PostMapping("/doExercise")
    public AjaxResult exercise(String id, String answer, int userId) {
        AnswerDTO answerDTO = shzjExerciseService.selectShzjAnswerById(Integer.parseInt(id));
        if (answer.equals(answerDTO.getAnswer())) {
            shzjUserService.updateShzjUserAnswer(userId);
            return AjaxResult.success("正确！", answerDTO);
        }
        return AjaxResult.success("错误！", answerDTO);
    }

    @ApiOperation("奖励分添加")
    @ApiImplicitParams({@ApiImplicitParam(name = "reward", value = "奖励分数", paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "userId", paramType = "query")
    })

    @PostMapping("/reward")
    public AjaxResult reward(@RequestParam(value = "reward", required = false) String reward, int userId) {

        if (reward != null) {
            int a = shzjUserService.updateShzjUserReward(userId, Integer.parseInt(reward));
        }
        return AjaxResult.success();
    }

    @ApiOperation("发布题目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "subject", value = "题目", required = true, paramType = "query"),
            @ApiImplicitParam(name = "choiceA", value = "答案A", paramType = "query"),
            @ApiImplicitParam(name = "choiceB", value = "答案B", paramType = "query"),
            @ApiImplicitParam(name = "choiceC", value = "答案C", paramType = "query"),
            @ApiImplicitParam(name = "choiceD", value = "答案D", paramType = "query"),
            @ApiImplicitParam(name = "answer", value = "正确答案", paramType = "query"),
            @ApiImplicitParam(name = "parse", value = "题目解析(未输入默认为 来源于+userName)", paramType = "query"),
            @ApiImplicitParam(name = "judge", value = "题目类型", paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "userId", paramType = "query")
    })
    @PostMapping("/fabutimu")
    public AjaxResult fabutimu(String subject, String choiceA, String choiceB, String choiceC, String choiceD, String answer, String parse, int judge, int userId) {
        shzjUserService.updateShzjUserQuiz(userId);
        return AjaxResult.success(shzjExerciseService.updateShzjtiExercise(subject, choiceA, choiceB, choiceC, choiceD, answer, parse, userId, judge));
    }

    @ApiOperation("排行榜")
    @GetMapping("/phb")
    public AjaxResult phb() {
        List<PhbDTO> phbDTO = shzjUserService.selectShzjUserAnswerPhb();
        return AjaxResult.success(phbDTO);
    }

    @ApiOperation("兑换优惠卷")
    @PostMapping("exchange")
    public AjaxResult exchange(CouponDTO couponDTO) {
        int jif = couponDTO.getExchange();
        int integer = shzjUserService.selectShzjIntegral(couponDTO.getUserId());
        if (integer - jif >= 0) {
            shzjUserService.updateShzjSubtract(couponDTO.getUserId(), jif);
            shzjCouponGift1.insertShzjMyCouponGift(couponDTO);
            return AjaxResult.success("兑换成功,您的积分剩余" + (integer - jif));
        }
        return AjaxResult.success("兑换失败，您的积分不足");
    }

    @ApiOperation("答题结束")
    @PostMapping("endOfAnswer")
    @ApiImplicitParam(name = "userId", value = "userId", paramType = "query")
    public AjaxResult endOfAnswer(@RequestParam("userId") int userId) {
        Integer[] answerMax = {0, 20, 50, 100};
        int count = 0;
        Random random = new Random();
        String actionForce = String.valueOf(random.nextInt(30) + 70);
        HeadPortraitDTO headPortraitDTO = shzjUserService.selectShzjHeadPortrait(userId);
        AnswerVO answerVO = new AnswerVO();
        for (int i = 0; i < answerMax.length; i++) {
            if (Integer.parseInt(headPortraitDTO.getAnswerNumber()) >= answerMax[i]) {
                count++;
            }
        }
        answerVO.setActionForce(actionForce + "%");
        answerVO.setGradeUrl(VariableName.domain + "/grade_v" + count);
        answerVO.setHeadPortrait(VariableName.domain + headPortraitDTO.getHeadPortrait());
        return AjaxResult.success("答题结束", answerVO);
    }

    @ApiOperation("兑换卷信息")
    @ApiImplicitParam(name = "userId", value = "userId", paramType = "query")
    @GetMapping("coupon")
    public AjaxResult coupon(int userId) {
        ShzjCoupon shzjCoupon = new ShzjCoupon();
        Coupon1DTO coupon1DTO = new Coupon1DTO();
        coupon1DTO.setMyjifen(shzjUserService.selectShzjIntegral(userId));
        coupon1DTO.setShzjCoupon(shzjCouponService.selectShzjCouponList(shzjCoupon));
        return AjaxResult.success(coupon1DTO);
    }

    @ApiOperation("我的兑换券")
    @ApiImplicitParam(name = "userId", value = "userId", paramType = "query")
    @PostMapping("myCoupon")
    public AjaxResult myCoupon(int userId) {
        List<MyCouponDTO> list = shzjCouponGift1.selectShzjMyCouponGift1(userId);
        return AjaxResult.success(list);
    }

    @ApiOperation("使用兑换卷")
    @ApiImplicitParam(name = "couponGiftId", value = "couponGiftId", paramType = "query")
    @GetMapping("useVoucher")
    public AjaxResult useVoucher(int couponGiftId) {
        ShzjCouponGift1 shzjCouponGift=new ShzjCouponGift1();
        shzjCouponGift.setCoupongiftId(couponGiftId);
        shzjCouponGift.setWhethertoredeem(1);
         shzjCouponGift1.updateShzjCouponGift1(shzjCouponGift);
        return AjaxResult.success("使用成功");
    }
}