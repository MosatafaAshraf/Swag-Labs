package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Browser {
    private static final Logger logger = LogManager.getLogger(Browser.class);
    public WebDriver _driver;
    private String baseUrl;

    private void setBaseUrl(String baseUrl){
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl(){
        return this.baseUrl;
    }

    public void naviagte_to_url(String url){
        _driver.get(url);
    }

    public String get_current_url(){
        return _driver.getCurrentUrl();
    }

    public Browser(String baseUrl){
        setBaseUrl(baseUrl);
        Initialize();
    }

    private void Initialize(){
        logger.info("Start to Initialize the browser ...");
        String seleniumFolderPath = "c/";
        System.setProperty("Webdriver.chrome.driver", seleniumFolderPath);
        if (_driver == null) {
            _driver = new ChromeDriver();
        }
        _driver.get(this.baseUrl);
        logger.info("Browser is initialized and navigated to login page of Swag-Labs website ....");
    }
}