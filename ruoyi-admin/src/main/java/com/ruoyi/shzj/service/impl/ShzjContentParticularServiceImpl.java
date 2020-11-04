package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjContentParticularMapper;
import com.ruoyi.shzj.domain.ShzjContentParticular;
import com.ruoyi.shzj.service.IShzjContentParticularService;
import com.ruoyi.common.core.text.Convert;

/**
 * 内容详情信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-15
 */
@Service
public class ShzjContentParticularServiceImpl implements IShzjContentParticularService 
{
    @Autowired
    private ShzjContentParticularMapper shzjContentParticularMapper;

    /**
     * 查询内容详情信息
     * 
     * @param particularId 内容详情信息ID
     * @return 内容详情信息
     */
    @Override
    public ShzjContentParticular selectShzjContentParticularById(Integer particularId)
    {
        return shzjContentParticularMapper.selectShzjContentParticularById(particularId);
    }

    /**
     * 查询内容详情信息列表
     * 
     * @param shzjContentParticular 内容详情信息
     * @return 内容详情信息
     */
    @Override
    public List<ShzjContentParticular> selectShzjContentParticularList(ShzjContentParticular shzjContentParticular)
    {
        return shzjContentParticularMapper.selectShzjContentParticularList(shzjContentParticular);
    }

    /**
     * 新增内容详情信息
     * 
     * @param shzjContentParticular 内容详情信息
     * @return 结果
     */
    @Override
    public int insertShzjContentParticular(ShzjContentParticular shzjContentParticular)
    {
        return shzjContentParticularMapper.insertShzjContentParticular(shzjContentParticular);
    }

    /**
     * 修改内容详情信息
     * 
     * @param shzjContentParticular 内容详情信息
     * @return 结果
     */
    @Override
    public int updateShzjContentParticular(ShzjContentParticular shzjContentParticular)
    {
        return shzjContentParticularMapper.updateShzjContentParticular(shzjContentParticular);
    }

    /**
     * 删除内容详情信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjContentParticularByIds(String ids)
    {
        return shzjContentParticularMapper.deleteShzjContentParticularByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除内容详情信息信息
     * 
     * @param particularId 内容详情信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjContentParticularById(Integer particularId)
    {
        return shzjContentParticularMapper.deleteShzjContentParticularById(particularId);
    }
}
