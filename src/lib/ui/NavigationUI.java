package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class NavigationUI extends MainPageObject {

   protected static String
      SAVED_OBJECTS;

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
