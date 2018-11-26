package Basic;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Basic.BaseClass.driver;

public class I {

    public static WebDriverWait wait;
    public static BaseClass baseClass;
    public static JavascriptExecutor javascriptExecutor;
    public static Actions builder;

    public I()
    {
        baseClass = new BaseClass();
        wait = new WebDriverWait(driver, 15);
        javascriptExecutor = (JavascriptExecutor) driver;
        builder = new Actions(driver);
    }

    public static void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void waitForReady(){
        wait.until(ExpectedConditions.jsReturnsValue("return $.active == 0;"));
    }

    public static void amOn(String url){
        driver.get(url);
    }

    public static void wait(int seconds) throws Exception{
        Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
    }

    public static void hoverElement(WebElement element){
        builder.moveToElement(element).build().perform();
    }

    public static void selectFromDropDown(WebElement element, String value){

        I.click(element);

    }



    /*
        Take screen shot with selenium
     */
    public static void takeScreenShot(String shotName) throws Exception{
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("D:\\Downloads\\" + shotName + ".png");
        FileUtils.copyFile(src, destination);
    }


}
