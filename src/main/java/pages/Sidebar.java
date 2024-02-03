package pages;

import Helper.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;


public class Sidebar extends Browser{

    public Sidebar(String baseUrl) throws MalformedURLException {
        super(baseUrl);
    }

    @FindBy(id = "reset_sidebar_link")
    public static WebElement reset_app_data_button;

    @FindBy(id = "logout_sidebar_link")
    public static WebElement logout_button;

    @FindBy( id = "about_sidebar_link")
    public static WebElement about_button;

    public void reset_app_data(){
        click_on_element(reset_app_data_button);
    }

    public void navigate_to_about(){
        click_on_element(about_button);
    }
}