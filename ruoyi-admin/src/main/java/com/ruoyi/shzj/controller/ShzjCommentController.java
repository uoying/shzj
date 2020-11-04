package com.ruoyi.shzj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kennycason.kumo.WordFrequency;
import com.ruoyi.shzj.domain.ShzjDynamic;
import com.ruoyi.shzj.domain.ShzjLike;
import com.ruoyi.shzj.domain.ShzjUser;
import com.ruoyi.shzj.service.IShzjLikeService;
import com.ruoyi.shzj.service.IShzjUserService;
import com.ruoyi.shzj.util.CiyunUtil;
import com.ruoyi.shzj.util.VariableName;
import io.swagger.models.auth.In;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.shzj.domain.ShzjComment;
import com.ruoyi.shzj.service.IShzjCommentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评论信息Controller
 *
 * @author ruoyi
 * @date 2020-08-15
 */
@Controller
@RequestMapping("/shzj/comment")
public class ShzjCommentController extends BaseController {
    private String prefix = "shzj/comment";

    @Autowired
    private IShzjCommentService shzjCommentService;
    @Autowired
    private IShzjUserService shzjUserService;
    @Autowired
    private IShzjLikeService shzjLikeService;


    @RequiresPermissions("shzj:comment:view")
    @GetMapping()
    public String comment() {
        return prefix + "/comment";
    }



    /**
     * 动态模块评论代码
     * @author OldCute
     */

    /**
     * 添加动态模块评论
     */
    public boolean dynamicAddComment(Integer dynamicId,
                                        Integer userId,
                                        String commentCon) {
        ShzjComment shzjComment=new ShzjComment();
        shzjComment.setUserId(userId);
        shzjComment.setCommentContent(commentCon);
        shzjComment.setContentId("dynamic:"+dynamicId);
        return shzjCommentService.insertShzjComment(shzjComment)==1?true:false;
    }
    @RequestMapping("/ciyun")
    @ResponseBody
    public AjaxResult ciyun(@RequestParam("conId")Integer conId) throws IOException {
        ShzjComment shzjComment=new ShzjComment();
        shzjComment.setContentId("content:"+conId);
        List<String> list = shzjCommentService.selectShzjConCommentList(shzjComment);
        CiyunUtil.ciyun(list);
        List<WordFrequency> wordFrequencies = CiyunUtil.updateCiyun(list);
        return AjaxResult.success(wordFrequencies);
    }
    /**
     * 获取动态模块评论
     */
    public List<CommentResult> dynamicCommentList(Integer dynamicId,Integer userId) {
        ShzjComment shzjComment=new ShzjComment();
        shzjComment.setContentId("dynamic:"+dynamicId);
        List<ShzjComment> shzjComments = shzjCommentService.selectShzjCommentList(shzjComment);
        List<CommentResult> commentResults=new ArrayList<>();
        for(ShzjComment comment:shzjComments){
            CommentResult commentResult=new CommentResult();
            commentResult.setCommentId(comment.getCommentId());
            commentResult.setUserId(comment.getUserId());
            ShzjUser shzjUser = shzjUserService.selectShzjUserById(comment.getUserId());
            commentResult.setHeadPortrait(VariableName.domain+shzjUser.getHeadPortrait());
            commentResult.setUserName(shzjUser.getUserName());
            commentResult.setCreatTime(comment.getCreatTime());
            commentResult.setCommentContent(comment.getCommentContent());
            commentResult.setLikeNum(comment.getLikeNum());
            ShzjLike shzjLike=new ShzjLike();
            shzjLike.setContent("dynamicComment:"+comment.getCommentId());
            shzjLike.setUserId(userId);
            List<ShzjLike> shzjLikes = shzjLikeService.selectShzjLikeList(shzjLike);
            commentResult.setLike(shzjLikes.size()>0);
            commentResults.add(commentResult);
        }
        return commentResults;
    }

    /**
     * 内容模块评论添加
     * @param contentId
     * @param userId
     * @param commentCon
     * @return
     */
    public boolean contentAddComment(Integer contentId, Integer userId, String commentCon) {
        ShzjComment shzjComment=new ShzjComment();
        shzjComment.setUserId(userId);
        shzjComment.setCommentContent(commentCon);
        shzjComment.setContentId("content:"+contentId);
        return shzjCommentService.insertShzjComment(shzjComment)==1?true:false;
    }

