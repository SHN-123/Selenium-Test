package objects;

import general.MainCall;
import org.openqa.selenium.By;

public class HomePage {
    //Adding locators
    public static By home = By.xpath("//*[@id='categorymenu']//a[@href='https://automationteststore.com/']");
    public static By dove = By.xpath("//a[@href='https://automationteststore.com/index.php?rt=product/manufacturer&manufacturer_id=18']");
    public static By men = By.xpath("//*[@class='nav-pills categorymenu']//a[@href='https://automationteststore.com/index.php?rt=product/category&path=58']");
    public static By cart = By.xpath("//*[@id='main_menu_top']/li[@data-id='menu_cart']/a");
    public static By apparelAndAccessories = By.cssSelector("#categorymenu > nav > ul > li:nth-child(2) > a");
    public static By tShirt =By.cssSelector("#categorymenu >nav > ul > li:nth-of-type(2) > div > ul > li:nth-of-type(2) > a");
    public static By shoes = By.cssSelector("#categorymenu >nav > ul > li:nth-of-type(2) > div > ul > li:nth-of-type(1) > a");
    public static void goToHomePage()
    {
        MainCall.genericFunctions.click(home);
    }
    public static void goToDoveItems()
    {
        MainCall.webDriverWaits.visibilityOf(cart);
        MainCall.genericFunctions.click(dove);
    }
    public static void goToMenSection()
    {
        MainCall.webDriverWaits.visibilityOf(cart);
        MainCall.genericFunctions.click(men);
    }
    public static void goToCart()
    {
        MainCall.webDriverWaits.visibilityOf(cart);
        MainCall.genericFunctions.click(cart);
    }
    public static void goToShirtsOnApparelAndAccessories()
    {
        MainCall.genericFunctions.hoverAndClickSubmenu(apparelAndAccessories,tShirt);
    }
    public static void goToShoesOnApparelAndAccessories()
    {
        MainCall.genericFunctions.hoverAndClickSubmenu(apparelAndAccessories,shoes);
    }

}
