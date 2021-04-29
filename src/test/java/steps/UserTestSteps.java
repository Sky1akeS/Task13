package steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import pageObject.BasePage;
import pageObject.MainPage;
import pageObject.SearchPage;

import java.util.concurrent.TimeUnit;

public class UserTestSteps extends BasePage {
    @Given("^open Amazon website$")
    public void openAmazon(){
        System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @When("^enter a product \"(.+)\" and proceed to search results$")
    public void searchResults(String product) {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage()
                .findSearchField()
                .searchForProduct(product);
    }

    @Then("^find the desired product \"(.+)\", click \"Buy now\"$")
    public void iFindTheDesiredProductAndClick(String product) {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.clickCurrentProduct(product)
                .findButtonToBuy()
                .clickToBuy()
                .verifyButtonAccount();
    }
    @And("^close browser$")
    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
    }

}
