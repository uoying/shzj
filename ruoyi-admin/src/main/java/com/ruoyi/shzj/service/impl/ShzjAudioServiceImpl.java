package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjAudioMapper;
import com.ruoyi.shzj.domain.ShzjAudio;
import com.ruoyi.shzj.service.IShzjAudioService;
import com.ruoyi.common.core.text.Convert;

/**
 * 音频信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-16
 */
@Service
public class ShzjAudioServiceImpl implements IShzjAudioService 
{
    @Autowired
    private ShzjAudioMapper shzjAudioMapper;

    /**
     * 查询音频信息
     * 
     * @param audioId 音频信息ID
     * @return 音频信息
     */
    @Override
    public ShzjAudio selectShzjAudioById(Integer audioId)
    {
        return shzjAudioMapper.selectShzjAudioById(audioId);
    }

    /**
     * 查询音频信息列表
     * 
     * @param shzjAudio 音频信息
     * @return 音频信息
     */
    @Override
    public List<ShzjAudio> selectShzjAudioList(ShzjAudio shzjAudio)
    {
        return shzjAudioMapper.selectShzjAudioList(shzjAudio);
    }

    /**
     * 新增音频信息
     * 
     * @param shzjAudio 音频信息
     * @return 结果
     */
    @Override
    public int insertShzjAudio(ShzjAudio shzjAudio)
    {
        return shzjAudioMapper.insertShzjAudio(shzjAudio);
    }

    /**
     * 修改音频信息
     * 
     * @param shzjAudio 音频信息
     * @return 结果
     */
    @Override
    public int updateShzjAudio(ShzjAudio shzjAudio)
    {
        return shzjAudioMapper.updateShzjAudio(shzjAudio);
    }

    /**
     * 删除音频信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjAudioByIds(String ids)
    {
        return shzjAudioMapper.deleteShzjAudioByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除音频信息信息
     * 
     * @param audioId 音频信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjAudioById(Integer audioId)
    {
        return shzjAudioMapper.deleteShzjAudioById(audioId);
    }
}
