package ru.skillfactory;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class ProgrammingCoursesPage {
    public static final String URL = "https://skillfactory.ru/courses/programmirovanie";
    private static final String JAVA_COURSES_PAGE = "//div[@class='t396__elem tn-elem tn-elem__7492324981678946499402']";
    private WebDriver webDriver;

    public ProgrammingCoursesPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void goToJavaCoursesPage() {
        webDriver.findElement(By.xpath(JAVA_COURSES_PAGE)).click();
    }


}
