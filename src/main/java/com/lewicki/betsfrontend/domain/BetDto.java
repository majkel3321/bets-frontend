package com.lewicki.betsfrontend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class BetDto {

    private Long userId;
    private String homeTeam;
    private String awayTeam;
    private String result;
    private double odd;
    private double amount;
}
