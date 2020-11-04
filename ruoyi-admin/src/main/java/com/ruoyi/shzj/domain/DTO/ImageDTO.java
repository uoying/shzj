package com.ruoyi.shzj.domain.DTO;

import com.ruoyi.common.annotation.Excel;

/**
 * @author hyj
 */
public class ImageDTO {
    /** 图像编号 */
    private Integer imageId;

    private String imageContentName;

    /** 图片url */
    @Excel(name = "图片url")
    private String imageUrl;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageContentName() {
        return imageContentName;
    }

    public void setImageContentName(String imageContentName) {
        this.imageContentName = imageContentName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ImageDTO{" +
                "imageId=" + imageId +
                ", imageContentName='" + imageContentName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
