package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public ProductsList products;
    private By searchBoxLocator=By.className("search_query");

    public HomePage(WebDriver driver) {
        super(driver);
        products=new ProductsList(driver);

    }
    public void open(){
        open("");
    }

    public void search(String productName) {
        driver.findElement(searchBoxLocator).sendKeys(productName);
        driver.findElement(searchBoxLocator).sendKeys(Keys.ENTER);
    }
}
