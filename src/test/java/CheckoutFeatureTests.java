import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;
import services.CartServices;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CheckoutFeatureTests extends BaseTests {

    @Test
    @DisplayName("Test completing purchase after signing in from Checkout page")
    void testSuccessfulCheckout_SignInDuringProcess() {
        // Add item to cart via web service call
        new CartServices(driver).addItemToCart(driver,"Printed Chiffon Dress");

        //Go to Cart Url
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.open();

        //Proceed to Checkout
        OrderPage orderPage = new OrderPage(driver);
        orderPage.proceedToCheckout();

        //Sign in
        orderPage.authentication.signIn("rouba.maamary7@gmail.com","test5");


        //Proceed from Address to shipping tab and accept terms of service
        orderPage.addresses.proceedToCheckout();
        new ShippingComponent(driver).acceptTermsOfService();

        //Proceed to Payment tab to fill info and confirm order
        orderPage.proceedToCheckout();
        orderPage.payment.payByCheck();
        orderPage.payment.confirmOrder();


        // Assert purchase is completed successfully
        assertTrue(orderPage.orderConfirmation.isSuccessMessageDisplayed());


    }

}
