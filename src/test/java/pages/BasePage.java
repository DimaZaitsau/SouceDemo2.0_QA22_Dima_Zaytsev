package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    public abstract boolean isPageOpen();
    public BasePage(WebDriver driver)   {
        this.driver = driver;
    }

}