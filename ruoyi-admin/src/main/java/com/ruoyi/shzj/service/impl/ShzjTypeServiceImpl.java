package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjTypeMapper;
import com.ruoyi.shzj.domain.ShzjType;
import com.ruoyi.shzj.service.IShzjTypeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 类别Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-13
 */
@Service
public class ShzjTypeServiceImpl implements IShzjTypeService 
{
    @Autowired
    private ShzjTypeMapper shzjTypeMapper;

    /**
     * 查询类别
     * 
     * @param typeId 类别ID
     * @return 类别
     */
    @Override
    public ShzjType selectShzjTypeById(Integer typeId)
    {
        return shzjTypeMapper.selectShzjTypeById(typeId);
    }

    /**
     * 查询类别列表
     * 
     * @param shzjType 类别
     * @return 类别
     */
    @Override
    public List<ShzjType> selectShzjTypeList(ShzjType shzjType)
    {
        return shzjTypeMapper.selectShzjTypeList(shzjType);
    }

    /**
     * 新增类别
     * 
     * @param shzjType 类别
     * @return 结果
     */
    @Override
    public int insertShzjType(ShzjType shzjType)
    {
        return shzjTypeMapper.insertShzjType(shzjType);
    }

    /**
     * 修改类别
     * 
     * @param shzjType 类别
     * @return 结果
     */
    @Override
    public int updateShzjType(ShzjType shzjType)
    {
        return shzjTypeMapper.updateShzjType(shzjType);
    }

    /**
     * 删除类别对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjTypeByIds(String ids)
    {
        return shzjTypeMapper.deleteShzjTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除类别信息
     * 
     * @param typeId 类别ID
     * @return 结果
     */
    @Override
    public int deleteShzjTypeById(Integer typeId)
    {
        return shzjTypeMapper.deleteShzjTypeById(typeId);
    }
}
