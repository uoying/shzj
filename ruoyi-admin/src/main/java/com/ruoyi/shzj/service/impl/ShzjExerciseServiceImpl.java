package com.ruoyi.shzj.service.impl;

import java.util.List;

import com.ruoyi.shzj.domain.DTO.AnswerDTO;
import com.ruoyi.shzj.domain.DTO.ExerciseDTO;
import com.ruoyi.shzj.domain.DTO.UpDataExerciseDTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shzj.mapper.ShzjExerciseMapper;
import com.ruoyi.shzj.domain.ShzjExercise;
import com.ruoyi.shzj.service.IShzjExerciseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 答题信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-21
 */
@Service
public class ShzjExerciseServiceImpl implements IShzjExerciseService 
{
    @Autowired
    private ShzjExerciseMapper shzjExerciseMapper;

    /**
     * 查询答题信息
     * 
     * @param exeId 答题信息ID
     * @return 答题信息
     */
    @Override
    public ShzjExercise selectShzjExerciseById(Integer exeId)
    {
        return shzjExerciseMapper.selectShzjExerciseById(exeId);
    }

    /**
     * 查询答题信息列表
     * 
     * @param shzjExercise 答题信息
     * @return 答题信息
     */
    @Override
    public List<ShzjExercise> selectShzjExerciseList(ShzjExercise shzjExercise)
    {
        return shzjExerciseMapper.selectShzjExerciseList(shzjExercise);
    }

    /**
     * 新增答题信息
     * 
     * @param shzjExercise 答题信息
     * @return 结果
     */
    @Override
    public int insertShzjExercise(ShzjExercise shzjExercise)
    {
        return shzjExerciseMapper.insertShzjExercise(shzjExercise);
    }

    /**
     * 修改答题信息
     * 
     * @param shzjExercise 答题信息
     * @return 结果
     */
    @Override
    public int updateShzjExercise(ShzjExercise shzjExercise)
    {
        return shzjExerciseMapper.updateShzjExercise(shzjExercise);
    }

    /**
     * 删除答题信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShzjExerciseByIds(String ids)
    {
        return shzjExerciseMapper.deleteShzjExerciseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除答题信息信息
     * 
     * @param exeId 答题信息ID
     * @return 结果
     */
    @Override
    public int deleteShzjExerciseById(Integer exeId)
    {
        return shzjExerciseMapper.deleteShzjExerciseById(exeId);
    }

    @Override
    public List<ExerciseDTO> selectShzjExercise(int judge) {
        return shzjExerciseMapper.selectShzjExercise(judge);
    }

    @Override
    public AnswerDTO selectShzjAnswerById(int id) {
        return shzjExerciseMapper.selectShzjAnswerById(id);
    }

    @Override
    public int updateShzjtiExercise(String subject, String choiceA, String choiceB, String choiceC, String choiceD, String answer,String parse,int judge, int userId) {
        return shzjExerciseMapper.updateShzjtiExercise(subject,choiceA,choiceB,choiceC,choiceD,answer,parse,userId,judge);
    }
}
