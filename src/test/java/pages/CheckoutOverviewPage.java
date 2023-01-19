package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends BasePage  {

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement ITEM_NAME;
    @FindBy(css = ".inventory_item_desc")
    private WebElement ITEM_DESCRIPTION;
    @FindBy(css = ".inventory_item_price")
    private WebElement ITEM_PRICE;
    @FindBy(id = "cancel")
    private WebElement CANCEL_BUTTON;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement SHOPPING_BASKET_BUTTON;
    @FindBy(id = "finish")
    private WebElement FINISH_BUTTON;

    public CheckoutOverviewPage(WebDriver driver)   {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Get item name")
    public String getItemName(String itemName)  {
        logger.info("Getting itemName");
        return ITEM_NAME.getText();
    }

    @Step("Get item description")
    public String getItemDescription(String itemName)   {
        logger.info("Getting itemDescription");
        return ITEM_DESCRIPTION.getText();
    }

    @Step("Get item price")
    public String getItemPrice(String itemName) {
        logger.info("Getting itemPrice");
        return ITEM_PRICE.getText();
    }

    @Step("Click cancel button")
    public ProductsPage clickCancelButton() {
        logger.info("Clicking cancelButton");
        CANCEL_BUTTON.click();
        return new ProductsPage(driver);
    }

    @Step("Click shopping basket button")
    public BasketPage clickShoppingBasketButton() {
        logger.info("Clicking shoppingBasketButton");
        SHOPPING_BASKET_BUTTON.click();
        return new BasketPage(driver);
    }

    @Step("Click finish button")
    public CheckoutCompletePage clickFinishButton() {
        logger.info("Clicking finishButton");
        FINISH_BUTTON.click();
        return new CheckoutCompletePage(driver);
    }

    @Override
    public boolean isPageOpen() {
        logger.info("Is present finishButton");
        return FINISH_BUTTON.isDisplayed();
    }
}