package com.ruoyi.shzj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Arrays;

/**
 * 诗词信息对象 shzj_poem
 * 
 * @author ruoyi
 * @date 2020-07-13
 */
public class ShzjPoem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 诗词编号 */
    private Integer poemId;

    /** 题目 */
    @Excel(name = "题目")
    private String poemName;

    /** 作者 */
    @Excel(name = "作者")
    private String poemAuthor;

    /** 诗文 */
    @Excel(name = "诗文")
    private String poemArtcle;

    /** 诗文配图 */
    @Excel(name = "诗文配图")
    private String poemPicture;

    /** 音频编号 */
    @Excel(name = "音频编号")
    private String poemAudio;
    private String poemPictureUrl;
    private String[] poemAudioUrl;

    public String[] getPoemAudioUrl() {
        return poemAudioUrl;
    }

    public void setPoemAudioUrl(String[] poemAudioUrl) {
        this.poemAudioUrl = poemAudioUrl;
    }

    public String getPoemPictureUrl() {
        return poemPictureUrl;
    }

    public void setPoemPictureUrl(String poemPictureUrl) {
        this.poemPictureUrl = poemPictureUrl;
    }

    public void setPoemId(Integer poemId)
    {
        this.poemId = poemId;
    }

    public Integer getPoemId() 
    {
        return poemId;
    }
    public void setPoemName(String poemName) 
    {
        this.poemName = poemName;
    }

    public String getPoemName() 
    {
        return poemName;
    }
    public void setPoemAuthor(String poemAuthor) 
    {
        this.poemAuthor = poemAuthor;
    }

    public String getPoemAuthor() 
    {
        return poemAuthor;
    }
    public void setPoemArtcle(String poemArtcle) 
    {
        this.poemArtcle = poemArtcle;
    }

    public String getPoemArtcle() 
    {
        return poemArtcle;
    }
    public void setPoemPicture(String poemPicture) 
    {
        this.poemPicture = poemPicture;
    }

    public String getPoemPicture() 
    {
        return poemPicture;
    }

    public String getPoemAudio() {
        return poemAudio;
    }

    public void setPoemAudio(String poemAudio) {
        this.poemAudio = poemAudio;
    }

    @Override
    public String toString() {
        return "ShzjPoem{" +
                "poemId=" + poemId +
                ", poemName='" + poemName + '\'' +
                ", poemAuthor='" + poemAuthor + '\'' +
                ", poemArtcle='" + poemArtcle + '\'' +
                ", poemPicture='" + poemPicture + '\'' +
                ", poemAudio='" + poemAudio + '\'' +
                ", poemPictureUrl='" + poemPictureUrl + '\'' +
                ", poemAudioUrl=" + Arrays.toString(poemAudioUrl) +
                '}';
    }
}
