package com.section2.springsecurity.Dao;

import com.section2.springsecurity.entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CardsDao extends JpaRepository<Cards,Long> {
    List<Cards> findByCustomerId(int customerId);
}
