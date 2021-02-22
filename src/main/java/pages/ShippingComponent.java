package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingComponent extends BasePage {
    private By termsOfServicesLocator=By.id("cgv");

    public ShippingComponent(WebDriver driver) {
        super(driver);
    }
    public void acceptTermsOfService(){
        click(termsOfServicesLocator);
    }
}
