package PageObject;

import Base.BaseUtil;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;


public class HomePage extends BaseUtil {
    private AndroidDriver<AndroidElement> driver;

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(className = "android.widget.Button" )
    public AndroidElement signInButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"What are you looking for?\")" )
    public AndroidElement searchField;

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text" )
    public AndroidElement searchFieldWhenClicked;

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/chrome_action_bar_burger_icon" )
    public AndroidElement actionMenu;


    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Deliver to\")" )
    public AndroidElement deliveryAddress;

    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\"Settings button. Double tap for links to change country, sign out, and more.\")" )
    public AndroidElement settingsDrawer;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Sign out\")" )
    public AndroidElement signOutDrawer;

    @AndroidFindBy(id = "android:id/button2" )
    public AndroidElement signOutButton;

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/sign_in_button" )
    public AndroidElement alreadyCustomerSignInButton;

    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/search_right_cam_img" )
    public AndroidElement cameraButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Filters\")" )
    public AndroidElement filterButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"60-69 in\")" )
    public AndroidElement tvItem;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"LED\")" )
    public AndroidElement LEDButton;


    public boolean isHomePageLoaded(){
        boolean status = false;
        try {
        this.searchField.isDisplayed();
        status = true;
        } catch (Exception e) {
            System.out.println("page is not loaded :"+ e);
        }
        return status;

    }
    public void goToSignInScreen(){
        this.signInButton.click();
    }

    public void searchForTvSize65(){
        WebDriverWait wait = new WebDriverWait(this.driver, 10000);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(this.searchField)));
        this.searchField.click();
        this.searchFieldWhenClicked.sendKeys("tv 65 inch"); //todo: hard coded
        this.driver.getKeyboard().sendKeys(Keys.ENTER);
    }
    public void turnOnFilterForTvSize65() {
        this.filterButton.click();

        new TouchAction(this.driver)
                .press(ElementOption.element(this.LEDButton))
                .waitAction(waitOptions(Duration.ofMillis(2000)))
                .moveTo(ElementOption.element(this.cameraButton)).release().perform();
                this.tvItem.click();
    }

    public void logOutCustomer(){
        this.actionMenu.click();
        this.settingsDrawer.click();
        this.signOutDrawer.click();
        this.signOutButton.click();
        this.alreadyCustomerSignInButton.click();
    }

}
