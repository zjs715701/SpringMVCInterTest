package com.aaa.inter.service;

import com.aaa.inter.entity.BusinessException;
import com.aaa.inter.entity.EmployeeEntity;
import com.aaa.inter.entity.ResultData;
import com.aaa.inter.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public List<EmployeeEntity> select() {
        List<EmployeeEntity> employeeEntities= employeeMapper.selectAll();
        return employeeEntities;
    }

    @Override
    public EmployeeEntity selectById(EmployeeEntity employeeEntity) {
        EmployeeEntity employeeEntity1 = employeeMapper.selectByPrimaryKey(employeeEntity);
        return employeeEntity1;
    }

    @Override
    public List<EmployeeEntity> selectEmpAll() {
        List<EmployeeEntity> employeeEntities = employeeMapper.selectEmpAll();
        return employeeEntities;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = BusinessException.class)
    public ResultData insert(EmployeeEntity employeeEntity) throws BusinessException {
        ResultData resultData = null;
        try {
            int i = employeeMapper.insertSelective(employeeEntity);
            if (i>0){
                resultData = new ResultData(true,"新增成功",null);
            }else {
                resultData = new ResultData(false,"新增失败",null);
            }
            return resultData;
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("修改失败");
        }
    }

    @Override
    public ResultData update(EmployeeEntity employeeEntity) throws BusinessException {
        ResultData resultData = null;
        try {
            int i = employeeMapper.updateByPrimaryKeySelective(employeeEntity);
            if (i>0){
                resultData = new ResultData(true,"修改成功",null);
            }else {
                resultData = new ResultData(false,"修改失败",null);
            }
            return resultData;
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("修改失败");
        }
    }
}
