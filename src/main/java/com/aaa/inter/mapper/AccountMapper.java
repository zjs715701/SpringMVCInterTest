package com.aaa.inter.mapper;

import com.aaa.inter.common.CommonMapper;
import com.aaa.inter.entity.AccountEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AccountMapper extends CommonMapper<AccountEntity> {
}