package Basic;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

    protected static WebDriver driver;

    public static WebDriver driver() {
        return driver;
    }

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\ebibi\\IdeaProjects\\AutomationTesting\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}

