package ru.skillfactory;

import org.openqa.selenium.WebDriver;

public class ContactsPage {
    public static final String URL = "https://skillfactory.ru/contacts";
    public static final String PAGE_TITLE_LOCATOR = "//h1[@field='tn_text_1678713723704']";
    public static final String PAGE_TITLE_TEXT = "Контактная информация";

    private final WebDriver webDriver;

    public ContactsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
