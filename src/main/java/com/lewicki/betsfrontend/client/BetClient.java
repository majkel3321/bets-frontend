package com.lewicki.betsfrontend.client;

import com.lewicki.betsfrontend.domain.BetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BetClient {

    @Autowired
    private RestTemplate restTemplate;

    public void createBetDto(Long userId,String homeTeam, String awayTeam, String result,double amount, double v1, double x, double v2){
        double odd;
        switch (result){
            case "v1":
                odd = v1;
                break;

            case "x":
                odd = x;
                break;

            case "v2":
                odd = v2;
                break;

                default:
                    odd = 0;
        }

        BetDto betDto = new BetDto(userId,homeTeam,awayTeam,result,odd,amount);
        submitBetDto(betDto);
    }

    private void submitBetDto(BetDto betDto){
        HttpEntity<BetDto> entity = new HttpEntity<>(betDto);
        restTemplate.postForObject("http://localhost:8080/bet/createBet",entity,BetDto.class);
    }
}
