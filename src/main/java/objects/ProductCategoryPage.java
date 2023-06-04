package objects;

import general.MainCall;
import general.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static general.WebDriverFactory.action;

public class ProductCategoryPage {

    public static By sort = By.cssSelector("#sort.form-control");
    public static By firstItem = By.xpath("//*[@id='maincontainer']/div/div/div/div/div[2]/div[1]");
    public static By men = By.xpath("//*[@class='nav-pills categorymenu']//a[@href='https://automationteststore.com/index.php?rt=product/category&path=58']");
    public static By menSubmenu = By.xpath("//*[@class='nav-pills categorymenu']/li[6]/div/ul[1]/li");
    public static By productItems = By.xpath("//*[@class='thumbnails grid row list-inline']//div[@class='col-md-3 col-sm-6 col-xs-12']");
    public static By clickToAdd = By.xpath("//*[@class='pricetag jumbotron']/a");
    public static By skincare = By.xpath("//*[@id='categorymenu']//li/a[@href='https://automationteststore.com/index.php?rt=product/category&path=43']");
    public static By outOfStock = By.xpath("*//div[@class='col-md-3 col-sm-6 col-xs-12']//div[@class='pricetag jumbotron']/span");
    public static void sortItemsBy(String s) {
        MainCall.genericFunctions.selectElementFromDropDownByText(sort, s);
    }

    public static void clickFirstItem() {
        MainCall.genericFunctions.click(firstItem);
    }

    public static void clickMensSubmenuAndFindItems() {
        int i = 1;
        while (i < 5)
        {
            action.moveToElement(WebDriverFactory.getDriver().findElement(men))
                    .perform();
            action.moveToElement(WebDriverFactory.getDriver().
                    findElement(By.xpath("//*[@class='nav-pills categorymenu']/li[6]/div/ul[1]/li[" + i + "]/a"))); // pointing cursor to the first element on the submenu
            action.click().build().perform(); //clicked the first submenu
            List<WebElement> items = MainCall.webDriverFactory.getDriver().findElements(productItems); //make list of all items of submenu
            for (int j = 1; j < items.size()+1;j++)
            {
                if (MainCall.webDriverFactory.getDriver().findElement(By.xpath("*//div["+j+"][@class='col-md-3 col-sm-6 col-xs-12']//a[@class='prdocutname']"))
                        .getText().trim().endsWith("M"))
                {
//                    System.out.println(MainCall.webDriverFactory.getDriver().findElement(By.xpath("*//div["+j+"][@class='col-md-3 col-sm-6 col-xs-12']//a[@class='prdocutname']"))
//                            .getText());
                    MainCall.webDriverFactory.getDriver().findElement(By.xpath("*//div["+j+"][@class='col-md-3 col-sm-6 col-xs-12']//div[@class='thumbnail']")).click();
                    if (!(MainCall.productPage.checkIfItemIsNotOutOfStock()))  // checking here if the selected item is not out of stock then add it to the cart.
                    {
                        MainCall.productPage.addToCart();
                        MainCall.envGlobals.itemsAdded++;
                        MainCall.webDriverFactory.getDriver().navigate().back();
                    }
                    MainCall.webDriverFactory.getDriver().navigate().back();
                    MainCall.webDriverFactory.getDriver().navigate().refresh();

                }
                if( j == 4)
                    j = j+1;
            }
            i++;
        }
    }

    public static boolean isElementPresent(By locatorKey)
    {
        try {
            MainCall.webDriverFactory.getDriver().findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public static void clickSkinCareAndSelectItems() {
        int i = 1;
        while (i < 6) {
            action.moveToElement(WebDriverFactory.getDriver().findElement(skincare))
                    .perform();
            action.moveToElement(WebDriverFactory.getDriver().
                    findElement(By.xpath("//*[@class='nav-pills categorymenu']/li[4]/div/ul[1]/li[" + i + "]/a")));
            action.click().build().perform(); //clicked the first submenu
            List<WebElement> items = MainCall.webDriverFactory.getDriver().findElements(productItems); //make list of all items of submenu
            for (int j = 1; j < items.size() + 2; j++) {
                if (isElementPresent(By.xpath("*//div[" + j + "][@class='col-md-3 col-sm-6 col-xs-12']//div[@class='thumbnail']//span[@class='sale']"))) //finds the sale tag
                {
                    System.out.println("Sale tag found at" +j);
                    System.out.println("Adding to cart - sale tag found at" +j);
                    MainCall.webDriverFactory.getDriver().findElement(By.xpath("*//div["+j+"][@class='col-md-3 col-sm-6 col-xs-12']//div[@class='thumbnail']/a")).click();
                    System.out.println("landed on product page" +j);
                    if (!(MainCall.productPage.checkIfItemIsNotOutOfStock()))
                    {
                        MainCall.envGlobals.amount += MainCall.productPage.totalAmountOfItemsAdded();
                        MainCall.productPage.addToCart();
                        MainCall.envGlobals.ItemsAddedToCart++;
                        System.out.println("Now at cart page " +j);
                        MainCall.webDriverFactory.getDriver().navigate().back();
                        MainCall.webDriverFactory.getDriver().navigate().back();
                       // MainCall.webDriverFactory.getDriver().navigate().refresh();
                    }
                    else {

                        MainCall.webDriverFactory.getDriver().navigate().back();
                        MainCall.webDriverFactory.getDriver().navigate().refresh();
                       // MainCall.envGlobals.itemsOnSaleAndOutOfStock++;
                    }
                }
                if (j == 4)
                    j = j + 1;
            }
            i++;
        }


    }
    public static void selectTopThreeShirts()
    {
        List<WebElement> items = MainCall.webDriverFactory.getDriver().findElements(productItems);
        int s = items.size();
        for (int j = 1; j < items.size()+2; j++) {
            MainCall.webDriverFactory.getDriver().findElement(By.xpath("*//div["+j+"][@class='col-md-3 col-sm-6 col-xs-12']//div[@class='thumbnail']/a")).click();
            System.out.println("landed on product page" +j);
            if (!(MainCall.productPage.checkIfItemIsNotOutOfStock()))
            {
                if (MainCall.productPage.getSizeOptions().contains("Medium"))
                {
                    MainCall.productPage.getTotalPrice();
                    MainCall.envGlobals.amount += MainCall.productPage.totalAmountOfItemsAdded();
                    MainCall.productPage.addToCart();
                    MainCall.envGlobals.ItemsAddedToCart++;
                    MainCall.webDriverFactory.getDriver().navigate().back();
                }
            }
            MainCall.webDriverFactory.getDriver().navigate().back();
            //MainCall.webDriverFactory.getDriver().navigate().refresh();

            if (j == 4)
                j = j + 1;
        }
    }
    public static void selectHighestPriceProduct()
    {
        MainCall.webDriverFactory.getDriver().findElement(By.xpath("*//div[1][@class='col-md-3 col-sm-6 col-xs-12']//div[@class='thumbnail']/a")).click();
        System.out.println("landed on product page");
        
    }

}
