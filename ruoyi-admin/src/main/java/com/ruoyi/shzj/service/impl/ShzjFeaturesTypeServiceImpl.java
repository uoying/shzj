package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjFeaturesTypeMapper;
import com.ruoyi.shzj.domain.ShzjFeaturesType;
import com.ruoyi.shzj.service.IShzjFeaturesTypeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 专题类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
@Service
public class ShzjFeaturesTypeServiceImpl implements IShzjFeaturesTypeService 
{
    @Autowired
    private ShzjFeaturesTypeMapper shzjFeaturesTypeMapper;

    /**
     * 查询专题类型
     * 
     * @param featuresId 专题类型ID
     * @return 专题类型
     */
    @Override
    public ShzjFeaturesType selectShzjFeaturesTypeById(Integer featuresId)
    {
        return shzjFeaturesTypeMapper.selectShzjFeaturesTypeById(featuresId);
    }

    /**
     * 查询专题类型列表
     * 
     * @param shzjFeaturesType 专题类型
     * @return 专题类型
     */
    @Override
    public List<ShzjFeaturesType> selectShzjFeaturesTypeList(ShzjFeaturesType shzjFeaturesType)
    {
        return shzjFeaturesTypeMapper.selectShzjFeaturesTypeList(shzjFeaturesType);
    }

    /**
     * 新增专题类型
     * 
     * @param shzjFeaturesType 专题类型
     * @return 结果
     */
    @Override
    public int insertShzjFeaturesType(ShzjFeaturesType shzjFeaturesType)
    {
        return shzjFeaturesTypeMapper.insertShzjFeaturesType(shzjFeaturesType);
    }

    /**
     * 修改专题类型
     * 
     * @param shzjFeaturesType 专题类型
     * @return 结果
     */
    @Override
    public int updateShzjFeaturesType(ShzjFeaturesType shzjFeaturesType)
    {
        return shzjFeaturesTypeMapper.updateShzjFeaturesType(shzjFeaturesType);
    }

    /**
     * 删除专题类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjFeaturesTypeByIds(String ids)
    {
        return shzjFeaturesTypeMapper.deleteShzjFeaturesTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除专题类型信息
     * 
     * @param featuresId 专题类型ID
     * @return 结果
     */
    @Override
    public int deleteShzjFeaturesTypeById(Integer featuresId)
    {
        return shzjFeaturesTypeMapper.deleteShzjFeaturesTypeById(featuresId);
    }
}
