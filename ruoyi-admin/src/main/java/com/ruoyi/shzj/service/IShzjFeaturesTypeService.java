package com.ruoyi.shzj.service;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjFeaturesType;

/**
 * 专题类型Service接口
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
public interface IShzjFeaturesTypeService 
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
     * 批量删除专题类型
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjFeaturesTypeByIds(String ids);

    /**
     * 删除专题类型信息
     * 
     * @param featuresId 专题类型ID
     * @return 结果
     */
    public int deleteShzjFeaturesTypeById(Integer featuresId);
}
