package com.lewicki.betsfrontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Component
public class BetsClient {

    @Autowired
    private RestTemplate restTemplate;

    private UserDto loggerUser;


    public List<UserDto> getUsers() {
        UserDto[] usersResponse = restTemplate.getForObject("http://localhost:8080/user/getUsers", UserDto[].class);
        return Arrays.asList(usersResponse);
    }

    public void createUser(String username, String password, String email) {
        UserDto userDto = new UserDto(username, password, email);
        HttpEntity<UserDto> entity = new HttpEntity<>(userDto);
        restTemplate.postForObject("http://localhost:8080/user/createUser", entity, UserDto.class);
    }

    public void logIn(String username, String password){
        String url = "http://localhost:8080/user/login";
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("username",username)
                .queryParam("password",password);

        restTemplate.put(builder.toUriString(),UserDto.class);
    }
}
