package com.guli.eduService.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.eduService.entity.EduTeacher;
import com.guli.eduService.entity.vo.TeacherQuery;
import com.guli.eduService.mapper.EduTeacherMapper;
import com.guli.eduService.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author syq
 * @since 2022-09-17
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Autowired
    private EduTeacherMapper mapper;
    @Override
    public IPage<EduTeacher> pageQuery(Page<EduTeacher>page,TeacherQuery query) {
        return mapper.selectTeachers(page,query);
    }

    @Override
    public void pageTeachers(Page<EduTeacher> page, TeacherQuery query) {
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        String name=query.getName();
        Integer level=query.getLevel();
        String begin=query.getBegin();
        String end=query.getEnd();
        if(!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)){
            wrapper.gt("gmt_create",begin);
        }
        if (!StringUtils.isEmpty(begin)){
            wrapper.lt("gmt_modified",begin);
        }
        page(page,wrapper);
    }
}
