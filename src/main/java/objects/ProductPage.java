package objects;

import general.MainCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import javax.swing.*;
import java.util.List;

public class ProductPage {
    public static By quantity = By.xpath("//*[@id='product_quantity']");
    public static By totalPrice = By.xpath("//*[@id='product']//span[@class='total-price']");
    public static By addToCart = By.xpath("//*[@id='product']//a[@class='cart']");
    public static By cart_button_check = By.xpath("*//ul[@class='productpagecart']/li");
    public static By sizeCheck = By.cssSelector("#product fieldset div div.input-group.col-sm-10");
    public static By label = By.cssSelector("#product > fieldset > div > label");

    public static void setQuantity(String q) {
        if (!(q.contains("0"))) {
            MainCall.webDriverFactory.getDriver().findElement(quantity).clear();
            MainCall.genericFunctions.sendKeys(quantity, q);
        }
    }

    public static void getTotalPrice() {
        MainCall.webDriverWaits.sleep1000();
        MainCall.webDriverWaits.visibilityOf(totalPrice);
        MainCall.envGlobals.totalPrice = MainCall.genericFunctions.getText(totalPrice);
    }

    public static int totalAmountOfItemsAdded() {
        getTotalPrice();
        return Integer.parseInt(MainCall.envGlobals.totalPrice.substring(1, MainCall.envGlobals.totalPrice.length() - 3));
    }

    public static void addToCart() {
        MainCall.genericFunctions.click(addToCart);
    }

    public static boolean checkIfItemIsNotOutOfStock() {
        return (MainCall.webDriverFactory.getDriver().findElement(cart_button_check).getText().contains("Out of Stock"));
    }

    public static int find_size_dropdown_index()
    {
        List<WebElement> l = MainCall.webDriverFactory.getDriver().findElements(label);
        String s;
        if (l.size()!=1)
        {
            for(int i = 0; i < l.size(); i++)
            {
                s = l.get(i).getText();
                if(s.contains("Size")){
                    return i+1;
                }
            }
        }
        return 0;
    }

    public static List<String> getSizeOptions() {
        int i = find_size_dropdown_index();
        return MainCall.genericFunctions.getDropDownOptions(By.cssSelector("#product > fieldset > div:nth-child("+i+") > div > select"));
    }
}
