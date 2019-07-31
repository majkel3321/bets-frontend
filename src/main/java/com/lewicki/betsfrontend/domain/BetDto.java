package com.lewicki.betsfrontend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class BetDto {

    private Long id;
    private Long userId;
    private String homeTeam;
    private String awayTeam;
    private String result;
    private double odd;
    private double amount;

    public BetDto(Long userId, String homeTeam, String awayTeam, String result, double odd, double amount) {
        this.userId = userId;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.result = result;
        this.odd = odd;
        this.amount = amount;
    }
}
