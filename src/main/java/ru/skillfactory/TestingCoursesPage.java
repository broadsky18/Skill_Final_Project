package ru.skillfactory;

import org.openqa.selenium.WebDriver;

public class TestingCoursesPage {
    public static final String URL = "https://skillfactory.ru/courses/testirovanie";
    public static final String PAGE_TITLE_LOCATOR = "//h1[@field='tn_text_1678366726776']";
    public static final String PAGE_TITLE_TEXT = "Курсы по тестированию";

    private WebDriver webDriver;

    public TestingCoursesPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
