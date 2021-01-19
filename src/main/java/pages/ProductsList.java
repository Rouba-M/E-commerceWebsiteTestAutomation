package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductsList extends BasePage {
    private By itemLocator = By.cssSelector(".product_list .product-container");
    private By itemNameLocator = By.cssSelector(".product-name");
    private By addToCartButtonLocator=By.cssSelector(".ajax_add_to_cart_button");
    private By addToCartCloseWindowLocator =By.className("cross");

    public ProductsList(WebDriver driver) {
        super(driver);

    }


    public void addRandomItem() {
        List<WebElement> itemsList=driver.findElements(itemLocator);
        JavascriptExecutor js=(JavascriptExecutor)driver;

        js.executeScript("arguments[0].scrollIntoView(true);",itemsList.get(0));

        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(itemLocator)).perform();
        driver.findElement(addToCartButtonLocator).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartCloseWindowLocator));
        driver.findElement(addToCartCloseWindowLocator).click();
    }

    public boolean isProductListed(String productName) {

        return findProduct(productName) != null;
    }

    private WebElement findProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));

        List<WebElement> products = driver.findElements(itemLocator);


        for (WebElement product : products) {
            String productTitle = (product.findElement(itemNameLocator).getText()).trim();
            if (productName.equalsIgnoreCase(productTitle))
                return product;
        }
        return null;
    }


}
