package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasketPage    {
    private final static By FIRST_NAME_INPUT = By.id("first-name");
    private final static By LAST_NAME_INPUT = By.id("last-name");
    private final static By ZIP_CODE_INPUT = By.id("postal-code");
    private final static By CONTINUE_BUTTON = By.id("continue");
    private final static By CANCEL_BUTTON =By.id("cancel");

    public CheckoutPage(WebDriver driver)   {
        super(driver);
    }

    public boolean firstNameInput() {
        try {
            driver.findElement(FIRST_NAME_INPUT).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    public void setFirstNameInput(String firstName) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
    }

    public void setLastNameInput(String lastName)   {
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
    }

    public void setZipCodeInput(String zipCode) {
        driver.findElement(ZIP_CODE_INPUT).sendKeys(zipCode);
    }

    public void clickContinueButton()   {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void clickCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }
}