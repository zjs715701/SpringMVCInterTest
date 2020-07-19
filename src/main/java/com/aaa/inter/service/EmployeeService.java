package com.aaa.inter.service;

import com.aaa.inter.entity.BusinessException;
import com.aaa.inter.entity.EmployeeEntity;
import com.aaa.inter.entity.ResultData;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeEntity> select();
    public EmployeeEntity selectById(EmployeeEntity employeeEntity);
    public List<EmployeeEntity> selectEmpAll();
    public ResultData insert(EmployeeEntity employeeEntity) throws BusinessException;
    public ResultData update(EmployeeEntity employeeEntity) throws BusinessException;
}
