package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "id:pcs-edit-section-title-description";
        //android.widget.TextView[@resource-id="pcs-edit-section-title-description"]
                TITLE_XPATH_TPL = "xpath://android.widget.TextView[@resource-id='pcs-edit-section-title-description' and @text='{TITLE_DESCRIPTION}']";
                TITLE_TPL = "xpath://android.view.View[@content-desc='{TITLE}']";
                FOOTER_ELEMENT = "xpath://android.view.View[@content-desc='View article in browser']";
                SAVE_BUTTON = "id:org.wikipedia:id/page_save";
                ADD_TO_LIST_BUTTON = "id:org.wikipedia:id/snackbar_action";
                MY_LIST_INPUT = "id:org.wikipedia:id/text_input";
                MY_LIST_OK_BUTTON = "id:android:id/button1";
                CREATED_LIST_ID = "id:org.wikipedia:id/item_title";
                TITLE_DESCRIPTION_XPATH = "xpath:id:@resource-id='pcs-edit-section-title-description'";
                NAVIGATE_UP_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
    }

    public AndroidArticlePageObject (AppiumDriver driver)
    {
        super(driver);
    }
}
