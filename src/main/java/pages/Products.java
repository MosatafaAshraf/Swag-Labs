package  pages;


import Helper.Browser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

public class Products extends Browser {

    private static final Logger logger = LogManager.getLogger(Products.class);

    @FindBy(className = "title")
    public static WebElement products_title;

    @FindBy(id = "react-burger-menu-btn")
    public static WebElement sidebar_button;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public static WebElement add_backpack_To_Cart;

    @FindBy(id = "remove-sauce-labs-backpack")
    public static WebElement remove_backpack_from_cart;

    public Products(String baseUrl) throws MalformedURLException {
        super(baseUrl);
    }

    public void add_to_cart(){
        logger.info("Clicking on add to cart to the backpack item ...");
        click_on_element(add_backpack_To_Cart);
    }

    public void expand_sidebar(){
        click_on_element(sidebar_button);
    }
}