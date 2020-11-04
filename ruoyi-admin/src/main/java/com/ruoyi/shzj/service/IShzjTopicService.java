package com.ruoyi.shzj.service;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjTopic;

/**
 * 话题信息Service接口
 * 
 * @author ruoyi
 * @date 2020-08-13
 */
public interface IShzjTopicService 
{
    /**
     * 查询话题信息
     * 
     * @param topicId 话题信息ID
     * @return 话题信息
     */
    public ShzjTopic selectShzjTopicById(Integer topicId);

    /**
     * 查询话题信息列表
     * 
     * @param shzjTopic 话题信息
     * @return 话题信息集合
     */
    public List<ShzjTopic> selectShzjTopicList(ShzjTopic shzjTopic);

    /**
     * 新增话题信息
     * 
     * @param shzjTopic 话题信息
     * @return 结果
     */
    public int insertShzjTopic(ShzjTopic shzjTopic);

    /**
     * 修改话题信息
     * 
     * @param shzjTopic 话题信息
     * @return 结果
     */
    public int updateShzjTopic(ShzjTopic shzjTopic);

    /**
     * 批量删除话题信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjTopicByIds(String ids);

    /**
     * 删除话题信息信息
     * 
     * @param topicId 话题信息ID
     * @return 结果
     */
    public int deleteShzjTopicById(Integer topicId);

    public List<ShzjTopic> selectShzjTopicListOrderByArticleNum(ShzjTopic shzjTopic);

    public List<String> selectShzjTopicTypeList();

    public List<ShzjTopic> selectShzjTopicListTop(int num);

}
