package com.lewicki.betsfrontend;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route
public class MainView extends VerticalLayout {

    private Label labelMenu = new Label("Menu");
    private Button buttonProfile = new Button("Profile");
    private Button buttonMatches = new Button("Matches");
    FlexLayout flexLayout = new FlexLayout();
    private Text textCreateUser = new Text("Create new user");
    private TextField textFieldUsername = new TextField();
    private TextField textFieldPassword = new TextField();
    private TextField texfieldEmanil = new TextField();
    private Button buttonCreate = new Button("Submit");



    @Autowired
    private BetsClient betsClient;

    public MainView(){
        flexLayout.add(labelMenu,buttonProfile,buttonMatches);
        textFieldPassword.setPlaceholder("password");
        textFieldUsername.setPlaceholder("username");
        texfieldEmanil.setPlaceholder("email");
        buttonCreate.addClickListener(event -> betsClient.create(textFieldUsername.getValue(),
                textFieldPassword.getValue(),texfieldEmanil.getValue()));

        add(flexLayout);
        add(textCreateUser);
        add(texfieldEmanil);
        add(textFieldUsername);
        add(textFieldPassword);
        add(buttonCreate);
    }


    //    buttonSecondView.addClickListener(event -> getUI().ifPresent(ui -> ui.navigate("second")));
}
