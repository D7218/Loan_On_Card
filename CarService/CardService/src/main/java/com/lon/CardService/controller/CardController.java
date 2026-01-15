package com.lon.CardService.controller;

import com.lon.CardService.dto.CardDto;
import com.lon.CardService.enetity.Card;
import com.lon.CardService.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public Card createCard(@RequestBody Card card){
        return cardService.createCard(card);
    }

    @GetMapping("/customer/{customerId}")
    public Card getCard(@PathVariable Long customerId){
        return cardService.getCardByCustomerId(customerId);

    }
    @PutMapping("/{Id}/limit")
    public CardDto updateLimit(@PathVariable Long cardId, @RequestParam Double amount){
     return cardService.updateAvailbleLimit(cardId, amount);

    }
    @GetMapping
   public Card issueCard(Card card){
        return cardService.issueCard(card);
   }
   @DeleteMapping("/{cardId}")
   public ResponseEntity<String> deleteCard(@PathVariable Long cardId){
         cardService.deleteCard(cardId);
         return ResponseEntity.ok("Card deleted successfully");
   }

}
