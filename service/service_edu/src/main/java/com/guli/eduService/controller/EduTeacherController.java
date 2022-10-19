package com.guli.eduService.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.commonutils.R;
import com.guli.eduService.entity.EduTeacher;
import com.guli.eduService.entity.vo.TeacherQuery;
import com.guli.eduService.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author syq
 * @since 2022-09-17
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/eduService/edu-teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService service;

    @ApiOperation(value = "讲师列表")
    @GetMapping("findAll")
    public R findAllTeacher() {
        List<EduTeacher> list = service.list(null);
        return R.ok().data("data", list);
    }

    @ApiOperation(value = "根据id删除讲师")
    @DeleteMapping("/delete/{id}")
    public R deleteById(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id) {
        boolean flag = service.removeById(id);
        if (flag == true) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @ApiOperation(value = "分页条件查询讲师列表")
    @PostMapping("pageTeacher/{current}/{limit}")
    public R pageListTeacher(@ApiParam(name = "current", value = "当前页", required = true) @PathVariable Long current,
                             @ApiParam(name = "limit", value = "当前条数", required = true) @PathVariable Long limit,
                             @RequestBody(required = false) TeacherQuery query) {
        Page<EduTeacher> page = new Page<>(current, limit);
//        service.pageQuery(page,query);
        service.pageTeachers(page,query);
        List<EduTeacher> list = page.getRecords();
        long total = page.getTotal();
        return R.ok().data("total", total).data("items", list);
    }

    @ApiOperation(value = "添加讲师信息")
    @PostMapping("add")
    public R addTeacher(@RequestBody  EduTeacher teacher){
        boolean flag=service.save(teacher);
        if(flag==true){
            return R.ok();
        }else {
            return R.error();
        }
    }

    @ApiOperation(value = "根据id查询讲师信息")
    @GetMapping("findTeacherById/{id}")
    public R findTeacherById(@ApiParam(name = "id",value = "讲师id",required = true) @PathVariable Long id){
        EduTeacher teacher=service.getById(id);
        return R.ok().data("teacher",teacher);
    }

    @ApiOperation(value = "修改讲师信息")
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean flag =service.updateById(eduTeacher);
        if(flag==true){
            return R.ok();
        }else {
            return R.error();
        }
    }
}

