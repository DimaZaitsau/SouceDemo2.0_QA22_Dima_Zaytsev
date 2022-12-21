package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsPage extends BasePage {
    private final static By SHOPPING_CART_BUTTON =By.cssSelector(".shopping_cart_link");
    private final static String ITEM_CONTAINER_LOCATOR = "//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='inventory_item']";
    private final static By ADD_TO_CART_BUTTON = By.xpath(".//button[text()='Add to cart']");
    private final static By ITEM_PRICE = By.xpath(".//div[@class='inventory_item_price']");
    private final static By ITEM_NAME = By.cssSelector(".inventory_item_name");
    private final static By ITEM_DESCRIPTION = By.cssSelector(".inventory_item_desc");
    private final static By ITEM_BUTTON = By.xpath(".//div[@class='inventory_item_name']/ancestor::a");
    private final static By DROPDOWN = By.className("product_sort_container");
    private final static By BURGER_BUTTON = By.cssSelector("#react-burger-menu-btn");
    private final static By LOGOUT_BUTTON = By.cssSelector("#logout_sidebar_link");
    private final static By SELECT_A_TO_Z = By.xpath("//option[@value='az']");
    private final static By SELECT_Z_TO_A = By.xpath("//option[@value='za']");
    private final static By SELECT_LOW_TO_HIGH = By.xpath("//option[@value='lohi']");
    private final static By SELECT_HIGH_TO_LOW = By.xpath("//option[@value='hilo']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public boolean isDropdownPresent()  {
        try {
            driver.findElement(DROPDOWN);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }
    public boolean isShoppingCartButtonPresent()    {
        try {
            driver.findElement(SHOPPING_CART_BUTTON);
        } catch (NoSuchElementException ex)  {
            return false;
        }
        return true;
    }

    public String getItemPrice(String itemName)   {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_PRICE).getText();
    }

    public String getItemDescription(String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_DESCRIPTION).getText();
    }

    public void clickAddToCartButton(String itemName)   {
        driver.findElement(getItemContainerByName(itemName)).findElement(ADD_TO_CART_BUTTON).click();
    }

    public void openItem(String itemName) {
        driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_BUTTON).click();
    }

    private By getItemContainerByName(String itemName)    {
        return By.xpath(String.format(ITEM_CONTAINER_LOCATOR, itemName));
    }

    public void clickBurgerButton()  {
        driver.findElement(BURGER_BUTTON).click();
    }

    public void clickLogoutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
    }

    public void clickSelectAToZ()   {
        driver.findElement(SELECT_A_TO_Z).click();
    }

    public void clickSelectZToA()   {
        driver.findElement(SELECT_Z_TO_A).click();
    }

    public void clickSelectLowToHigh()    {
        driver.findElement(SELECT_LOW_TO_HIGH).click();
    }

    public void clickSelectHighToLow()    {
        driver.findElement(SELECT_HIGH_TO_LOW).click();
    }

    public ArrayList<String> sortListItemNameAToZ() {
        ArrayList<String> allList1 = new ArrayList<>();
        List<WebElement> listItemName1 = driver.findElements(ITEM_NAME);

        for (int i = 0; i < listItemName1.size(); i++)   {
            allList1.add(listItemName1.get(i).getText());
        }
        Collections.sort(allList1);
        return allList1;
    }

    public ArrayList<String> sortListItemNameZToA() {
        ArrayList<String> allList2 = new ArrayList<>();
        List<WebElement> listItemName2 = driver.findElements(ITEM_NAME);

        for (int i = 0; i < listItemName2.size(); i++)   {
            allList2.add(listItemName2.get(i).getText());
        }
        Collections.sort(allList2);
        return allList2;
    }

    public ArrayList<String> sortListItemNameLowToHigh() {
        ArrayList<String> allList3 = new ArrayList<>();
        List<WebElement> listItemName3 = driver.findElements(ITEM_NAME);

        for (int i = 0; i < listItemName3.size(); i++)   {
            allList3.add(listItemName3.get(i).getText());
        }
        Collections.sort(allList3);
        return allList3;
    }

    public ArrayList<String> sortListItemNameHighToLow() {
        ArrayList<String> allList4 = new ArrayList<>();
        List<WebElement> listItemName4 = driver.findElements(ITEM_NAME);

        for (int i = 0; i < listItemName4.size(); i++)   {
            allList4.add(listItemName4.get(i).getText());
        }
        Collections.sort(allList4);
        return allList4;
    }

    public void back()  {
        driver.navigate().back();
    }
}