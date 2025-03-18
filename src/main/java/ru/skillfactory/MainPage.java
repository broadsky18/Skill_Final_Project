package ru.skillfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {
    public static final String URL = "https://skillfactory.ru/";
    public static final String LOGO = "//div[@class='main__logo-wrapper']";
    public static final String PROGRAMMING_COURSES = "//div[@class='directions']/ul/li[1]";
    public static final String DATA_SCIENCE = "//div[@class='directions']/ul/li[2]";
    public static final String DATA_ANALYSIS = "//div[@class='directions']/ul/li[3]";
    public static final String TESTING = "//div[@class='directions']/ul/li[4]";
    public static final String HIGHER_EDUCATION = "//div[@class='directions']/ul/li[5]";
    public static final String DESIGN = "//div[@class='directions']/ul/li[6]";
    public static final String ALL_COURSES = "//div[@class='directions']/ul/li[7]";
    public static final String PROFORIENTACIYA = "//a[@href='/it-specialist-proforientaciya']";
    public static final String TOP_MENU_ONLINE_COURSES = "//a[@class='main__nav-item t978__tm-link']";
    public static final String TOP_MENU_FREE_COURSES = "//section[@class='main']//a[@href='/free-events']";
    public static final String TOP_MENU_CAREER_CENTER = "//section[@class='main']//a[@href='/career-center']";
    public static final String TOP_MENU_CONTACTS = "//section[@class='main']//a[@href='/contacts']";
    public static final String TOP_MENU_MEDIA = "//section[@class='main']//a[@href='https://blog.skillfactory.ru/']";
    public static final String TOP_MENU_CORPORATE_EDUCATION = "//section[@class='main']//a[@href='https://new.skillfactory.ru/corporativnoye-obuchenye']";
    public static final String TOP_MENU_ONLINE_COURSES_ALL_COURSES = "/html/body/div/div[6]/div[2]/div/div[2]/ul/li[1]/div/a";
    public static final String TOP_MENU_ONLINE_COURSES_DATA_SCIENCE_COURSES = "/html/body/div/div[6]/div[2]/div/div[2]/ul/li[2]/div/a";
    public static final String DATA_ANALYST = "//a[@href='/data-analyst-pro']";
    public static final String PYTHON_DEVELOPER = "//a[@href='/python-developer']";
    public static final String GRAPHIC_DESIGNER = "//a[@href='https://contented.ru/edu/graphic-designer-pro?utm_source=skillfactory']";
    public static final String UXUI_DESIGNER = "//a[@href='https://contented.ru/edu/ux-ui-designer-pro?utm_source=skillfactory']";
    public static final String WHITE_HACKER = "//a[@href='/cyber-security-etichnij-haker']";

    private final WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void goToPage() {
        webDriver.get(URL);
        //test page loading
        try {
            if(!(webDriver.findElement(By.xpath(LOGO)).isDisplayed())) {}
        } catch (Exception e) {
            throw new AssertionError("The 'Main Page' was not loaded");
        }
    }

    public void goToProgrammingCoursesPage() {
        webDriver.findElement(By.xpath(PROGRAMMING_COURSES)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
    }

    public void goToTopMenuAllCoursesAndCheck() {
        webDriver.findElement(By.xpath(TOP_MENU_ONLINE_COURSES)).click();
        webDriver.findElement(By.xpath(TOP_MENU_ONLINE_COURSES_ALL_COURSES)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
        assertEquals(AllCoursesPage.URL, webDriver.getCurrentUrl(), "У открытой страницы некорректный url");
        String pageTitle = webDriver.findElement(By.xpath(AllCoursesPage.PAGE_TITLE_LOCATOR)).getText();
        assertEquals(AllCoursesPage.PAGE_TITLE_TEXT, pageTitle,"У открытой страницы некорректный заголовок");
    }

    public void goToTopMenuDataScienceCoursesAndCheck() {
        webDriver.findElement(By.xpath(TOP_MENU_ONLINE_COURSES)).click();
        webDriver.findElement(By.xpath(TOP_MENU_ONLINE_COURSES_DATA_SCIENCE_COURSES)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
        assertEquals(DataScienceCoursesPage.URL, webDriver.getCurrentUrl(), "У открытой страницы некорректный url");
        String pageTitle = webDriver.findElement(By.xpath(DataScienceCoursesPage.PAGE_TITLE_LOCATOR)).getText();
        assertEquals(DataScienceCoursesPage.PAGE_TITLE_TEXT, pageTitle, "У открытой страницы некорректный заголовок");
    }

    public FreeCoursesPage goToTopMenuFreeCoursesAndCheck() {
        webDriver.findElement(By.xpath(TOP_MENU_FREE_COURSES)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
        assertEquals(FreeCoursesPage.URL, webDriver.getCurrentUrl(),"У открытой страницы некорректный url");
        String pageTitle = webDriver.findElement(By.xpath(FreeCoursesPage.PAGE_TITLE_LOCATOR)).getText();
        assertEquals(FreeCoursesPage.PAGE_TITLE_TEXT, pageTitle, "У открытой страницы некорректный заголовок");
        return new FreeCoursesPage(webDriver);
    }

    public void goToTopMenuCareerCenterAndCheck() {
        webDriver.findElement(By.xpath(TOP_MENU_CAREER_CENTER)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
        assertEquals(CareerCenterPage.URL, webDriver.getCurrentUrl(), "У открытой страницы некорректный url");
        String pageTitle = webDriver.findElement(By.xpath(CareerCenterPage.PAGE_TITLE_LOCATOR)).getText();
        assertEquals(CareerCenterPage.PAGE_TITLE_TEXT, pageTitle, "У открытой страницы некорректный заголовок");
    }

    public void goToTopMenuContactsAndCheck() {
        webDriver.findElement(By.xpath(TOP_MENU_CONTACTS)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
        assertEquals(ContactsPage.URL, webDriver.getCurrentUrl(), "У открытой страницы некорректный url");
        String pageTitle = webDriver.findElement(By.xpath(ContactsPage.PAGE_TITLE_LOCATOR)).getText();
        assertEquals(ContactsPage.PAGE_TITLE_TEXT, pageTitle, "У открытой страницы некорректный заголовок");
    }

    public void goToTopMenuCorporateEducationAndCheck() {
        webDriver.findElement(By.xpath(TOP_MENU_CORPORATE_EDUCATION)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
        assertEquals(CorporateEducationPage.URL, webDriver.getCurrentUrl(), "У открытой страницы некорректный url");
        String pageTitle = webDriver.findElement(By.xpath(CorporateEducationPage.PAGE_TITLE_LOCATOR)).getText();
        assertEquals(CorporateEducationPage.PAGE_TITLE_TEXT, pageTitle, "У открытой страницы некорректный заголовок");
    }

    public void goToTopMenuMediaAndCheck() {
        webDriver.findElement(By.xpath(TOP_MENU_MEDIA)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
        assertEquals(MediaPage.URL, webDriver.getCurrentUrl(), "У открытой страницы некорректный url");
        String pageTitle = webDriver.findElement(By.xpath(MediaPage.PAGE_TITLE_LOCATOR)).getText();
        assertEquals(MediaPage.PAGE_TITLE_TEXT, pageTitle, "У открытой страницы некорректный заголовок");
    }

    public void goToDataSciencePageAndCheck() {
        webDriver.findElement(By.xpath(DATA_SCIENCE)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
        assertEquals(DataScienceCoursesPage.URL, webDriver.getCurrentUrl(), "У открытой страницы некорректный url");
        String pageTitle = webDriver.findElement(By.xpath(DataScienceCoursesPage.PAGE_TITLE_LOCATOR)).getText();
        assertEquals(DataScienceCoursesPage.PAGE_TITLE_TEXT, pageTitle, "У открытой страницы некорректный заголовок");
    }

    public void goToDataAnalysisPageAndCheck() {
        webDriver.findElement(By.xpath(DATA_ANALYSIS)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
        assertEquals(DataScienceCoursesPage.URL, webDriver.getCurrentUrl(), "У открытой страницы некорректный url");
        String pageTitle = webDriver.findElement(By.xpath(DataScienceCoursesPage.PAGE_TITLE_LOCATOR)).getText();
        assertEquals(DataScienceCoursesPage.PAGE_TITLE_TEXT, pageTitle, "У открытой страницы некорректный заголовок");
    }

    public void goToTestingPageAndCheck() {
        webDriver.findElement(By.xpath(TESTING)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
        assertEquals(TestingCoursesPage.URL, webDriver.getCurrentUrl(), "У открытой страницы некорректный url");
        String pageTitle = webDriver.findElement(By.xpath(TestingCoursesPage.PAGE_TITLE_LOCATOR)).getText();
        assertEquals(TestingCoursesPage.PAGE_TITLE_TEXT, pageTitle, "У открытой страницы некорректный заголовок");
    }

    public void goToHigherEducationPageAndCheck() {
        webDriver.findElement(By.xpath(HIGHER_EDUCATION)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
        assertEquals(HigherEducationPage.URL, webDriver.getCurrentUrl(), "У открытой страницы некорректный url");
        String pageTitle = webDriver.findElement(By.xpath(HigherEducationPage.PAGE_TITLE_LOCATOR)).getText();
        assertEquals(HigherEducationPage.PAGE_TITLE_TEXT, pageTitle, "У открытой страницы некорректный заголовок");
    }

    public void goToDesignPageAndCheck() {
        webDriver.findElement(By.xpath(DESIGN)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
        assertEquals(DesignCoursesPage.URL, webDriver.getCurrentUrl(), "У открытой страницы некорректный url");
        String pageTitle = webDriver.findElement(By.xpath(DesignCoursesPage.PAGE_TITLE_LOCATOR)).getText();
        assertEquals(DesignCoursesPage.PAGE_TITLE_TEXT, pageTitle, "У открытой страницы некорректный заголовок");
    }

    public void goToAllCoursesPageAndCheck() {
        webDriver.findElement(By.xpath(ALL_COURSES)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
        assertEquals(AllCoursesPage.URL, webDriver.getCurrentUrl(), "У открытой страницы некорректный url");
        String pageTitle = webDriver.findElement(By.xpath(AllCoursesPage.PAGE_TITLE_LOCATOR)).getText();
        assertEquals(AllCoursesPage.PAGE_TITLE_TEXT, pageTitle, "У открытой страницы некорректный заголовок");
    }

    public void goToProforientaciyaPageAndCheck() {
        webDriver.findElement(By.xpath(PROFORIENTACIYA)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
        assertEquals(ProforientaciyaPage.URL, webDriver.getCurrentUrl(), "У открытой страницы некорректный url");
        String pageTitle = webDriver.findElement(By.xpath(ProforientaciyaPage.PAGE_TITLE_LOCATOR)).getText();
        assertEquals(ProforientaciyaPage.PAGE_TITLE_TEXT, pageTitle, "У открытой страницы некорректный заголовок");
    }

    public void goToDataAnalystPageAndCheck() {
        webDriver.findElement(By.xpath(DATA_ANALYST)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
        assertEquals(DataAnalystCoursePage.URL, webDriver.getCurrentUrl(), "У открытой страницы некорректный url");
        String pageTitle = webDriver.findElement(By.xpath(DataAnalystCoursePage.PAGE_TITLE_LOCATOR)).getText();
        assertEquals(DataAnalystCoursePage.PAGE_TITLE_TEXT, pageTitle, "У открытой страницы некорректный заголовок");
    }

    public void goToPythonPageAndCheck() {
        webDriver.findElement(By.xpath(PYTHON_DEVELOPER)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
        assertEquals(PythonCoursePage.URL, webDriver.getCurrentUrl(), "У открытой страницы некорректный url");
        String pageTitle = webDriver.findElement(By.xpath(PythonCoursePage.PAGE_TITLE_LOCATOR)).getText();
        assertEquals(PythonCoursePage.PAGE_TITLE_TEXT, pageTitle, "У открытой страницы некорректный заголовок");
    }

    public void goToGraphicDesignerPageAndCheck() {
        webDriver.findElement(By.xpath(GRAPHIC_DESIGNER)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
        assertEquals(GraphicDesignerCousePage.URL, webDriver.getCurrentUrl(), "У открытой страницы некорректный url");
        String pageTitle = webDriver.findElement(By.xpath(GraphicDesignerCousePage.PAGE_TITLE_LOCATOR)).getText();
        assertEquals(GraphicDesignerCousePage.PAGE_TITLE_TEXT, pageTitle, "У открытой страницы некорректный заголовок");
    }

    public void goToUXUIDesignerPageAndCheck() {
        webDriver.findElement(By.xpath(UXUI_DESIGNER)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
        assertEquals(UXUIDesignerCoursePage.URL, webDriver.getCurrentUrl(), "У открытой страницы некорректный url");
        String pageTitle = webDriver.findElement(By.xpath(UXUIDesignerCoursePage.PAGE_TITLE_LOCATOR)).getText();
        assertEquals(UXUIDesignerCoursePage.PAGE_TITLE_TEXT, pageTitle, "У открытой страницы некорректный заголовок");
    }

    public void goToWhiteHackerPageAndCheck() {
        webDriver.findElement(By.xpath(WHITE_HACKER)).click();
        ArrayList<String> handles = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(handles.get(1));
        assertEquals(WhiteHackerCoursePage.URL, webDriver.getCurrentUrl(), "У открытой страницы некорректный url");
        String pageTitle = webDriver.findElement(By.xpath(WhiteHackerCoursePage.PAGE_TITLE_LOCATOR)).getText();
        assertEquals(WhiteHackerCoursePage.PAGE_TITLE_TEXT, pageTitle, "У открытой страницы некорректный заголовок");
    }
}
