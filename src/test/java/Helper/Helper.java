package Helper;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import java.net.MalformedURLException;
import pages.Products;
import pages.Sidebar;


public class Helper{

    Browser browser;
    Products products;

    @BeforeTest
    private void setUp() throws MalformedURLException {
        browser = new Browser("https://www.saucedemo.com/");
    }

    @AfterClass
    private void logout(){
        products.expand_sidebar();
        click_on_element(Sidebar.logout_button);
    }

    @AfterTest
    private void tearDown(){
        browser.quit();
    }

    private String get_current_url(){
        return browser.get_current_url();
    }

    private void navigate_to_url(String url){
        browser.navigate_to_url(url);
    }

    private void click_on_element(WebElement element){
        browser.click_on_element(element);
    }

    public boolean is_visible(@NotNull WebElement element){
        return element.isDisplayed();
    }
}