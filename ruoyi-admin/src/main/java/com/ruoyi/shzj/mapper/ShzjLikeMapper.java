package com.ruoyi.shzj.mapper;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjLike;

/**
 * 点赞信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-15
 */
public interface ShzjLikeMapper 
{
    /**
     * 查询点赞信息
     * 
     * @param likeId 点赞信息ID
     * @return 点赞信息
     */
    public ShzjLike selectShzjLikeById(Integer likeId);

    /**
     * 查询点赞信息列表
     * 
     * @param shzjLike 点赞信息
     * @return 点赞信息集合
     */
    public List<ShzjLike> selectShzjLikeList(ShzjLike shzjLike);

    /**
     * 新增点赞信息
     * 
     * @param shzjLike 点赞信息
     * @return 结果
     */
    public int insertShzjLike(ShzjLike shzjLike);

    /**
     * 修改点赞信息
     * 
     * @param shzjLike 点赞信息
     * @return 结果
     */
    public int updateShzjLike(ShzjLike shzjLike);

    /**
     * 删除点赞信息
     * 
     * @param likeId 点赞信息ID
     * @return 结果
     */
    public int deleteShzjLikeById(Integer likeId);

    /**
     * 批量删除点赞信息
     * 
     * @param likeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjLikeByIds(String[] likeIds);
}
