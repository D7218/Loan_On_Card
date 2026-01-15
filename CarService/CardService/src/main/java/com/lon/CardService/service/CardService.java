package com.lon.CardService.service;

import com.lon.CardService.Repository.CardRepository;
import com.lon.CardService.dto.CardDto;
import com.lon.CardService.enetity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository repository;

    // create card
    public Card issueCard(Card card){
        card.setAvailableLimit(card.getAvailableLimit());
        card.setStatus("ACTIVE");
        return repository.save(card);
    }

//    public List<Card> createCard() {
//        return repository.save(card);
//    }
     public Card createCard(Card card){
        return repository.save(card);
     }
    // Read
    public Card getCardByCustomerId(Long customerId){
        return repository.findByCustomerId(customerId);
    }

public CardDto updateAvailbleLimit(Long cardId, Double loanAmount){
    Card card = repository.findById(cardId).orElseThrow(() -> new RuntimeException("card not found"));
    if (card.getAvailableLimit()< loanAmount){
        throw new RuntimeException("Insufficient card limit");
    }
    card.setAvailableLimit(card.getAvailableLimit()- loanAmount);
    Card update = repository.save(card);
    CardDto cardDto = new CardDto();
    cardDto.setCardId(update.getId());
    cardDto.setAvailableLimits(update.getAvailableLimit());
    cardDto.setStatus(update.getStatus());
    return cardDto;
}
  public void deleteCard(Long cardId){
        if (!repository.existsById(cardId)){
            throw new RuntimeException("card not found with id:" + cardId);
        }
        repository.deleteById(cardId);
  }

    // update
}
