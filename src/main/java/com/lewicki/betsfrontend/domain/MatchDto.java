package com.lewicki.betsfrontend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MatchDto {

    private String homeTeam;
    private String awayTeam;
    private double v1;
    private double x;
    private double v2;
}
