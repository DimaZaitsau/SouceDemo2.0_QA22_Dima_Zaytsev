package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(css = "#user-name")
    private WebElement USERNAME_INPUT_LOCATOR;
    @FindBy(css = "#password")
    private WebElement PASSWORD_INPUT;
    @FindBy(css = "#login-button")
    private WebElement LOGIN_BUTTON;
    @FindBy(css = ".error-message-container")
    private WebElement ERROR_MESSAGE_CONTAINER;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Click login button")
    public ProductsPage clickLoginButton()  {
        LOGIN_BUTTON.click();
        return new ProductsPage(driver);
    }

    @Step("Input username = {username}")
    public LoginPage setUsername(String username)   {
        USERNAME_INPUT_LOCATOR.sendKeys(username);
        return this;
    }

    @Step("Input password = {password}")
    public LoginPage setPassword(String password)    {
        PASSWORD_INPUT.sendKeys(password);
        return this;
    }

    @Step("Get error message")
    public String getErrorMessageText()  {
        return ERROR_MESSAGE_CONTAINER.getText();
    }

    @Override
    public boolean isPageOpen()    {
        return LOGIN_BUTTON.isDisplayed();
    }
}