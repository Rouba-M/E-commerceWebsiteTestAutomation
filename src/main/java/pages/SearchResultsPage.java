package pages;

import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage{

    public ProductsList products;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
        products =new ProductsList(driver);
    }
}
