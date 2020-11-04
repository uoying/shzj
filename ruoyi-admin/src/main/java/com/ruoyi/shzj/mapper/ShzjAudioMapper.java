package com.ruoyi.shzj.mapper;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjAudio;

/**
 * 音频信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-07-16
 */
public interface ShzjAudioMapper 
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
     * 删除音频信息
     * 
     * @param audioId 音频信息ID
     * @return 结果
     */
    public int deleteShzjAudioById(Integer audioId);

    /**
     * 批量删除音频信息
     * 
     * @param audioIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjAudioByIds(String[] audioIds);
}
