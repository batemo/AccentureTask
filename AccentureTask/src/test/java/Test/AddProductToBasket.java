package Test;

import Basic.BaseClass;
import Page.AddProductToBasketPage;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class AddProductToBasket extends BaseClass{

    public AddProductToBasket(){
        PageFactory.initElements(driver, AddProductToBasketPage.class);
    }

    @Test
    public void AddProductToBasketTest() throws Exception{
        AddProductToBasketPage.SelectWomenProductAndAddItToTheBasket();
    }
}
