package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationComponent extends BasePage {
   private By emailLocator=By.id("email");
   private By passwordLocator=By.id("passwd");
   private By signInButtonLocator=By.id("SubmitLogin");


    public AuthenticationComponent(WebDriver driver) {
        super(driver);
    }

    public void signIn(String email, String password){
        fillField(emailLocator,email);
        fillField(passwordLocator, password);
        click(signInButtonLocator);

    }
}
