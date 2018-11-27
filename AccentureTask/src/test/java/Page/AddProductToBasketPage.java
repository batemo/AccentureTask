package Page;

import Basic.BaseClass;
import Basic.I;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AddProductToBasketPage extends I {

    @FindBy(xpath = "//div[@id='block_top_menu']//a[.='Women']")
    public static WebElement womenCategory;

    //Opravi tozi selektor
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
    @FindBy(css = "#add_to_cart span")
    private static WebElement addToCard;
    @FindBy(xpath = "//span[@title='Close window']")
    private static WebElement closeWindow;
    @FindBy(css = ".shopping_cart a")
    private static WebElement shopingCard;
    @FindBy(className = "ajax_block_products_total")
    private static WebElement totalProduct;
    @FindBy(id = "layer_cart_product_attributes")
    private static WebElement colorAndSize;
    @FindBy(id = "layer_cart_product_attributes")
    private static WebElement quantity;
    @FindBy(id = "layer_cart_product_title")
    private static WebElement name;

    public static void SelectWomenProductAndAddItToTheBasket() throws Exception{
        I.amOn("http://automationpractice.com/index.php");
        I.hoverElement(womenCategory);
        I.click(summerDresses);
        javascriptExecutor.executeScript("javascript:window.scrollBy(250,550)");
        I.hoverElement(middleElement);
        I.click(quickView);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
        BaseClass.driver().switchTo().frame(0);
        I.click(plusButton);
        I.click(plusButton);
        I.click(white);
        I.click(sizeDropDown);
        I.click(Msize);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#add_to_cart span")));
        I.click(addToCard);
        I.waitForReady();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,'Product successfully added to your shopping cart')]")));
        String colorAndSizeOfProduct = colorAndSize.getText();
        String totalOfTheProduct = totalProduct.getText();
        String nameOfTheProduct = name.getText();
        I.hoverElement(closeWindow);
        I.click(closeWindow);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shopping_cart a")));
        I.hoverElement(shopingCard);
        I.wait(3);
        Assert.assertTrue
                (colorAndSizeOfProduct.equalsIgnoreCase
                        (BaseClass.driver().findElement(By.cssSelector(".product-atributes a[title='Printed Summer Dress']")).getText()));
        Assert.assertTrue
                (totalOfTheProduct.equalsIgnoreCase
                        (BaseClass.driver().findElement(By.cssSelector(".cart-info .price")).getText()));
        Assert.assertTrue
                (nameOfTheProduct.equalsIgnoreCase
                        (BaseClass.driver().findElement(By.cssSelector(".product-name a[title='Printed Summer Dress']")).getAttribute("title")));
    }
}
