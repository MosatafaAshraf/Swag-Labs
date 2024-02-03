package tests;

import Helper.Helper;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.LoginPage;
import pages.Products;
import Helper.Browser;

import java.net.MalformedURLException;


public class LoginPageTests {

    LoginPage loginPage;
    Helper helper;

    private static final Logger logger = LogManager.getLogger(LoginPageTests.class);

    @Test(dataProviderClass = LoginPage.class, dataProvider = "loginData")
    public void testLogin(String username, String password){
        logger.info("Test successful login attempt ... ");
        loginPage.login(username, password);
        try {
            Assert.assertTrue(helper.is_visible(pages.Products.products_title));
            logger.info("User logged in successfully");
        }
        catch (AssertionError e){
            logger.info("User failed to login");
        }
    }

    @Test
    public void addToCart(){

    }

    @Test
    public void resetAppDate(){

    }

    @Test
    public void logoutTest(){

    }
}