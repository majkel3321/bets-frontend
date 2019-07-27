package com.lewicki.betsfrontend.client;

import com.lewicki.betsfrontend.domain.PlayerDto;
import com.lewicki.betsfrontend.domain.TeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Component
public class LeagueClient {

    @Autowired
    private RestTemplate restTemplate;

    public List<TeamDto> getTeamsFromLeague(String name){
        String url = "http://localhost:8080/team/league";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("name",name);

        TeamDto[] teams = restTemplate.getForObject(builder.toUriString(),TeamDto[].class);
        return Arrays.asList(teams);
    }

    public List<PlayerDto> getSquad(String name){
        String url = "http://localhost:8080/team";   //przeniesc do configuration i uwywac jako stalej
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("name",name);

        PlayerDto[] players = restTemplate.getForObject(builder.toUriString(),PlayerDto[].class);
        return Arrays.asList(players);
    }
}
