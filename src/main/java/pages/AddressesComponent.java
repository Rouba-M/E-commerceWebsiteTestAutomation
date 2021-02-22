package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressesComponent extends BasePage {

    private By proceedToCheckoutButtonLocator=By.name("processAddress");

    public AddressesComponent(WebDriver driver) {
        super(driver);
    }
    public void proceedToCheckout(){
        driver.findElement(proceedToCheckoutButtonLocator).click();
    }
}
