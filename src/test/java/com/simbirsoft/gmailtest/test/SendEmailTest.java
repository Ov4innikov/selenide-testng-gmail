package com.simbirsoft.gmailtest.test;

import com.simbirsoft.gmailtest.page.HomeUserPage;
import com.simbirsoft.gmailtest.page.LoginPage;
import com.simbirsoft.gmailtest.page.WelcomeInfoGmailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SendEmailTest extends DefaultSelenoidTest {

    SendEmailTest() throws IOException {
        super();
    }

    @Test
    public void testSendEmail() throws IOException, InterruptedException {
        log.trace("Start test SendEmailTest().testSendEmail()");
        WelcomeInfoGmailPage welcomeInfoGmailPage = new WelcomeInfoGmailPage(local);
        welcomeInfoGmailPage.openThisPage();
        LoginPage loginPage = welcomeInfoGmailPage.openLoginPage(local);
        loginPage.inputEmail(prop.getProperty(local + ".test.user.email"));
        loginPage.inputPassword(prop.getProperty(local + ".test.user.password"));
        //getWebDriver().manage().page.loaded();
        HomeUserPage homeUserPage = new HomeUserPage(local);
        String countOfEmails1 = homeUserPage.getCountOfEmails();
        log.trace("Count of emails 1 = " + countOfEmails1);
        homeUserPage.inputSearchString(prop.getProperty(local + ".test.recipient.fullname"));
        String countOfEmails2 = homeUserPage.getCountOfEmails();
        while(countOfEmails1.equals(countOfEmails2)||countOfEmails2.equals("")){
            countOfEmails2 = homeUserPage.getCountOfEmails();
        }
        log.trace("Count of emails 2 = " + countOfEmails2);
        homeUserPage.clickSubbmitNewEmail();
        homeUserPage.inputRecipientEmail(prop.getProperty(local + ".test.recipient.email"));
        homeUserPage.inputMessageSubject(prop.getProperty(local + ".test.email.subject") + " " + prop.getProperty(local + ".test.user.lastname"));
        homeUserPage.inputMessageText(countOfEmails2);
        homeUserPage.clickButtonSendMessage();
    }
}
