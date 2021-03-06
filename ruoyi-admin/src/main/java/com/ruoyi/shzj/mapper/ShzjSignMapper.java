package com.ruoyi.shzj.mapper;

import java.util.List;
import com.ruoyi.shzj.domain.ShzjSign;

/**
 * 签到信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-07-28
 */
public interface ShzjSignMapper 
{
    /**
     * 查询签到信息
     * 
     * @param signId 签到信息ID
     * @return 签到信息
     */
    public ShzjSign selectShzjSignById(Integer signId);

    /**
     * 查询签到信息列表
     * 
     * @param shzjSign 签到信息
     * @return 签到信息集合
     */
    public List<ShzjSign> selectShzjSignList(ShzjSign shzjSign);

    /**
     * 新增签到信息
     * 
     * @param shzjSign 签到信息
     * @return 结果
     */
    public int insertShzjSign(ShzjSign shzjSign);

    /**
     * 修改签到信息
     * 
     * @param shzjSign 签到信息
     * @return 结果
     */
    public int updateShzjSign(ShzjSign shzjSign);

    /**
     * 删除签到信息
     * 
     * @param signId 签到信息ID
     * @return 结果
     */
    public int deleteShzjSignById(Integer signId);

    /**
     * 批量删除签到信息
     * 
     * @param signIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjSignByIds(String[] signIds);
}
