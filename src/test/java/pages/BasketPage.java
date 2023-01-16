package pages;

import io.qameta.allure.Step;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage extends BasePage{

    @FindBy(className = "inventory_item_name")
    private WebElement ITEM_NAME;
    @FindBy(css = ".inventory_item_desc")
    private WebElement ITEM_DESCRIPTION;
    @FindBy(css = ".inventory_item_price")
    private WebElement ITEM_PRICE;
    @FindBy(id = "checkout")
    private WebElement CHECKOUT_BUTTON;
    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small cart_button']")
    private WebElement REMOVE_BUTTON;
    @FindBy(id = "continue-shopping")
    private WebElement CONTINUE_SHOPPING_BUTTON;
    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement NUMBER_OF_ITEMS_IN_BASKET;

    public BasketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Get item name")
    public String getItemName(String itemName)  {
        return ITEM_NAME.getText();
    }

    @Step("Get item description")
    public String getItemDescription(String itemName)   {
        return ITEM_DESCRIPTION.getText();
    }

    @Step("Get item price")
    public String getItemPrice(String itemName) {
        return ITEM_PRICE.getText();
    }

    @Step("Click checkout button")
    public CheckoutPage clickCheckoutButton()    {
        CHECKOUT_BUTTON.click();
        return new CheckoutPage(driver);
    }

    @Step("Click remove button")
    public BasketPage clickRemoveButton()  {
        REMOVE_BUTTON.click();
        return new BasketPage(driver);
    }

    @Step("Click continue shopping button")
    public ProductsPage clickContinueShoppingButton()    {
        CONTINUE_SHOPPING_BUTTON.click();
        return new ProductsPage(driver);
    }

    @Step("Have some items in basket")
    public boolean numberOfItemsInBasket()  {
        try {
            NUMBER_OF_ITEMS_IN_BASKET.isDisplayed();
        }   catch (NoSuchElementException ex)   {
            return false;
        }
        return true;
    }

    @Override
    public boolean isPageOpen() {
        return CHECKOUT_BUTTON.isDisplayed();
    }
}