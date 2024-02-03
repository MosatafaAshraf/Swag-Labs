package pages;

import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(id = "user-name")
    private static WebElement user_name_field;

    @FindBy(id = "password")
    private static WebElement password_field;

    @FindBy(id = "login-button")
    private static WebElement login_button;

    @DataProvider
    public Object [][] loginData(){
        Object [] [] data = new Object[1][2];
        data[0][0] = "problem_user";
        data[0][1] = "secret_sauce";
        return data;
    }

    public void login(String user_name, String password){
        logger.info("Enter username ...");
        user_name_field.sendKeys(user_name);
        logger.info("Enter Password ...");
        password_field.sendKeys(password);
        login_button.click();
    }
}