package com.ruoyi.shzj.service;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjComment;

/**
 * 评论信息Service接口
 * 
 * @author ruoyi
 * @date 2020-08-15
 */
public interface IShzjCommentService 
{
    /**
     * 查询评论信息
     * 
     * @param commentId 评论信息ID
     * @return 评论信息
     */
    public ShzjComment selectShzjCommentById(Integer commentId);

    /**
     * 查询评论信息列表
     * 
     * @param shzjComment 评论信息
     * @return 评论信息集合
     */
    public List<ShzjComment> selectShzjCommentList(ShzjComment shzjComment);

    /**
     * 新增评论信息
     * 
     * @param shzjComment 评论信息
     * @return 结果
     */
    public int insertShzjComment(ShzjComment shzjComment);

    /**
     * 修改评论信息
     * 
     * @param shzjComment 评论信息
     * @return 结果
     */
    public int updateShzjComment(ShzjComment shzjComment);

    /**
     * 批量删除评论信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjCommentByIds(String ids);

    /**
     * 删除评论信息信息
     * 
     * @param commentId 评论信息ID
     * @return 结果
     */
    public int deleteShzjCommentById(Integer commentId);

    List<String> selectShzjConCommentList(ShzjComment shzjComment);
}
