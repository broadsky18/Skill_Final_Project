package ru.skillfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;

public class TestSuite {
    public WebDriver webDriver;
    public MainPage mainPage;
    public ProgrammingCoursesPage programmingCoursesPage;
    public JavaCoursesPage javaCoursesPage;
    public JavaQACoursePage javaQACoursePage;
    public AllCoursesPage allCoursesPage;
    public FreeCoursesPage freeCoursesPage;
    public ProforientaciyaPage proforientaciyaPage;

    @BeforeEach
    public void setUpWebDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mainPage = new MainPage(webDriver);
        programmingCoursesPage = new ProgrammingCoursesPage(webDriver);
        javaCoursesPage = new JavaCoursesPage(webDriver);
        javaQACoursePage = new JavaQACoursePage(webDriver);
        allCoursesPage = new AllCoursesPage(webDriver);
        freeCoursesPage = new FreeCoursesPage(webDriver);
        proforientaciyaPage = new ProforientaciyaPage(webDriver);
    }

    @Test
    public void checkMainPageLinksProforientaciya() {
        mainPage.goToPage();
        mainPage.goToProforientaciyaPageAndCheck();
    }
    @ParameterizedTest
    @MethodSource("getEmailsForTest")
    public void checkProforientaciyaEmailValidation(String email) {
        proforientaciyaPage.goToPage();
        proforientaciyaPage.openEnrollmentApplication();
        proforientaciyaPage.checkEmailField(email);
    }

    @Test
    public void enrollInQAJavaCourseNegative() {
        mainPage.goToPage();
        mainPage.goToProgrammingCoursesPage();
        programmingCoursesPage.goToJavaCoursesPage();
        javaCoursesPage.goToJavaQACoursePage();
        javaQACoursePage.enrollFail();
    }

    @Test
    public void freeTestProgrammingLanguage() {
        mainPage.goToPage();
        mainPage.goToTopMenuFreeCoursesAndCheck().takeProgrammingLanguageTest();
    }
    @Test
    public void checkMainPageLinksTopMenuAllCourses() {
        mainPage.goToPage();
        mainPage.goToTopMenuAllCoursesAndCheck();
    }
    @Test
    public void checkMainPageLinksTopMenuDataScienceCourses() {
        mainPage.goToPage();
        mainPage.goToTopMenuDataScienceCoursesAndCheck();
    }

    @Test
    public void checkMainPageLinksTopMenuCareerCenter() {
        mainPage.goToPage();
        mainPage.goToTopMenuCareerCenterAndCheck();
    }

    @Test
    public void checkMainPageLinksTopMenuContacts() {
        mainPage.goToPage();
        mainPage.goToTopMenuContactsAndCheck();
    }

    @Test
    public void checkMainPageLinksTopMenuMedia() {
        mainPage.goToPage();
        mainPage.goToTopMenuMediaAndCheck();
    }

    @Test
    public void checkMainPageLinksTopMenuCorporateEducation() {
        mainPage.goToPage();
        mainPage.goToTopMenuCorporateEducationAndCheck();
    }

    @Test
    public void checkMainPageLinksDataScience() {
        mainPage.goToPage();
        mainPage.goToDataSciencePageAndCheck();
    }

    @Test
    public void checkMainPageLinksTesting() {
        mainPage.goToPage();
        mainPage.goToTestingPageAndCheck();
    }

    @Test
    public void checkMainPageLinksHigherEducation() {
        mainPage.goToPage();
        mainPage.goToHigherEducationPageAndCheck();
    }

    @Test
    public void checkMainPageLinksDesign() {
        mainPage.goToPage();
        mainPage.goToDesignPageAndCheck();
    }

    @Test
    public void checkMainPageLinksAllCourses() {
        mainPage.goToPage();
        mainPage.goToAllCoursesPageAndCheck();
    }

    @Test
    public void checkMainPageLinksDataAnalyst() {
        mainPage.goToPage();
        mainPage.goToDataAnalystPageAndCheck();
    }

    @Test
    public void checkMainPageLinksPython() {
        mainPage.goToPage();
        mainPage.goToPythonPageAndCheck();
    }

    @Test
    public void checkMainPageLinksGraphicDesigner() {
        mainPage.goToPage();
        mainPage.goToGraphicDesignerPageAndCheck();
    }

    @Test
    public void checkMainPageLinksUXUIDesigner() {
        mainPage.goToPage();
        mainPage.goToUXUIDesignerPageAndCheck();
    }

    @Test
    public void checkMainPageLinksWhiteHacker() {
        mainPage.goToPage();
        mainPage.goToWhiteHackerPageAndCheck();
    }

    public static String[] getEmailsForTest() {
        return new String[] { "email@example.com",
                "",
                "plainaddress",
                "firstname.lastname@example.com",
                "email@subdomain.example.com",
                "firstname+lastname@example.com",
                "email@123.123.123.123",
                "email@[123.123.123.123]",
                "\"email\"@example.com",
                "1234567890@example.com",
                "email@example-one.com",
                "_______@example.com",
                "email@example.name",
                "email@example.museum",
                "email@example.co.jp",
                "firstname-lastname@example.com",
                "#@%^%#$@#$@#.com",
                "@example.com",
                "Joe Smith <email@example.com>" };
    }

    @AfterEach
    public void tearDown() {
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        for (String s : handles) {
            webDriver.switchTo().window(s);
            webDriver.close();
        }
        webDriver.quit();
    }
}
