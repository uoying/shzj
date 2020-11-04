package com.ruoyi.shzj.service;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjContentParticular;

/**
 * 内容详情信息Service接口
 * 
 * @author ruoyi
 * @date 2020-08-15
 */
public interface IShzjContentParticularService 
{
    /**
     * 查询内容详情信息
     * 
     * @param particularId 内容详情信息ID
     * @return 内容详情信息
     */
    public ShzjContentParticular selectShzjContentParticularById(Integer particularId);

    /**
     * 查询内容详情信息列表
     * 
     * @param shzjContentParticular 内容详情信息
     * @return 内容详情信息集合
     */
    public List<ShzjContentParticular> selectShzjContentParticularList(ShzjContentParticular shzjContentParticular);

    /**
     * 新增内容详情信息
     * 
     * @param shzjContentParticular 内容详情信息
     * @return 结果
     */
    public int insertShzjContentParticular(ShzjContentParticular shzjContentParticular);

    /**
     * 修改内容详情信息
     * 
     * @param shzjContentParticular 内容详情信息
     * @return 结果
     */
    public int updateShzjContentParticular(ShzjContentParticular shzjContentParticular);

    /**
     * 批量删除内容详情信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjContentParticularByIds(String ids);

    /**
     * 删除内容详情信息信息
     * 
     * @param particularId 内容详情信息ID
     * @return 结果
     */
    public int deleteShzjContentParticularById(Integer particularId);
}
