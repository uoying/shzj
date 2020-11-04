package com.ruoyi.shzj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjSignMapper;
import com.ruoyi.shzj.domain.ShzjSign;
import com.ruoyi.shzj.service.IShzjSignService;
import com.ruoyi.common.core.text.Convert;

/**
 * 签到信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-28
 */
@Service
public class ShzjSignServiceImpl implements IShzjSignService 
{
    @Autowired
    private ShzjSignMapper shzjSignMapper;

    /**
     * 查询签到信息
     * 
     * @param signId 签到信息ID
     * @return 签到信息
     */
    @Override
    public ShzjSign selectShzjSignById(Integer signId)
    {
        return shzjSignMapper.selectShzjSignById(signId);
    }

    /**
     * 查询签到信息列表
     * 
     * @param shzjSign 签到信息
     * @return 签到信息
     */
    @Override
    public List<ShzjSign> selectShzjSignList(ShzjSign shzjSign)
    {
        return shzjSignMapper.selectShzjSignList(shzjSign);
    }

    /**
     * 新增签到信息
     * 
     * @param shzjSign 签到信息
     * @return 结果
     */
    @Override
    public int insertShzjSign(ShzjSign shzjSign)
    {
        return shzjSignMapper.insertShzjSign(shzjSign);
    }

    /**
     * 修改签到信息
     * 
     * @param shzjSign 签到信息
     * @return 结果
     */
    @Override
    public int updateShzjSign(ShzjSign shzjSign)
    {
        return shzjSignMapper.updateShzjSign(shzjSign);
    }

    /**
     * 删除签到信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjSignByIds(String ids)
    {
        return shzjSignMapper.deleteShzjSignByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除签到信息信息
     * 
     * @param signId 签到信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjSignById(Integer signId)
    {
        return shzjSignMapper.deleteShzjSignById(signId);
    }
}
