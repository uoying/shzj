package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjStrategyMapper;
import com.ruoyi.shzj.domain.ShzjStrategy;
import com.ruoyi.shzj.service.IShzjStrategyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 攻略信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-05
 */
@Service
public class ShzjStrategyServiceImpl implements IShzjStrategyService 
{
    @Autowired
    private ShzjStrategyMapper shzjStrategyMapper;

    /**
     * 查询攻略信息
     * 
     * @param strategyId 攻略信息ID
     * @return 攻略信息
     */
    @Override
    public ShzjStrategy selectShzjStrategyById(Integer strategyId)
    {
        return shzjStrategyMapper.selectShzjStrategyById(strategyId);
    }

    /**
     * 查询攻略信息列表
     * 
     * @param shzjStrategy 攻略信息
     * @return 攻略信息
     */
    @Override
    public List<ShzjStrategy> selectShzjStrategyList(ShzjStrategy shzjStrategy)
    {
        return shzjStrategyMapper.selectShzjStrategyList(shzjStrategy);
    }

    /**
     * 新增攻略信息
     * 
     * @param shzjStrategy 攻略信息
     * @return 结果
     */
    @Override
    public int insertShzjStrategy(ShzjStrategy shzjStrategy)
    {
        return shzjStrategyMapper.insertShzjStrategy(shzjStrategy);
    }

    /**
     * 修改攻略信息
     * 
     * @param shzjStrategy 攻略信息
     * @return 结果
     */
    @Override
    public int updateShzjStrategy(ShzjStrategy shzjStrategy)
    {
        return shzjStrategyMapper.updateShzjStrategy(shzjStrategy);
    }

    /**
     * 删除攻略信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjStrategyByIds(String ids)
    {
        return shzjStrategyMapper.deleteShzjStrategyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除攻略信息信息
     * 
     * @param strategyId 攻略信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjStrategyById(Integer strategyId)
    {
        return shzjStrategyMapper.deleteShzjStrategyById(strategyId);
    }

    @Override
    public List<String> selectStrategyTypeList() {
        return shzjStrategyMapper.selectStrategyTypeList();
    }
}
