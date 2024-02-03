package  pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products {

    @FindBy(className = "title")
    public static WebElement products_title;
}