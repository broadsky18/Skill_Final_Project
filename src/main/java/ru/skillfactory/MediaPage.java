package ru.skillfactory;

import org.openqa.selenium.WebDriver;

public class MediaPage {
    public static final String URL = "https://blog.skillfactory.ru/";
    public static final String PAGE_TITLE_LOCATOR = "//div[@class='header__left']/p";
    public static final String PAGE_TITLE_TEXT = "Честные истории о карьере в IT";

    private final WebDriver webDriver;

    public MediaPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
