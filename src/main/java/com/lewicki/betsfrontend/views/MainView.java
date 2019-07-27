package com.lewicki.betsfrontend.views;

import com.lewicki.betsfrontend.client.UserClient;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route
public class MainView extends VerticalLayout {

    private Button buttonProfile = new Button("ProfileView");
    private Button buttonMatches = new Button("Matches");
    private Button buttonSignIn = new Button("Sign in");
    private Button buttonLogIn = new Button("Log in");
    private Button buttonLogOut = new Button("Log out");
    private Span spanBets = new Span("Bets App");
    private Div div = new Div();

    @Autowired
    UserClient userClient;


    public MainView() {
        add(Panel.getPanel());
    }
}
