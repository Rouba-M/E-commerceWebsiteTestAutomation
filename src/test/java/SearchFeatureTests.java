import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SearchResultsPage;

import static org.junit.jupiter.api.Assertions.*;

public class SearchFeatureTests extends BaseTests {


    @Test
    @DisplayName("Test searched product is listed in results page")
    public void testSearchForProduct() {
        String productName="Blouse";
        HomePage homePage=new HomePage(driver);
        homePage.open();
        homePage.search(productName);

      assertTrue(new SearchResultsPage(driver).products.isProductListed(productName), "Product is not listed in Search Results!");


    }




}
