package ru.utair;

import org.junit.Test;

public class FirstTest extends BaseTest {

    @Test
    public void openPageTest(){
        driver.get("https://www.utair.ru/");

        String title = driver.getTitle();
        System.out.println(title);
    }

}
