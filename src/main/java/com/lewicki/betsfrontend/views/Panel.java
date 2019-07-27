package com.lewicki.betsfrontend.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.AppLayoutMenu;
import com.vaadin.flow.component.applayout.AppLayoutMenuItem;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;

public class Panel {

    public static AppLayout getPanel(){
        AppLayout appLayout = new AppLayout();
        AppLayoutMenu menu = appLayout.createMenu();
        Image img = new Image("https://rukminim1.flixcart.com/image/704/704/jcp4b680/ball/g/9/y/410-450g-pl-strike-22-1-1-sc3148-100-football-nike-original-imaffrnn4d4jeudp.jpeg?q=70", "Vaadin Logo");
        img.setHeight("60px");
        appLayout.setBranding(img);

        menu.addMenuItems(new AppLayoutMenuItem("Matches", "matches"),
                new AppLayoutMenuItem("Teams", "team"),
                new AppLayoutMenuItem("Profile", "profile"),
                new AppLayoutMenuItem("Admin", "admin"));

        Component content = new Span(new H3("CRUD Api"),
                new Span("With Bets \n and \nlatest team squads"));
        content.getElement().getStyle().set("font-size", "30px");
        appLayout.setContent(content);

        return appLayout;
    }
}
