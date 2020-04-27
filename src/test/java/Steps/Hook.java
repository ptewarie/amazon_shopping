package Steps;

import Base.BaseUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitialiseTest() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "test_pixel"); //these can all be moved to process env
        cap.setCapability("appPackage", "com.amazon.mShop.android.shopping");
        cap.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
        cap.setCapability("noReset", true);
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        base.driver = driver;
    }

    @After
    public void TearDownTest(Scenario scenario) {

        if (scenario.isFailed()) {
            takeScreenShot(scenario);
            System.out.println("Scenario : " + scenario.getName() + " has failed! ");
        } else {
            System.out.println("Scenario passed");
        }
        base.driver.quit();
        System.out.println("Report can be found under : target/site/cucumber-pretty/index.html");
    }

    public void takeScreenShot(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) base.driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png", scenario.getName());
    }

}
