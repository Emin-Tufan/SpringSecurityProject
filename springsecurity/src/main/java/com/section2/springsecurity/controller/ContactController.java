package com.section2.springsecurity.controller;

import com.section2.springsecurity.Dao.ContactTransactionsDao;
import com.section2.springsecurity.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
public class ContactController {
    private ContactTransactionsDao contactTransactionsDao;

    @Autowired
    public ContactController(ContactTransactionsDao contactTransactionsDao) {
        this.contactTransactionsDao = contactTransactionsDao;
    }

    @PostMapping("/contact")
    public Contact saveContactInquiryDetails(@RequestBody Contact contact) {
        contact.setContactId(getServiceReqNumber());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        return contactTransactionsDao.save(contact);
    }

    public String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR"+ranNum;
    }
}
