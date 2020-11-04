package com.ruoyi.shzj.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.shzj.domain.*;
import com.ruoyi.shzj.service.*;
import com.ruoyi.shzj.util.CiyunUtil;
import com.ruoyi.shzj.util.VariableName;
import com.ruoyi.shzj.util.YiyuanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import oshi.util.StringUtil;

/**
 * 内容详情信息Controller
 *
 * @author ruoyi
 * @date 2020-08-15
 */
@Controller
@RequestMapping("/shzj/contentParticular")
@Api(tags = "contentParticular")
public class ShzjContentParticularController extends BaseController {
    private String prefix = "shzj/contentParticular";

    @Autowired
    private IShzjContentParticularService shzjContentParticularService;
    @Autowired
    private IShzjContentService shzjContentService;
    @Autowired
    private IShzjLikeService shzjLikeService;
    @Autowired
    private ShzjCommentController shzjCommentController;
    @Autowired
    private ShzjLikeController shzjLikeController;
    @Autowired
    private IShzjCityService shzjCityService;
    @Autowired
    private IShzjTypeService shzjTypeService;

    @GetMapping("/like")
    @ResponseBody
    @ApiOperation("like")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户编号", paramType = "query"),
            @ApiImplicitParam(name = "commentId", value = "评论编号", paramType = "query")
    })
    public AjaxResult like(@RequestParam("userId") Integer userId,
                           @RequestParam("commentId") Integer commentId) {
        return shzjLikeController.contentCommentLike(userId, commentId);
    }

    @GetMapping("/dislike")
    @ResponseBody
    @ApiOperation("dislike")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户编号", paramType = "query"),
            @ApiImplicitParam(name = "commentId", value = "评论编号", paramType = "query")
    })
    public AjaxResult dislike(@RequestParam("userId") Integer userId,
                              @RequestParam("commentId") Integer commentId) {
        return shzjLikeController.contentCommentDislike(userId, commentId);
    }

    @PostMapping("/addComment")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentId", value = "内容编号", paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "用户编号", paramType = "query"),
            @ApiImplicitParam(name = "commentCon", value = "评论内容", paramType = "query")
    })
    @ApiOperation("addComment")
    public AjaxResult addComment(@RequestParam("contentId") Integer contentId,
                                 @RequestParam("userId") Integer userId,
                                 @RequestParam("commentCon") String commentCon) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        if (!YiyuanUtil.isBlock(commentCon))
            return error("暴******粗口");
        return shzjCommentController.contentAddComment(contentId, userId, commentCon) ? success() : error();
    }

    @PostMapping("/commentInfo")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentId", value = "内容编号", paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "用户编号", paramType = "query"),
    })
    @ApiOperation("commentInfo")
    public AjaxResult commentInfo(@RequestParam("contentId") Integer contentId,
                                  @RequestParam("userId") Integer userId) {
        List<ShzjCommentController.CommentResult> commentResults = shzjCommentController.contentCommentList(contentId, userId);
        List<String> list = new ArrayList<>();
        for (ShzjCommentController.CommentResult commentResult : commentResults)
            list.add(commentResult.getCommentContent());
        System.err.println(CiyunUtil.updateCiyun(list));
        return AjaxResult.success(commentResults);
    }

    @RequiresPermissions("shzj:contentParticular:view")
    @GetMapping()
    public String contentParticular() {
        return prefix + "/contentParticular";
    }

    @PostMapping("/particularInfo")
    @ResponseBody
    @ApiImplicitParams({
            @ApiImplicitParam(name = "contentId", value = "内容编号", paramType = "query"),
            @ApiImplicitParam(name = "userId", value = "用户编号", paramType = "query"),
    })
    @ApiOperation("particularInfo")
    public AjaxResult dynamicInfo(@RequestParam("contentId") Integer contentId,
                                  @RequestParam("userId") Integer userId) {
        ParticularResult result = new ParticularResult();
        ShzjContentParticular shzjContentParticular = new ShzjContentParticular();
        ShzjContent shzjContent = shzjContentService.selectShzjContentById(contentId);
        shzjContentParticular.setConId(contentId);
        ShzjContentParticular contentParticular = shzjContentParticularService.selectShzjContentParticularList(shzjContentParticular).get(0);
        result.setContentId(contentId);
        result.setParticularId(contentParticular.getParticularId());
        result.setIs720(contentParticular.getIs720());
        String[] split = contentParticular.getMianPicurl().trim().split("\\s+");
        for (int i = 0; i < split.length; i++)
            split[i] = VariableName.domain + split[i];
        result.setMainPicUrls(split);
        result.setLikeNum(contentParticular.getLikeNum());
        result.setContentTile(shzjContent.getConTitile());
        result.setScore(shzjContent.getConScore());
        result.setAddress(shzjContent.getConAddress());
        result.setAudio(shzjContent.getConAudio());
        result.setH5(contentParticular.getParticularH5());
        String[] arrays = contentParticular.getArrays().split("\\s+");
        String[][]arr=new String[arrays.length/2][2];
        for (int i = 0; i < arrays.length/2; i++) {
            arr[i][0]=arrays[i*2];
            arr[i][1]=arrays[i*2+1];
        }
        result.setArrays(arr);
        if(!contentParticular.getMinorPicurl().trim().equals("")){
            split = contentParticular.getMinorPicurl().split("\\s+");
            String[][] minorPic = new String[split.length][2];
            for (int i = 0; i < split.length; i++) {
                String[] split1 = split[i].split(":");
                minorPic[i][0] = split1[0];
                minorPic[i][1] = VariableName.domain + split1[1];
            }
            result.setMinorPic(minorPic);
        }
        ShzjLike shzjLike = new ShzjLike();
        shzjLike.setContent("content:" + contentId);
        shzjLike.setUserId(userId);
        List<ShzjLike> shzjLikes = shzjLikeService.selectShzjLikeList(shzjLike);
        result.setLike(shzjLikes.size() > 0);
        return AjaxResult.success(result);
    }


    class ParticularResult {
        private Integer contentId;
        private Integer particularId;
        private Integer is720;
        private String[] mainPicUrls;
        private Integer likeNum;
        private String contentTile;
        private Integer score;
        private String address;
        private String audio;
        private String h5;
        private String[][] arrays;
        private String[][] minorPic;
        private boolean isLike;

        public String[][] getArrays() {
            return arrays;
        }

        public void setArrays(String[][] arrays) {
            this.arrays = arrays;
        }

        public String getAudio() {
            return audio;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }

        public Integer getContentId() {
            return contentId;
        }

        public void setContentId(Integer contentId) {
            this.contentId = contentId;
        }

        public Integer getParticularId() {
            return particularId;
        }

        public void setParticularId(Integer particularId) {
            this.particularId = particularId;
        }

        public Integer getIs720() {
            return is720;
        }

        public void setIs720(Integer is720) {
            this.is720 = is720;
        }

        public String[] getMainPicUrls() {
            return mainPicUrls;
        }

        public void setMainPicUrls(String[] mainPicUrls) {
            this.mainPicUrls = mainPicUrls;
        }

        public Integer getLikeNum() {
            return likeNum;
        }

        public void setLikeNum(Integer likeNum) {
            this.likeNum = likeNum;
        }

        public String getContentTile() {
            return contentTile;
        }

        public void setContentTile(String contentTile) {
            this.contentTile = contentTile;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getH5() {
            return h5;
        }

        public void setH5(String h5) {
            this.h5 = h5;
        }

        public String[][] getMinorPic() {
            return minorPic;
        }

        public void setMinorPic(String[][] minorPic) {
            this.minorPic = minorPic;
        }

        public boolean isLike() {
            return isLike;
        }

        public void setLike(boolean like) {
            isLike = like;
        }
    }

    /**
     * 查询内容详情信息列表
     */
    @RequiresPermissions("shzj:contentParticular:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjContentParticular shzjContentParticular) {
        startPage();
        List<ShzjContentParticular> shzjContentParticulars = shzjContentParticularService.selectShzjContentParticularList(shzjContentParticular);
        List<ListResult> results = new ArrayList<>();
        for (ShzjContentParticular contentParticular : shzjContentParticulars) {
            ShzjContent shzjContent = shzjContentService.selectShzjContentById(contentParticular.getConId());
            ListResult listResult = new ListResult();
            listResult.setConTitile(shzjContent.getConTitile());
            listResult.setConAddress(shzjContent.getConAddress());
            listResult.setCityName(shzjCityService.selectShzjCityById(shzjContent.getConCity()).getCityName());
            listResult.setIsRecommend(shzjContent.getIsRecommend());
            listResult.setConScore(shzjContent.getConScore());
            listResult.setTypeName(shzjTypeService.selectShzjTypeById(shzjContent.getConType()).getTypeName());
            listResult.setIs720(contentParticular.getIs720());
            listResult.setLikeNum(contentParticular.getLikeNum());
            listResult.setParticularId(contentParticular.getParticularId());
            listResult.setConPicture(VariableName.domain+shzjContent.getConPicture());
            String[] split = contentParticular.getMianPicurl().trim().split("\\s+");
            for (int i = 0; i < split.length; i++)
                split[i] = VariableName.domain + split[i];
            listResult.setMianPicurl(StringUtil.join("</br>", split));
            if (contentParticular.getMinorPicurl() != null && !contentParticular.getMinorPicurl().trim().equals("")) {
                split = contentParticular.getMinorPicurl().trim().split("\\s+");
                for (int i = 0; i < split.length; i++) {
                    String[] split1 = split[i].split(":");
                    split1[1] = VariableName.domain + split1[1];
                    split[i] = StringUtil.join(" ", split1);
                }
                listResult.setMinorPicurl(StringUtil.join("</br>", split));
            }
            results.add(listResult);
        }
        return getDataTable(results);
    }

    class ListResult extends ShzjContent {
        private Integer particularId;
        private Integer conId;
        private Integer is720;
        private Integer likeNum;
        private String particularH5;
        private String mianPicurl;
        private String minorPicurl;

        public Integer getParticularId() {
            return particularId;
        }

        public void setParticularId(Integer particularId) {
            this.particularId = particularId;
        }

        @Override
        public Integer getConId() {
            return conId;
        }

        @Override
        public void setConId(Integer conId) {
            this.conId = conId;
        }

        public Integer getIs720() {
            return is720;
        }

        public void setIs720(Integer is720) {
            this.is720 = is720;
        }

        public Integer getLikeNum() {
            return likeNum;
        }

        public void setLikeNum(Integer likeNum) {
            this.likeNum = likeNum;
        }

        public String getParticularH5() {
            return particularH5;
        }

        public void setParticularH5(String particularH5) {
            this.particularH5 = particularH5;
        }

        public String getMianPicurl() {
            return mianPicurl;
        }

        public void setMianPicurl(String mianPicurl) {
            this.mianPicurl = mianPicurl;
        }

        public String getMinorPicurl() {
            return minorPicurl;
        }

        public void setMinorPicurl(String minorPicurl) {
            this.minorPicurl = minorPicurl;
        }
    }

    /**
     * 导出内容详情信息列表
     */
    @RequiresPermissions("shzj:contentParticular:export")
    @Log(title = "内容详情信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjContentParticular shzjContentParticular) {
        List<ShzjContentParticular> list = shzjContentParticularService.selectShzjContentParticularList(shzjContentParticular);
        ExcelUtil<ShzjContentParticular> util = new ExcelUtil<ShzjContentParticular>(ShzjContentParticular.class);
        return util.exportExcel(list, "contentParticular");
    }

    /**
     * 新增内容详情信息
     */
    @GetMapping("/add")
    public String add(Model model) {
        List<ShzjCity> shzjCities = shzjCityService.selectShzjCityList(null);
        model.addAttribute("cities", shzjCities);
        return prefix + "/add";
    }

    /**
     * 新增保存内容详情信息
     */
    @RequiresPermissions("shzj:contentParticular:add")
    @Log(title = "内容详情信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjContent shzjContent, ShzjContentParticular shzjContentParticular) {
        if (shzjContent.getConPicture().trim().split("\\s+").length != 1 || shzjContent.getConPicture().trim().charAt(0) != '/')
            return error("背景图url格式有误");
        if (shzjContent.getConAudio() != null&&!("").equals(shzjContent.getConAudio()))
            if (shzjContent.getConAudio().trim().split("\\s+").length != 1 || shzjContent.getConAudio().trim().charAt(0) != '/')
                return error("音频url有误");
        if(shzjContentParticular.getMinorPicurl()!=null&&!("").equals(shzjContentParticular.getMinorPicurl()))
            for(String str:shzjContentParticular.getMinorPicurl().trim().split("\\s+"))
                if(str.split(":").length!=2)
                    return error("次要图片URL格式错误");
        shzjContentService.insertShzjContent(shzjContent);
        shzjContentParticular.setConId(shzjContent.getConId());
        return toAjax(shzjContentParticularService.insertShzjContentParticular(shzjContentParticular));
    }

    /**
     * 修改内容详情信息
     */
    @GetMapping("/edit/{particularId}")
    public String edit(@PathVariable("particularId") Integer particularId, ModelMap mmap) {
        ShzjContentParticular shzjContentParticular = shzjContentParticularService.selectShzjContentParticularById(particularId);
        mmap.put("shzjContentParticular", shzjContentParticular);
        return prefix + "/edit";
    }

    /**
     * 修改保存内容详情信息
     */
    @RequiresPermissions("shzj:contentParticular:edit")
    @Log(title = "内容详情信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjContentParticular shzjContentParticular) {
        return toAjax(shzjContentParticularService.updateShzjContentParticular(shzjContentParticular));
    }

    /**
     * 删除内容详情信息
     */
    @RequiresPermissions("shzj:contentParticular:remove")
    @Log(title = "内容详情信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(shzjContentParticularService.deleteShzjContentParticularByIds(ids));
    }
}
