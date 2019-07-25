package com.lewicki.betsfrontend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerDto {

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("position")
    private String position;

    @JsonProperty("age")
    private int age;

    @JsonProperty("nationality")
    private String nationality;

    @JsonProperty("height")
    private String height;

    @JsonProperty("weight")
    private String weight;
}
