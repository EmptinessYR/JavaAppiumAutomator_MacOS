package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.NavigationUI;
import lib.ui.SavedObjects;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFatorie;
import lib.ui.factories.SearchPageObjectFactorie;
import org.junit.Test;

public class SavedLists extends CoreTestCase {

    private static final String
            TITLE_DESCRIPTION_JAVA = "Object-oriented programming language",
            TITLE_DESCRIPTION_APPIUM = "Automation for Apps";

    @Test
    public void testAddAndDeleteListOfArticles()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactorie.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring(TITLE_DESCRIPTION_JAVA);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFatorie.get(driver);
        ArticlePageObject.waitForTitleElement(TITLE_DESCRIPTION_JAVA);
        String article_title = ArticlePageObject.getArticleTitle(TITLE_DESCRIPTION_JAVA);
        //название созданного списка
        String name_of_list = "Test_list";
        ArticlePageObject.addArticleToMyList(name_of_list);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMySavedObjects();

        SavedObjects SavedObjects = new SavedObjects(driver);
        SavedObjects.openListByName(name_of_list);
        SavedObjects.swipeByArticleToDelete(article_title);
    }

    @Test
    public void testSaveTwoArticlesInList ()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactorie.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring(TITLE_DESCRIPTION_JAVA);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFatorie.get(driver);
        ArticlePageObject.waitForTitleElement(TITLE_DESCRIPTION_JAVA);
        String article_title_to_delete = ArticlePageObject.getArticleTitle(TITLE_DESCRIPTION_JAVA);
        String name_of_list = "Test_list";
        ArticlePageObject.addArticleToMyList(name_of_list);
        ArticlePageObject.closeArticle();
        SearchPageObject.initSearchInputWithoutSkip();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring(TITLE_DESCRIPTION_APPIUM);
        ArticlePageObject.waitForTitleElement(TITLE_DESCRIPTION_APPIUM);
        String article_title_check = ArticlePageObject.getArticleTitle(TITLE_DESCRIPTION_APPIUM);
        ArticlePageObject.addArticleToCreatedList(name_of_list);
        ArticlePageObject.closeArticle();
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMySavedObjects();
        SavedObjects SavedObjects = new SavedObjects(driver);
        SavedObjects.openListByName(name_of_list);
        SavedObjects.swipeByArticleToDelete2(article_title_to_delete);
        SavedObjects.waitForArticleToAppearByTitle(article_title_check);
    }
}
