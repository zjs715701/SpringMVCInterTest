package com.aaa.inter.controller;

import com.aaa.inter.entity.AccountEntity;
import com.aaa.inter.entity.BusinessException;
import com.aaa.inter.entity.ResultData;
import com.aaa.inter.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public ResultData Login(AccountEntity accountEntity, HttpSession session) throws BusinessException {
         ResultData resultData = accountService.selectById(accountEntity);
        System.out.println(1111);
//        System.out.println(resultData);
         if (resultData.isState()){
             session.setAttribute("userInfo",resultData.getData());
         }
        return resultData;
    }
}
