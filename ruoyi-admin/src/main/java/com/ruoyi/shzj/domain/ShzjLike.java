package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 点赞信息对象 shzj_like
 * 
 * @author ruoyi
 * @date 2020-08-15
 */
public class ShzjLike extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 点赞编号 */
    private Integer likeId;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Integer userId;

    /** 获赞内容 */
    @Excel(name = "获赞内容")
    private String content;

    public void setLikeId(Integer likeId) 
    {
        this.likeId = likeId;
    }

    public Integer getLikeId() 
    {
        return likeId;
    }
    public void setUserId(Integer userId) 
    {
        this.userId = userId;
    }

    public Integer getUserId() 
    {
        return userId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("likeId", getLikeId())
            .append("userId", getUserId())
            .append("content", getContent())
            .toString();
    }
}
