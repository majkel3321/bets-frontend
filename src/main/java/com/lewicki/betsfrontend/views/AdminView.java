package com.lewicki.betsfrontend.views;

import com.lewicki.betsfrontend.client.BetClient;
import com.lewicki.betsfrontend.client.UserClient;
import com.lewicki.betsfrontend.domain.BetDto;
import com.lewicki.betsfrontend.domain.UserDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("admin")
public class AdminView extends VerticalLayout {

    private Button buttonShowUsers = new Button("show users");
    private Button buttonShowBets = new Button("show bets");
    private Grid<UserDto> gridUsers = new Grid<>(UserDto.class);
    private Grid<BetDto> gridBets = new Grid<>(BetDto.class);

    @Autowired
    private UserClient userClient;

    @Autowired
    private BetClient betClient;

    public AdminView(){
        buttonShowUsers.addClickListener(event -> gridUsers.setItems(userClient.getUsers()));
        buttonShowBets.addClickListener(event -> gridBets.setItems(betClient.getBets()));
        gridUsers.setColumns("id","username","password","email","createTime","balance","loggedIn");
        gridBets.setColumns("id","userId","homeTeam","awayTeam","result","odd","amount");
        add(gridUsers);
        add(buttonShowUsers);
        add(gridBets);
        add(buttonShowBets);
    }

}
