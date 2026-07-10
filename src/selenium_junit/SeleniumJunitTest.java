package selenium_junit;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

@SuppressWarnings("unused")
class SeleniumJunitTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {

        System.setProperty("webdriver.gecko.driver", "./src/geckodriver.exe");

        driver = new FirefoxDriver();

        driver.get("https://www.calculator.net/bmi-calculator.html");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void tc_101_BMI() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.tagName("body"), "Normal"));

        assertTrue(driver.getPageSource().contains("20.1"));
        assertTrue(driver.getPageSource().contains("Normal"));
    }
}