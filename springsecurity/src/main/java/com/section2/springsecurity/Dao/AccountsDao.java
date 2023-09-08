package com.section2.springsecurity.Dao;

import com.section2.springsecurity.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AccountsDao extends JpaRepository<Accounts,Long> {
    Accounts findByCustomerId(int customerId);
}
