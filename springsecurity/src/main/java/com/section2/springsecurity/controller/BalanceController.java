package com.section2.springsecurity.controller;

import com.section2.springsecurity.Dao.AccountTransactionsDao;
import com.section2.springsecurity.entity.AccountTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    private AccountTransactionsDao accountTransactionsDao;

    @Autowired
    public BalanceController(AccountTransactionsDao accountTransactionsDao) {
        this.accountTransactionsDao = accountTransactionsDao;
    }

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam int id) {
        List<AccountTransactions> accountTransactions = accountTransactionsDao.
                findByCustomerIdOrderByTransactionDtDesc(id);
        if (accountTransactions != null ) {
            return accountTransactions;
        }else {
            return null;
        }
    }
}
