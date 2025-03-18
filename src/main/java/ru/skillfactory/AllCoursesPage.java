package ru.skillfactory;

import org.openqa.selenium.WebDriver;

public class AllCoursesPage {
    public static final String URL = "https://skillfactory.ru/courses";
    public static final String PAGE_TITLE_LOCATOR = "//h1[@field='tn_text_1678366726776']";
    public static final String PAGE_TITLE_TEXT = "Онлайн-курсы по IT-профессиям";

    private final WebDriver webDriver;

    public AllCoursesPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
