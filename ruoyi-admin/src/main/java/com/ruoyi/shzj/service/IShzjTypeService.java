package com.ruoyi.shzj.service;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjType;

/**
 * 类别Service接口
 * 
 * @author ruoyi
 * @date 2020-07-13
 */
public interface IShzjTypeService 
{
    /**
     * 查询类别
     * 
     * @param typeId 类别ID
     * @return 类别
     */
    public ShzjType selectShzjTypeById(Integer typeId);

    /**
     * 查询类别列表
     * 
     * @param shzjType 类别
     * @return 类别集合
     */
    public List<ShzjType> selectShzjTypeList(ShzjType shzjType);

    /**
     * 新增类别
     * 
     * @param shzjType 类别
     * @return 结果
     */
    public int insertShzjType(ShzjType shzjType);

    /**
     * 修改类别
     * 
     * @param shzjType 类别
     * @return 结果
     */
    public int updateShzjType(ShzjType shzjType);

    /**
     * 批量删除类别
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjTypeByIds(String ids);

    /**
     * 删除类别信息
     * 
     * @param typeId 类别ID
     * @return 结果
     */
    public int deleteShzjTypeById(Integer typeId);
}
