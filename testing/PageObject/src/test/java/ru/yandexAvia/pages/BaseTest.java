package ru.yandexAvia.pages;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver driver;

    @BeforeClass
    public static void initialDriver(){
        System.setProperty("webdriver.chrome.driver", "/home/sollent/chromedriver");
        driver = new ChromeDriver();
    }

    @Before
    public void startTest(){
        System.out.println("Start test");
    }

    @After
    public void quitTest(){
        driver.quit();
        System.out.println("Test has been completed");
    }
}
