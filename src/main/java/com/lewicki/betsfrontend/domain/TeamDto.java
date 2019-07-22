package com.lewicki.betsfrontend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamDto {

    @JsonProperty("team_id")
    private Long team_id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("venue_name")
    private String venue_name;

    @JsonProperty("venue_capacity")
    private int venue_capacity;

    @JsonProperty("venue_city")
    private String venue_city;
}
