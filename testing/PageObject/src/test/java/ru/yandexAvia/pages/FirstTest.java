package ru.yandexAvia.pages;

import org.junit.BeforeClass;
import org.junit.Test;

public class FirstTest extends BaseTest{

    public static SearchPage searchPage;

    @BeforeClass
    public static void initial(){
        searchPage = new SearchPage(driver);
        driver.get("https://avia.yandex.ru");
    }

    @Test
    public void ticketsSearchWithValidData() throws InterruptedException {
        searchPage.typeInputFrom("Минск");
        searchPage.typeInputTo("Нижний Новгород");
        searchPage.clickOnCalendar();
        Thread.sleep(1000);
        searchPage.selectDepartureDate("20", "11");
        Thread.sleep(1000);
        searchPage.selectArrivalDate("27", "11");
        Thread.sleep(1000);
        searchPage.clickOnPeople();
        Thread.sleep(1000);
        searchPage.addAdults(4);
        Thread.sleep(500);
        searchPage.clickOnSearch();
    }

}
