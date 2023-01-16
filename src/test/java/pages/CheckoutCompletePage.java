package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BasePage {
    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement FINISH_TEXT;
    @FindBy(id = "back-to-products")
    private WebElement BACK_HOME_BUTTON;


    public CheckoutCompletePage(WebDriver driver)  {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Click back home button")
    public ProductsPage clickBackHomeButton()   {
        BACK_HOME_BUTTON.click();
        return new ProductsPage(driver);
    }

    @Override
    public boolean isPageOpen() {
        return BACK_HOME_BUTTON.isDisplayed();
    }
}