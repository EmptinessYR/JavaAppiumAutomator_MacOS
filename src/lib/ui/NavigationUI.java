package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject {

   private static final String
      SAVED_OBJECTS = "xpath://android.widget.FrameLayout[@content-desc=\"Saved\"]/android.widget.FrameLayout/android.widget.ImageView";

   public NavigationUI (AppiumDriver driver)
   {
      super(driver);
   }

   public void clickMySavedObjects ()
   {
      //Выходим в сохраненные объекты
      this.waitForElementAndClick(
              SAVED_OBJECTS,
              "Cannot find Saved objects",
              5
      );
   }
}
