package com.lewicki.betsfrontend.views;

import com.lewicki.betsfrontend.client.UserClient;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.AppLayoutMenu;
import com.vaadin.flow.component.applayout.AppLayoutMenuItem;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("profile")
public class ProfileView extends VerticalLayout {

    @Autowired
    private UserClient userClient;
    private AppLayout appLayout = new AppLayout();
    private Button buttonLogin = new Button("log in");
    private TextField textFieldPassword = new TextField();
    private TextField textFieldUsername = new TextField();
    private Span spanLogIn = new Span("Log In");
    private Component content;
    private Component content1;


    public ProfileView() {
        AppLayoutMenu menu = appLayout.createMenu();
        Image img = new Image("https://rukminim1.flixcart.com/image/704/704/jcp4b680/ball/g/9/y/410-450g-pl-strike-22-1-1-sc3148-100-football-nike-original-imaffrnn4d4jeudp.jpeg?q=70", "Vaadin Logo");
        img.setHeight("60px");
        appLayout.setBranding(img);

        menu.addMenuItems(
                new AppLayoutMenuItem("Sign in", "signin"),
                new AppLayoutMenuItem("Log in", e -> login()),
                new AppLayoutMenuItem("Log out", e -> logout()));


        add(appLayout);
    }

    public void logout() {
        userClient.logOut();
        appLayout.removeContent();

    }

    public void login() {
        buttonLogin.addClickListener(event -> {
            userClient.logIn(textFieldUsername.getValue(), textFieldPassword.getValue());
            remove(buttonLogin, textFieldPassword, textFieldUsername, spanLogIn);
            content = new Span(new H3("Logged as: " + userClient.getLoggedUser().getUsername() + ", account balance: " + userClient.getLoggedUser().getBalance()));
            content.getElement().getStyle().set("font-size", "30px");
            appLayout.setContent(content);

        });
        spanLogIn.getElement().getStyle().set("font-size", "100px");
        textFieldPassword.setPlaceholder("password");
        textFieldUsername.setPlaceholder("username");
        add(spanLogIn);
        add(textFieldUsername);
        add(textFieldPassword);
        add(buttonLogin);
        setAlignItems(Alignment.CENTER);
    }
}
