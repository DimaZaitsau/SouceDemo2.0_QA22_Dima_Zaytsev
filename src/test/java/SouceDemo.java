import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SouceDemo {
    WebElement driver;

    @Test
    public void souceDemoTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement shoppingBasketBtn = driver.findElement(By.className("shopping_cart_link"));
        Assert.assertEquals(shoppingBasketBtn.isDisplayed(), true);

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        shoppingBasketBtn.click();

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        Assert.assertEquals(checkoutButton.isDisplayed(), true);

        WebElement itemName = driver.findElement(By.className("inventory_item_name"));
        itemName.getText();
        Assert.assertEquals(itemName.getText(), "Sauce Labs Backpack");
        WebElement itemPrice = driver.findElement(By.className("inventory_item_price"));
        itemPrice.getText();
        Assert.assertEquals(itemPrice.getText(), "$29.99");

        driver.quit();
    }
}