package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

abstract public class SearchPageObject extends MainPageObject {

     protected static String
        SKIP_BUTTON,
        SEARCH_INIT_ELEMENT,
        SEARCH_INPUT_ID,
        SEARCH_CANCEL_BUTTON,
        SEARCH_CANCEL_CLOSE_BUTTON,
        SEARCH_RESULT_BY_SUBSTRING_TPL,
        SEARCH_RESULT_ELEMENT,
        SEARCH_EMPTY_RESULT_LABEL,
        SEARCH_RESULT_LIST,
        TITLE_AND_DESCRIPTION_TOGETHER_TPL,
        SEARCH_EMPTY_RESULT;

    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /*TEMPLATES METHODS*/
    private static String getResultSearchElement (String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}",substring);
    }

    private static String getResultTitleAndDescriptionTogether (String title, String description)
    {
        return TITLE_AND_DESCRIPTION_TOGETHER_TPL.replace("{TITLE}", title).replace("{DESCRIPTION}", description);
    }

    /*TEMPLATES METHODS*/

    public void initSearchInput()
    {
        this.waitForElementAndClick(SKIP_BUTTON,"Cannot find and click Skip-button",5 );
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element");
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);
    }

    public void initSearchInputWithoutSkip()
    {
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element");
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find and click search init element", 5);
    }

    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "Search cancel button is still present", 5);
    }

    public void waitForCancelButtonToAppear()
    {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "Cannot find search cancel button", 5);
    }

    public void clickCancelSearchButton()
    {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click search cancel button", 5);
    }

    public void clickCancelCloseSearchButton()
    {
        this.waitForElementAndClick(SEARCH_CANCEL_CLOSE_BUTTON, "Cannot find and click search/cancel cancel button", 5);
    }

    public void typeSearchLine (String search_line)
    {
        this.waitForElementAndSendKeys(SEARCH_INPUT_ID, search_line, "Cannot find and type into search input", 5);
    }
    public void waitForSearchResult (String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result with substring " + substring);
    }

    public void clickByArticleWithSubstring (String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "Cannot find and click search result with substring " + substring, 10);
    }

    public int getAmountOfFoundArticles()
    {
        this.waitForElementPresent(
                SEARCH_RESULT_ELEMENT,
                "Cannot find anything by the request ",
                15
        );

        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    public void waitForEmptyResultsLabel()
    {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT_LABEL, "Cannot find empty result label",15);
    }

    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT,"We supposed not to find any results");
    }

    public void waitForEmptySearchResult()
    {
        this.waitForElementPresent(SEARCH_EMPTY_RESULT,"Cannot find empty search message",15);
    }

    public void assertNotAllElementsContainsSearchParam(String search_param)
    {
        this.assertElementsContainText(
            SEARCH_RESULT_LIST,
                search_param,
            "Not all search results contain the word '" + search_param + "'",
            15
        );
    }

    public void waitForElementByTitleAndDescription(String title, String description)
    {
        String title_and_description_xpath = getResultTitleAndDescriptionTogether(title,description);
        this.waitForElementPresent(
                title_and_description_xpath,
                "Cannot find object with title ='" + title + "' and description ='" + description + "'",
                15);
    }
}
