package objects;

import general.MainCall;
import general.WebDriverFactory;
import general.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class CheckoutPage {
    public static By table =
            By.cssSelector("#cart > div > div.container-fluid.cart-info.product-list > table");
    public static By rows = By.cssSelector("#cart div div.container-fluid.cart-info.product-list table tr");
    public static By coloumn = By.cssSelector(("#cart div div.container-fluid.cart-info.product-list table tr td:nth-child(7)"));
    public static By quantity = By.cssSelector("#cart > div > div.container-fluid.cart-info.product-list > table > tbody > tr:nth-child(2) > td:nth-child(5) > div > input");
    public static By totalPrice = By.xpath("//*[@class='table table-striped table-bordered']//tr[2]//td[6]");
    public static String itemsName;
    public static By subtotal = By.xpath("//*[@id='totals_table']//tr[1]//td[2]/span[@class='bold ']");
    public static void getQuantity()
    {
        MainCall.envGlobals.checkoutQuantity = MainCall.webDriverFactory.getDriver().findElement(quantity).getAttribute("value");
    }
    public static void getTotalPrice()
    {
        MainCall.envGlobals.subtotalCheckoutPrice = MainCall.genericFunctions.getText(totalPrice);
    }
    public static void verifyQuantity() {
        getQuantity();
        if (!(MainCall.envGlobals.Quantity.contains("0")))
            Assert.assertEquals(MainCall.envGlobals.checkoutQuantity, MainCall.envGlobals.Quantity);
        else
            Assert.assertEquals(MainCall.envGlobals.checkoutQuantity, "1");
    }
    public static void verifyTotalPrice()
    {
        getTotalPrice();
        Assert.assertEquals(MainCall.envGlobals.subtotalCheckoutPrice,MainCall.envGlobals.totalPrice);
    }
    public static void verifyItemsNameEndsWithM()
    {
       for(int x = 2; x < MainCall.envGlobals.itemsAdded + 2; x++)
       {
           itemsName = MainCall.webDriverFactory.getDriver()
                   .findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr["+x+"]/td[2]/a")).getText();
           //System.out.println(itemsName);
           Assert.assertTrue(itemsName.endsWith("m"));
       }
    }
    public static void verifyNumberOfSaleItems()
    {
        Assert.assertEquals(MainCall.envGlobals.ItemsAddedToCart, MainCall.envGlobals.saleItems);
    }
    public static void verifyNumberOfItemsOutOfStock()
    {
        Assert.assertEquals(MainCall.envGlobals.itemsOnSaleAndOutOfStock, MainCall.envGlobals.outOfStockAndOnSale);
    }
    public static void verifySubtotalOfItems()
    {
        MainCall.webDriverWaits.visibilityOf(subtotal);
        MainCall.envGlobals.subtotal =
                Integer.parseInt(MainCall.genericFunctions.getText(subtotal).substring(1,MainCall.genericFunctions.getText(subtotal).length()-3));
        Assert.assertEquals(MainCall.envGlobals.amount, MainCall.envGlobals.subtotal);

    }
    public static void cleanup()
    {
        MainCall.genericFunctions.clickOnColumnOfTable();
        MainCall.genericFunctions.resetGlobalVariables();
    }
}