    public List<CommentResult> contentCommentList(Integer contentId,Integer userId) {
        ShzjComment shzjComment=new ShzjComment();
        shzjComment.setContentId("content:"+contentId);
        List<ShzjComment> shzjComments = shzjCommentService.selectShzjCommentList(shzjComment);
        List<CommentResult> commentResults=new ArrayList<>();
        for(ShzjComment comment:shzjComments){
            CommentResult commentResult=new CommentResult();
            commentResult.setCommentId(comment.getCommentId());
            commentResult.setUserId(comment.getUserId());
            ShzjUser shzjUser = shzjUserService.selectShzjUserById(comment.getUserId());
            commentResult.setHeadPortrait(VariableName.domain+shzjUser.getHeadPortrait());
            commentResult.setUserName(shzjUser.getUserName());
            commentResult.setCreatTime(comment.getCreatTime());
            commentResult.setCommentContent(comment.getCommentContent());
            commentResult.setLikeNum(comment.getLikeNum());
            ShzjLike shzjLike=new ShzjLike();
            shzjLike.setContent("contentComment:"+comment.getCommentId());
            shzjLike.setUserId(userId);
            List<ShzjLike> shzjLikes = shzjLikeService.selectShzjLikeList(shzjLike);
            commentResult.setLike(shzjLikes.size()>0);
            commentResults.add(commentResult);
        }
        return commentResults;
    }


    class CommentResult {
        private Integer commentId;
        private Integer userId;
        private String headPortrait;
        private String userName;
        private Date creatTime;
        private String commentContent;
        private Integer likeNum;
        private boolean isLike;

        public String getHeadPortrait() {
            return headPortrait;
        }

        public void setHeadPortrait(String headPortrait) {
            this.headPortrait = headPortrait;
        }

        public Integer getCommentId() {
            return commentId;
        }

        public void setCommentId(Integer commentId) {
            this.commentId = commentId;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Date getCreatTime() {
            return creatTime;
        }

        public void setCreatTime(Date creatTime) {
            this.creatTime = creatTime;
        }

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public Integer getLikeNum() {
            return likeNum;
        }

        public void setLikeNum(Integer likeNum) {
            this.likeNum = likeNum;
        }

        public boolean isLike() {
            return isLike;
        }

        public void setLike(boolean like) {
            isLike = like;
        }
    }
    /**
     * 查询评论信息列表
     */
    @RequiresPermissions("shzj:comment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjComment shzjComment) {
        startPage();
        List<ShzjComment> list = shzjCommentService.selectShzjCommentList(shzjComment);
        return getDataTable(list);
    }

    /**
     * 导出评论信息列表
     */
    @RequiresPermissions("shzj:comment:export")
    @Log(title = "评论信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjComment shzjComment) {
        List<ShzjComment> list = shzjCommentService.selectShzjCommentList(shzjComment);
        ExcelUtil<ShzjComment> util = new ExcelUtil<ShzjComment>(ShzjComment.class);
        return util.exportExcel(list, "comment");
    }

    /**
     * 新增评论信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存评论信息
     */
    @RequiresPermissions("shzj:comment:add")
    @Log(title = "评论信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjComment shzjComment) {
        return toAjax(shzjCommentService.insertShzjComment(shzjComment));
    }

    /**
     * 修改评论信息
     */
    @GetMapping("/edit/{commentId}")
    public String edit(@PathVariable("commentId") Integer commentId, ModelMap mmap) {
        ShzjComment shzjComment = shzjCommentService.selectShzjCommentById(commentId);
        mmap.put("shzjComment", shzjComment);
        return prefix + "/edit";
    }

    /**
     * 修改保存评论信息
     */
    @RequiresPermissions("shzj:comment:edit")
    @Log(title = "评论信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjComment shzjComment) {
        return toAjax(shzjCommentService.updateShzjComment(shzjComment));
    }

    /**
     * 删除评论信息
     */
    @RequiresPermissions("shzj:comment:remove")
    @Log(title = "评论信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(shzjCommentService.deleteShzjCommentByIds(ids));
    }


}
