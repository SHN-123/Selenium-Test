package testcases;

import general.BaseTest;
import general.MainCall;
import org.testng.annotations.Test;

public class Scenario2 extends BaseTest {

//    @Test
//    public static void testLogin()
//    {
//        MainCall.loginPage.goToLoginPage();
//        MainCall.loginPage.setName();
//        MainCall.loginPage.setPassword();
//        MainCall.loginPage.login();
//    }

    @Test
    public static void testScenario2()
    {
        MainCall.hompePage.goToHomePage();
        MainCall.hompePage.goToShirtsOnApparelAndAccessories();
        MainCall.productCategoryPage.sortItemsBy(MainCall.envGlobals.lowToHigh);
        MainCall.productCategoryPage.selectTopThreeShirts();
        MainCall.hompePage.goToCart();
        MainCall.checkoutPage.verifySubtotalOfItems();
        MainCall.hompePage.goToShoesOnApparelAndAccessories();
        MainCall.productCategoryPage.sortItemsBy(MainCall.envGlobals.highToLow);
        MainCall.productCategoryPage.selectHighestPriceProduct();
        MainCall.productPage.setQuantity(MainCall.envGlobals.Quantity);
        MainCall.productPage.getTotalPrice();
        MainCall.envGlobals.amount += MainCall.productPage.totalAmountOfItemsAdded();
        MainCall.productPage.addToCart();
        MainCall.hompePage.goToCart();
        MainCall.checkoutPage.verifySubtotalOfItems();
        MainCall.checkoutPage.cleanup();

    }
}
