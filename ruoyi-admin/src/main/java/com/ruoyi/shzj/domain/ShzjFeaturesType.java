package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 专题类型对象 shzj_features_type
 * 
 * @author ruoyi
 * @date 2020-08-04
 */
public class ShzjFeaturesType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 专题编号 */
    private Integer featuresId;

    /** 专题名称 */
    @Excel(name = "专题名称")
    private String featuresName;

    public void setFeaturesId(Integer featuresId) 
    {
        this.featuresId = featuresId;
    }

    public Integer getFeaturesId() 
    {
        return featuresId;
    }
    public void setFeaturesName(String featuresName) 
    {
        this.featuresName = featuresName;
    }

    public String getFeaturesName() 
    {
        return featuresName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("featuresId", getFeaturesId())
            .append("featuresName", getFeaturesName())
            .toString();
    }
}
