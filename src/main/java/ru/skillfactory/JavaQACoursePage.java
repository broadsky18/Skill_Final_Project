package ru.skillfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaQACoursePage {
    public static final String URL = "https://skillfactory.ru/java-qa-engineer-testirovshik-po";
    public static final String ENROLL_BUTTON = "//div[@class='t396__elem tn-elem tn-elem__3596564571596261549401']";
    public static final String SEND_APPLICATION_BUTTON = "/html/body/div[2]/div[8]/div/div/div[2]/div/form/div[2]/div[6]/button";
    public static final String ERROR_MESSAGE_LOCATOR = "//a[@class='t-form__errorbox-link']";
    public static final String ERROR_TEXT = "Please fill out all required fields";
    private WebDriver webDriver;

    public JavaQACoursePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void goToPage() {
        webDriver.get(URL);
    }

    public void enrollFail() {
        webDriver.findElement(By.xpath(ENROLL_BUTTON)).click();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SEND_APPLICATION_BUTTON))).click();
        String message = webDriver.findElement(By.xpath(ERROR_MESSAGE_LOCATOR)).getText();
        assertEquals(ERROR_TEXT, message, "Неправильное сообщение об ошибке");
    }
}
