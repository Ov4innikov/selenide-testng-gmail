package com.simbirsoft.gmailtest.page;

import com.codeborne.selenide.SelenideElement;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WelcomeInfoGmailPage extends DefaultPage {

    private String login;

    public WelcomeInfoGmailPage() throws IOException {
        login = "a.gmail-nav__nav-link__sign-in";
    }

    public WelcomeInfoGmailPage(String local) throws IOException {
        this();
        this.local = local;
    }

    public void openThisPage(){
        open("https://www.google.com/intl/ru/gmail/about/#");
    }

    public LoginPage openLoginPage(String local) throws IOException {
        $(login).click();
        return new LoginPage(local);
    }
}
