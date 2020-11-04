package com.ruoyi.shzj.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.shzj.domain.DTO.TxsbDTO;
import com.ruoyi.shzj.domain.ShzjImage;
import com.ruoyi.shzj.service.impl.ShzjImageServiceImpl;
import com.ruoyi.shzj.util.VariableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.*;
import java.net.URL;
import java.util.List;

@Controller
@Api(tags = "txsb")
@RequestMapping("shzj/txsb")
public class ZjffShzjTxsbController {
    @Autowired
    private ShzjImageServiceImpl shzjImageService;

    @GetMapping("totxsb")
    public String totxsb(){

        return "test";
    }
    @ResponseBody
    @PostMapping("txsb")
    @ApiOperation("txsb")
    public AjaxResult txsb(MultipartFile files) throws IOException {
        //转换为File文件 并创建相应图片路径
        File imageFile = new File(files.getOriginalFilename());
        InputStream ins = files.getInputStream();
        try {
            OutputStream os = new FileOutputStream(imageFile);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        URL imageFile3=imageFile.toURI().toURL();
        Image image = ImageIO.read(imageFile3);
        image = toGrayscale(image);
        image = scale(image);
        int[] pixels = getPixels(image);
        int averageColor = getAverageOfPixelArray(pixels);
        pixels = getPixelDeviateWeightsArray(pixels, averageColor);
        ShzjImage shzjImage=new ShzjImage();

        List<ShzjImage> list= shzjImageService.selectShzjImageList(shzjImage);
        for(ShzjImage image1:list){
            URL imageFile2 = new URL(VariableName.domain+image1.getImageUrl());
            Image image2 = ImageIO.read(imageFile2);
            // 转换至灰度
            image2 = toGrayscale(image2);
            // 缩小成32x32的缩略图
            image2 = scale(image2);
            // 获取灰度像素数组
            int[] pixels2 = getPixels(image2);
            // 获取平均灰度颜色
            int averageColor2 = getAverageOfPixelArray(pixels2);
            // 获取灰度像素的比较数组（即图像指纹序列）
            pixels2 = getPixelDeviateWeightsArray(pixels2, averageColor2);
            System.err.println(pixels2);
            // 获取两个图的汉明距离（假设另一个图也已经按上面步骤得到灰度比较数组）
            int hammingDistance = getHammingDistance(pixels, pixels2);
            // 通过汉明距离计算相似度，取值范围 [0.0， 1.0]
            double similarity = calSimilarity(hammingDistance);
            File del = new File(imageFile.toURI());
            del.delete();
            System.err.println(similarity);
            if (similarity>=0.75){

                TxsbDTO txsbDTO= shzjImageService.selectShzjImageH5(image1.getImageContentId());
                String backgroundImg=VariableName.domain+image1.getImageUrl();
                txsbDTO.setBackgroundImg(backgroundImg);
                return AjaxResult.success(txsbDTO);
            }
        }


        return AjaxResult.success("无法识别！请更换角度");
    }


    // 将任意Image类型图像转换为BufferedImage类型，方便后续操作


    public static BufferedImage convertToBufferedFrom(Image srcImage) {
        BufferedImage bufferedImage = new BufferedImage(srcImage.getWidth(null),
                srcImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bufferedImage.createGraphics();
        g.drawImage(srcImage, null,null);
        g.dispose();
        return bufferedImage;

    }

    // 转换至灰度图


    public static BufferedImage toGrayscale(Image image) {
        BufferedImage sourceBuffered = convertToBufferedFrom(image);
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        ColorConvertOp op = new ColorConvertOp(cs, null);
        BufferedImage grayBuffered = op.filter(sourceBuffered, null);
        return grayBuffered;

    }

// 缩放至32x32像素缩略图

    public static Image scale(Image image) {
        image = image.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        return image;

    }

// 获取像素数组


    public static int[] getPixels(Image image) {
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        int[] pixels = convertToBufferedFrom(image).getRGB(0,0,width,height,null,0,width);
        return pixels;

    }

    // 获取灰度图的平均像素颜色值


    public static int getAverageOfPixelArray(int[] pixels) {
        Color color;
        long sumRed = 0;
        for (int i = 0; i < pixels.length; i++) {
            color = new Color(pixels[i],true);
            sumRed += color.getRed();
        }
        int averageRed = (int) (sumRed / pixels.length);
        return averageRed;
    }
// 获取灰度图的像素比较数组（平均值的离差）

    public static int[] getPixelDeviateWeightsArray(int[] pixels,final int averageColor) {
        Color color;
        int[] dest = new int[pixels.length];
        for (int i = 0; i < pixels.length; i++) {
            color = new Color(pixels[i],true);
            dest[i] = color.getRed() - averageColor > 0 ? 1 : 0;
        }
        return dest;

    }

    // 获取两个缩略图的平均像素比较数组的汉明距离（距离越大差异越大）
    public static int getHammingDistance(int[] a,int[] b) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] == b[i] ? 0 : 1;
        }
        return sum;
    }

    // 通过汉明距离计算相似度
    public static double calSimilarity(int hammingDistance) {
        int length = 32 * 32;
        double similarity = (length - hammingDistance) / (double) length;

        // 使用指数曲线调整相似度结果
        similarity = Math.pow(similarity,2);
        return similarity;
    }
}
