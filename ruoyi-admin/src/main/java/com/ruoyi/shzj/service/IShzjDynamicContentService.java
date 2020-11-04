package com.ruoyi.shzj.service;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjDynamicContent;

/**
 * 动态详情信息Service接口
 * 
 * @author ruoyi
 * @date 2020-08-14
 */
public interface IShzjDynamicContentService 
{
    /**
     * 查询动态详情信息
     * 
     * @param dynamicContentId 动态详情信息ID
     * @return 动态详情信息
     */
    public ShzjDynamicContent selectShzjDynamicContentById(Integer dynamicContentId);

    /**
     * 查询动态详情信息列表
     * 
     * @param shzjDynamicContent 动态详情信息
     * @return 动态详情信息集合
     */
    public List<ShzjDynamicContent> selectShzjDynamicContentList(ShzjDynamicContent shzjDynamicContent);

    /**
     * 新增动态详情信息
     * 
     * @param shzjDynamicContent 动态详情信息
     * @return 结果
     */
    public int insertShzjDynamicContent(ShzjDynamicContent shzjDynamicContent);

    /**
     * 修改动态详情信息
     * 
     * @param shzjDynamicContent 动态详情信息
     * @return 结果
     */
    public int updateShzjDynamicContent(ShzjDynamicContent shzjDynamicContent);

    /**
     * 批量删除动态详情信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjDynamicContentByIds(String ids);

    /**
     * 删除动态详情信息信息
     * 
     * @param dynamicContentId 动态详情信息ID
     * @return 结果
     */
    public int deleteShzjDynamicContentById(Integer dynamicContentId);
}
