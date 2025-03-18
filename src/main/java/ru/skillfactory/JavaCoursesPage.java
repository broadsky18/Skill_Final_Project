package ru.skillfactory;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class JavaCoursesPage {
    public static final String URL = "https://skillfactory.ru/courses/java";
    public static final String JAVA_QA_COURSE_PAGE = "//div[@class='page-wrapper']/ul/li[@id='QAJA']";
    private WebDriver webDriver;

    public JavaCoursesPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void goToJavaQACoursePage() {
        webDriver.findElement(By.xpath(JAVA_QA_COURSE_PAGE)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(2));
    }
}
