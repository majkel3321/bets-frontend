package com.lewicki.betsfrontend.client;

import com.lewicki.betsfrontend.domain.MatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Component
public class MatchClient {

    @Autowired
    private RestTemplate restTemplate;

    public List<MatchDto> getMatches(String leagueName){
        String url = "http://localhost:8080/matches/all";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("leagueName",leagueName);

        MatchDto[] matchDtos = restTemplate.getForObject(builder.toUriString(),MatchDto[].class);
        return Arrays.asList(matchDtos);
    }
}
