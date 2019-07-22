package com.lewicki.betsfrontend.client;

import com.lewicki.betsfrontend.domain.MatchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class MatchClient {

    @Autowired
    private RestTemplate restTemplate;

    public List<MatchDto> getMatches(){
        MatchDto[] matchDtos = restTemplate.getForObject("http://localhost:8080/matches",MatchDto[].class);
        return Arrays.asList(matchDtos);
    }
}
