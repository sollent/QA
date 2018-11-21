package ru.utair;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public ChromeDriver driver;

    @Before
    public void initialDriver(){
        System.setProperty("webdriver.chrome.driver", "/home/sollent/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void quitTest(){
        driver.quit();
        System.out.println("Test has been completed");
    }

}
