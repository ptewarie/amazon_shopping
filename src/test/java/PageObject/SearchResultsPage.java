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
        int randomNumber =  r.nextInt((15 - 6) + 1) + 6; //random number between search index

        //run until the selected tv is not a sponsored advertisement, since these can be a different product
        if (this.randomTv.get(randomNumber).getText().equalsIgnoreCase("Sponsored")){
            this.selectRandomTv();
        }

        new TouchAction(this.driver)
                .press(ElementOption.element(this.randomTv.get(randomNumber)))
                .waitAction(waitOptions(Duration.ofMillis(2000)))
                .moveTo(ElementOption.element(this.cameraButton)).release().perform();

        this.randomTv.get(randomNumber).click();

    }


}
