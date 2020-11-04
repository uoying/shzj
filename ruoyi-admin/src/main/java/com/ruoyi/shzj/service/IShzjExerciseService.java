package com.ruoyi.shzj.service;

import java.util.List;

import com.ruoyi.shzj.domain.DTO.AnswerDTO;
import com.ruoyi.shzj.domain.DTO.ExerciseDTO;
import com.ruoyi.shzj.domain.DTO.UpDataExerciseDTo;
import com.ruoyi.shzj.domain.ShzjExercise;

/**
 * 答题信息Service接口
 * 
 * @author ruoyi
 * @date 2020-07-21
 */
public interface IShzjExerciseService 
{
    /**
     * 查询答题信息
     * 
     * @param exeId 答题信息ID
     * @return 答题信息
     */
    public ShzjExercise selectShzjExerciseById(Integer exeId);

    /**
     * 查询答题信息列表
     * 
     * @param shzjExercise 答题信息
     * @return 答题信息集合
     */
    public List<ShzjExercise> selectShzjExerciseList(ShzjExercise shzjExercise);

    /**
     * 新增答题信息
     * 
     * @param shzjExercise 答题信息
     * @return 结果
     */
    public int insertShzjExercise(ShzjExercise shzjExercise);

    /**
     * 修改答题信息
     * 
     * @param shzjExercise 答题信息
     * @return 结果
     */
    public int updateShzjExercise(ShzjExercise shzjExercise);

    /**
     * 批量删除答题信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShzjExerciseByIds(String ids);

    /**
     * 删除答题信息信息
     * 
     * @param exeId 答题信息ID
     * @return 结果
     */
    public int deleteShzjExerciseById(Integer exeId);

    List<ExerciseDTO> selectShzjExercise(int judge);

    AnswerDTO selectShzjAnswerById(int id);

    int updateShzjtiExercise(String subject, String choiceA, String choiceB, String choiceC, String choiceD, String answer,String parse,int judge, int userId);
}
