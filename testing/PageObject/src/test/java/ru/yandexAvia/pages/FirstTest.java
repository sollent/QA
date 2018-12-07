package ru.yandexAvia.pages;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FirstTest extends BaseTest{

    public static SearchPage searchPage;

    @BeforeClass
    public static void initial(){
        searchPage = new SearchPage(driver);
    }   

    @Test
    public void ticketsSearchWithValidData() throws InterruptedException {
        driver.get("https://avia.yandex.ru");
        searchPage.typeInputFrom("Минск");
        searchPage.typeInputTo("Нижний Новгород");
        searchPage.clickOnCalendar();
        searchPage.selectDepartureDate("29", "11");
        searchPage.selectArrivalDate("30", "11");
        searchPage.clickOnPeople();
        searchPage.addAdults(4);
        searchPage.clickOnSearch();
    }

    @Test
    public void invalidFromAndToFields(){
        driver.get("https://avia.yandex.ru");
        searchPage.typeInputTo("Испаниозе");
        searchPage.typeInputFrom("Новосибирский край");
        searchPage.clickOnSearch();
        String title = driver.getTitle();
        assertEquals(title, "Некорректные параметры поиска");
    }

}
