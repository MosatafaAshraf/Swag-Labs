package Helper;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.net.MalformedURLException;
import java.net.URL;


public class Browser {

    // Log4j source code doesn't allow singletons to be created, so an instance of the logger should ve created for each class
    private static final Logger logger = LogManager.getLogger(Browser.class);

    public RemoteWebDriver _driver;
    private String baseUrl;

    private void setBaseUrl(String baseUrl){
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl(){
        return this.baseUrl;
    }

    public void navigate_to_url(String url){
        logger.info(String.format("Navigating to %s ...", url));
        _driver.get(url);
    }

    public String get_current_url(){
        return _driver.getCurrentUrl();
    }

    public void click_on_element(@NotNull WebElement element){
        element.click();
    }

    public void send_key(@NotNull WebElement element, String key){
        element.sendKeys(key);
    }

    public Browser(String baseUrl) throws MalformedURLException {
        setBaseUrl(baseUrl);
        Initialize();
    }

    private void Initialize() throws MalformedURLException {
        logger.info("Start to Initialize the browser ...");
        String remote_url = "http://localhost:4444";
        ChromeOptions options = new ChromeOptions();
        if (_driver == null) {
            _driver = new RemoteWebDriver(new URL(remote_url), options);
        }
        _driver.get(this.baseUrl);
        logger.info("Browser is initialized and navigated to login page of Swag-Labs website ....");
    }

    public void quit(){
        logger.info("Closing the browser ...");
        _driver.quit();
        logger.info("Browser closed");
    }
}