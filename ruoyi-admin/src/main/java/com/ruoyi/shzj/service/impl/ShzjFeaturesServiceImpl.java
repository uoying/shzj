package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjFeaturesMapper;
import com.ruoyi.shzj.domain.ShzjFeatures;
import com.ruoyi.shzj.service.IShzjFeaturesService;
import com.ruoyi.common.core.text.Convert;

/**
 * 专题信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
@Service
public class ShzjFeaturesServiceImpl implements IShzjFeaturesService 
{
    @Autowired
    private ShzjFeaturesMapper shzjFeaturesMapper;

    /**
     * 查询专题信息
     * 
     * @param conId 专题信息ID
     * @return 专题信息
     */
    @Override
    public ShzjFeatures selectShzjFeaturesById(Integer conId)
    {
        return shzjFeaturesMapper.selectShzjFeaturesById(conId);
    }

    /**
     * 查询专题信息列表
     * 
     * @param shzjFeatures 专题信息
     * @return 专题信息
     */
    @Override
    public List<ShzjFeatures> selectShzjFeaturesList(ShzjFeatures shzjFeatures)
    {
        return shzjFeaturesMapper.selectShzjFeaturesList(shzjFeatures);
    }

    /**
     * 新增专题信息
     * 
     * @param shzjFeatures 专题信息
     * @return 结果
     */
    @Override
    public int insertShzjFeatures(ShzjFeatures shzjFeatures)
    {
        return shzjFeaturesMapper.insertShzjFeatures(shzjFeatures);
    }

    /**
     * 修改专题信息
     * 
     * @param shzjFeatures 专题信息
     * @return 结果
     */
    @Override
    public int updateShzjFeatures(ShzjFeatures shzjFeatures)
    {
        return shzjFeaturesMapper.updateShzjFeatures(shzjFeatures);
    }

    /**
     * 删除专题信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjFeaturesByIds(String ids)
    {
        return shzjFeaturesMapper.deleteShzjFeaturesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除专题信息信息
     * 
     * @param conId 专题信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjFeaturesById(Integer conId)
    {
        return shzjFeaturesMapper.deleteShzjFeaturesById(conId);
    }
}
