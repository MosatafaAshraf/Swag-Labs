package Helper;

import Helper.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;


public class Helper{

    Browser browser;
    public void setUp(){
        browser = new Browser("https://www.saucedemo.com/");
    }
    private String get_current_url(){
        return browser.get_current_url();
    }

    private void navigate_to_url(String url){
        browser.naviagte_to_url(url);
    }
}