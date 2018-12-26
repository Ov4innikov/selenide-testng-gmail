package com.simbirsoft.gmailtest.test;

import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class DefaultLocalTest {

    protected Logger log = LoggerFactory.getLogger(DefaultLocalTest.class);
    protected Properties prop = new Properties();
    protected String local;

    private Configuration conf = new Configuration();
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

    DefaultLocalTest() throws IOException {
        log.trace("Create DefaultLocalTest...");
        this.local = "ru";
    }

    DefaultLocalTest(String local) throws IOException {
        log.trace("Create DefaultLocalTest...");
        this.local = local;
    }

    @BeforeClass()
    public void setUp() throws MalformedURLException {
        conf.timeout = 50000;
        conf.startMaximized = true;
        conf.browser="firefox";
        conf.baseUrl="https://www.google.com";
        open("/");
        getWebDriver().manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        getWebDriver().manage().timeouts().setScriptTimeout(50, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown(){
        closeWebDriver();
    }
}
