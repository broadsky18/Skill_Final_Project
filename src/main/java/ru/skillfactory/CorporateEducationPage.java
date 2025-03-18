package ru.skillfactory;

import org.openqa.selenium.WebDriver;

public class CorporateEducationPage {
    public static final String URL = "https://new.skillfactory.ru/corporativnoye-obuchenye";
    public static final String PAGE_TITLE_LOCATOR = "//h1[@field='tn_text_1636447160852']/span";
    public static final String PAGE_TITLE_TEXT = "Развивайте бизнес";

    private final WebDriver webDriver;

    public CorporateEducationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
