package com.guli.eduService.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.eduService.entity.EduTeacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guli.eduService.entity.vo.TeacherQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 讲师 Mapper 接口
 * </p>
 *
 * @author syq
 * @since 2022-09-17
 */
@Mapper
public interface EduTeacherMapper extends BaseMapper<EduTeacher> {
    IPage<EduTeacher> selectTeachers(Page<EduTeacher>page,@Param("query") TeacherQuery query);
}
