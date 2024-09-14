package tests;

import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactorie;
import org.junit.Test;
import org.openqa.selenium.By;

public class SearchTests extends CoreTestCase {
    @Test
    public void testSearch() throws InterruptedException
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactorie.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }

    @Test
    public void testCanselSearch ()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactorie.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearchButton();
        SearchPageObject.waitForCancelButtonToDisappear();
    }

    @Test
    public void testAmountOfNotEmptySearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactorie.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "Linkin Park discography";
        SearchPageObject.typeSearchLine(search_line);
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        assertTrue(
                "We found too few results",
                amount_of_search_results > 0
        );
    }

    @Test
    public void testAmountOfEmptySearch()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactorie.get(driver);
        SearchPageObject.initSearchInput();
        String search_line = "sdafdsgndhgjr";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();

        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*/*[@resource-id='org.wikipedia:id/page_list_item_title']";
        String empty_result_label = "//*[@text='No results']";
    }

    @Test
    public void testSearchAndCancle ()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactorie.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        SearchPageObject.clickCancelCloseSearchButton();
        SearchPageObject.waitForEmptySearchResult();
    }

    @Test
    public void testSearchAndCompareResult ()  //пока не работает на ios так как не понимаю как собрать все названия статей
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactorie.get(driver);
        String search_param = "Java";
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_param);
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        SearchPageObject.assertNotAllElementsContainsSearchParam(search_param);
    }

    @Test
    public void testSearchAndCompareTitleDescription ()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactorie.get(driver);
        String article_title = "Java (programming language)";
        String article_description = "Object-oriented programming language";
        String search_param = "Java";
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_param);
        SearchPageObject.waitForElementByTitleAndDescription(article_title,article_description);
    }

}
