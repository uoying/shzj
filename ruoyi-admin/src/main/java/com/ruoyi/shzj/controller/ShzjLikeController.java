package com.ruoyi.shzj.controller;

import java.util.List;

import com.ruoyi.shzj.domain.*;
import com.ruoyi.shzj.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 点赞信息Controller
 *
 * @author ruoyi
 * @date 2020-08-15
 */
@Controller
@RequestMapping("/shzj/like")
public class ShzjLikeController extends BaseController {
    private String prefix = "shzj/like";

    @Autowired
    private IShzjLikeService shzjLikeService;
    @Autowired
    private IShzjCommentService shzjCommentService;
    @Autowired
    private IShzjDynamicService shzjDynamicService;
    @Autowired
    private IShzjContentService shzjContentService;
    @Autowired
    private IShzjContentParticularService shzjContentParticularService;

    @RequiresPermissions("shzj:like:view")
    @GetMapping()
    public String like() {
        return prefix + "/like";
    }

    /**
     * 动态评论模块点赞
     */
    public AjaxResult dynamicCommentLike(Integer userId,
                                         Integer commentId) {
        ShzjLike shzjLike = new ShzjLike();
        shzjLike.setUserId(userId);
        shzjLike.setContent("dynamicComment:" + commentId);
        ShzjComment shzjComment = shzjCommentService.selectShzjCommentById(commentId);
        shzjComment.setLikeNum(shzjComment.getLikeNum() + 1);
        if (shzjCommentService.updateShzjComment(shzjComment) != 1)
            return error("点赞失败，数据未追加");
        if (shzjLikeService.selectShzjLikeList(shzjLike).size() != 0)
            return error("已点赞");
        return shzjLikeService.insertShzjLike(shzjLike) == 1 ? success("点赞成功") : error("点赞失败");
    }

    public AjaxResult dynamicCommentDislike(Integer userId,
                                            Integer commentId) {
        ShzjLike shzjLike = new ShzjLike();
        shzjLike.setUserId(userId);
        shzjLike.setContent("dynamicComment:" + commentId);
        List<ShzjLike> shzjLikes = shzjLikeService.selectShzjLikeList(shzjLike);
        if (shzjLikes.size() != 0)
            shzjLike = shzjLikes.get(0);
        ShzjComment shzjComment = shzjCommentService.selectShzjCommentById(commentId);
        shzjComment.setLikeNum(shzjComment.getLikeNum() - 1);
        if (shzjCommentService.updateShzjComment(shzjComment) != 1)
            return error("取消点赞失败，数据未追加");
        return shzjLikeService.deleteShzjLikeById(shzjLike.getLikeId()) == 1 ? success("取消点赞成功") : error("取消点赞失败");
    }

    /**
     *内容模块评论点赞
     */
    public AjaxResult contentCommentDislike(Integer userId, Integer commentId) {
        ShzjLike shzjLike = new ShzjLike();
        shzjLike.setUserId(userId);
        shzjLike.setContent("contentComment:" + commentId);
        List<ShzjLike> shzjLikes = shzjLikeService.selectShzjLikeList(shzjLike);
        if (shzjLikes.size() != 0)
            shzjLike = shzjLikes.get(0);
        ShzjComment shzjComment = shzjCommentService.selectShzjCommentById(commentId);
        shzjComment.setLikeNum(shzjComment.getLikeNum() - 1);
        if (shzjCommentService.updateShzjComment(shzjComment) != 1)
            return error("取消点赞失败，数据未追加");
        return shzjLikeService.deleteShzjLikeById(shzjLike.getLikeId()) == 1 ? success("取消点赞成功") : error("取消点赞失败");
    }

    public AjaxResult contentCommentLike(Integer userId, Integer commentId) {
        ShzjLike shzjLike = new ShzjLike();
        shzjLike.setUserId(userId);
        shzjLike.setContent("contentComment:" + commentId);
        ShzjComment shzjComment = shzjCommentService.selectShzjCommentById(commentId);
        shzjComment.setLikeNum(shzjComment.getLikeNum() + 1);
        if (shzjCommentService.updateShzjComment(shzjComment) != 1)
            return error("点赞失败，数据未追加");
        if (shzjLikeService.selectShzjLikeList(shzjLike).size() != 0)
            return error("已点赞");
        return shzjLikeService.insertShzjLike(shzjLike) == 1 ? success("点赞成功") : error("点赞失败");
    }
    /**
     * 动态模块点赞
     */
    public AjaxResult dynamicLike(Integer userId, Integer dynamic) {
        ShzjLike shzjLike = new ShzjLike();
        shzjLike.setUserId(userId);
        shzjLike.setContent("dynamic:" + dynamic);
        ShzjDynamic shzjDynamic = shzjDynamicService.selectShzjDynamicById(dynamic);
        shzjDynamic.setLikeNum(shzjDynamic.getLikeNum() + 1);
        if (shzjDynamicService.updateShzjDynamic(shzjDynamic) != 1)
            return error("点赞失败，数据未追加");
        if (shzjLikeService.selectShzjLikeList(shzjLike).size() != 0)
            return error("已点赞");
        return shzjLikeService.insertShzjLike(shzjLike) == 1 ? success("点赞成功") : error("点赞失败");
    }

