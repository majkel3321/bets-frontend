package com.lewicki.betsfrontend;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route
public class MainView extends VerticalLayout {

    private TextField textFieldUsername = new TextField("username");
    private TextField textFieldPassword = new TextField("password");
    private Button buttonCreate = new Button("create");
    private Button buttonGetUsers = new Button("show users");
    private TextArea textAreaShowUsers = new TextArea("users");
    @Autowired
    private BetsClient betsClient;

    public MainView(){
        buttonGetUsers.addClickListener(event -> {
            textAreaShowUsers.setValue(betsClient.getUsers().toString());
        });
        buttonCreate.addClickListener(event -> {
            betsClient.createUser(textFieldUsername.getValue(),textFieldPassword.getValue());
            textFieldUsername.clear();
            textFieldPassword.clear();
        });
        add(textFieldUsername);
        add(textFieldPassword);
        add(buttonCreate);
        add(textAreaShowUsers,buttonGetUsers);
    }
}
