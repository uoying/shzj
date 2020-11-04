package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjActionMapper;
import com.ruoyi.shzj.domain.ShzjAction;
import com.ruoyi.shzj.service.IShzjActionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 关注功能Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-17
 */
@Service
public class ShzjActionServiceImpl implements IShzjActionService 
{
    @Autowired
    private ShzjActionMapper shzjActionMapper;

    /**
     * 查询关注功能
     * 
     * @param actionId 关注功能ID
     * @return 关注功能
     */
    @Override
    public ShzjAction selectShzjActionById(Integer actionId)
    {
        return shzjActionMapper.selectShzjActionById(actionId);
    }

    /**
     * 查询关注功能列表
     * 
     * @param shzjAction 关注功能
     * @return 关注功能
     */
    @Override
    public List<ShzjAction> selectShzjActionList(ShzjAction shzjAction)
    {
        return shzjActionMapper.selectShzjActionList(shzjAction);
    }

    /**
     * 新增关注功能
     * 
     * @param shzjAction 关注功能
     * @return 结果
     */
    @Override
    public int insertShzjAction(ShzjAction shzjAction)
    {
        return shzjActionMapper.insertShzjAction(shzjAction);
    }

    /**
     * 修改关注功能
     * 
     * @param shzjAction 关注功能
     * @return 结果
     */
    @Override
    public int updateShzjAction(ShzjAction shzjAction)
    {
        return shzjActionMapper.updateShzjAction(shzjAction);
    }

    /**
     * 删除关注功能对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjActionByIds(String ids)
    {
        return shzjActionMapper.deleteShzjActionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除关注功能信息
     * 
     * @param actionId 关注功能ID
     * @return 结果
     */
    @Override
    public int deleteShzjActionById(Integer actionId)
    {
        return shzjActionMapper.deleteShzjActionById(actionId);
    }

    @Override
    public Integer[] selectAuthorIdsInAttention(int userId) {
        return shzjActionMapper.selectAuthorIdsInAttention(userId);
    }
}
