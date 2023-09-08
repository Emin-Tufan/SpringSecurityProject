package com.section2.springsecurity.controller;

import com.section2.springsecurity.Dao.LoanDao;
import com.section2.springsecurity.entity.Loans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    private LoanDao loanDao;

    @Autowired
    public LoansController(LoanDao loanDao) {
        this.loanDao = loanDao;
    }
    @GetMapping("/myLoans")
    public List<Loans> getLoanDetails(@RequestParam int id) {
        List<Loans> loans = loanDao.findByCustomerIdOrderByStartDtDesc(id);
        if (loans != null ) {
            return loans;
        }else {
            return null;
        }
    }
}
