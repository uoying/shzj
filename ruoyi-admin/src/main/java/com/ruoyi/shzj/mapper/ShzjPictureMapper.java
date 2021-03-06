package com.ruoyi.shzj.mapper;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjPicture;

/**
 * 图片信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-07-13
 */
public interface ShzjPictureMapper 
{
    /**
     * 查询图片信息
     * 
     * @param picId 图片信息ID
     * @return 图片信息
     */
    public ShzjPicture selectShzjPictureById(Integer picId);

    /**
     * 查询图片信息列表
     * 
     * @param shzjPicture 图片信息
     * @return 图片信息集合
     */
    public List<ShzjPicture> selectShzjPictureList(ShzjPicture shzjPicture);

    /**
     * 新增图片信息
     * 
     * @param shzjPicture 图片信息
     * @return 结果
     */
    public int insertShzjPicture(ShzjPicture shzjPicture);

    /**
     * 修改图片信息
     * 
     * @param shzjPicture 图片信息
     * @return 结果
     */
    public int updateShzjPicture(ShzjPicture shzjPicture);

    /**
     * 删除图片信息
     * 
     * @param picId 图片信息ID
     * @return 结果
     */
    public int deleteShzjPictureById(Integer picId);

    /**
     * 批量删除图片信息
     * 
     * @param picIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjPictureByIds(String[] picIds);
}
