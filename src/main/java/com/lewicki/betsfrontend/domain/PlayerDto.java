package com.lewicki.betsfrontend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlayerDto {

    private String firstname;
    private String lastname;
    private String position;
    private int age;
    private String nationality;
    private String height;
    private String weight;
}
