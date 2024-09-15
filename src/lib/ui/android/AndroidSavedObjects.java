package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SavedObjects;

public class AndroidSavedObjects extends SavedObjects {

    static
    {
        LIST_BY_NAME_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_title' and @text='{LIST_NAME}']";
        ARTICLE_BY_TITLE_TPL = "xpath://*[@text='{TITLE}']";
        ARTICLE_TITLE_DESCRIPTION_ID = "id:org.wikipedia:id/page_list_item_description";
    }

    public AndroidSavedObjects (AppiumDriver driver)
    {
        super(driver);
    }
}
