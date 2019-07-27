package com.lewicki.betsfrontend.views;

import com.lewicki.betsfrontend.client.BetClient;
import com.lewicki.betsfrontend.client.MatchClient;
import com.lewicki.betsfrontend.client.UserClient;
import com.lewicki.betsfrontend.domain.MatchDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Route("matches")
public class MatchesView extends HorizontalLayout {

    private Grid<MatchDto> gridMatch = new Grid<>(MatchDto.class);
    private Button buttonShowMatches = new Button("show matches");
    private Button buttonCreateBet = new Button("create bet");
    private ComboBox<String> comboBoxTeams = new ComboBox<>("select match");
    private ComboBox<String> comboBoxBet = new ComboBox<>("select result");
    private TextField textFieldAmount = new TextField("amount");
    private List<String> homeVsAway = new ArrayList<>();
    private List<String> results = new ArrayList<>();
    private List<MatchDto> matches = new ArrayList<>();
    private MatchDto chosenMatch;

    @Autowired
    private MatchClient matchClient;

    @Autowired
    private BetClient betClient;

    @Autowired
    private UserClient userClient;

    public MatchesView() {
        results.add("v1");
        results.add("x");
        results.add("v2");
        VerticalLayout verticalLayout = new VerticalLayout(gridMatch, buttonShowMatches);
        FormLayout formLayout = new FormLayout(comboBoxTeams, comboBoxBet,textFieldAmount, buttonCreateBet);

        buttonShowMatches.addClickListener(event -> {
            matches.addAll(matchClient.getMatches());
            gridMatch.setItems(matches);             //zle pokazuje v1 x v2 - zle przypisuje prawdopodobienstwo
            for (MatchDto match : matches) {
                homeVsAway.add(match.getHomeTeam() + " vs " + match.getAwayTeam());
            }
            comboBoxTeams.setItems(homeVsAway);
            comboBoxBet.setItems(results);
        });

        buttonCreateBet.addClickListener(event -> {
            String team[] = comboBoxTeams.getValue().split(" vs ");

            chosenMatch = matchClient.getMatches().stream()
                    .filter(matchDto1 -> matchDto1.getHomeTeam().equals(team[0]))
                    .findAny().get();

            betClient.createBetDto(userClient.getLoggedUser().getId(),chosenMatch.getHomeTeam(), chosenMatch.getAwayTeam(), comboBoxBet.getValue(),
                   Double.parseDouble(textFieldAmount.getValue()), chosenMatch.getV1(), chosenMatch.getX(), chosenMatch.getV2());

            userClient.updateAccountBalance(userClient.getLoggedUser().getId(),Double.parseDouble(textFieldAmount.getValue()));

            comboBoxTeams.clear();
            comboBoxBet.clear();
            textFieldAmount.clear();

        });


        gridMatch.setColumns("homeTeam", "awayTeam", "v1", "x", "v2");
        add(verticalLayout, formLayout);
    }
}
