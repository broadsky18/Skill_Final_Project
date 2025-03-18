package ru.skillfactory;

import org.openqa.selenium.WebDriver;

public class DataAnalysisCoursesPage {
    public static final String URL = "https://skillfactory.ru/courses/analitika-dannyh";
    public static final String PAGE_TITLE_LOCATOR = "//h1[@field='tn_text_1678366726776']";
    public static final String PAGE_TITLE_TEXT = "Курсы по аналитике данных";

    private WebDriver webDriver;

    public DataAnalysisCoursesPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
