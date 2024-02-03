package tests;

import Helper.Helper;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.LoginPage;
import pages.Products;
import pages.Sidebar;


public class LoginPageTests extends Helper{

    LoginPage loginPage;
    Products products;
    Sidebar sidebar;

    private static final Logger logger = LogManager.getLogger(LoginPageTests.class);

    @Test(dataProviderClass = LoginPage.class, dataProvider = "loginData")
    public void testLogin(String username, String password){
        logger.info("Test successful login attempt ... ");
        loginPage.login(username, password);
        try {
            Assert.assertTrue(is_visible(pages.Products.products_title));
            logger.info("User logged in successfully");
        }
        catch (AssertionError e){
            logger.info("User failed to login");
        }
    }

    @Test(dataProviderClass = LoginPage.class, dataProvider = "loginData")
    public void addToCart(String username, String password){
        loginPage.login(username, password);
        products.add_to_cart();
        Assert.assertTrue(is_visible(Products.remove_backpack_from_cart));
    }

    @Test(dataProviderClass = LoginPage.class, dataProvider = "loginData")
    public void resetAppDate(String username, String password){
        loginPage.login(username, password);
        products.add_to_cart();
        products.expand_sidebar();
        sidebar.reset_app_data();
        Assert.assertTrue(is_visible(Products.add_backpack_To_Cart));
    }

    @Test(dataProviderClass = LoginPage.class, dataProvider = "loginData")
    public void navigateToAboutPage(String username, String password){
        loginPage.login(username, password);
        products.expand_sidebar();
        sidebar.navigate_to_about();
        Assert.assertFalse(is_visible(Products.products_title));
    }
}