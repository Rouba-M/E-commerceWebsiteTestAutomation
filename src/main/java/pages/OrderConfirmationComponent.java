package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationComponent extends BasePage{
    private By successMessageLocator=By.className("alert-success");

    public OrderConfirmationComponent(WebDriver driver) {
        super(driver);
    }

    public boolean isSuccessMessageDisplayed() {
      return   driver.findElement(successMessageLocator).isDisplayed();
    }
}
