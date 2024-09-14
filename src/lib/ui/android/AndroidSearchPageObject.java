package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {

     static {
         SKIP_BUTTON = "xpath://*[contains(@text,'Skip')]";
                 SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]";
                 SEARCH_INPUT_ID = "id:org.wikipedia:id/search_src_text";
                 SEARCH_CANCEL_BUTTON = "xpath://android.widget.ImageButton[@content-desc=\"Navigate up\"]";
                 SEARCH_CANCEL_CLOSE_BUTTON = "id:org.wikipedia:id/search_close_btn";
                 SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_description' and @text='{SUBSTRING}']";
                 SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']/*/*[@resource-id='org.wikipedia:id/page_list_item_title']";
                 SEARCH_EMPTY_RESULT_LABEL = "id:org.wikipedia:id/results_text";
                 SEARCH_RESULT_LIST = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title']";
                 TITLE_AND_DESCRIPTION_TOGETHER_TPL = "xpath://*[@resource-id = 'org.wikipedia:id/page_list_item_title' and @text='{TITLE}']/following-sibling::*[name()='android.widget.TextView' and @resource-id='org.wikipedia:id/page_list_item_description' and @text='{DESCRIPTION}']";
                 SEARCH_EMPTY_RESULT = "id:org.wikipedia:id/search_empty_message";
     }

    public AndroidSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

}
