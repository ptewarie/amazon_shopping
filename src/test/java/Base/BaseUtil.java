package Base;

import PageObject.HomePage;
import PageObject.SignInPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseUtil {

    public AndroidDriver<AndroidElement> driver;
    protected HomePage homePage;
    protected SignInPage signInPage;

}


