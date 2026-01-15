package com.lon.CardService.Repository;

import com.lon.CardService.dto.CardDto;
import com.lon.CardService.enetity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {


    Card findByCustomerId(Long customerId);
}