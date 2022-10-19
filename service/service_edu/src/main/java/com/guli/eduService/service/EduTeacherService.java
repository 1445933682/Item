package com.guli.eduService.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.eduService.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.eduService.entity.vo.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author syq
 * @since 2022-09-17
 */
public interface EduTeacherService extends IService<EduTeacher> {
    IPage<EduTeacher> pageQuery(Page<EduTeacher>page,TeacherQuery query);
    void pageTeachers(Page<EduTeacher>page,TeacherQuery query);

}
