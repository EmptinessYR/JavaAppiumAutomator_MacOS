package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {

    private static final String
            TITLE_DESCRIPTION_JAVA = "Object-oriented programming language",
            TITLE_DESCRIPTION_APPIUM = "Automation for Apps";

    @Test
    public void testCompareArticleTitle()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring(TITLE_DESCRIPTION_JAVA);

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String article_title = ArticlePageObject.getArticleTitle(TITLE_DESCRIPTION_JAVA);

        assertEquals(
                "We see unexpected title",
                TITLE_DESCRIPTION_JAVA,
                article_title
        );
    }

    @Test
    public void testSwipeArticle()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring(TITLE_DESCRIPTION_APPIUM);

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement(TITLE_DESCRIPTION_APPIUM);
        ArticlePageObject.swipeToFooter();
    }

    @Test
    public void testArticleHasTitleDescription()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring(TITLE_DESCRIPTION_JAVA);
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.assertElementPresentArticleTitleDescription();
    }
}
