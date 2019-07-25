package com.lewicki.betsfrontend.views;

import com.lewicki.betsfrontend.client.MatchClient;
import com.lewicki.betsfrontend.domain.MatchDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("matches")
public class MatchesView extends VerticalLayout {

    private Grid<MatchDto> gridMatch = new Grid<>(MatchDto.class);
    private Button buttonShowMatches = new Button("show matches");

    @Autowired
    private MatchClient matchClient;

    public MatchesView(){
        buttonShowMatches.addClickListener(event -> gridMatch.setItems(matchClient.getMatches()));
        gridMatch.setColumns("homeTeam","awayTeam","v1","x","v2");
        add(gridMatch,buttonShowMatches);
    }
}
