package com.ruoyi.shzj.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评论信息对象 shzj_comment
 * 
 * @author ruoyi
 * @date 2020-08-15
 */
public class ShzjComment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评论编号 */
    private Integer commentId;

    /** 文章编号 */
    @Excel(name = "文章编号")
    private String contentId;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Integer userId;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String commentContent;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Integer likeNum;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatTime;

    public void setCommentId(Integer commentId) 
    {
        this.commentId = commentId;
    }

    public Integer getCommentId() 
    {
        return commentId;
    }
    public void setContentId(String contentId) 
    {
        this.contentId = contentId;
    }

    public String getContentId() 
    {
        return contentId;
    }
    public void setUserId(Integer userId) 
    {
        this.userId = userId;
    }

    public Integer getUserId() 
    {
        return userId;
    }
    public void setCommentContent(String commentContent) 
    {
        this.commentContent = commentContent;
    }

    public String getCommentContent() 
    {
        return commentContent;
    }
    public void setLikeNum(Integer likeNum) 
    {
        this.likeNum = likeNum;
    }

    public Integer getLikeNum() 
    {
        return likeNum;
    }
    public void setCreatTime(Date creatTime) 
    {
        this.creatTime = creatTime;
    }

    public Date getCreatTime() 
    {
        return creatTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("commentId", getCommentId())
            .append("contentId", getContentId())
            .append("userId", getUserId())
            .append("commentContent", getCommentContent())
            .append("likeNum", getLikeNum())
            .append("creatTime", getCreatTime())
            .toString();
    }
}
