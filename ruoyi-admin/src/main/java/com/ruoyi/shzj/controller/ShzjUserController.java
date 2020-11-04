package com.ruoyi.shzj.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.ruoyi.common.utils.StringUtils;

import com.ruoyi.shzj.domain.*;
import com.ruoyi.shzj.service.IShzjActionService;
import com.ruoyi.shzj.service.IShzjSignService;
import com.ruoyi.shzj.util.QiniuUpload;
import com.ruoyi.shzj.util.VariableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.shzj.service.IShzjUserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户信息Controller
 *
 * @author ruoyi
 * @date 2020-07-28
 */
@Controller
@RequestMapping("/shzj/user")
@Api(tags = "user")
public class ShzjUserController extends BaseController {
    private String prefix = "shzj/user";

    @Autowired
    private IShzjUserService shzjUserService;
    @Autowired
    private IShzjSignService shzjSignService;
    @Autowired
    private IShzjActionService shzjActionService;

    @PostMapping("/fansList")
    @ApiOperation("fansList")
    @ResponseBody
    @ApiImplicitParam(name = "userId", value = "用户编号", paramType = "query")
    public AjaxResult fansList(@RequestParam("userId") int userId) {
        ShzjAction shzjAction = new ShzjAction();
        shzjAction.setContent("user");
        shzjAction.setContentid(userId);
        List<ShzjAction> shzjActions = shzjActionService.selectShzjActionList(shzjAction);
        List<ShzjUser> shzjUsers = new ArrayList<>();
        for (ShzjAction action : shzjActions) {
            shzjUsers.add(shzjUserService.selectShzjUserById(action.getUserId()));
        }

        return AjaxResult.success(shzjUsers);
    }

    @RequestMapping("/toUpdate")
    @ResponseBody
    public AjaxResult toUpdate(@RequestParam("userId") int userId) {
        ShzjUser shzjUser = shzjUserService.selectShzjUserById(userId);
        shzjUser.setHeadPortrait(VariableName.domain + shzjUser.getHeadPortrait());
        return AjaxResult.success(shzjUser);
    }

