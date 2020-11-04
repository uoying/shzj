package com.ruoyi.shzj.service;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjDynamic;

/**
 * 动态信息Service接口
 * 
 * @author ruoyi
 * @date 2020-08-13
 */
public interface IShzjDynamicService 
{
    /**
     * 查询动态信息
     * 
     * @param dynamicId 动态信息ID
     * @return 动态信息
     */
    public ShzjDynamic selectShzjDynamicById(Integer dynamicId);

    /**
     * 查询动态信息列表
     * 
     * @param shzjDynamic 动态信息
     * @return 动态信息集合
     */
    public List<ShzjDynamic> selectShzjDynamicList(ShzjDynamic shzjDynamic);

    /**
     * 新增动态信息
     * 
     * @param shzjDynamic 动态信息
     * @return 结果
     */
    public int insertShzjDynamic(ShzjDynamic shzjDynamic);

    /**
     * 修改动态信息
     * 
     * @param shzjDynamic 动态信息
     * @return 结果
     */
    public int updateShzjDynamic(ShzjDynamic shzjDynamic);

    /**
     * 批量删除动态信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjDynamicByIds(String ids);

    /**
     * 删除动态信息信息
     * 
     * @param dynamicId 动态信息ID
     * @return 结果
     */
    public int deleteShzjDynamicById(Integer dynamicId);

    public List<ShzjDynamic> selectShzjDynamicListByAuthorId(Integer[] authorIds);

    List<ShzjDynamic> selectShzjDynamicListByDynamicTopic(String dynamicTopic);

    List<ShzjDynamic> selectShzjDynamicListByDynamicTopicByHot(String dynamicTopic);
}
