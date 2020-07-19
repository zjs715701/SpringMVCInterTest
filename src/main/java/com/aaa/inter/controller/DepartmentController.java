package com.aaa.inter.controller;

import com.aaa.inter.entity.DepartmentEntity;
import com.aaa.inter.entity.EmployeeEntity;
import com.aaa.inter.service.DepartmentService;
import com.aaa.inter.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/selectDepAll")
    public List<DepartmentEntity> selectDepAll(){
        List<DepartmentEntity> departmentEntities = departmentService.selectAll();
        return departmentEntities;
    }
}
