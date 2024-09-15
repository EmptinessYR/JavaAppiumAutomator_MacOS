package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.SavedObjects;
import lib.ui.android.AndroidSavedObjects;
import lib.ui.ios.iOSSavedObjects;

public class SavedObjectsFactorie
{
    public static SavedObjects get(AppiumDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidSavedObjects(driver);
        } else {
            return new iOSSavedObjects(driver);
        }
    }
}
