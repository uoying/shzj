package com.ruoyi.shzj.controller;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.shzj.domain.ShzjTopic;
import com.ruoyi.shzj.domain.ShzjUser;
import com.ruoyi.shzj.service.IShzjTopicService;
import com.ruoyi.shzj.service.IShzjUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.shzj.domain.ShzjAction;
import com.ruoyi.shzj.service.IShzjActionService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 关注功能Controller
 * 
 * @author ruoyi
 * @date 2020-09-17
 */
@Controller
@RequestMapping("/shzj/action")
@Api(tags = "action")
public class ShzjActionController extends BaseController
{
    private String prefix = "shzj/action";

    @Autowired
    private IShzjActionService shzjActionService;
    @Autowired
    private IShzjTopicService shzjTopicService;
    @Autowired
    private IShzjUserService shzjUserService;

    @RequiresPermissions("shzj:action:view")
    @GetMapping()
    public String action()
    {
        return prefix + "/action";
    }

    /**
     * 查询关注功能列表
     */
    @RequiresPermissions("shzj:action:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ShzjAction shzjAction)
    {
        startPage();
        List<ShzjAction> list = shzjActionService.selectShzjActionList(shzjAction);
        return getDataTable(list);
    }

    @ApiOperation("addAction")
    @PostMapping("/addAction")
    @ResponseBody
    @ApiImplicitParam(name = "shzjAction",value = "关注类",paramType = "body")
    public AjaxResult addAction(ShzjAction shzjAction){
        return shzjActionService.insertShzjAction(shzjAction)==1?success():error();
    }
    @ApiOperation("cancelAction")
    @PostMapping("/cancelAction")
    @ResponseBody
    @ApiImplicitParam(name = "shzjAction",value = "关注类",paramType = "body")
    public AjaxResult cancelAction(ShzjAction shzjAction){
        shzjAction=shzjActionService.selectShzjActionList(shzjAction).get(0);
        return shzjActionService.deleteShzjActionById(shzjAction.getActionId())==1?success():error();
    }
    @ApiOperation("actionList")
    @PostMapping("/actionList")
    @ResponseBody
    @ApiImplicitParam(name = "shzjAction",value = "关注类",paramType = "body")
    public AjaxResult actionList(ShzjAction shzjAction){
        List<ShzjAction> shzjActions = shzjActionService.selectShzjActionList(shzjAction);
        List<Object> list=new ArrayList<>();
        if(shzjAction.getContent().equals("topic")){
            List<ShzjTopic>topics=new ArrayList<>();
            for (ShzjAction action:shzjActions){
                topics.add(shzjTopicService.selectShzjTopicById(action.getContentid()));
            }
            list.add(topics);
        }else if(shzjAction.getContent().equals("user")){
            List<ShzjUser>users=new ArrayList<>();
            for (ShzjAction action:shzjActions){
                users.add(shzjUserService.selectShzjUserById(action.getContentid()));
            }
            list.add(users);
        }
        return AjaxResult.success(list);
    }

    /**
     * 导出关注功能列表
     */
    @RequiresPermissions("shzj:action:export")
    @Log(title = "关注功能", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ShzjAction shzjAction)
    {
        List<ShzjAction> list = shzjActionService.selectShzjActionList(shzjAction);
        ExcelUtil<ShzjAction> util = new ExcelUtil<ShzjAction>(ShzjAction.class);
        return util.exportExcel(list, "action");
    }

    /**
     * 新增关注功能
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存关注功能
     */
    @RequiresPermissions("shzj:action:add")
    @Log(title = "关注功能", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ShzjAction shzjAction)
    {
        return toAjax(shzjActionService.insertShzjAction(shzjAction));
    }

    /**
     * 修改关注功能
     */
    @GetMapping("/edit/{actionId}")
    public String edit(@PathVariable("actionId") Integer actionId, ModelMap mmap)
    {
        ShzjAction shzjAction = shzjActionService.selectShzjActionById(actionId);
        mmap.put("shzjAction", shzjAction);
        return prefix + "/edit";
    }

    /**
     * 修改保存关注功能
     */
    @RequiresPermissions("shzj:action:edit")
    @Log(title = "关注功能", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShzjAction shzjAction)
    {
        return toAjax(shzjActionService.updateShzjAction(shzjAction));
    }

    /**
     * 删除关注功能
     */
    @RequiresPermissions("shzj:action:remove")
    @Log(title = "关注功能", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(shzjActionService.deleteShzjActionByIds(ids));
    }
}
