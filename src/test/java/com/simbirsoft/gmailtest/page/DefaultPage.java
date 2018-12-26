package com.simbirsoft.gmailtest.page;

import com.codeborne.selenide.SelenideElement;
import com.simbirsoft.gmailtest.test.DefaultLocalTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DefaultPage {

    protected Logger log = LoggerFactory.getLogger(DefaultPage.class);
    protected Properties prop = new Properties();
    protected String local = "ru";

    private static final String PATH_TO_PROPERTIES = "src/test/resources/test.properties";
    private FileInputStream fileInputStream;
    {
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(new InputStreamReader(fileInputStream,"UTF8"));
        } catch (Exception e) {
            log.error("Error create or read property",e);
        }
    }

    DefaultPage() throws IOException {
    }

    DefaultPage(String local) throws IOException {
        this.local = local;
    }

}
