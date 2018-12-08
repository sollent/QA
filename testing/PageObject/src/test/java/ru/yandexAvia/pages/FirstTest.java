package ru.yandexAvia.pages;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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
        searchPage.selectDepartureDate("29", "11", "2018");
        searchPage.selectArrivalDate("30", "11", "2018");
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

    @Test(expected = NoSuchElementException.class)
    public void pastDate(){
        driver.get("https://avia.yandex.ru");
        searchPage.clickOnCalendar();
        searchPage.selectDepartureDate("20", "10", "2016");
    }

    @Test(expected = NoSuchElementException.class)
    public void futureDate(){
        driver.get("https://avia.yandex.ru");
        searchPage.clickOnCalendar();
        searchPage.selectDepartureDate("20", "10", "2021");
    }

    @Test
    public void fromAndToPointNotMatch(){
        driver.get("https://avia.yandex.ru");
        searchPage.typeInputFrom("Минск");
        searchPage.typeInputTo("Минск");
        searchPage.clickOnSearch();
        WebElement errorAlert = driver.findElement(By.cssSelector(".y-tooltip__content"));
        String errorText = errorAlert.getText().toString();
        assertEquals(errorText, "Выберите различные пункты отправления и прибытия");
    }

    @Test
    public void maxCountOfPassengers(){
        driver.get("https://avia.yandex.ru");
        searchPage.clickOnPeople();
        searchPage.addAdults(10);
        WebElement countPassengersInput = driver.findElement(By.cssSelector(".form-options-picker_kb__input-persons"));
        String countPassengersText = countPassengersInput.getText();
        assertEquals(countPassengersText, "9 взрослых");
    }

    @Test
    public void getNonExistentTickets(){
        driver.get("https://avia.yandex.ru");
        searchPage.typeInputFrom("Санкт-Петербург");
        searchPage.typeInputTo("Йондон");
        searchPage.clickOnSearch();
        // Checking that block with empty result exist
        int count = driver.findElements(By.cssSelector(".empty-result_kb-no-flights-at-all")).size();
        assertNotEquals(0, count);
    }

    @Test
    public void countAdultsEqualInfants(){
        driver.get("https://avia.yandex.ru");
        searchPage.clickOnPeople();
        // This input has default value 1 for count of adults
        searchPage.addAdults(3);
        searchPage.addInfant(5);
        WebElement countOfAdults = driver.findElement(By.cssSelector(".form-options_kb__passengers-adults .passengers_kb__text"));
        WebElement countOfInfants = driver.findElement(By.cssSelector(".form-options_kb__passengers-infant .passengers_kb__text"));
        int countAdl = Character.getNumericValue(countOfAdults.getText().charAt(0));
        int countInf = Character.getNumericValue(countOfInfants.getText().charAt(0));
        assertEquals(countAdl, countInf);
    }

//    @Test
//    public void getOrderPageAterTicketsSearch() throws MalformedURLException {
//        driver.get("https://avia.yandex.ru");
//        searchPage.typeInputFrom("Минск");
//        searchPage.typeInputTo("Нижний Новгород");
//        searchPage.clickOnCalendar();
//        searchPage.selectDepartureDate("29", "11", "2018");
//        searchPage.selectArrivalDate("30", "11", "2018");
//        searchPage.clickOnPeople();
//        searchPage.addAdults(4);
//        searchPage.clickOnSearch();
//        List<WebElement> tickets = driver.findElements(By.cssSelector(".flight_list__forward"));
//        tickets.get(0).click();
//        URL url = new URL(driver.getCurrentUrl());
//        String[] pathSegments = url.getPath().split("/");
//        System.out.println("\n" + pathSegments[0]);
//    }

}
