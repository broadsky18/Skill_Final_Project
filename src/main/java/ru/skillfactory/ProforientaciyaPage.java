package ru.skillfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.commons.validator.routines.EmailValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProforientaciyaPage {
    public static final String URL = "https://skillfactory.ru/it-specialist-proforientaciya";
    public static final String PAGE_TITLE_LOCATOR = "//h2[@field='tn_text_1650022405403']";
    public static final String PAGE_TITLE_TEXT = "IT-специалист с нуля";
    public static final String ENROLL_IN_COURSE_BUTTON = "//div[@class='t396__elem tn-elem tn-elem__4962330021650022473427']/a";
    public static final String EMAIL = "//form[@id='form527771797']//input[@type='email']";
    public static final String SUBMIT_BUTTON = "//form[@id='form527771797']//button[@type='submit']";
    public static final String EMAIL_FIELD_INCORRECT_ERROR = "//div[@class='t-input-group t-input-group_em js-error-control-box']//div[@class='t-input-error']";
    public static final String EMAIL_FIELD_EMPTY_ERROR = "//form[@id='form527771797']//div[@data-input-lid='1495810354468']//div[@class='t-input-error']";

    private WebDriver webDriver;

    public ProforientaciyaPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void goToPage() {
        webDriver.get(URL);
    }

    public void openEnrollmentApplication() {
        webDriver.findElement(By.xpath(ENROLL_IN_COURSE_BUTTON)).click();
    }

    public void checkEmailField(String email) {
        webDriver.findElement(By.xpath(EMAIL)).sendKeys(email);
        webDriver.findElement(By.xpath(SUBMIT_BUTTON)).click();
        if (EmailValidator.getInstance().isValid(email)) {
            System.out.println(email + " is valid");
            assertTrue(webDriver.findElements(By.xpath(EMAIL_FIELD_EMPTY_ERROR)).isEmpty()
                    || webDriver.findElements(By.xpath(EMAIL_FIELD_INCORRECT_ERROR)).isEmpty());
        } else {
            System.out.println(email + " is invalid");
            assertTrue(webDriver.findElement(By.xpath(EMAIL_FIELD_INCORRECT_ERROR)).isDisplayed()
                    || webDriver.findElement(By.xpath(EMAIL_FIELD_EMPTY_ERROR)).isDisplayed());
        }
    }
}
