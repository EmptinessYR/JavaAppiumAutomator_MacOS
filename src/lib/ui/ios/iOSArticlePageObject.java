package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject {

    static {
        //TITLE = "id:Object-oriented programming language";
        TITLE = "id:{TITLE_DESCRIPTION}";
        TITLE_XPATH_TPL = "xpath://android.view.View[@content-desc='{TITLE_DESCRIPTION}']";
        TITLE_TPL = "xpath://android.view.View[@content-desc='{TITLE}']";
        FOOTER_ELEMENT = "id:View article in browser";
        SAVE_BUTTON = "id:Save for later";
        NAVIGATE_UP_BUTTON = "id:Back";
        ADD_TO_LIST_BUTTON = "id:add-to-list";
        CREATE_A_NEW_LIST = "xpath://XCUIElementTypeButton[@name='Create a new list']";
        MY_LIST_INPUT = "xpath://XCUIElementTypeTextField[@value='reading list title']";
        MY_LIST_OK_BUTTON = "xpath://XCUIElementTypeButton[@name='Create reading list']";
        SEARCH_CANCEL_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Cancel']";
        SEARCH_CANCEL_CLOSE_BUTTON = "id:Clear text";
        CREATED_LIST_ID_TPL = "id:{NAME_OF_ARTICLE}";
    }

    public iOSArticlePageObject (AppiumDriver driver)
    {
        super(driver);
    }
}
