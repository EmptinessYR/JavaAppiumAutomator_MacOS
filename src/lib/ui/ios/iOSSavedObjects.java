package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SavedObjects;

public class iOSSavedObjects extends SavedObjects {
    static
    {
        LIST_BY_NAME_TPL = "id:{NAME_OF_LIST}";
        ARTICLE_BY_TITLE_TPL = "id:{TITLE}";
        ARTICLE_TITLE_DESCRIPTION_ID = "id:Object-oriented programming language";
        CLOSE_SYNC_MESSAGE = "id:Close";
        READING_LISTS = "xpath://XCUIElementTypeStaticText[@name='Reading lists']";
        DELETE_ARTICLE_FROM_LIST_BUTTON = "id:swipe action delete";
    }

    public iOSSavedObjects (AppiumDriver driver)
    {
        super(driver);
    }

}
