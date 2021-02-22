import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.ShoppingCartPage;
import services.CartServices;


import static org.junit.jupiter.api.Assertions.assertTrue;


public class ShoppingCartFeatureTests extends BaseTests {


    @Test
    @DisplayName("Test item added to cart is listed in Cart Page")
    public void testAddedItemShowsInCartPage() {
        //Add an item to Cart page
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.products.addRandomItem();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.open();

        //Assert item shows in cart Page
        assertTrue(shoppingCartPage.hasItems(1),"Shopping Cart has not the item added");
    }

    @Test
    @DisplayName("Test item can be removed successfully from cart")
    public void testSuccessfulItemRemoval() {
        // Add item to cart via web service call
         new CartServices(driver).addItemToCart(driver,"Printed Chiffon Dress");

        //Go to Cart Url
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.open();

        //Remove item from cart
        shoppingCartPage.removeItemFromCart();

        //Assert item is removed successfully from cart
        assertTrue(shoppingCartPage.isCartEmpty(),"Shopping Cart is not empty!");

    }


}
