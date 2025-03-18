package ru.skillfactory;

import org.openqa.selenium.WebDriver;

public class CareerCenterPage {
    public static final String URL = "https://skillfactory.ru/career-center";
    public static final String PAGE_TITLE_LOCATOR = "//h1[@field='tn_text_1628851978862']";
    public static final String PAGE_TITLE_TEXT = "Центр карьеры";

    private final WebDriver webDriver;

    public CareerCenterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
