package com.ruoyi.shzj.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 动态信息对象 shzj_dynamic
 * 
 * @author ruoyi
 * @date 2020-08-13
 */
public class ShzjDynamic
{
    private static final long serialVersionUID = 1L;

    /** 动态编号 */
    private Integer dynamicId;

    /** 动态标题 */
    @Excel(name = "动态标题")
    private String dynamicTitle;

    /** 动态话题 */
    @Excel(name = "动态话题")
    private String dynamicTopic;

    /** 作者编号 */
    @Excel(name = "作者编号")
    private Integer authorId;
    private String authorName;
    private String headPortrait;

    /** 图片URL */
    @Excel(name = "图片URL")
    private String dynamicPic;
    private String backgroundPic;

    /** 动态地址 */
    @Excel(name = "动态地址")
    private String dynamicAddress;

    /** 动态标签 */
    @Excel(name = "动态标签")
    private String dynamicLable;

    /** 评论数量 */
    @Excel(name = "评论数量")
    private Integer discussNum;

    /** 收藏数量 */
    @Excel(name = "收藏数量")
    private Integer collectNum;

    /** 喜欢数量 */
    @Excel(name = "喜欢数量")
    private Integer likeNum;

    /** 城市编号 */
    @Excel(name = "城市编号")
    private Integer cityId;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatTime;

    public String getBackgroundPic() {
        return backgroundPic;
    }

    public void setBackgroundPic(String backgroundPic) {
        this.backgroundPic = backgroundPic.split("\\s+")[0];
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public void setDynamicId(Integer dynamicId)
    {
        this.dynamicId = dynamicId;
    }

    public Integer getDynamicId() 
    {
        return dynamicId;
    }
    public void setDynamicTitle(String dynamicTitle) 
    {
        this.dynamicTitle = dynamicTitle;
    }

    public String getDynamicTitle() 
    {
        return dynamicTitle;
    }
    public void setDynamicTopic(String dynamicTopic) 
    {
        this.dynamicTopic = dynamicTopic;
    }

    public String getDynamicTopic() 
    {
        return dynamicTopic;
    }
    public void setAuthorId(Integer authorId) 
    {
        this.authorId = authorId;
    }

    public Integer getAuthorId() 
    {
        return authorId;
    }
    public void setDynamicPic(String dynamicPic) 
    {
        this.dynamicPic = dynamicPic;
    }

    public String getDynamicPic() 
    {
        return dynamicPic;
    }
    public void setDynamicAddress(String dynamicAddress) 
    {
        this.dynamicAddress = dynamicAddress;
    }

    public String getDynamicAddress() 
    {
        return dynamicAddress;
    }
    public void setDynamicLable(String dynamicLable) 
    {
        this.dynamicLable = dynamicLable;
    }

    public String getDynamicLable() 
    {
        return dynamicLable;
    }
    public void setDiscussNum(Integer discussNum) 
    {
        this.discussNum = discussNum;
    }

    public Integer getDiscussNum() 
    {
        return discussNum;
    }
    public void setCollectNum(Integer collectNum) 
    {
        this.collectNum = collectNum;
    }

    public Integer getCollectNum() 
    {
        return collectNum;
    }
    public void setLikeNum(Integer likeNum) 
    {
        this.likeNum = likeNum;
    }

    public Integer getLikeNum() 
    {
        return likeNum;
    }
    public void setCityId(Integer cityId) 
    {
        this.cityId = cityId;
    }

    public Integer getCityId() 
    {
        return cityId;
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
            .append("dynamicId", getDynamicId())
            .append("dynamicTitle", getDynamicTitle())
            .append("dynamicTopic", getDynamicTopic())
            .append("authorId", getAuthorId())
            .append("dynamicPic", getDynamicPic())
            .append("dynamicAddress", getDynamicAddress())
            .append("dynamicLable", getDynamicLable())
            .append("discussNum", getDiscussNum())
            .append("collectNum", getCollectNum())
            .append("likeNum", getLikeNum())
            .append("cityId", getCityId())
            .append("creatTime", getCreatTime())
            .toString();
    }
}
