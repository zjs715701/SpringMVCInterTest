package com.aaa.inter.service;

import com.aaa.inter.entity.AccountEntity;
import com.aaa.inter.entity.BusinessException;
import com.aaa.inter.entity.ResultData;

import java.util.List;

public interface AccountService {

    public ResultData selectById(AccountEntity accountEntity) throws BusinessException;

}
