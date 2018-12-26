package com.simbirsoft.gmailtest.page;

import com.codeborne.selenide.SelenideElement;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginPage extends DefaultPage {

    private String emailInput;
    private String passwordInput;

    public LoginPage() throws IOException {
        emailInput = "input#identifierId";
        passwordInput = "//input[@name = 'password']";
    }

    public LoginPage(String local) throws IOException {
        this();
        this.local = local;
    }

    public void inputEmail(String email){
        $(emailInput).val(email).pressEnter();
    }

    public void inputPassword(String pass) throws InterruptedException {
        $(byXpath(passwordInput)).val(pass).pressEnter();
    }
}
