package com.lewicki.betsfrontend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeamDto {

    private Long team_id;
    private String name;
    private String venue_name;
    private int venue_capacity;
    private String venue_city;
}
