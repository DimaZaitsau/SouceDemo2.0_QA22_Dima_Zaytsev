package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final static By USERNAME_INPUT_LOCATOR = By.cssSelector("#user-name");
    private final static By PASSWORD_INPUT = By.cssSelector("#password");
    private final static By LOGIN_BUTTON = By.cssSelector("#login-button");
    private final static By ERROR_MESSAGE_CONTAINER = By.cssSelector(".error-message-container");
    private final static By BURGER_BUTTON = By.cssSelector("#react-burger-menu-btn");
    private final static By LOGOUT_BUTTON = By.cssSelector("#logout_sidebar_link");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton()  {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void setUsername(String username)   {
        driver.findElement(USERNAME_INPUT_LOCATOR).sendKeys(username);
    }

    public void setPassword(String password)    {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public String getErrorMessageText()  {
        return driver.findElement(ERROR_MESSAGE_CONTAINER).getText();
    }

    public void clickBurgerButton()  {
        driver.findElement(BURGER_BUTTON).click();
    }

    public void clickLogoutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
    }

    public boolean isLoginButtonPresent()   {
        try {
            driver.findElement(LOGIN_BUTTON);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }
}