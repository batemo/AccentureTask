package Page;

import Basic.BaseClass;
import Basic.I;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AddProductToBasketPage extends I {

    @FindBy(xpath = "//div[@id='block_top_menu']//a[.='Women']")
    public static WebElement womenCategory;

    //Opravi tozi selektor i vkarai draivyra w proekta s referenten put
    @FindBy(xpath = "(//*[@id='block_top_menu']//a[.='Summer Dresses'])[1]")
    public static WebElement summerDresses;

    @FindBy(xpath = "//img[@src='http://automationpractice.com/img/p/1/6/16-home_default.jpg']")
    public static WebElement middleElement;

    @FindBy(xpath = "//a[@rel='http://automationpractice.com/index.php?id_product=6&controller=product']//span[.='Quick view']")
    public static WebElement quickView;

    @FindBy(xpath = "//iframe[contains(@id,'fancybox-frame')]")
    public static WebElement quickViewWindow;

    @FindBy(xpath = "//*[@id='quantity_wanted_p']/a[2]")
    private static WebElement plusButton;

    @FindBy(id = "uniform-group_1")
    private static WebElement sizeDropDown;

    @FindBy(xpath = "//option[.='M']")
    private static WebElement Msize;

    @FindBy(css = "a[name='White']")
    private static WebElement white;

    public static void SelectWomenProductAndAddItToTheBasket() throws Exception{
        I.amOn("http://automationpractice.com/index.php");
        I.hoverElement(womenCategory);
        I.click(summerDresses);
        I.hoverElement(middleElement);
        I.click(quickView);
        I.wait(5);
        List<WebElement> iFrame = BaseClass.driver().findElements(By.xpath("//iframe[contains(@id,'fancybox-frame')]"));
        Assert.assertTrue(iFrame.size() == 1);
        BaseClass.driver().switchTo().frame(0);
        I.click(plusButton);
        I.click(plusButton);
        I.click(white);
        I.click(sizeDropDown);
        I.click(Msize);
        I.wait(5);
    }
}
