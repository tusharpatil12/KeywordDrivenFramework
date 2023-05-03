package com.bridgelabz.keyword.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public BaseClass(){

       /* Properties prop = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/main/resources/application.properties");
            prop.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

    }


    public static WebDriver driver;
    Properties properties;

    public static Properties initializeProperties() {

       Properties properties=BaseClass.initializeProperties();

        properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/main/resources/facebookLogin.xlsx");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public WebDriver launchBrowser(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications");
            driver = new ChromeDriver(chromeOptions);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();

        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }
}
