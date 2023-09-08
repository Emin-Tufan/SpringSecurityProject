package com.section2.springsecurity.controller;

import com.section2.springsecurity.Dao.CardsDao;
import com.section2.springsecurity.entity.Cards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    private CardsDao cardsDao;

    @Autowired
    public CardsController(CardsDao cardsDao) {
        this.cardsDao = cardsDao;
    }

    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam int id) {
        List<Cards> cards = cardsDao.findByCustomerId(id);
        if (cards != null ) {
            return cards;
        }else {
            return null;
        }
    }
}
