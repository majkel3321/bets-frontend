package com.lewicki.betsfrontend.client;

import com.lewicki.betsfrontend.domain.UserDto;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Component
@Getter
public class UserClient {

    @Autowired
    private RestTemplate restTemplate;

    private UserDto loggedUser;

    public List<UserDto> getUsers() {
        UserDto[] usersResponse = restTemplate.getForObject("http://localhost:8080/user/all", UserDto[].class);
        return Arrays.asList(usersResponse);
    }

    public void createUser(String username, String password, String email) {
        UserDto userDto = new UserDto(username, password, email);
        HttpEntity<UserDto> entity = new HttpEntity<>(userDto);
        restTemplate.postForObject("http://localhost:8080/user/create", entity, Void.class);
    }

    public void logIn(String username, String password) {
        String url = "http://localhost:8080/user/login";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("username", username)
                .queryParam("password", password);

        restTemplate.put(builder.toUriString(), Boolean.class);
    }

    public UserDto getLoggedUser(){
        loggedUser = restTemplate.getForObject("http://localhost:8080/user/logged", UserDto.class);
        return loggedUser;
    }

    public void logOut(){
        String url = "http://localhost:8080/user/logout";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("username",loggedUser.getUsername());

        restTemplate.put(builder.toUriString(),Boolean.class);
    }

    public void updateAccountBalance(Long userId, double amount){
        String url = "http://localhost:8080/user/updateBalance";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("userId",userId)
                .queryParam("amount",(amount * -1));

        restTemplate.put(builder.toUriString(),Boolean.class);
    }
}
