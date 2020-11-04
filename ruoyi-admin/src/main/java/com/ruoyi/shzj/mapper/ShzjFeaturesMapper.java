package com.ruoyi.shzj.mapper;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjFeatures;

/**
 * 专题信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
public interface ShzjFeaturesMapper 
{
    /**
     * 查询专题信息
     * 
     * @param conId 专题信息ID
     * @return 专题信息
     */
    public ShzjFeatures selectShzjFeaturesById(Integer conId);

    /**
     * 查询专题信息列表
     * 
     * @param shzjFeatures 专题信息
     * @return 专题信息集合
     */
    public List<ShzjFeatures> selectShzjFeaturesList(ShzjFeatures shzjFeatures);

    /**
     * 新增专题信息
     * 
     * @param shzjFeatures 专题信息
     * @return 结果
     */
    public int insertShzjFeatures(ShzjFeatures shzjFeatures);

    /**
     * 修改专题信息
     * 
     * @param shzjFeatures 专题信息
     * @return 结果
     */
    public int updateShzjFeatures(ShzjFeatures shzjFeatures);

    /**
     * 删除专题信息
     * 
     * @param conId 专题信息ID
     * @return 结果
     */
    public int deleteShzjFeaturesById(Integer conId);

    /**
     * 批量删除专题信息
     * 
     * @param conIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjFeaturesByIds(String[] conIds);
}
