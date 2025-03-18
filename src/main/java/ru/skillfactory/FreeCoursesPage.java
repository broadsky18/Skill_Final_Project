package ru.skillfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FreeCoursesPage {
    public static final String URL = "https://skillfactory.ru/free-events";
    public static final String PAGE_TITLE_LOCATOR = "//h1[@field='tn_text_1678713723704']";
    public static final String PAGE_TITLE_TEXT = "Бесплатные курсы,\n" +
            "онлайн-вебинары,\n" +
            "семинары, тесты";

    public static final String TESTS_BUTTON = "//div[@class='t396__elem tn-elem tn-elem__7156205461679404485958 js-sbs-anim-trigger_hover']/a";
    public static final String PROGRAMMING_LANGUAGE_TEST_TITLE = "//div[@class='t396__elem tn-elem tn-elem__6143650851686213323756']//h3[@field='tn_text_1686213323756']";
    public static final String PROGRAMMING_LANGUAGE_TEST_TITLE_TEXT = "Какой язык программирования вам подходит?";
    public static final String PROGRAMMING_LANGUAGE_TEST_BUTTON = "//div[@class='t396__elem tn-elem tn-elem__6143650851686213423572']//a[@href='#popup:marquiz_62f23dbeb695ef0047694558?utm_source=sf-events&utm_medium=site&utm_campaign=np_coding_all_sf-events_site_lp_leadmagnet-28_none_all_sf&utm_content=none&utm_term=none']";
    public static final String IFRAME = "//iframe[@class='marquiz__frame marquiz__frame_open']";
    public static final String TEST_QUESTION_DIV = "//div[@class='title quiz__question-title quiz__question-title_without-title']";
    public static final String TEST_QUESTION_LOCATOR = "//div[@class='title quiz__question-title quiz__question-title_without-title']/span[@class='is-block']";
    public static final String TEST_QUESTION_01_TEXT = "Что привлекает вас в IT больше всего?";
    public static final String TEST_QUESTION_02_TEXT = "В какой сфере вы хотели бы работать?";
    public static final String TEST_ANSWER_01 = "//div[@class='answer-variants__group']/div[@data-element-index='0']//input[@value='QS8f18DaR6']";

    private final WebDriver webDriver;

    public FreeCoursesPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void goToPage() {
        webDriver.get(URL);
    }

    public void takeProgrammingLanguageTest() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(100));
        Actions actions = new Actions(webDriver);
        WebElement testTitle = webDriver.findElement(By.xpath(PROGRAMMING_LANGUAGE_TEST_TITLE));
        actions.moveToElement(testTitle);
        wait.until(ExpectedConditions.visibilityOf(testTitle));
        String text = webDriver.findElement(By.xpath(PROGRAMMING_LANGUAGE_TEST_TITLE)).getText();
        assertEquals(PROGRAMMING_LANGUAGE_TEST_TITLE_TEXT, text, "Название теста некорректное");
        webDriver.findElement(By.xpath(PROGRAMMING_LANGUAGE_TEST_BUTTON)).click();
        WebElement iFrame = webDriver.findElement(By.xpath(IFRAME));
        webDriver.switchTo().frame(iFrame);
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath(TEST_QUESTION_LOCATOR))));
        String question01Text = webDriver.findElement(By.xpath(TEST_QUESTION_LOCATOR)).getText();
        assertEquals(TEST_QUESTION_01_TEXT, question01Text, "Некорректный текст первого вопроса");
        webDriver.findElement(By.xpath(TEST_ANSWER_01)).click();
    }

}
