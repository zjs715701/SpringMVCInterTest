package com.aaa.inter.mapper;

import com.aaa.inter.common.CommonMapper;
import com.aaa.inter.entity.DepartmentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DepartmentMapper extends CommonMapper<DepartmentEntity> {
}