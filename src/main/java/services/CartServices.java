package services;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utils.Links;
import utils.Products;

public class CartServices {
    public WebDriver driver;

    public CartServices(WebDriver driver) {
        this.driver = driver;
    }

    public  static void addItemToCart(WebDriver driver,String productName){
        int productID= Products.getProductID(productName);
        String postUrl=String.format("%s?controller=cart&add=1&id_product=%d&token=e817bb0705dd58da8db074c69f729fd8", Links.HOME,productID);
        BasePage basePage = new BasePage(driver);
        basePage.goTo(postUrl);
        basePage.refreshPage();

    }
}
