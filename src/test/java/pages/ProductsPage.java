package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends BasePage {
    private final static By SHOPPING_CART_BUTTON =By.cssSelector(".shopping_cart_link");
    private final static String ITEM_CONTAINER_LOCATOR = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='inventory_item']";
    private final static By ADD_TO_CART_BUTTON = By.xpath(".//button[text()='Add to cart']");
    private final static By ITEM_PRICE = By.xpath(".//div[@class='inventory_item_price']");
    private final static By ITEM_NAME = By.cssSelector(".inventory_item_name");
    private final static By ITEM_DESCRIPTION = By.cssSelector(".inventory_item_desc");
    private final static By ITEM_BUTTON = By.xpath(".//div[@class='inventory_item_name']/ancestor::a");
    private final static By DROPDOWN = By.className("product_sort_container");
    private final static By BURGER_BUTTON = By.cssSelector("#react-burger-menu-btn");
    private final static By LOGOUT_BUTTON = By.cssSelector("#logout_sidebar_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Is present dropdown button on the products page")
    public boolean isDropdownPresent()  {
        try {
            driver.findElement(DROPDOWN);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("Is present shopping cart button on the products page")
    public boolean isShoppingCartButtonPresent()    {
        try {
            driver.findElement(SHOPPING_CART_BUTTON);
        } catch (NoSuchElementException ex)  {
            return false;
        }
        return true;
    }

    @Step("Get item name in container")
    public String getItemPrice(String itemName)   {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_PRICE).getText();
    }

    @Step("Get item description in container")
    public String getItemDescription(String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_DESCRIPTION).getText();
    }

    @Step("Click on add to cart button in container in the products page")
    public void clickAddToCartButton(String itemName)   {
        driver.findElement(getItemContainerByName(itemName)).findElement(ADD_TO_CART_BUTTON).click();
    }

    @Step("Click on item name for open item page")
    public void openItem(String itemName) {
        driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_BUTTON).click();
    }

    @Step("Get item container by name")
    private By getItemContainerByName(String itemName)    {
        return By.xpath(String.format(ITEM_CONTAINER_LOCATOR, itemName));
    }

    @Step("Click burger button")
    public void clickBurgerButton()  {
        driver.findElement(BURGER_BUTTON).click();
    }

    @Step("Click logout button")
    public void clickLogoutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
    }

    @Step("Click dropdown button")
    public void clickDropdownButton()   {
        driver.findElement(DROPDOWN).click();
    }

    @Step("Select sorting option by option name = {optionName}")
    public void selectSortingOrderOption(String optionName) {
        Select select = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        select.selectByVisibleText(optionName);
    }

    @Step("Get actual collection item names on page")
    public List<String> getSortListItemName() {
        List<WebElement> listItemName = driver.findElements(ITEM_NAME);
        List<String> allItemNameList = listItemName.stream().map(WebElement::getText).toList();
        return allItemNameList;
    }

    public void back()  {
        driver.navigate().back();
    }
}