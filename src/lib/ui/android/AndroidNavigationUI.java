package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;

public class AndroidNavigationUI extends NavigationUI {

static {
    SAVED_OBJECTS = "xpath://android.widget.FrameLayout[@content-desc=\"Saved\"]/android.widget.FrameLayout/android.widget.ImageView";
}

    public AndroidNavigationUI (AppiumDriver driver)
    {
        super(driver);
    }
}
