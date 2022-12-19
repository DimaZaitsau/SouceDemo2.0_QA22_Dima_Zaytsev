package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Sotring extends BasePage   {

    Select select = new Select(driver.findElement(By.className("product_sort_container")));
    List<WebElement> allSorting = select.getOptions();



    public Sotring(WebDriver driver)    {
        super(driver);
    }


    public void dropdownOption()   {
        Assert.assertEquals(allSorting.get(0).getText(), "Name (A to Z)");
        Assert.assertEquals(allSorting.get(1).getText(), "Name (Z to A)");
        Assert.assertEquals(allSorting.get(2).getText(), "Price (low to high)");
        Assert.assertEquals(allSorting.get(3).getText(), "Price (high to low)");
    }

    public void clickFistSorting()  {
        allSorting.get(0).click();
    }
    public void clickSecondSorting()    {
        allSorting.get(1).click();
    }
    public void clickThirdSorting() {
        allSorting.get(2).click();
    }
    public void clickFourthSoring() {
        allSorting.get(3).click();
    }
}