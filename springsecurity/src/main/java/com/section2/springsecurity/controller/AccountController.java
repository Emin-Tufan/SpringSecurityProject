package com.section2.springsecurity.controller;

import com.section2.springsecurity.Dao.AccountsDao;
import com.section2.springsecurity.entity.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private AccountsDao accountsDao;
@Autowired
    public AccountController(AccountsDao accountsDao) {
        this.accountsDao = accountsDao;
    }

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam int id) {
        Accounts accounts = accountsDao.findByCustomerId(id);
        if (accounts != null ) {
            return accounts;
        }else {
            return null;
        }
    }
}
