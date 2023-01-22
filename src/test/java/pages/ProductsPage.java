package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends BasePage {
    @FindBy(css = ".shopping_cart_link")
    private WebElement SHOPPING_CART_BUTTON;
    private final static String ITEM_CONTAINER_LOCATOR = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='inventory_item']";
    private final static By ADD_TO_CART_BUTTON = By.xpath(".//button[text()='Add to cart']");
    private final static By ITEM_PRICE = By.xpath(".//div[@class='inventory_item_price']");
    private final static By ITEM_NAME = By.cssSelector(".inventory_item_name");
    private final static By ITEM_DESCRIPTION = By.cssSelector(".inventory_item_desc");
    private final static By ITEM_BUTTON = By.xpath(".//div[@class='inventory_item_name']/ancestor::a");
    @FindBy(className = "product_sort_container")
    private WebElement DROPDOWN;
    @FindBy(css = "#react-burger-menu-btn")
    private WebElement BURGER_BUTTON;
    @FindBy(css = "#logout_sidebar_link")
    private WebElement LOGOUT_BUTTON;

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Is present dropdown button on the products page")
    public boolean isDropdownPresent()  {
        try {
            logger.info("Is present dropdownButton");
             DROPDOWN.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("Get item name in container")
    public String getItemPrice(String itemName)   {
        logger.info("Getting itemPrice by name value {}", itemName);
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_PRICE).getText();
    }

    @Step("Get item description in container")
    public String getItemDescription(String itemName) {
        logger.info("Getting itemDescription by name value {}", itemName);
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_DESCRIPTION).getText();
    }

    @Step("Click on add to cart button in container in the products page")
    public void clickAddToCartButton(String itemName)   {
        logger.info("Clicking addToCartButton by name {}", itemName);
        driver.findElement(getItemContainerByName(itemName)).findElement(ADD_TO_CART_BUTTON).click();
    }

    @Step("Click on item name for open item page")
    public ItemPage openItem(String itemName) {
        logger.info("Clicking item link by name {}", itemName);
        driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_BUTTON).click();
        return new ItemPage(driver);
    }

    @Step("Get item container by name")
    private By getItemContainerByName(String itemName)    {
        logger.info("Getting itemContainerByName {}", itemName);
        return By.xpath(String.format(ITEM_CONTAINER_LOCATOR, itemName));
    }

    @Step("Click burger button")
    public ProductsPage clickBurgerButton()  {
        logger.info("Clicking burgerButton");
        BURGER_BUTTON.click();
        return this;
    }

    @Step("Click logout button")
    public LoginPage clickLogoutButton() {
        logger.info("Clicking logoutButton");
        LOGOUT_BUTTON.click();
        return new LoginPage(driver);
    }

    @Step("Click dropdown button")
    public ProductsPage clickDropdownButton()   {
        logger.info("Clicking dropdownButton");
        DROPDOWN.click();
        return new ProductsPage(driver);
    }

    @Step("Select sorting option by option name = {optionName}")
    public ProductsPage selectSortingOrderOption(String optionName) {
        logger.info("Selecting option in dropdown value{}", optionName);
        Select select = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        select.selectByVisibleText(optionName);
        return new ProductsPage(driver);
    }

    @Step("Get actual collection item names on page")
    public List<String> getSortListItemName() {
        logger.info("Getting sort item list");
        List<WebElement> listItemName = driver.findElements(ITEM_NAME);
        List<String> allItemNameList = listItemName.stream().map(WebElement::getText).toList();
        return allItemNameList;
    }

    @Override
    public boolean isPageOpen()    {
        logger.info("Is present shoppingCartButton");
        return SHOPPING_CART_BUTTON.isDisplayed();
    }

    public void back()  {
        driver.navigate().back();
    }
}