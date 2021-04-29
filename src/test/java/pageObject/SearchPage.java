package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public ProductPage clickCurrentProduct(String product){
        driver.findElement(By.partialLinkText(product)).click();
        return new ProductPage(driver);
}

}
