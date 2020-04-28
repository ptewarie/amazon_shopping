package PageObject;

import Base.BaseUtil;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static io.appium.java_client.touch.WaitOptions.waitOptions;


public class ProductDetailsScreenPage extends BaseUtil {
    private AndroidDriver<AndroidElement> driver;
    public String productDetailsText;
    public String priceProductText;

    public ProductDetailsScreenPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"65\")")
    public AndroidElement titleProduct;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"See All Buying Options\")")
    public AndroidElement buyingOptionsButton;

    @AndroidFindBy(className = "android.widget.Button")
    public AndroidElement addToCartButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"$\")")
    public AndroidElement priceProduct;

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/chrome_action_bar_cart_count" )
    public AndroidElement shoppingCartIcon;

    public boolean isPageLoaded(){
        boolean status = false;


        try {
            WebDriverWait wait = new WebDriverWait(this.driver, 10000);
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(this.titleProduct)));
            this.titleProduct.isDisplayed();
            storeProductDetailsTitleText();
            status = true;
        } catch (Exception e) {
            System.out.println("page is not loaded :"+ e);
        }
        return status;

    }

    public void storeProductDetailsTitleText(){
        this.productDetailsText = this.titleProduct.getText();
    }

    public void storePriceDetails(){
        this.priceProductText = this.priceProduct.getText();
    }

    public void addProductToCart(){
        WebDriverWait wait = new WebDriverWait(this.driver, 10000);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(this.buyingOptionsButton)));
        this.buyingOptionsButton.click();
        try {
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(this.priceProduct)));
            this.priceProduct.isDisplayed();
            storePriceDetails();
            this.addToCartButton.click();
        } catch (Exception e) {
            System.out.println("page is not loaded :"+ e);
        }

    }

    public void goToShoppingCart() {
        try {
            this.shoppingCartIcon.isDisplayed();
            this.shoppingCartIcon.click();
        } catch (Exception e) {
            System.out.println("shoppingCartIcon is not loaded :" + e);
        }
    }
}
