package com.aaa.inter.service;

import com.aaa.inter.entity.AccountEntity;
import com.aaa.inter.entity.BusinessException;
import com.aaa.inter.entity.ResultData;
import com.aaa.inter.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public ResultData selectById(AccountEntity accountEntity) throws BusinessException {
        try {
            ResultData resultData = null;
            List<AccountEntity> accountEntities = accountMapper.select(accountEntity);
            if (accountEntities.size()>0){
                resultData = new ResultData(true,"登录成功",accountEntities.get(0));
            }else {
                resultData = new ResultData(false,"登录失败",null);
            }
            return resultData;
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("非法登录");
        }
    }
}
