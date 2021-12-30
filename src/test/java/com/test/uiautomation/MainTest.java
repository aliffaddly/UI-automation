package com.test.uiautomation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainTest {

        public static WebDriver driver;

        @BeforeAll
        public static void setupDriver() {
            // set the driver
            WebDriverManager.chromedriver().setup();
        }

        @BeforeEach
        void setup() {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }

        @Test
        void runTest() {

            // open https://www.service.nsw.gov.au/ web
            driver.get("https://www.service.nsw.gov.au/");
            driver.manage().window().maximize();

            // locate web elements
            WebElement search = driver.findElement(By.cssSelector("#homeautosuggesttaeVOW3QNgc > input"));
            search.sendKeys("Apply for a number plate");

            WebElement clickSearch = driver.findElement(By.cssSelector("#block-content > article > section.personalised-content > div > div:nth-child(1) > header > div.container > div > form > div.form__actions > button"));
            clickSearch.click();

            WebElement findLoc = driver.findElement(By.xpath("//a[text()='Find locations']"));
            findLoc.click();

            WebElement enterSuburb = driver.findElement(By.cssSelector("#locatorTextSearch"));
            enterSuburb.sendKeys("Sydney 2000");

            WebElement searchSuburb = driver.findElement(By.xpath("//button[@class='button button--primary button--xxlarge']"));
            searchSuburb.click();

            WebElement clickSuburb = driver.findElement(By.xpath("//a[text()='Marrickville Service Centre ']"));
            clickSuburb.click();
        }

        @AfterAll
        static void postTest(){
            driver.close();
        }
}

