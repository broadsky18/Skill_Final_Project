package ru.skillfactory;

import org.openqa.selenium.WebDriver;

public class DesignCoursesPage {
    public static final String URL = "https://skillfactory.ru/courses/design";
    public static final String PAGE_TITLE_LOCATOR = "//div[@field='tn_text_1696428275110']";
    public static final String PAGE_TITLE_TEXT = "Обучение в крупнейшей профильной онлайн-школе дизайна Contented *";

    private WebDriver webDriver;

    public DesignCoursesPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
