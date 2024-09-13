package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class CoreTestCase extends TestCase {

    private static final String PLATFORM_IOS = "iOS";
    private static final String PLATFORM_ANDROID = "Android";

    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/";

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        DesiredCapabilities capabilities = this.getCapabilitiesByPlatformEnv();

        driver = new AndroidDriver(new URL(AppiumURL), capabilities);
        this.rotateScreenPortrait();

    }

    @Override
    protected void tearDown() throws Exception {
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.quit();

        super.tearDown();
    }

    protected void rotateScreenPortrait() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backgroundApp(int seconds) {
        driver.runAppInBackground(Duration.ofSeconds(seconds));
    }

    private DesiredCapabilities getCapabilitiesByPlatformEnv() throws Exception {
        String platform = System.getenv("PLATFORM");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (platform.equals(PLATFORM_ANDROID)) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("appium:deviceName", "and80_automator");
            capabilities.setCapability("appium:platformVersion", "8.0.0");
            capabilities.setCapability("appium:automationName", "UiAutomator2");
            capabilities.setCapability("appium:appPackage", "org.wikipedia");
            capabilities.setCapability("appium:appActivity", ".main.MainActivity");
            capabilities.setCapability("appium:app", "/Users/admin/IdeaProjects/JavaAppiumAutomation/apks/org.wikipedia_50492_apps.evozi.com.apk");
        } else if (platform.equals(PLATFORM_IOS)) {

            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("appium:deviceName", "iPhone 15 Pro");
            capabilities.setCapability("appium:platformVersion", "17.5");
            capabilities.setCapability("appium:app", "/Users/admin/Documents/Wikipedia.app");
            capabilities.setCapability("appium:automationName", "XCUITest");
        } else {
            throw new Exception("Cannot get run platform from env variable. Platform value " + platform);
        }

        return capabilities;
    }

}
