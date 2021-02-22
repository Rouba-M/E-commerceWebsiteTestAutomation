package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentComponent extends BasePage{
    private By payByCheckLocator=By.className("cheque");
    private By confirmOrderButtonLocator=By.cssSelector("#cart_navigation button[type='submit']");

    public PaymentComponent(WebDriver driver) {
        super(driver);
    }
    public void payByCheck(){
    click(payByCheckLocator);
    }

    public void confirmOrder(){
        click(confirmOrderButtonLocator);
    }
}
