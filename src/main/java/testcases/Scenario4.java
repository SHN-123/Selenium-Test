package testcases;

import general.BaseTest;
import general.MainCall;
import org.testng.annotations.Test;

public class Scenario4 extends BaseTest {

//    @Test
//    public static void testLogin()
//    {
//        MainCall.loginPage.goToLoginPage();
//        MainCall.loginPage.setName();
//        MainCall.loginPage.setPassword();
//        MainCall.loginPage.login();
//    }

    @Test
    public static void testScenario4()
    {
        MainCall.hompePage.goToHomePage();
        MainCall.productCategoryPage.clickMensSubmenuAndFindItems();
        MainCall.hompePage.goToCart();
        MainCall.checkoutPage.verifyItemsNameEndsWithM();
        MainCall.checkoutPage.cleanup();
    }
}
