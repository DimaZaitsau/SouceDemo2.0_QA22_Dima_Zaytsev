package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private final static By SHOPPING_CART_BUTTON =By.cssSelector(".shopping_cart_link");
    private final static String ITEM_CONTAINER_LOCATOR = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='inventory_item']";
    private final static By ADD_TO_CART_BUTTON = By.xpath(".//button[text()='Add to cart']");
    private final static By ITEM_PRICE = By.xpath(".//div[@class='inventory_item_price']");
    private final static By ITEM_DESCRIPTION = By.cssSelector(".inventory_item_desc");
    private final static By ITEM_BUTTON = By.xpath(".//div[@class='inventory_item_name']/ancestor::a");
    private final static By DROPDOWN = By.className("product_sort_container");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public boolean isDropdownPresent()  {
        try {
            driver.findElement(DROPDOWN);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }
    public boolean isShoppingCartButtonPresent()    {
        try {
            driver.findElement(SHOPPING_CART_BUTTON);
        } catch (NoSuchElementException ex)  {
            return false;
        }
        return true;
    }


    public String getItemPrice(String itemName)   {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_PRICE).getText();
    }

    public String getItemDescription(String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_DESCRIPTION).getText();
    }

    public void clickAddToCartButton(String itemName)   {
        driver.findElement(getItemContainerByName(itemName)).findElement(ADD_TO_CART_BUTTON).click();
    }

    public void openItem(String itemName) {
        driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_BUTTON).click();
    }

    private By getItemContainerByName(String itemName)    {
        return By.xpath(String.format(ITEM_CONTAINER_LOCATOR, itemName));
    }

    public void back()  {
        driver.getWindowHandle();
        driver.navigate().back();
    }
}