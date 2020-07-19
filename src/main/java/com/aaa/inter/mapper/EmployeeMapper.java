package com.aaa.inter.mapper;

import com.aaa.inter.common.CommonMapper;
import com.aaa.inter.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmployeeMapper extends CommonMapper<EmployeeEntity> {
    List<EmployeeEntity> selectEmpAll();
}