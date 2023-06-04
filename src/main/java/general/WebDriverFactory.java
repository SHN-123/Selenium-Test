package general;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.awt.*;
import java.io.File;
import java.util.concurrent.TimeUnit;
import static config.ConfigProperties.*;

public class WebDriverFactory {
    static WebDriver driver;
    static String device = Device; // Change to windows or mac accordingly
    static Boolean headless = Boolean.valueOf(Headless);
    public static Actions action;
    public static Robot robot;


    public static WebDriver getInstance(String Browser) throws AWTException {

        ChromeOptions op = new ChromeOptions();
//        if (device.equals("Windows")) {
//            //op.addArguments("--start-maximized");
//            op.addArguments("start-fullscreen");
//        }
//
//        else {
//            op.addArguments("start-fullscreen");
//        }

        if(headless)
            op.addArguments("--headless");

        op.addExtensions(new File("chromeappExtension/chromeapp.crx"));

        switch (Browser)
        {
            case "Chrome":
                if (device.equals("Windows"))
                {
                   driver = new ChromeDriver(op);
//                    webDriver = new ChromeDriver(op);
                    //setDriverThread(webDriver);
                    break;
                }
                else if (device.equals("Ubuntu"))

                {
                    driver = new ChromeDriver(op);
//                    webDriver = new ChromeDriver(op);
                   // setDriverThread(webDriver);
                    break;
                }

            case "Safari":
                driver = new SafariDriver();
//                webDriver = new SafariDriver();
               // setDriverThread(webDriver);
                break;

            case "IE":
                driver = new InternetExplorerDriver();
//                webDriver = new InternetExplorerDriver();
                //setDriverThread(webDriver);
                break;

            case "Firefox":
                File filef = new File("driver/geckodriver");
                System.setProperty("webdriver.gecko.driver", filef.getAbsolutePath());
                driver = new FirefoxDriver();
//                webDriver = new FirefoxDriver();
               // setDriverThread(webDriver);
                break;

            case "Edge":
                File file = new File("driver/msedgedriver");
                System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
                driver = new EdgeDriver();
//                webDriver = new EdgeDriver();
               // setDriverThread(webDriver);
                break;

        }

        driver.get(Url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        action = new Actions(driver);
        robot = new Robot();

        return driver;
    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        else
        {
            throw new IllegalStateException("Driver has not been initialized");
        }
    }
//    public static void setDriverThread(WebDriver d)
//    {
//        driver.set(d);
//    }
    public static void finishDriver()
    {
        if (driver != null)
        {
            driver.quit();
            driver = null;
        }
    }

}
