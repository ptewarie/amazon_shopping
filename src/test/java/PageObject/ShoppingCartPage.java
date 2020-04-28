package PageObject;

import Base.BaseUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ShoppingCartPage extends BaseUtil {
    private AndroidDriver<AndroidElement> driver;


    public ShoppingCartPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Proceed to Checkout\")" )
    public AndroidElement proceedToCheckOutButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Subtotal\")" )
    public AndroidElement subtotalText;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"$\")" )
    public AndroidElement priceProduct;

    @AndroidFindBy(id  = "olpProductMobileBack" )
    public AndroidElement productDetailsText;

    public boolean isPageLoaded(){
        boolean status = false;


        try {
            WebDriverWait wait = new WebDriverWait(this.driver, 10000);
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(this.proceedToCheckOutButton)));
            this.proceedToCheckOutButton.isDisplayed();
            status = true;
        } catch (Exception e) {
            System.out.println("page is not loaded :"+ e);
        }
        return status;

    }

    public String getSubtotalText(){
        return this.subtotalText.getText();
    }

    public String getPriceProduct(){
        return this.priceProduct.getText();
    }

    public String getProductDetailsText(){
        return this.productDetailsText.getText();
    }


}
