package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasketPage    {
    @FindBy(id = "first-name")
    private WebElement FIRST_NAME_INPUT;
    @FindBy(id = "last-name")
    private WebElement LAST_NAME_INPUT;
    @FindBy(id = "postal-code")
    private WebElement ZIP_CODE_INPUT;
    @FindBy(id = "continue")
    private WebElement CONTINUE_BUTTON;
    @FindBy(id = "cancel")
    private WebElement CANCEL_BUTTON;

    public CheckoutPage(WebDriver driver)   {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Is present first name input")
    public boolean isFirstNameInputPresent() {
        try {
            FIRST_NAME_INPUT.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("Input first name")
    public CheckoutPage setFirstNameInput(String firstName) {
        FIRST_NAME_INPUT.sendKeys(firstName);
        return this;
    }

    @Step("Input last name")
    public CheckoutPage setLastNameInput(String lastName)   {
        LAST_NAME_INPUT.sendKeys(lastName);
        return this;
    }

    @Step("Input zip code")
    public CheckoutPage setZipCodeInput(String zipCode) {
        ZIP_CODE_INPUT.sendKeys(zipCode);
        return this;
    }

    @Step("Click continue button")
    public CheckoutOverviewPage clickContinueButton()   {
        CONTINUE_BUTTON.click();
        return new CheckoutOverviewPage(driver);
    }

    @Step("Click cancel button")
    public BasketPage clickCancelButton() {
        CANCEL_BUTTON.click();
        return new BasketPage(driver);
    }

    @Override
    public boolean isPageOpen() {
        return CONTINUE_BUTTON.isDisplayed();
    }
}