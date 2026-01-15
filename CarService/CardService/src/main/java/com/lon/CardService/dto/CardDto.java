package com.lon.CardService.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CardDto {

    private Long cardId;
    private Double availableLimits;
    private String status;


}