    @RequestMapping("/updateHead")
    @ResponseBody
    public AjaxResult updateHead(@RequestParam("userId") int userId, HttpServletRequest request, HttpServletResponse response) {
        ShzjUser shzjUser = new ShzjUser();
        shzjUser.setUserId(userId);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获得文件：
        MultipartFile imgFile = multipartRequest.getFile("headPortrait");
        if (imgFile != null) {
            QiniuUpload qiniuUpload = new QiniuUpload();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date = new Date();
            String fileName = imgFile.toString().split("@")[1] + formatter.format(date);
            try {
                qiniuUpload.updateFile(imgFile, fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            shzjUser.setHeadPortrait("/" + fileName);
        }
        return AjaxResult.success(shzjUserService.updateShzjUser(shzjUser));
    }


    @RequestMapping("/update")
    @ResponseBody
    public AjaxResult update(@RequestParam("userId") int userId, ShzjUser shzjUser) throws Exception {
        shzjUser.setUserId(userId);
        if (shzjUser.getLoginPwd() != null) {
            shzjUser.setSalt(StringUtils.replace(UUID.randomUUID().toString(), "-", ""));
            shzjUser.setLoginPwd(DigestUtils.md5Hex(shzjUser.getLoginPwd() + shzjUser.getSalt()));
        }

        return shzjUserService.updateShzjUser(shzjUser) == 1 ? success() : error();
    }

    @RequestMapping("/reg")
    @ResponseBody
    public AjaxResult reg(ShzjUser shzjUser) {
        ShzjUser user = new ShzjUser();
        user.setLoginId(shzjUser.getLoginId());
        if (shzjUserService.selectShzjUserList(user).size() != 0) {
            return error("该用户已被注册");
        }
        user = shzjUser;
        user.setSalt(StringUtils.replace(UUID.randomUUID().toString(), "-", ""));
        user.setLoginPwd(DigestUtils.md5Hex(shzjUser.getLoginPwd() + user.getSalt()));
        user.setUserName(shzjUser.getUserName() == null ? "shzj" + user.getSalt().substring(0, 9) : shzjUser.getUserName());
        if (shzjUserService.insertShzjUser(user) == 1) {
            return success("注册成功");
        }
        return error("注册失败");
    }

    /**
     * 登录
     *
     * @param loginId  用户名
     * @param loginPwd 密码
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public AjaxResult login(@RequestParam("loginId") String loginId, @RequestParam("loginPwd") String loginPwd) {
        ShzjUser shzjUser = new ShzjUser();
        shzjUser.setLoginId(loginId);
        List<ShzjUser> shzjUsers = shzjUserService.selectShzjUserList(shzjUser);
        if (shzjUsers.size() == 0) {
            return error("用户名不存在!");
        }
        String salt = shzjUsers.get(0).getSalt();
        if (DigestUtils.md5Hex(loginPwd + salt).equals(shzjUsers.get(0).getLoginPwd())) {
            return AjaxResult.success("登录成功", shzjUsers.get(0).getUserId());
        }
        return error("密码错误");
    }

    /**
     * 登出
     *
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public AjaxResult logout() {
        return success();
    }

    /**
     * 个人资料
     *
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public AjaxResult info(@RequestParam("userId") int userId) {
        ShzjUser shzjUser = shzjUserService.selectShzjUserById(userId);
        Integer[] answerMax = {0, 20, 50, 100};
        Integer[] quizMax = {0, 2, 5, 10};
        int answer = 0;
        int quiz = 0;
        Integer answerNumber = shzjUser.getAnswerNumber();
        Integer quizNumber = shzjUser.getQuizNumber();
        String answerURL = "4";
        String quizURL = "4";
        for (int i = 0; i < 4; i++)
            if (answerMax[i] > answerNumber) {
                answer = answerMax[i];
                answerURL = i + "";
                break;
            }
        for (int i = 0; i < 4; i++)
            if (quizMax[i] > quizNumber) {
                quiz = quizMax[i];
                quizURL = i + "";
                break;
            }
        shzjUser.setAnswerMax(answer);
        shzjUser.setQuizMax(quiz);
        shzjUser.setAnswerURL(VariableName.domain + "/g_1_v" + answerURL);
        shzjUser.setQuizURL(VariableName.domain + "/g_1_v" + quizURL);
        if (shzjUser.getHeadPortrait() == null) {
            shzjUser.setHeadPortrait("mrtx");
        }
        shzjUser.setHeadPortrait(VariableName.domain + shzjUser.getHeadPortrait());
        ShzjSign sign = new ShzjSign();
        sign.setUserId(shzjUser.getUserId());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        sign.setSignTime(df.format(new Date()) + "%");
        List<ShzjSign> shzjSigns = shzjSignService.selectShzjSignList(sign);
        if (shzjSigns.size() != 0) {
            shzjUser.setSign(true);
        } else {
            shzjUser.setSign(false);
        }
        return AjaxResult.success(shzjUser);
    }


    @RequiresPermissions("shzj:user:view")
    @GetMapping()
    public String user() {
        return prefix + "/user";
    }

    /**
     * 查询用户信息列表
     */
    @RequiresPermissions("shzj:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjUser shzjUser) {
        startPage();
        List<ShzjUser> list = shzjUserService.selectShzjUserList(shzjUser);
        return getDataTable(list);
    }

    /**
     * 导出用户信息列表
     */
    @RequiresPermissions("shzj:user:export")
    @Log(title = "用户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjUser shzjUser) {
        List<ShzjUser> list = shzjUserService.selectShzjUserList(shzjUser);
        ExcelUtil<ShzjUser> util = new ExcelUtil<ShzjUser>(ShzjUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 新增用户信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存用户信息
     */
    @RequiresPermissions("shzj:user:add")
    @Log(title = "用户信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjUser shzjUser) {
        return reg(shzjUser);
    }

    /**
     * 修改用户信息
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Integer userId, ModelMap mmap) {
        ShzjUser shzjUser = shzjUserService.selectShzjUserById(userId);
        mmap.put("shzjUser", shzjUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户信息
     */
    @RequiresPermissions("shzj:user:edit")
    @Log(title = "用户信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjUser shzjUser) {
        ShzjUser user = shzjUser;
        shzjUser = shzjUserService.selectShzjUserById(shzjUser.getUserId());
        shzjUser.setLoginPwd(DigestUtils.md5Hex(user.getLoginPwd() + shzjUser.getSalt()));
        return toAjax(shzjUserService.updateShzjUser(shzjUser));
    }

    /**
     * 删除用户信息
     */
    @RequiresPermissions("shzj:user:remove")
    @Log(title = "用户信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(shzjUserService.deleteShzjUserByIds(ids));
    }
}
