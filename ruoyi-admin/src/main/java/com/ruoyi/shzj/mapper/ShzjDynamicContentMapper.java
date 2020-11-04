package com.ruoyi.shzj.mapper;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjDynamicContent;

/**
 * 动态详情信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-14
 */
public interface ShzjDynamicContentMapper 
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
     * 删除动态详情信息
     * 
     * @param dynamicContentId 动态详情信息ID
     * @return 结果
     */
    public int deleteShzjDynamicContentById(Integer dynamicContentId);

    /**
     * 批量删除动态详情信息
     * 
     * @param dynamicContentIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjDynamicContentByIds(String[] dynamicContentIds);
}
