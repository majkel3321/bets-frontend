package com.lewicki.betsfrontend.Views;

import com.lewicki.betsfrontend.BetsClient;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("signin")
public class SignInView extends VerticalLayout {

    private TextField textFieldPassword = new TextField();
    private TextField textFieldUsername = new TextField();
    private TextField textFieldEmail = new TextField();
    private Button buttonCreate = new Button("Submit");
    private Span spanSignIn = new Span("Sign In");

    @Autowired
    BetsClient betsClient;

    public SignInView(){
        spanSignIn.getElement().getStyle().set("font-size","100px");
        textFieldPassword.setPlaceholder("password");
        textFieldUsername.setPlaceholder("username");
        textFieldEmail.setPlaceholder("email");
        buttonCreate.addClickListener(event -> betsClient.createUser(textFieldUsername.getValue(),
                textFieldPassword.getValue(),textFieldEmail.getValue()));

        add(spanSignIn);
        add(textFieldEmail);
        add(textFieldUsername);
        add(textFieldPassword);
        add(buttonCreate);
        setAlignItems(Alignment.CENTER);
    }
}
