package com.lewicki.betsfrontend.views;

import com.lewicki.betsfrontend.client.UserClient;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("login")
public class LogInView extends VerticalLayout {

    private TextField textFieldPassword = new TextField();
    private TextField textFieldUsername = new TextField();
    private Span spanLogIn = new Span("Log In");
    private Button buttonLogIn = new Button("log in");
    @Autowired
    UserClient userClient;


    public LogInView(){
        buttonLogIn.addClickListener(event -> userClient.logIn(textFieldUsername.getValue(),textFieldPassword.getValue()));
        spanLogIn.getElement().getStyle().set("font-size","100px");
        textFieldPassword.setPlaceholder("password");
        textFieldUsername.setPlaceholder("username");
        add(spanLogIn);
        add(textFieldUsername);
        add(textFieldPassword);
        add(buttonLogIn);
        setAlignItems(Alignment.CENTER);
    }
}
