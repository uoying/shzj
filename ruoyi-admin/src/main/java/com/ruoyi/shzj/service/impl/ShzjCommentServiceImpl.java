package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjCommentMapper;
import com.ruoyi.shzj.domain.ShzjComment;
import com.ruoyi.shzj.service.IShzjCommentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 评论信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-15
 */
@Service
public class ShzjCommentServiceImpl implements IShzjCommentService 
{
    @Autowired
    private ShzjCommentMapper shzjCommentMapper;

    /**
     * 查询评论信息
     * 
     * @param commentId 评论信息ID
     * @return 评论信息
     */
    @Override
    public ShzjComment selectShzjCommentById(Integer commentId)
    {
        return shzjCommentMapper.selectShzjCommentById(commentId);
    }

    /**
     * 查询评论信息列表
     * 
     * @param shzjComment 评论信息
     * @return 评论信息
     */
    @Override
    public List<ShzjComment> selectShzjCommentList(ShzjComment shzjComment)
    {
        return shzjCommentMapper.selectShzjCommentList(shzjComment);
    }

    /**
     * 新增评论信息
     * 
     * @param shzjComment 评论信息
     * @return 结果
     */
    @Override
    public int insertShzjComment(ShzjComment shzjComment)
    {
        return shzjCommentMapper.insertShzjComment(shzjComment);
    }

    /**
     * 修改评论信息
     * 
     * @param shzjComment 评论信息
     * @return 结果
     */
    @Override
    public int updateShzjComment(ShzjComment shzjComment)
    {
        return shzjCommentMapper.updateShzjComment(shzjComment);
    }

    /**
     * 删除评论信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjCommentByIds(String ids)
    {
        return shzjCommentMapper.deleteShzjCommentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除评论信息信息
     * 
     * @param commentId 评论信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjCommentById(Integer commentId)
    {
        return shzjCommentMapper.deleteShzjCommentById(commentId);
    }

    @Override
    public List<String> selectShzjConCommentList(ShzjComment shzjComment) {
        return shzjCommentMapper.selectShzjConCommentList(shzjComment);
    }
}
