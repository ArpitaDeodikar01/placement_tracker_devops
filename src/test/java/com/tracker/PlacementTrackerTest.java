package com.tracker;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PlacementTrackerTest {

    @Test
    public void testApplicationLoads() throws InterruptedException {

        System.out.println("Waiting for application to start...");

        Thread.sleep(10000);

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
String baseUrl = System.getProperty("base.url", "http://localhost:8090");
driver.get(baseUrl);

        System.out.println("Application opened successfully");

        Thread.sleep(3000);

        driver.quit();
    }

}
