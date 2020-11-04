package com.ruoyi.shzj.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ruoyi.shzj.domain.*;
import com.ruoyi.shzj.service.*;
import com.ruoyi.shzj.util.VariableName;
import com.ruoyi.shzj.util.YiyuanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

/**
 * 动态详情信息Controller
 *
 * @author ruoyi
 * @date 2020-08-14
 */
@Controller
@RequestMapping("/shzj/dynamicContent")
@Api(tags = "dynamicContent")
public class ShzjDynamicContentController extends BaseController {
    private String prefix = "shzj/dynamicContent";

    @Autowired
    private IShzjDynamicContentService shzjDynamicContentService;
    @Autowired
    private IShzjDynamicService shzjDynamicService;
    @Autowired
    private IShzjUserService shzjUserService;
    @Autowired
    private IShzjCityService shzjCityService;
    @Autowired
    private ShzjCommentController shzjCommentController;
    @Autowired
    private ShzjLikeController shzjLikeController;
    @Autowired
    private IShzjLikeService shzjLikeService;

    @RequiresPermissions("shzj:dynamicContent:view")
    @GetMapping()
    public String dynamicContent() {
        return prefix + "/dynamicContent";
    }

    @PostMapping("/addDynamicContent")
    @ResponseBody
    @ApiOperation("addDynamicContent")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "shzjDynamic",value = "诗画浙江话题",paramType = "body"),
                    @ApiImplicitParam(name = "shzjDynamicContent",value = "诗画浙江话题内容",paramType = "body")
            }
    )
    public AjaxResult addDynamicContent(ShzjDynamic shzjDynamic,ShzjDynamicContent shzjDynamicContent){
        if(shzjDynamicService.insertShzjDynamic(shzjDynamic)!=1)
            return error("添加失败");
        List<ShzjDynamic> shzjDynamics = shzjDynamicService.selectShzjDynamicList(shzjDynamic);
        shzjDynamicContent.setDynamicId(shzjDynamics.get(0).getDynamicId());
        if(shzjDynamicContentService.insertShzjDynamicContent(shzjDynamicContent)!=1)
            return error("插入动态内容失败");
        return success();
    }

    @PostMapping("/deleteDynamic")
    @ResponseBody
    @ApiOperation("deleteDynamic")
    @ApiImplicitParam(name = "dynamicId",value = "动态编号",paramType = "query")
    public AjaxResult deleteDynamic(@RequestParam("dynamicId")Integer dynamicId){
        shzjDynamicService.deleteShzjDynamicById(dynamicId);
        ShzjDynamicContent shzjDynamicContent=new ShzjDynamicContent();
        shzjDynamicContent.setDynamicId(dynamicId);
        List<ShzjDynamicContent> shzjDynamicContents = shzjDynamicContentService.selectShzjDynamicContentList(shzjDynamicContent);

        return shzjDynamicContentService.deleteShzjDynamicContentById(shzjDynamicContents.get(0).getDynamicContentId())==1?success():error();
    }


    /**
     * 查询动态详情信息列表
     */
    @RequiresPermissions("shzj:dynamicContent:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjDynamicContent shzjDynamicContent) {
        startPage();
        List<ShzjDynamicContent> list = shzjDynamicContentService.selectShzjDynamicContentList(shzjDynamicContent);
        return getDataTable(list);
    }

    @GetMapping("/like")
    @ResponseBody
    @ApiOperation("like")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户编号",paramType = "query"),
            @ApiImplicitParam(name = "commentId",value = "评论编号",paramType = "query")
    })
    public AjaxResult like(@RequestParam("userId")Integer userId,
                           @RequestParam("commentId")Integer commentId){
        return shzjLikeController.dynamicCommentLike(userId,commentId);
    }
    @GetMapping("/dislike")
    @ResponseBody
    @ApiOperation("dislike")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "用户编号",paramType = "query"),
            @ApiImplicitParam(name = "commentId",value = "评论编号",paramType = "query")
    })
    public AjaxResult dislike(@RequestParam("userId")Integer userId,
                           @RequestParam("commentId")Integer commentId){
        return shzjLikeController.dynamicCommentDislike(userId,commentId);
    }


    @PostMapping("/addComment")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dynamicId",value = "动态编号",paramType = "query"),
            @ApiImplicitParam(name = "userId",value = "用户编号",paramType = "query"),
            @ApiImplicitParam(name = "commentCon",value = "评论内容",paramType = "query")
    })
    @ApiOperation("addComment")
    public AjaxResult addComment(@RequestParam("dynamicId") Integer dynamicId,
                                 @RequestParam("userId") Integer userId,
                                 @RequestParam("commentCon") String commentCon) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        if(!YiyuanUtil.isBlock(commentCon))
            return error("暴******粗口");
        return shzjCommentController.dynamicAddComment(dynamicId,userId,commentCon)?success():error();
    }

    @PostMapping("/commentInfo")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dynamicId",value = "动态编号",paramType = "query"),
            @ApiImplicitParam(name = "userId",value = "用户编号",paramType = "query"),
    })
    @ApiOperation("commentInfo")
    public AjaxResult commentInfo(@RequestParam("dynamicId") Integer dynamicId,
                                  @RequestParam("userId")Integer userId){
        return AjaxResult.success(shzjCommentController.dynamicCommentList(dynamicId,userId));
    }

    @PostMapping("/dynamicInfo")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dynamicId",value = "动态编号",paramType = "query"),
            @ApiImplicitParam(name = "userId",value = "用户编号",paramType = "query"),
    })
    @ApiOperation("dynamicInfo")
    public AjaxResult dynamicInfo(@RequestParam("dynamicId") Integer dynamicId,
                                  @RequestParam("userId")Integer userId) {
        ShzjDynamicContent dynamicContent = new ShzjDynamicContent();
        dynamicContent.setDynamicId(dynamicId);
        ShzjDynamicContent shzjDynamicContent = shzjDynamicContentService.selectShzjDynamicContentList(dynamicContent).get(0);
        ShzjDynamic shzjDynamic = shzjDynamicService.selectShzjDynamicById(dynamicId);
        ShzjUser shzjUser = shzjUserService.selectShzjUserById(shzjDynamic.getAuthorId());
        DynamicContentResult dynamicContentResult = new DynamicContentResult();
        dynamicContentResult.setAuthorId(shzjUser.getUserId());
        dynamicContentResult.setDynamicId(dynamicId);
        dynamicContentResult.setHeadPicUrl(VariableName.domain + shzjUser.getHeadPortrait());
        dynamicContentResult.setUserName(shzjUser.getUserName());
        dynamicContentResult.setCityName(shzjCityService.selectShzjCityById(shzjDynamic.getCityId()).getCityName());
        List<String> picUrls = new ArrayList<>();
        for (String url : shzjDynamic.getDynamicPic().split("\\s+")) {
            url = VariableName.domain + url;
            picUrls.add(url);
        }
        dynamicContentResult.setPicUrl(picUrls);
        dynamicContentResult.setDynamicTitle(shzjDynamic.getDynamicTitle());
        dynamicContentResult.setDynamicContent(shzjDynamicContent.getDynamicContent());
        dynamicContentResult.setTopicTitle(shzjDynamic.getDynamicTopic());
        dynamicContentResult.setCreatTime(shzjDynamic.getCreatTime());
        ShzjLike shzjLike=new ShzjLike();
        shzjLike.setContent("dynamic:"+dynamicId);
        shzjLike.setUserId(userId);
        List<ShzjLike> shzjLikes = shzjLikeService.selectShzjLikeList(shzjLike);
        dynamicContentResult.setLike(shzjLikes.size()>0);
        dynamicContentResult.setLikeNum(shzjDynamic.getLikeNum());
        return AjaxResult.success(dynamicContentResult);
    }

    class DynamicContentResult {
        private Integer dynamicId;
        private Integer authorId;
        private String headPicUrl;
        private String userName;
        private String cityName;
        private List<String> picUrl;
        private String dynamicTitle;
        private String dynamicContent;
        private String topicTitle;
        private Date creatTime;
        private Integer likeNum;
        private boolean isLike;

        public Integer getAuthorId() {
            return authorId;
        }

        public void setAuthorId(Integer authorId) {
            this.authorId = authorId;
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

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public Integer getDynamicId() {
            return dynamicId;
        }

        public void setDynamicId(Integer dynamicId) {
            this.dynamicId = dynamicId;
        }

        public String getHeadPicUrl() {
            return headPicUrl;
        }

        public void setHeadPicUrl(String headPicUrl) {
            this.headPicUrl = headPicUrl;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public List<String> getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(List<String> picUrl) {
            this.picUrl = picUrl;
        }

        public String getDynamicTitle() {
            return dynamicTitle;
        }

        public void setDynamicTitle(String dynamicTitle) {
            this.dynamicTitle = dynamicTitle;
        }

        public String getDynamicContent() {
            return dynamicContent;
        }

        public void setDynamicContent(String dynamicContent) {
            this.dynamicContent = dynamicContent;
        }

        public String getTopicTitle() {
            return topicTitle;
        }

        public void setTopicTitle(String topicTitle) {
            this.topicTitle = topicTitle;
        }

        public Date getCreatTime() {
            return creatTime;
        }

        public void setCreatTime(Date creatTime) {
            this.creatTime = creatTime;
        }
    }

    /**
     * 导出动态详情信息列表
     */
    @RequiresPermissions("shzj:dynamicContent:export")
    @Log(title = "动态详情信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjDynamicContent shzjDynamicContent) {
        List<ShzjDynamicContent> list = shzjDynamicContentService.selectShzjDynamicContentList(shzjDynamicContent);
        ExcelUtil<ShzjDynamicContent> util = new ExcelUtil<ShzjDynamicContent>(ShzjDynamicContent.class);
        return util.exportExcel(list, "dynamicContent");
    }

    /**
     * 新增动态详情信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存动态详情信息
     */
    @RequiresPermissions("shzj:dynamicContent:add")
    @Log(title = "动态详情信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjDynamicContent shzjDynamicContent) {
        return toAjax(shzjDynamicContentService.insertShzjDynamicContent(shzjDynamicContent));
    }

    /**
     * 修改动态详情信息
     */
    @GetMapping("/edit/{dynamicContentId}")
    public String edit(@PathVariable("dynamicContentId") Integer dynamicContentId, ModelMap mmap) {
        ShzjDynamicContent shzjDynamicContent = shzjDynamicContentService.selectShzjDynamicContentById(dynamicContentId);
        mmap.put("shzjDynamicContent", shzjDynamicContent);
        return prefix + "/edit";
    }

    /**
     * 修改保存动态详情信息
     */
    @RequiresPermissions("shzj:dynamicContent:edit")
    @Log(title = "动态详情信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjDynamicContent shzjDynamicContent) {
        return toAjax(shzjDynamicContentService.updateShzjDynamicContent(shzjDynamicContent));
    }

    /**
     * 删除动态详情信息
     */
    @RequiresPermissions("shzj:dynamicContent:remove")
    @Log(title = "动态详情信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(shzjDynamicContentService.deleteShzjDynamicContentByIds(ids));
    }
}
