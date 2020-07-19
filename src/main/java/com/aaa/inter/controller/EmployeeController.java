package com.aaa.inter.controller;

import com.aaa.inter.entity.BusinessException;
import com.aaa.inter.entity.EmployeeEntity;
import com.aaa.inter.entity.ResultData;
import com.aaa.inter.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/selectEmpAll")
    public List<EmployeeEntity> selectEmpAll(){
        List<EmployeeEntity> employeeEntities = employeeService.selectEmpAll();
        return employeeEntities;
    }

    @PutMapping("/updateEmp")
    public ResultData updateEmp(@RequestBody EmployeeEntity employeeEntity) throws BusinessException {
        ResultData resultData = employeeService.update(employeeEntity);
        return resultData;
    }

    @PostMapping("/insertEmp")
    public ResultData insertEmp(EmployeeEntity employeeEntity) throws BusinessException {
        ResultData resultData = employeeService.insert(employeeEntity);
        return resultData;
    }

    @GetMapping("/selectById")
    public EmployeeEntity selectById(EmployeeEntity employeeEntity) throws BusinessException {
        EmployeeEntity employeeEntity1 = employeeService.selectById(employeeEntity);
        return employeeEntity1;
    }
}
