package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends BasePage{
    private By itemLocator=By.className("cart_item");
    private By trashLocator=By.className("icon-trash");
    private By emptyCartAlertLocator=By.className("alert");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }


    public void open(){
        open("/index.php?controller=order");
    }

    public boolean hasItems(int i) {
        return getNumberOfItemsListed()==i;
    }

    public int getNumberOfItemsListed(){
        return driver.findElements(itemLocator).size();
    }

    public void removeItemFromCart() {

        driver.findElement(trashLocator).click();
    }

    public boolean isCartEmpty() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartAlertLocator));
        return getNumberOfItemsListed()==0;
    }

}
