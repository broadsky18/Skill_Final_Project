package ru.skillfactory;

import org.openqa.selenium.WebDriver;

public class HigherEducationPage {
    public static final String URL = "https://new.skillfactory.ru/vyssheye-obrazovaniye";
    public static final String PAGE_TITLE_LOCATOR = "//h1[@field='tn_text_1689594433384']";
    public static final String PAGE_TITLE_TEXT = "Высшее образование\n" +
            "от лучших университетов страны и Skillfactory — онлайн";

    private WebDriver webDriver;

    public HigherEducationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
