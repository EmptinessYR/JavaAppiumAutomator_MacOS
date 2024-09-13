package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class iOSTestCase extends TestCase {

    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/";

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","iOS");
        capabilities.setCapability("appium:deviceName","iPhone 15 Pro");
        capabilities.setCapability("appium:platformVersion","17.5");
        capabilities.setCapability("appium:app","/Users/admin/Documents/Wikipedia.app");
        capabilities.setCapability("appium:automationName", "XCUITest");

        driver = new IOSDriver(new URL(AppiumURL), capabilities);
        this.rotateScreenPortrait();

    }

    @Override
    protected void tearDown() throws Exception
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.quit();

        super.tearDown();
    }

    protected void rotateScreenPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backgroundApp (int seconds)
    {
        driver.runAppInBackground(Duration.ofSeconds(seconds));
    }

}
