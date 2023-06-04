package general;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EnvGlobals {

    public static StringBuilder Differnce = new StringBuilder() ;
    public static RequestSpecification requestSpecification;
    public static Response response;
    public static String requestBody = "";

    public static String firstName = "";
    public static String lastName = "";
    public static String email = "";
    public static String password = "";
    public static String company = "";
    public static String ProjectName = "";

    //My Env variables
    public static String loginName = "Hassan";
    public static String loginPass = "Hassan123";
    public static String newestItem = "Date New > Old";
    public static String oldestItem = "Date Old > New";
    public static String lowToHigh = "Price Low > High";
    public static String highToLow = "Price High > Low";
    public static String Quantity = "1";
    public static String checkoutQuantity = "";
    public static String totalPrice = "";
    public static String subtotalCheckoutPrice = "";
    public static int itemsAdded = 0;
    public static int saleItems = 2;
    public static int ItemsAddedToCart =0;
    public static int outOfStockAndOnSale = 1;
    public static int itemsOnSaleAndOutOfStock = 0;
    public static int amount;
    public static int subtotal;
}
