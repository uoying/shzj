package com.ruoyi.shzj.service;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjAudio;

/**
 * 音频信息Service接口
 * 
 * @author ruoyi
 * @date 2020-07-16
 */
public interface IShzjAudioService 
{
    /**
     * 查询音频信息
     * 
     * @param audioId 音频信息ID
     * @return 音频信息
     */
    public ShzjAudio selectShzjAudioById(Integer audioId);

    /**
     * 查询音频信息列表
     * 
     * @param shzjAudio 音频信息
     * @return 音频信息集合
     */
    public List<ShzjAudio> selectShzjAudioList(ShzjAudio shzjAudio);

    /**
     * 新增音频信息
     * 
     * @param shzjAudio 音频信息
     * @return 结果
     */
    public int insertShzjAudio(ShzjAudio shzjAudio);

    /**
     * 修改音频信息
     * 
     * @param shzjAudio 音频信息
     * @return 结果
     */
    public int updateShzjAudio(ShzjAudio shzjAudio);

    /**
     * 批量删除音频信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjAudioByIds(String ids);

    /**
     * 删除音频信息信息
     * 
     * @param audioId 音频信息ID
     * @return 结果
     */
    public int deleteShzjAudioById(Integer audioId);
}
