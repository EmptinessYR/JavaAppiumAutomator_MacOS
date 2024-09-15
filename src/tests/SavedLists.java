package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.NavigationUI;
import lib.ui.SavedObjects;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactorie;
import lib.ui.factories.NavigationUIFactorie;
import lib.ui.factories.SavedObjectsFactorie;
import lib.ui.factories.SearchPageObjectFactorie;
import org.junit.Test;

public class SavedLists extends CoreTestCase {

    private static final String
            TITLE_DESCRIPTION_JAVA = "Object-oriented programming language",
            TITLE_DESCRIPTION_APPIUM = "Automation for Apps",
            NAME_OF_LIST = "Test_list";


    @Test
    public void testAddAndDeleteListOfArticles()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactorie.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring(TITLE_DESCRIPTION_JAVA);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactorie.get(driver);
        ArticlePageObject.waitForTitleElement(TITLE_DESCRIPTION_JAVA);
        String article_title = ArticlePageObject.getArticleTitle(TITLE_DESCRIPTION_JAVA);

        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(NAME_OF_LIST);
            ArticlePageObject.closeArticle();

            NavigationUI NavigationUI = NavigationUIFactorie.get(driver);
            NavigationUI.clickMySavedObjects();

            SavedObjects SavedObjects = SavedObjectsFactorie.get(driver);
            SavedObjects.openListByName(NAME_OF_LIST);
            SavedObjects.swipeByArticleToDelete(article_title);
        } else
        {
            ArticlePageObject.addArticlesToMySaved();
            ArticlePageObject.addArticleToMyNewListIOS(NAME_OF_LIST);
            ArticlePageObject.closeArticle();
            NavigationUI NavigationUI = NavigationUIFactorie.get(driver);
            NavigationUI.clickMySavedObjects();
            SavedObjects SavedObjects = SavedObjectsFactorie.get(driver);
            SavedObjects.closeMessageAboutSync();
            SavedObjects.goToTargetReadingLists(NAME_OF_LIST);
            SavedObjects.swipeByArticleToDelete(article_title);
        }
    }

    @Test
    public void testSaveTwoArticlesInList ()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactorie.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring(TITLE_DESCRIPTION_JAVA);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactorie.get(driver);
        ArticlePageObject.waitForTitleElement(TITLE_DESCRIPTION_JAVA);
        String article_title_to_delete = ArticlePageObject.getArticleTitle(TITLE_DESCRIPTION_JAVA);
        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.addArticleToMyList(NAME_OF_LIST);
            ArticlePageObject.closeArticle();
            SearchPageObject.initSearchInputWithoutSkip();
            SearchPageObject.typeSearchLine("Appium");
            SearchPageObject.clickByArticleWithSubstring(TITLE_DESCRIPTION_APPIUM);
            ArticlePageObject.waitForTitleElement(TITLE_DESCRIPTION_APPIUM);
            String article_title_check = ArticlePageObject.getArticleTitle(TITLE_DESCRIPTION_APPIUM);
            ArticlePageObject.addArticleToCreatedList(NAME_OF_LIST);
            ArticlePageObject.closeArticle();
            NavigationUI NavigationUI = NavigationUIFactorie.get(driver);
            NavigationUI.clickMySavedObjects();
            SavedObjects SavedObjects = SavedObjectsFactorie.get(driver);
            SavedObjects.openListByName(NAME_OF_LIST);
            SavedObjects.swipeByArticleToDelete2(article_title_to_delete);
            SavedObjects.waitForArticleToAppearByTitle(article_title_check);
        } else {
            ArticlePageObject.addArticlesToMySaved();
            ArticlePageObject.addArticleToMyNewListIOS(NAME_OF_LIST);
            ArticlePageObject.closeArticleToSearchNextArticleIOS();
            SearchPageObject.typeSearchLine("Appium");
            SearchPageObject.clickByArticleWithSubstring(TITLE_DESCRIPTION_APPIUM);
            ArticlePageObject.waitForTitleElement(TITLE_DESCRIPTION_APPIUM);
            String article_title_check = ArticlePageObject.getArticleTitle(TITLE_DESCRIPTION_APPIUM);
            ArticlePageObject.addArticleToMyExistingList(NAME_OF_LIST);
            ArticlePageObject.closeArticle();
            NavigationUI NavigationUI = NavigationUIFactorie.get(driver);
            NavigationUI.clickMySavedObjects();
            SavedObjects SavedObjects = SavedObjectsFactorie.get(driver);
            SavedObjects.closeMessageAboutSync();
            SavedObjects.goToTargetReadingLists(NAME_OF_LIST);
            SavedObjects.swipeByArticleToDelete(article_title_to_delete);
            SavedObjects.waitForArticleToAppearByTitle(article_title_check);
        }

    }
}
