package com.ruoyi.shzj.domain.DTO;

public class TxsbDTO {
    private String  imageName, imageH5,imageAudio,backgroundImg;

    @Override
    public String toString() {
        return "TxsbDTO{" +
                "imageName='" + imageName + '\'' +
                ", imageH5='" + imageH5 + '\'' +
                ", imageAudio='" + imageAudio + '\'' +
                ", backgroundImg='" + backgroundImg + '\'' +
                '}';
    }

    public String getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(String backgroundImg) {
        this.backgroundImg = backgroundImg;
    }

    public String getImageAudio() {
        return imageAudio;
    }

    public void setImageAudio(String imageAudio) {
        this.imageAudio = imageAudio;
    }

    public String getImageH5() {
        return imageH5;
    }

    public void setImageH5(String imageH5) {
        this.imageH5 = imageH5;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
