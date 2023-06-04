package testcases;

import general.BaseTest;
import general.MainCall;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Scenario1 extends BaseTest {

    @Test
    public static void testLogin() {
        MainCall.loginPage.goToLoginPage();
        MainCall.loginPage.setName();
        MainCall.loginPage.setPassword();
        MainCall.loginPage.login();
    }
//    @Test
//    public static void testScenario1(){
//        MainCall.hompePage.goToHomePage();
//        MainCall.hompePage.goToDoveItems();
//        MainCall.productCategoryPage.sortItemsBy(MainCall.envGlobals.newestItem);
//        MainCall.productCategoryPage.clickFirstItem();
//        MainCall.productPage.setQuantity(MainCall.envGlobals.Quantity);
//        MainCall.envGlobals.amount += MainCall.productPage.totalAmountOfItemsAdded();
//        MainCall.productPage.addToCart();
//        MainCall.checkoutPage.verifyQuantity();
//        MainCall.checkoutPage.verifySubtotalOfItems();
//        MainCall.checkoutPage.cleanup();
//
//    }

//    @Test(priority = 2)
//    public static void testScenario2()
//    {
//        MainCall.hompePage.goToShirtsOnApparelAndAccessories();
//        MainCall.productCategoryPage.sortItemsBy(MainCall.envGlobals.lowToHigh);
//        MainCall.productCategoryPage.selectTopThreeShirts();
//        MainCall.hompePage.goToCart();
//        MainCall.checkoutPage.verifySubtotalOfItems();
//        MainCall.hompePage.goToShoesOnApparelAndAccessories();
//        MainCall.productCategoryPage.sortItemsBy(MainCall.envGlobals.highToLow);
//        MainCall.productCategoryPage.selectHighestPriceProduct();
//        MainCall.productPage.setQuantity(MainCall.envGlobals.Quantity);
//        MainCall.productPage.getTotalPrice();
//        MainCall.envGlobals.amount += MainCall.productPage.totalAmountOfItemsAdded();
//        MainCall.productPage.addToCart();
//        MainCall.hompePage.goToCart();
//        MainCall.checkoutPage.verifySubtotalOfItems();
//        MainCall.checkoutPage.cleanup();
//
//    }

//        @Test(priority = 3)
//    public static void testScenario3()
//    {
//        MainCall.productCategoryPage.clickSkinCareAndSelectItems();
//        MainCall.hompePage.goToCart();
//        System.out.println("Total items on sale are: "+MainCall.envGlobals.ItemsAddedToCart);
//        System.out.println("Total items on sale and out of stock are: "+MainCall.envGlobals.itemsOnSaleAndOutOfStock);
//        System.out.println("Total amount of sale items: "+MainCall.envGlobals.amount);
//        MainCall.checkoutPage.verifyNumberOfSaleItems();
//        MainCall.checkoutPage.verifySubtotalOfItems();
//        System.out.println("Subtotal "+MainCall.envGlobals.subtotal);
//        MainCall.checkoutPage.cleanup();
//
//    }
    @Test(priority = 4)
    public static void testScenario4() {
        MainCall.productCategoryPage.clickMensSubmenuAndFindItems();
        MainCall.hompePage.goToCart();
        MainCall.checkoutPage.verifyItemsNameEndsWithM();
        MainCall.checkoutPage.cleanup();
   }
//    @AfterMethod
//    public static void cleanup()
//    {
//        MainCall.envGlobals.totalPrice = "0";
//        MainCall.envGlobals.subtotalCheckoutPrice = "0";
//        MainCall.envGlobals.itemsAdded = 0;
//        MainCall.envGlobals.ItemsAddedToCart =0;
//        MainCall.envGlobals.amount = 0;
//        MainCall.envGlobals.subtotal =0;
//    }

    }
