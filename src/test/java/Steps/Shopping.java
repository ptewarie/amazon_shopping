package Steps;

import Base.BaseUtil;
import PageObject.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import static org.junit.Assert.*;

public class Shopping extends BaseUtil {


    public Shopping(BaseUtil base) {
        this.driver = base.driver;
        this.homePage = new HomePage(driver);
        this.signInPage =   new SignInPage(driver);
        this.searchResultsPage =   new SearchResultsPage(driver);
        this.productDetailsScreenPage =   new ProductDetailsScreenPage(driver);
        this.shoppingCartPage =   new ShoppingCartPage(driver);
    }


    @Given("I have launched the shopping App")
    public void iHaveLaunchedTheShoppingApp() {
        Assert.assertTrue(homePage.isPageLoaded());
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
        signInPage.loginCustomer("******", "*********"); //ToDo: username and pw in property file

    }

    @When("I search for a 65 inch television")
    public void ISearchForA65InchTelevision() {
        homePage.searchForTvSize65();
        Assert.assertTrue(searchResultsPage.isPageLoaded());
        searchResultsPage.turnOnFilterForTvSize65();
        searchResultsPage.selectRandomTv();
    }

    @When("I add that item to the cart")
    public void IAddThatItemToTheCart() {
        Assert.assertTrue(productDetailsScreenPage.isPageLoaded());
        assertTrue(productDetailsScreenPage.productDetailsText.contains("65"));
        productDetailsScreenPage.addProductToCart();
    }

    @When("I go to shopping cart screen")
    public void IGoToShoppingCartScreen() {
        productDetailsScreenPage.goToShoppingCart();
        shoppingCartPage.isPageLoaded();
    }

    @Then("the product details should be correct")
    public void theProductDetailsShouldBeCorrect() {
        assertTrue(shoppingCartPage.getSubtotalText().contains("1 item"));

        //compare with details on the productDetailsPage
        assertTrue(shoppingCartPage.getPriceProduct().contains(productDetailsScreenPage.priceProductText));
        assertTrue(shoppingCartPage.getProductDetailsText().contains(productDetailsScreenPage.productDetailsText));
    }
}
