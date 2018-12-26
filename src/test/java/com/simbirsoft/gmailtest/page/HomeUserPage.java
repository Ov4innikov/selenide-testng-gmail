package com.simbirsoft.gmailtest.page;

import com.codeborne.selenide.SelenideElement;

import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomeUserPage extends DefaultPage {

    private String searchInput;
    private String countOfEmails;
    private String subbmitNewEmail;
    private String messageSubjectInput;
    private String messageTextInput;
    private String recipientEmailInput;
    private String buttonSendMessage;
    private String loadingText;

    public HomeUserPage() throws IOException, InterruptedException {
        super();
        log.trace("local = " + local);
        loadingText = "Loading";
        $(byText(loadingText)).waitUntil(disappears, 20000);
        Thread.sleep(10000);
        searchInput = "form#aso_search_form_anchor div input";
        countOfEmails = "//div[@role='button']//span[@class = 'Dj']/span[last()]";
        subbmitNewEmail = "//div[@class = 'aic']/div/div";
        messageSubjectInput = "//input[@name='subjectbox']";
        messageTextInput = "//table[@id='undefined']//div[@role='textbox']";
        recipientEmailInput = "//textarea[@aria-label='" + prop.getProperty(local + ".test.homeuserpage.recipientemail.aria-label") + "']";
        log.trace("recipientEmailInput = " + recipientEmailInput);
        buttonSendMessage = "//td//div[text() = '" + prop.getProperty(local + ".test.homeuserpage.buttonsend.text") + "']";
    }

    public HomeUserPage(String local) throws IOException, InterruptedException {
        super(local);
        log.trace("local = " + local);
        loadingText = "Loading";
        $(byText(loadingText)).waitUntil(disappears, 20000);
        Thread.sleep(15000);
        searchInput = "form#aso_search_form_anchor div input";
        countOfEmails = "//div[@role='button']//span[@class = 'Dj']/span[last()]";
        subbmitNewEmail = "//div[@class = 'aic']/div/div";
        messageSubjectInput = "//input[@name='subjectbox']";
        messageTextInput = "//table[@id='undefined']//div[@role='textbox']";
        recipientEmailInput = "//textarea[@aria-label='" + prop.getProperty(local + ".test.homeuserpage.recipientemail.aria-label") + "']";
        log.trace("recipientEmailInput = " + recipientEmailInput);
        buttonSendMessage = "//td//div[text() = '" + prop.getProperty(local + ".test.homeuserpage.buttonsend.text") + "']";
    }

    public void inputSearchString(String searchString){
        $(searchInput).should(exist).setValue(searchString).pressEnter();
    }

    public String getCountOfEmails(){
        return $$(byXpath(countOfEmails)).last().getText();
    }

    public void clickSubbmitNewEmail(){
        $(byXpath(subbmitNewEmail)).click();
    }

    public void inputRecipientEmail(String recipient){
        $(byXpath(recipientEmailInput)).val(recipient);
    }

    public void inputMessageSubject(String subject){
        $(byXpath(messageSubjectInput)).val(subject);
    }

    public void inputMessageText(String message){
        $(byXpath(messageTextInput)).val(message);
    }

    public void clickButtonSendMessage(){
        $(byXpath(buttonSendMessage)).click();
    }
}
