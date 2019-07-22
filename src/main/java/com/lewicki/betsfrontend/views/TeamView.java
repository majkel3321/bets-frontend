package com.lewicki.betsfrontend.views;

import com.lewicki.betsfrontend.client.LeagueClient;
import com.lewicki.betsfrontend.domain.PlayerDto;
import com.lewicki.betsfrontend.domain.TeamDto;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Route("team")
public class TeamView extends VerticalLayout {

    private Grid<TeamDto> gridTeams = new Grid<>(TeamDto.class);
    private Grid<PlayerDto> gridPlayers = new Grid<>(PlayerDto.class);
    private Button buttonShowTeams = new Button("show teams");
    private List<String> leagues = new ArrayList<>();

    @Autowired
    private LeagueClient leagueClient;

    public TeamView(){
        leagues.add("PremierLeague");
        leagues.add("PrimeraDivision");
        leagues.add("SerieA");
        leagues.add("Ligue1");
        leagues.add("Bundesliga1");
        leagues.add("Ekstraklasa");
        leagues.add("SuperLeague");
        leagues.add("ChampionsLeague");
        ComboBox<String> select = new ComboBox<>("select league");
        select.setItems(leagues);
        gridTeams.setColumns("name","venue_name","venue_capacity","venue_city");
        gridPlayers.setColumns("firstname","lastname","position","age","nationality","height","weight");
        buttonShowTeams.addClickListener(event -> gridTeams.setItems(leagueClient.getTeamsFromLeague(select.getValue())));
        add(select);
        add(buttonShowTeams);
        add(gridTeams,gridPlayers);

    }

}
