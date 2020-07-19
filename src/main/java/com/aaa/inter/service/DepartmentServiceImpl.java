package com.aaa.inter.service;

import com.aaa.inter.entity.DepartmentEntity;
import com.aaa.inter.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public List<DepartmentEntity> selectAll() {
        return departmentMapper.selectAll();
    }
}
