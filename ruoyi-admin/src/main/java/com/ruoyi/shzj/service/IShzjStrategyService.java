package com.ruoyi.shzj.service;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjStrategy;

/**
 * 攻略信息Service接口
 * 
 * @author ruoyi
 * @date 2020-08-05
 */
public interface IShzjStrategyService 
{
    /**
     * 查询攻略信息
     * 
     * @param strategyId 攻略信息ID
     * @return 攻略信息
     */
    public ShzjStrategy selectShzjStrategyById(Integer strategyId);

    /**
     * 查询攻略信息列表
     * 
     * @param shzjStrategy 攻略信息
     * @return 攻略信息集合
     */
    public List<ShzjStrategy> selectShzjStrategyList(ShzjStrategy shzjStrategy);

    /**
     * 新增攻略信息
     * 
     * @param shzjStrategy 攻略信息
     * @return 结果
     */
    public int insertShzjStrategy(ShzjStrategy shzjStrategy);

    /**
     * 修改攻略信息
     * 
     * @param shzjStrategy 攻略信息
     * @return 结果
     */
    public int updateShzjStrategy(ShzjStrategy shzjStrategy);

    /**
     * 批量删除攻略信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjStrategyByIds(String ids);

    /**
     * 删除攻略信息信息
     * 
     * @param strategyId 攻略信息ID
     * @return 结果
     */
    public int deleteShzjStrategyById(Integer strategyId);

    public List<String> selectStrategyTypeList();
}