    public AjaxResult dynamicDislike(Integer userId, Integer dynamic) {
        ShzjLike shzjLike = new ShzjLike();
        shzjLike.setUserId(userId);
        shzjLike.setContent("dynamic:" + dynamic);
        List<ShzjLike> shzjLikes = shzjLikeService.selectShzjLikeList(shzjLike);
        if (shzjLikes.size() != 0)
            shzjLike = shzjLikes.get(0);
        ShzjDynamic shzjDynamic = shzjDynamicService.selectShzjDynamicById(dynamic);
        shzjDynamic.setLikeNum(shzjDynamic.getLikeNum() - 1);
        if (shzjDynamicService.updateShzjDynamic(shzjDynamic) != 1)
            return error("取消点赞失败，数据未追加");
        return shzjLikeService.deleteShzjLikeById(shzjLike.getLikeId()) == 1 ? success("取消点赞成功") : error("取消点赞失败");
    }
    public AjaxResult contentDislike(Integer userId, Integer contentId) {
        ShzjLike shzjLike = new ShzjLike();
        shzjLike.setUserId(userId);
        shzjLike.setContent("content:" + contentId);
        List<ShzjLike> shzjLikes = shzjLikeService.selectShzjLikeList(shzjLike);
        if (shzjLikes.size() != 0)
            shzjLike = shzjLikes.get(0);
        ShzjContentParticular shzjContentParticular=new ShzjContentParticular();
        shzjContentParticular.setConId(contentId);
        ShzjContentParticular contentParticular=shzjContentParticularService.selectShzjContentParticularList(shzjContentParticular).get(0);
        contentParticular.setLikeNum(contentParticular.getLikeNum() - 1);
        if (shzjContentParticularService.updateShzjContentParticular(contentParticular) != 1)
            return error("点赞失败，数据未追加");
        return shzjLikeService.deleteShzjLikeById(shzjLike.getLikeId()) == 1 ? success("取消点赞成功") : error("取消点赞失败");
    }

    public AjaxResult contentLike(Integer userId, Integer contentId) {
        ShzjLike shzjLike = new ShzjLike();
        shzjLike.setUserId(userId);
        shzjLike.setContent("content:" + contentId);
        ShzjContentParticular shzjContentParticular=new ShzjContentParticular();
        shzjContentParticular.setConId(contentId);
        ShzjContentParticular contentParticular=shzjContentParticularService.selectShzjContentParticularList(shzjContentParticular).get(0);
        contentParticular.setLikeNum(contentParticular.getLikeNum() + 1);
        if (shzjContentParticularService.updateShzjContentParticular(contentParticular) != 1)
            return error("点赞失败，数据未追加");
        if (shzjLikeService.selectShzjLikeList(shzjLike).size() != 0)
            return error("已点赞");
        return shzjLikeService.insertShzjLike(shzjLike) == 1 ? success("点赞成功") : error("点赞失败");
    }

    /**
     * 查询点赞信息列表
     */
    @RequiresPermissions("shzj:like:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjLike shzjLike) {
        startPage();
        List<ShzjLike> list = shzjLikeService.selectShzjLikeList(shzjLike);
        return getDataTable(list);
    }


    /**
     * 导出点赞信息列表
     */
    @RequiresPermissions("shzj:like:export")
    @Log(title = "点赞信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjLike shzjLike) {
        List<ShzjLike> list = shzjLikeService.selectShzjLikeList(shzjLike);
        ExcelUtil<ShzjLike> util = new ExcelUtil<ShzjLike>(ShzjLike.class);
        return util.exportExcel(list, "like");
    }

    /**
     * 新增点赞信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存点赞信息
     */
    @RequiresPermissions("shzj:like:add")
    @Log(title = "点赞信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjLike shzjLike) {
        return toAjax(shzjLikeService.insertShzjLike(shzjLike));
    }

    /**
     * 修改点赞信息
     */
    @GetMapping("/edit/{likeId}")
    public String edit(@PathVariable("likeId") Integer likeId, ModelMap mmap) {
        ShzjLike shzjLike = shzjLikeService.selectShzjLikeById(likeId);
        mmap.put("shzjLike", shzjLike);
        return prefix + "/edit";
    }

    /**
     * 修改保存点赞信息
     */
    @RequiresPermissions("shzj:like:edit")
    @Log(title = "点赞信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjLike shzjLike) {
        return toAjax(shzjLikeService.updateShzjLike(shzjLike));
    }

    /**
     * 删除点赞信息
     */
    @RequiresPermissions("shzj:like:remove")
    @Log(title = "点赞信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(shzjLikeService.deleteShzjLikeByIds(ids));
    }



}
