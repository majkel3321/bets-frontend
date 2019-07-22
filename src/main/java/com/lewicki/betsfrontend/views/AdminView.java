package com.lewicki.betsfrontend.views;

import com.lewicki.betsfrontend.client.UserClient;
import com.lewicki.betsfrontend.domain.UserDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("admin")
public class AdminView extends VerticalLayout {

    private Button buttonShowUsers = new Button("show users");
    private Grid<UserDto> gridUsers = new Grid<>(UserDto.class);

    @Autowired
    UserClient userClient;

    public AdminView(){
        buttonShowUsers.addClickListener(event -> gridUsers.setItems(userClient.getUsers()));
        gridUsers.setColumns("id","username","password","email","createTime","loggedIn");
        add(gridUsers);
        add(buttonShowUsers);
    }

}
