package com.lon.CardService.Repository;

import com.lon.CardService.enetity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

    Card findByCustomerId(Long customerId);
}