package com.section2.springsecurity.Dao;

import com.section2.springsecurity.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Long> {
    List<Customer> findByEmail (String email);
}
