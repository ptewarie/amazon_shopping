package Steps;

import Base.BaseUtil;
import PageObject.HomePage;
import PageObject.SearchResultsPage;
import PageObject.SignInPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class Shopping extends BaseUtil {


    public Shopping(BaseUtil base) {
        this.driver = base.driver;
        this.homePage = new HomePage(driver);
        this.signInPage =   new SignInPage(driver);
    }


    @Given("I have launched the shopping App")
    public void iHaveLaunchedTheShoppingApp() {
        Assert.assertTrue(homePage.isHomePageLoaded());
    }

    @When("the customer is logged out")
    public void theCustomerIsLoggedOut() {
        try {
            homePage.goToSignInScreen();
        }
        catch (NoSuchElementException e) {
            homePage.logOutCustomer();
        }

    }

    @When("I log in the amazon app")
    public void ILogInTheAmazonApp() {
        signInPage.loginCustomer("*****", "*****"); //ToDo: username and pw in property file

    }

    @When("I search for a 65 inch television")
    public void ISearchForA65InchTelevision() {
        homePage.searchForTvSize65();
        SearchResultsPage searchResultsPage =   new SearchResultsPage(driver);
        searchResultsPage.turnOnFilterForTvSize65();
        searchResultsPage.selectRandomTv();
    }



}
