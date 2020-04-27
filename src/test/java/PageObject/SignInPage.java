package PageObject;

import Base.BaseUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignInPage extends BaseUtil {


    private AndroidDriver<AndroidElement> driver;

    public SignInPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Sign-In\")" )
    public AndroidElement signInButton;

    @AndroidFindBy(className = "android.widget.EditText" )
    private AndroidElement emailLoginField;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Continue\")" )
    private AndroidElement continueButton;


    //    @AndroidFindBy(id = "ap_password" )
    @AndroidFindBy(className = "android.widget.EditText" )
//    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Amazon\")" )
    private AndroidElement passwordField;

    @AndroidFindBy(className = "android.widget.Button" )
    private AndroidElement signInSubmitButton;


    public void loginCustomer(String username, String password){
        WebDriverWait wait = new WebDriverWait(this.driver, 10000);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(this.emailLoginField)));
        this.emailLoginField.sendKeys(username); //todo: place in property file
        this.continueButton.click();

        try {
            Thread.sleep(2000); //todo: remove sleeper
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.passwordField.sendKeys(password); //todo: place in property file

        while(!this.signInSubmitButton.isDisplayed()){
            System.out.println("waiting for submit");
        }

        this.signInSubmitButton.click();
    }

}
