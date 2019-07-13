package com.lewicki.betsfrontend.Views;

import com.lewicki.betsfrontend.BetsClient;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("login")
public class LogInView extends VerticalLayout {

    private TextField textFieldPassword = new TextField();
    private TextField textFieldUsername = new TextField();
    private TextField textFieldEmail = new TextField();
    private Button buttonCreate = new Button("Submit");

    @Autowired
    BetsClient betsClient;

    public LogInView(){
        textFieldPassword.setPlaceholder("password");
        textFieldUsername.setPlaceholder("username");
        textFieldEmail.setPlaceholder("email");
        buttonCreate.addClickListener(event -> betsClient.create(textFieldUsername.getValue(),
                textFieldPassword.getValue(),textFieldEmail.getValue()));

        add(textFieldEmail);
        add(textFieldUsername);
        add(textFieldPassword);
        add(buttonCreate);
    }
}
