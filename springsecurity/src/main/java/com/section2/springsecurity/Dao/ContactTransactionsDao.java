package com.section2.springsecurity.Dao;


import com.section2.springsecurity.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ContactTransactionsDao extends JpaRepository<Contact,Long> {
}
