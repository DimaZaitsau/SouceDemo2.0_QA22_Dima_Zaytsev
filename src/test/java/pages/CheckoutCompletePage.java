package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {
    private final static By FINISH_TEXT = By.xpath("//h2[@class='complete-header']");
    private final static By BACK_HOME_BUTTON = By.id("back-to-products");


    public CheckoutCompletePage(WebDriver driver)  {
        super(driver);
    }

    @Step("Is present finish text")
    public boolean isFinishTextPresent()    {
        try {
            driver.findElement(FINISH_TEXT);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step("Click back home button")
    public void clickBackHomeButton()   {
        driver.findElement(BACK_HOME_BUTTON).click();
    }
}