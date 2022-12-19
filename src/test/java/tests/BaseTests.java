package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTests {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected ItemPage itemPage;
    protected BasketPage basketPage;
    protected CheckoutPage checkoutPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;
    protected Sotring sotring;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        itemPage = new ItemPage(driver);
        basketPage = new BasketPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        sotring = new Sotring(driver);
    }

    @BeforeMethod
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
}