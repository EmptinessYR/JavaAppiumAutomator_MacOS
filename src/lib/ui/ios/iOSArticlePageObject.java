package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "id:Object-oriented programming language";
        TITLE_XPATH_TPL = "xpath://android.view.View[@content-desc='{TITLE_DESCRIPTION}']";
        TITLE_TPL = "xpath://android.view.View[@content-desc='{TITLE}']";
        FOOTER_ELEMENT = "id:View article in browser";
        SAVE_BUTTON = "id:Save for later";
        NAVIGATE_UP_BUTTON = "id:Back";
    }

    public iOSArticlePageObject (AppiumDriver driver)
    {
        super(driver);
    }
}
