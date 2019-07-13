package com.lewicki.betsfrontend.Views;

import com.lewicki.betsfrontend.BetsClient;
import com.lewicki.betsfrontend.UserDto;
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
    BetsClient betsClient;

    public AdminView(){
        buttonShowUsers.addClickListener(event -> gridUsers.setItems(betsClient.getUsers()));
        gridUsers.setColumns("id","username","password","email","createTime","loggedIn");
        add(gridUsers);
        add(buttonShowUsers);
    }

}
