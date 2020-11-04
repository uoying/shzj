package com.ruoyi.shzj.mapper;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjFeaturesType;

/**
 * 专题类型Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
public interface ShzjFeaturesTypeMapper 
{
    /**
     * 查询专题类型
     * 
     * @param featuresId 专题类型ID
     * @return 专题类型
     */
    public ShzjFeaturesType selectShzjFeaturesTypeById(Integer featuresId);

    /**
     * 查询专题类型列表
     * 
     * @param shzjFeaturesType 专题类型
     * @return 专题类型集合
     */
    public List<ShzjFeaturesType> selectShzjFeaturesTypeList(ShzjFeaturesType shzjFeaturesType);

    /**
     * 新增专题类型
     * 
     * @param shzjFeaturesType 专题类型
     * @return 结果
     */
    public int insertShzjFeaturesType(ShzjFeaturesType shzjFeaturesType);

    /**
     * 修改专题类型
     * 
     * @param shzjFeaturesType 专题类型
     * @return 结果
     */
    public int updateShzjFeaturesType(ShzjFeaturesType shzjFeaturesType);

    /**
     * 删除专题类型
     * 
     * @param featuresId 专题类型ID
     * @return 结果
     */
    public int deleteShzjFeaturesTypeById(Integer featuresId);

    /**
     * 批量删除专题类型
     * 
     * @param featuresIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjFeaturesTypeByIds(String[] featuresIds);
}
