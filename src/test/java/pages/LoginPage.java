package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final static By USERNAME_INPUT_LOCATOR = By.cssSelector("#user-name");
    private final static By PASSWORD_INPUT = By.cssSelector("#password");
    private final static By LOGIN_BUTTON = By.cssSelector("#login-button");
    private final static By ERROR_MESSAGE_CONTAINER = By.cssSelector(".error-message-container");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click login button")
    public void clickLoginButton()  {
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Input username = {username}")
    public void setUsername(String username)   {
        driver.findElement(USERNAME_INPUT_LOCATOR).sendKeys(username);
    }

    @Step("Input password = {password}")
    public void setPassword(String password)    {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    @Step("Get error message")
    public String getErrorMessageText()  {
        return driver.findElement(ERROR_MESSAGE_CONTAINER).getText();
    }

    @Step("Is present login button")
    public boolean isLoginButtonPresent()   {
        try {
            driver.findElement(LOGIN_BUTTON);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }
}