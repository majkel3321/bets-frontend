package com.lewicki.betsfrontend.Views;

import com.lewicki.betsfrontend.BetsClient;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route
public class MainView extends VerticalLayout {

    private Button buttonProfile = new Button("Profile");
    private Button buttonMatches = new Button("Matches");
    private Button buttonSignIn = new Button("Sign in");
    private Button buttonLogIn = new Button("Log in");
    private Button buttonLogOut = new Button("Log out");
    private Span spanBets = new Span("Bets App");
    private Div div = new Div();

    @Autowired
    BetsClient betsClient;


    public MainView() {
        buttonSignIn.addClickListener(event -> getUI().ifPresent(ui -> ui.navigate("signin")));
        buttonLogIn.addClickListener(event -> getUI().ifPresent(ui -> ui.navigate("login")));

        spanBets.getElement().getStyle().set("font-size", "100px");
        div.add(buttonSignIn, buttonLogIn,buttonLogOut, buttonMatches, buttonProfile);
        div.setMaxWidth("20px");
        add(spanBets);
        add(div);
    }

    //    buttonSecondView.addClickListener(event -> getUI().ifPresent(ui -> ui.navigate("second")));
}
