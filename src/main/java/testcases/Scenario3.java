package testcases;

import general.BaseTest;
import general.MainCall;
import org.testng.annotations.Test;

public class Scenario3 extends BaseTest {

//    @Test
//    public static void testLogin()
//    {
//        MainCall.loginPage.goToLoginPage();
//        MainCall.loginPage.setName();
//        MainCall.loginPage.setPassword();
//        MainCall.loginPage.login();
//    }

    @Test(priority = 2)
    public static void testScenario3()
    {
        MainCall.hompePage.goToHomePage();
        MainCall.productCategoryPage.clickSkinCareAndSelectItems();
        MainCall.hompePage.goToCart();
        System.out.println("Total items on sale are: "+MainCall.envGlobals.ItemsAddedToCart);
        System.out.println("Total items on sale and out of stock are: "+MainCall.envGlobals.itemsOnSaleAndOutOfStock);
        System.out.println("Total amount of sale items: "+MainCall.envGlobals.amount);
        MainCall.checkoutPage.verifyNumberOfSaleItems();
        MainCall.checkoutPage.verifySubtotalOfItems();
        System.out.println("Subtotal "+MainCall.envGlobals.subtotal);
        MainCall.checkoutPage.cleanup();

    }
}
