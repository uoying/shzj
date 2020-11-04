package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 音频信息对象 shzj_audio
 * 
 * @author ruoyi
 * @date 2020-07-16
 */
public class ShzjAudio extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 音频编号 */
    private Integer audioId;

    /** 音频URL */
    @Excel(name = "音频URL")
    private String audioUrl;

    public void setAudioId(Integer audioId) 
    {
        this.audioId = audioId;
    }

    public Integer getAudioId() 
    {
        return audioId;
    }
    public void setAudioUrl(String audioUrl) 
    {
        this.audioUrl = audioUrl;
    }

    public String getAudioUrl() 
    {
        return audioUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("audioId", getAudioId())
            .append("audioUrl", getAudioUrl())
            .toString();
    }
}
