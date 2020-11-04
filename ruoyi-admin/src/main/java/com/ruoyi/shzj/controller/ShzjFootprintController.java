package com.ruoyi.shzj.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.ruoyi.shzj.domain.ShzjPhoto;
import com.ruoyi.shzj.domain.ShzjUser;
import com.ruoyi.shzj.service.IShzjPhotoService;
import com.ruoyi.shzj.service.IShzjUserService;
import com.ruoyi.shzj.util.QiniuUpload;
import com.ruoyi.shzj.util.VariableName;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.shzj.domain.ShzjFootprint;
import com.ruoyi.shzj.service.IShzjFootprintService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import oshi.util.StringUtil;


/**
 * 足迹信息Controller
 *
 * @author ruoyi
 * @date 2020-07-30
 */
@Controller
@RequestMapping("/shzj/footprint")
public class ShzjFootprintController extends BaseController {
    private String prefix = "shzj/footprint";

    @Autowired
    private IShzjFootprintService shzjFootprintService;
    @Autowired
    private IShzjPhotoService shzjPhotoService;
    @Autowired
    private IShzjUserService shzjUserService;

    @RequiresPermissions("shzj:footprint:view")
    @GetMapping()
    public String footprint() {
        return prefix + "/footprint";
    }


    @RequestMapping("/infoList")
    @ResponseBody
    public AjaxResult infoList(@RequestParam("userId")int userId) {
        ShzjFootprint shzjFootprint = new ShzjFootprint();
        shzjFootprint.setUserId(userId);
        List<ShzjFootprint> shzjFootprints = shzjFootprintService.selectShzjFootprintListOrderByCreatTime(shzjFootprint);
        for (ShzjFootprint i : shzjFootprints) {
            String[] split = i.getFootPicture().split("\\s+");
            List<String> picURL = new ArrayList<>();
            for (String j : split) {
                picURL.add(VariableName.domain + j);
            }
            i.setPicURL(picURL);
        }
        return AjaxResult.success(shzjFootprints);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public AjaxResult delettInfo(@RequestParam("footId")int footId){
        ShzjFootprint shzjFootprint = shzjFootprintService.selectShzjFootprintById(footId);
        for (String i :shzjFootprint.getFootPicture().split("\\s+")){
            if(i.equals(""))
                break;
            ShzjPhoto shzjPhoto=new ShzjPhoto();
            shzjPhoto.setPhotoUrl(i);
            shzjPhoto = shzjPhotoService.selectShzjPhotoList(shzjPhoto).get(0);
            QiniuUpload.deletePic(shzjPhoto.getPhotoUrl());
            shzjPhotoService.deleteShzjPhotoById(shzjPhoto.getPhotoId());
        }
        shzjFootprintService.deleteShzjFootprintById(footId);
        return success();
    }
    @RequestMapping("/info")
    @ResponseBody
    public AjaxResult info(@RequestParam("userId")int userId ,@RequestParam("footId")int footId)  {
        ShzjUser shzjUser = shzjUserService.selectShzjUserById(userId);
        FootPrintInfo footPrintInfo=new FootPrintInfo();
        footPrintInfo.setHeadPortrait(VariableName.domain+"/"+shzjUser.getHeadPortrait());
        footPrintInfo.setUserName(shzjUser.getUserName());
        ShzjFootprint shzjFootprint = shzjFootprintService.selectShzjFootprintById(footId);
        footPrintInfo.setFootTitle(shzjFootprint.getFootTitle());
        footPrintInfo.setFootContent(shzjFootprint.getFootContent());
        List<String> picUrls=new ArrayList<>();
        for (String i:shzjFootprint.getFootPicture().split("\\s+")){
            if(i.equals(""))
                break;
            picUrls.add(VariableName.domain+i);
        }
        footPrintInfo.setPicUrls(picUrls);
        footPrintInfo.setCreatTime(shzjFootprint.getCreateTime());
        return AjaxResult.success(footPrintInfo);
    }

    public static class FootPrintInfo{
        private String headPortrait;
        private String userName;
        private String footTitle;
        private String footContent;
        private List<String> picUrls;
        private String creatTime;

        public String getHeadPortrait() {
            return headPortrait;
        }

        public void setHeadPortrait(String headPortrait) {
            this.headPortrait = headPortrait;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getFootTitle() {
            return footTitle;
        }

        public void setFootTitle(String footTitle) {
            this.footTitle = footTitle;
        }

        public String getFootContent() {
            return footContent;
        }

        public void setFootContent(String footContent) {
            this.footContent = footContent;
        }

        public List<String> getPicUrls() {
            return picUrls;
        }

        public void setPicUrls(List<String> picUrls) {
            this.picUrls = picUrls;
        }

        public String getCreatTime() {
            return creatTime;
        }

        public void setCreatTime(Date creatTime) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            this.creatTime = df.format(creatTime);
        }
    }


    @RequestMapping("/addInfo")
    @ResponseBody
    public AjaxResult addInfo(@RequestParam("userId")int userId, ShzjFootprint footprint,
                              @RequestParam("photosURL") String[] photosURL) {

        String photoURL = StringUtil.join(" ", photosURL);
        footprint.setUserId(userId);
        footprint.setFootPicture(photoURL);
        return
                shzjFootprintService.insertShzjFootprint(footprint) == 1 ?
                        success("上传成功") : error("上传失败");
    }

    /**
     * 查询足迹信息列表
     */
    @RequiresPermissions("shzj:footprint:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjFootprint shzjFootprint) {
        startPage();
        List<ShzjFootprint> list = shzjFootprintService.selectShzjFootprintList(shzjFootprint);
        return getDataTable(list);
    }

    /**
     * 导出足迹信息列表
     */
    @RequiresPermissions("shzj:footprint:export")
    @Log(title = "足迹信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjFootprint shzjFootprint) {
        List<ShzjFootprint> list = shzjFootprintService.selectShzjFootprintList(shzjFootprint);
        ExcelUtil<ShzjFootprint> util = new ExcelUtil<ShzjFootprint>(ShzjFootprint.class);
        return util.exportExcel(list, "footprint");
    }

    /**
     * 新增足迹信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存足迹信息
     */
    @RequiresPermissions("shzj:footprint:add")
    @Log(title = "足迹信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjFootprint shzjFootprint) {
        return toAjax(shzjFootprintService.insertShzjFootprint(shzjFootprint));
    }

    /**
     * 修改足迹信息
     */
    @GetMapping("/edit/{footId}")
    public String edit(@PathVariable("footId") Integer footId, ModelMap mmap) {
        ShzjFootprint shzjFootprint = shzjFootprintService.selectShzjFootprintById(footId);
        mmap.put("shzjFootprint", shzjFootprint);
        return prefix + "/edit";
    }

    /**
     * 修改保存足迹信息
     */
    @RequiresPermissions("shzj:footprint:edit")
    @Log(title = "足迹信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjFootprint shzjFootprint) {
        return toAjax(shzjFootprintService.updateShzjFootprint(shzjFootprint));
    }

    /**
     * 删除足迹信息
     */
    @RequiresPermissions("shzj:footprint:remove")
    @Log(title = "足迹信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(shzjFootprintService.deleteShzjFootprintByIds(ids));
    }
}
