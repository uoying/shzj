package com.ruoyi.shzj.mapper;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjPhoto;

/**
 * 照片信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-07-30
 */
public interface ShzjPhotoMapper 
{
    /**
     * 查询照片信息
     * 
     * @param photoId 照片信息ID
     * @return 照片信息
     */
    public ShzjPhoto selectShzjPhotoById(Integer photoId);

    /**
     * 查询照片信息列表
     * 
     * @param shzjPhoto 照片信息
     * @return 照片信息集合
     */
    public List<ShzjPhoto> selectShzjPhotoList(ShzjPhoto shzjPhoto);

    /**
     * 新增照片信息
     * 
     * @param shzjPhoto 照片信息
     * @return 结果
     */
    public int insertShzjPhoto(ShzjPhoto shzjPhoto);

    /**
     * 修改照片信息
     * 
     * @param shzjPhoto 照片信息
     * @return 结果
     */
    public int updateShzjPhoto(ShzjPhoto shzjPhoto);

    /**
     * 删除照片信息
     * 
     * @param photoId 照片信息ID
     * @return 结果
     */
    public int deleteShzjPhotoById(Integer photoId);

    /**
     * 批量删除照片信息
     * 
     * @param photoIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjPhotoByIds(String[] photoIds);
}
