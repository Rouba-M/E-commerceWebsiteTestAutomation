package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage extends BasePage{
    public AuthenticationComponent authentication;
    public AddressesComponent addresses;
    public ShippingComponent shipping;
    public PaymentComponent payment;
    public OrderConfirmationComponent orderConfirmation;
    private By proceedToCheckoutButtonLocator=By.className("standard-checkout");


    public OrderPage(WebDriver driver) {
        super(driver);
        authentication =new AuthenticationComponent(driver);
        addresses =new AddressesComponent(driver);
        shipping =new ShippingComponent(driver);
        payment =new PaymentComponent(driver);
        orderConfirmation =new OrderConfirmationComponent(driver);

    }
    public void proceedToCheckout(){
        driver.findElement(proceedToCheckoutButtonLocator).click();
    }
}
