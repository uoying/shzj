package com.ruoyi.shzj.service;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjAction;

/**
 * 关注功能Service接口
 * 
 * @author ruoyi
 * @date 2020-09-17
 */
public interface IShzjActionService 
{
    /**
     * 查询关注功能
     * 
     * @param actionId 关注功能ID
     * @return 关注功能
     */
    public ShzjAction selectShzjActionById(Integer actionId);

    /**
     * 查询关注功能列表
     * 
     * @param shzjAction 关注功能
     * @return 关注功能集合
     */
    public List<ShzjAction> selectShzjActionList(ShzjAction shzjAction);

    /**
     * 新增关注功能
     * 
     * @param shzjAction 关注功能
     * @return 结果
     */
    public int insertShzjAction(ShzjAction shzjAction);

    /**
     * 修改关注功能
     * 
     * @param shzjAction 关注功能
     * @return 结果
     */
    public int updateShzjAction(ShzjAction shzjAction);

    /**
     * 批量删除关注功能
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjActionByIds(String ids);

    /**
     * 删除关注功能信息
     * 
     * @param actionId 关注功能ID
     * @return 结果
     */
    public int deleteShzjActionById(Integer actionId);

    Integer[] selectAuthorIdsInAttention(int userId);
}
