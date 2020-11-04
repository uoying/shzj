package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjDynamicMapper;
import com.ruoyi.shzj.domain.ShzjDynamic;
import com.ruoyi.shzj.service.IShzjDynamicService;
import com.ruoyi.common.core.text.Convert;

/**
 * 动态信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-13
 */
@Service
public class ShzjDynamicServiceImpl implements IShzjDynamicService 
{
    @Autowired
    private ShzjDynamicMapper shzjDynamicMapper;

    /**
     * 查询动态信息
     * 
     * @param dynamicId 动态信息ID
     * @return 动态信息
     */
    @Override
    public ShzjDynamic selectShzjDynamicById(Integer dynamicId)
    {
        return shzjDynamicMapper.selectShzjDynamicById(dynamicId);
    }

    /**
     * 查询动态信息列表
     * 
     * @param shzjDynamic 动态信息
     * @return 动态信息
     */
    @Override
    public List<ShzjDynamic> selectShzjDynamicList(ShzjDynamic shzjDynamic)
    {
        return shzjDynamicMapper.selectShzjDynamicList(shzjDynamic);
    }

    /**
     * 新增动态信息
     * 
     * @param shzjDynamic 动态信息
     * @return 结果
     */
    @Override
    public int insertShzjDynamic(ShzjDynamic shzjDynamic)
    {
        return shzjDynamicMapper.insertShzjDynamic(shzjDynamic);
    }

    /**
     * 修改动态信息
     * 
     * @param shzjDynamic 动态信息
     * @return 结果
     */
    @Override
    public int updateShzjDynamic(ShzjDynamic shzjDynamic)
    {
        return shzjDynamicMapper.updateShzjDynamic(shzjDynamic);
    }

    /**
     * 删除动态信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjDynamicByIds(String ids)
    {
        return shzjDynamicMapper.deleteShzjDynamicByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除动态信息信息
     * 
     * @param dynamicId 动态信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjDynamicById(Integer dynamicId)
    {
        return shzjDynamicMapper.deleteShzjDynamicById(dynamicId);
    }

    @Override
    public List<ShzjDynamic> selectShzjDynamicListByAuthorId(Integer[] authorIds) {
        return shzjDynamicMapper.selectShzjDynamicListByAuthorId(authorIds);
    }

    @Override
    public List<ShzjDynamic> selectShzjDynamicListByDynamicTopic(String dynamicTopic) {
        return shzjDynamicMapper.selectShzjDynamicListByDynamicTopic(dynamicTopic);
    }

    @Override
    public List<ShzjDynamic> selectShzjDynamicListByDynamicTopicByHot(String dynamicTopic) {
        return shzjDynamicMapper.selectShzjDynamicListByDynamicTopicByHot(dynamicTopic);
    }
}
