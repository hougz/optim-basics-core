package com.hgz.optim.controller;

import com.hgz.bean.vo.StudentVo;
import com.hgz.optim.entity.StudentEntity;
import com.hgz.optim.service.StudentService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/9 16:13
 */
@Api(tags = "学生管理")
@RestController
@RequestMapping("/api/v1/student")
public class StudentController extends BaseController<StudentVo, StudentEntity> {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        super(studentService);
        this.studentService = studentService;
    }
}
