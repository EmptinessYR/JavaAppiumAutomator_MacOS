package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject {

    static {
        SKIP_BUTTON = "xpath://XCUIElementTypeStaticText[@name='Skip']";
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT_ID = "xpath:////XCUIElementTypeSearchField[@name='Search Wikipedia']"; //в андроид версии есть id
        SEARCH_CANCEL_BUTTON = "xpath:///XCUIElementTypeStaticText[@name='Cancel']";
        SEARCH_CANCEL_CLOSE_BUTTON = "id:Clear text";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath:(//XCUIElementTypeStaticText[contains(@name,'{SUBSTRING}')])";
        SEARCH_RESULT_ELEMENT = "xpath://*[type='XCUIElementTypeCollectionView']/*/*[type='XCUIElementTypeCell']";
        SEARCH_EMPTY_RESULT_LABEL = "xpath://XCUIElementTypeStaticText[@name='No results found']";
        SEARCH_RESULT_LIST="xpath://XCUIElementTypeApplication[@name='Wikipedia']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeStaticText[@value]";
       // SEARCH_RESULT_LIST = "xpath://*[type='XCUIElementTypeCollectionView']/*/*[type='XCUIElementTypeCell']/*/*[type='XCUIElementTypeOther']/*/*[type='XCUIElementTypeStaticText']";
        TITLE_AND_DESCRIPTION_TOGETHER_TPL = "xpath://XCUIElementTypeStaticText[@name='{TITLE}']/following-sibling::*//XCUIElementTypeStaticText[@name='{DESCRIPTION}'])";
        SEARCH_EMPTY_RESULT = "id:No recent searches yet";
    }

    public iOSSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
