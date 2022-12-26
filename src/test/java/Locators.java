import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Locators {
    WebElement driver;

    public void locators()  {
        WebElement continueButton = driver.findElement(By.id("continue"));
        WebElement cancelButton = driver.findElement(By.name("cancel"));
        WebElement zipCodeInput = driver.findElement(By.className("input_error form_input"));
        WebElement input = driver.findElement(By.tagName("input"));

//        xpath
        WebElement burgerMenu = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        WebElement descriptionItem = driver.findElement(By.xpath("//div[text()='carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.']"));
        WebElement checkoutButton = driver.findElement(By.xpath("//button[contains(@class,'btn btn_secondary')]"));
        WebElement itemName = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Backpack')]"));
        WebElement x = driver.findElement(By.xpath("//a[@id='item_4_title_link']/ancestor::div[@class='inventory_item_label']"));
//        WebElement a = driver.findElement(By.xpath(""));
        WebElement abc7 = driver.findElement(By.xpath("//a[@id='item_4_link']/following::div"));
//        WebElement b = driver.findElement(By.xpath(""));
//        WebElement c = driver.findElement(By.xpath(""));
        WebElement ImgItem = driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack' and @class='inventory_item_img']"));


//    css
//        WebElement a = driver.findElement(By.cssSelector(""));
        WebElement op = driver.findElement(By.cssSelector(".bm-item.menu-item[style*='display']"));
        WebElement yv = driver.findElement(By.cssSelector(".bm-menu [style*='display']"));
        WebElement finishButton = driver.findElement(By.cssSelector("#finish"));
        WebElement qwe5 = driver.findElement(By.cssSelector("div"));
        WebElement itemPrice = driver.findElement(By.cssSelector("div.inventory_item_price"));
//        WebElement b = driver.findElement(By.cssSelector(""));
//        WebElement c = driver.findElement(By.cssSelector(""));
//        WebElement d = driver.findElement(By.cssSelector(""));
        WebElement imgItems = driver.findElement(By.cssSelector("img.inventory_item_img[src^='/']"));
//        WebElement e = driver.findElement(By.cssSelector(""));
//        WebElement f = driver.findElement(By.cssSelector(""));
    }
}
