package com.lon.CardService.controller;

import com.lon.CardService.Repository.CardRepository;
import com.lon.CardService.enetity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    @GetMapping("/customer/{customerId}")
    public Card getCardByCustomer(@PathVariable Long customerId){
        return cardRepository.findByCustomerId(customerId);

    }
    @PutMapping("/{Id}/limit")
    public Card udateLimit(@PathVariable Long id, @RequestParam Double amount){
        Card card = cardRepository.findById(id).get();
        card.setAvailableLimit(card.getAvailableLimit()- amount);
        return cardRepository.save(card);
    }


}
