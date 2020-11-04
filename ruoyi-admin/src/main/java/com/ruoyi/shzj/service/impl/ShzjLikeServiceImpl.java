package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjLikeMapper;
import com.ruoyi.shzj.domain.ShzjLike;
import com.ruoyi.shzj.service.IShzjLikeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 点赞信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-15
 */
@Service
public class ShzjLikeServiceImpl implements IShzjLikeService 
{
    @Autowired
    private ShzjLikeMapper shzjLikeMapper;

    /**
     * 查询点赞信息
     * 
     * @param likeId 点赞信息ID
     * @return 点赞信息
     */
    @Override
    public ShzjLike selectShzjLikeById(Integer likeId)
    {
        return shzjLikeMapper.selectShzjLikeById(likeId);
    }

    /**
     * 查询点赞信息列表
     * 
     * @param shzjLike 点赞信息
     * @return 点赞信息
     */
    @Override
    public List<ShzjLike> selectShzjLikeList(ShzjLike shzjLike)
    {
        return shzjLikeMapper.selectShzjLikeList(shzjLike);
    }

    /**
     * 新增点赞信息
     * 
     * @param shzjLike 点赞信息
     * @return 结果
     */
    @Override
    public int insertShzjLike(ShzjLike shzjLike)
    {
        return shzjLikeMapper.insertShzjLike(shzjLike);
    }

    /**
     * 修改点赞信息
     * 
     * @param shzjLike 点赞信息
     * @return 结果
     */
    @Override
    public int updateShzjLike(ShzjLike shzjLike)
    {
        return shzjLikeMapper.updateShzjLike(shzjLike);
    }

    /**
     * 删除点赞信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjLikeByIds(String ids)
    {
        return shzjLikeMapper.deleteShzjLikeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除点赞信息信息
     * 
     * @param likeId 点赞信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjLikeById(Integer likeId)
    {
        return shzjLikeMapper.deleteShzjLikeById(likeId);
    }
}
