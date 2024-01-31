package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Browser {
    public WebDriver _driver;
    private String baseUrl;

    private void setBaseUrl(String baseUrl){
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl(){
        return this.baseUrl;
    }

    public Browser(String baseUrl){
        setBaseUrl(baseUrl);
        Initialize();
    }

    private void Initialize(){
        String seleniumFolderPath = "c/";
        System.setProperty("Webdriver.chrome.driver", seleniumFolderPath);
        _driver = new ChromeDriver();
        _driver.get(this.baseUrl);
        System.out.println("Browser is initialized and navigated to login page of Swag-Labs website ....");
    }
}