package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjTopicMapper;
import com.ruoyi.shzj.domain.ShzjTopic;
import com.ruoyi.shzj.service.IShzjTopicService;
import com.ruoyi.common.core.text.Convert;

/**
 * 话题信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-13
 */
@Service
public class ShzjTopicServiceImpl implements IShzjTopicService 
{
    @Autowired
    private ShzjTopicMapper shzjTopicMapper;

    /**
     * 查询话题信息
     * 
     * @param topicId 话题信息ID
     * @return 话题信息
     */
    @Override
    public ShzjTopic selectShzjTopicById(Integer topicId)
    {
        return shzjTopicMapper.selectShzjTopicById(topicId);
    }

    /**
     * 查询话题信息列表
     * 
     * @param shzjTopic 话题信息
     * @return 话题信息
     */
    @Override
    public List<ShzjTopic> selectShzjTopicList(ShzjTopic shzjTopic)
    {
        return shzjTopicMapper.selectShzjTopicList(shzjTopic);
    }

    /**
     * 新增话题信息
     * 
     * @param shzjTopic 话题信息
     * @return 结果
     */
    @Override
    public int insertShzjTopic(ShzjTopic shzjTopic)
    {
        return shzjTopicMapper.insertShzjTopic(shzjTopic);
    }

    /**
     * 修改话题信息
     * 
     * @param shzjTopic 话题信息
     * @return 结果
     */
    @Override
    public int updateShzjTopic(ShzjTopic shzjTopic)
    {
        return shzjTopicMapper.updateShzjTopic(shzjTopic);
    }

    /**
     * 删除话题信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjTopicByIds(String ids)
    {
        return shzjTopicMapper.deleteShzjTopicByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除话题信息信息
     * 
     * @param topicId 话题信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjTopicById(Integer topicId)
    {
        return shzjTopicMapper.deleteShzjTopicById(topicId);
    }

    @Override
    public List<ShzjTopic> selectShzjTopicListOrderByArticleNum(ShzjTopic shzjTopic) {
        return shzjTopicMapper.selectShzjTopicListOrderByArticleNum(shzjTopic);
    }

    @Override
    public List<String> selectShzjTopicTypeList() {
        return shzjTopicMapper.selectShzjTopicTypeList();
    }

    @Override
    public List<ShzjTopic> selectShzjTopicListTop(int num) {
        return shzjTopicMapper.selectShzjTopicListTop(num);
    }


}
