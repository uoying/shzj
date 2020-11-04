package com.ruoyi.shzj.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 签到信息对象 shzj_sign
 * 
 * @author ruoyi
 * @date 2020-07-28
 */
public class ShzjSign extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 签到记录编号 */
    private Integer signId;

    /** 签到时间 */
    @Excel(name = "签到时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String signTime;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Integer userId;

    public void setSignId(Integer signId) 
    {
        this.signId = signId;
    }

    public Integer getSignId() 
    {
        return signId;
    }
    public void setSignTime(String signTime)
    {
        this.signTime = signTime;
    }

    public String getSignTime()
    {
        return signTime;
    }
    public void setUserId(Integer userId) 
    {
        this.userId = userId;
    }

    public Integer getUserId() 
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("signId", getSignId())
            .append("signTime", getSignTime())
            .append("userId", getUserId())
            .toString();
    }
}
