package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTests {
    protected final Logger logger = LogManager.getLogger(this.getClass().getName());
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected ItemPage itemPage;
    protected BasketPage basketPage;
    protected CheckoutPage checkoutPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browserName, ITestContext testContext) throws Exception {
        if (browserName.equals("chrome"))   {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("fireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new Exception("Incorrect browser name");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        testContext.setAttribute("driver", driver);

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        itemPage = new ItemPage(driver);
        basketPage = new BasketPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void navigate()  {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown()  {
        driver.quit();
    }

    @DataProvider(name = "ItemList")
    public Object[][] listItem() {
        return new Object[][]   {
                {"Sauce Labs Backpack", "$29.99", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds " +
                        "uncompromising style with unequaled laptop and tablet protection."},
                {"Sauce Labs Bike Light", "$9.99", "A red light isn't the desired state in testing but it sure helps " +
                        "when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."},
                {"Sauce Labs Bolt T-Shirt", "$15.99", "Get your testing superhero on with the Sauce Labs bolt T-shirt. " +
                        "From American Apparel, 100% ringspun combed cotton, heather gray with red bolt."},
                {"Sauce Labs Fleece Jacket", "$49.99", "It's not every day that you come across a midweight quarter-zip " +
                        "fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office."},
                {"Sauce Labs Onesie", "$7.99", "Rib snap infant onesie for the junior automation engineer in development. " +
                        "Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel."},
                {"Test.allTheThings() T-Shirt (Red)", "$15.99", "This classic Sauce Labs t-shirt is perfect to wear when " +
                        "cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."},
        };
    }

    @DataProvider(name = "NegativeCheckout")
    public Object[][] negativeCheckoutList()    {
        logger.info("Setting checkout value firstName {}, lastName {} zipCode {}");
        return new Object[][]   {
                {"", "gsidbnfihnd", "453745"},
                {"fdhgj", "", "5434768"},
                {"ijfdhgfd", "fdhgfdjh", ""},
                {"jfnhog", "lkjngfh", "jfdngo"},
                {"%£%£%%£", "%£%£%%£", "64386"},
        };
    }

    @DataProvider(name = "Sorting")
    public Object[][] sortingTest() {
        return new Object[][]   {
                {"Name (A to Z)", Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                        "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)")},
                {"Name (Z to A)", Arrays.asList("Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie", "Sauce Labs Fleece Jacket",
                        "Sauce Labs Bolt T-Shirt", "Sauce Labs Bike Light", "Sauce Labs Backpack")},
                {"Price (low to high)", Arrays.asList("Sauce Labs Onesie", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                        "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Backpack", "Sauce Labs Fleece Jacket")},
                {"Price (high to low)", Arrays.asList("Sauce Labs Fleece Jacket", "Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt",
                        "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Bike Light", "Sauce Labs Onesie")},
        };
    }
}