package com.ruoyi.shzj.mapper;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjTopic;

/**
 * 话题信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-13
 */
public interface ShzjTopicMapper 
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
     * 删除话题信息
     * 
     * @param topicId 话题信息ID
     * @return 结果
     */
    public int deleteShzjTopicById(Integer topicId);

    /**
     * 批量删除话题信息
     * 
     * @param topicIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjTopicByIds(String[] topicIds);

    public List<ShzjTopic> selectShzjTopicListOrderByArticleNum(ShzjTopic shzjTopic);

    public List<String> selectShzjTopicTypeList();

    public List<ShzjTopic> selectShzjTopicListTop(int num);

}
