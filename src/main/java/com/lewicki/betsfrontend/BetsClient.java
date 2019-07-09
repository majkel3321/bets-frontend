package com.lewicki.betsfrontend;

import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class BetsClient {

    @Autowired
    private RestTemplate restTemplate;


    public List<UserDto> getUsers () {
        UserDto[] usersResponse =  restTemplate.getForObject("http://localhost:8080/user/getUsers",UserDto[].class);
        return Arrays.asList(usersResponse);
    }

    public String receivedString(){
        return restTemplate.getForObject("http://localhost:8080/user/emample",String.class);
    }

    public void createUser(String username, String password) {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"username\": \"" + username +"\",\n    \"password\": \"" + password +"\"\n}");
        Request request = new Request.Builder()
                .url("http://localhost:8080/user/createUser")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("cache-control", "no-cache")
                .build();

        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
