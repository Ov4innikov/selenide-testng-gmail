package com.simbirsoft.gmailtest.test;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import com.codeborne.selenide.WebDriverRunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class DefaultSelenoidTest {

    protected Logger log = LoggerFactory.getLogger(DefaultLocalTest.class);
    protected Properties prop = new Properties();
    protected String local;

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

    DefaultSelenoidTest() throws IOException {
        this.local = "ru";
    }

    DefaultSelenoidTest(String local) throws IOException {
        this.local = local;
    }

    @BeforeClass()
    public void setUp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        caps.setVersion("63.0");
        caps.setCapability("enableVNC", true);
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.get("https://mail.google.com");
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterClass
    public void tearDown(){
        WebDriverRunner.closeWebDriver();
    }
}
