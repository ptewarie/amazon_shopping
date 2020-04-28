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
import java.util.List;
import java.util.Random;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static jdk.nashorn.internal.objects.NativeArray.lastIndexOf;


public class SearchResultsPage extends BaseUtil {
    private AndroidDriver<AndroidElement> driver;

    public SearchResultsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/search_right_cam_img" )
    public AndroidElement cameraButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Filters\")" )
    public AndroidElement filterButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"60-69 in\")" )
    public AndroidElement tvItem;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"LED\")" )
    public AndroidElement LEDButton;

    @AndroidFindBy(className = "android.view.View" )
    public List<AndroidElement> randomTv;

    public boolean isPageLoaded(){
        boolean status = false;


        try {
            WebDriverWait wait = new WebDriverWait(this.driver, 10000);
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(this.filterButton)));
            this.filterButton.isDisplayed();
            status = true;
        } catch (Exception e) {
            System.out.println("page is not loaded :"+ e);
        }
        return status;

    }

    public void turnOnFilterForTvSize65() {
        this.filterButton.click();

        new TouchAction(this.driver)
                .press(ElementOption.element(this.LEDButton))
                .waitAction(waitOptions(Duration.ofMillis(2000)))
                .moveTo(ElementOption.element(this.cameraButton)).release().perform();
                this.tvItem.click();
    }

    public void selectRandomTv(){
        Random r = new Random();
        int randomNumber =  r.nextInt( 1) + 5; //random number between search index

        /*
        ignore advertisement
        ignore products that do not have a 65 inch screen size
        */
        if (this.randomTv.get(randomNumber).getText().equalsIgnoreCase("Sponsored") || !this.randomTv.get(randomNumber).getText().contains("65")){
            this.selectRandomTv();
        }

        new TouchAction(this.driver)
                .press(ElementOption.element(this.randomTv.get(randomNumber)))
                .waitAction(waitOptions(Duration.ofMillis(2000)))
                .moveTo(ElementOption.element(this.cameraButton)).release().perform();

        this.randomTv.get(randomNumber).click();

    }


}
