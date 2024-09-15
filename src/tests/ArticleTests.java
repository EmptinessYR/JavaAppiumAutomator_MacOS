package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactorie;
import lib.ui.factories.SearchPageObjectFactorie;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {

    private static final String
            TITLE_DESCRIPTION_JAVA = "Object-oriented programming language",
            TITLE_DESCRIPTION_APPIUM = "Automation for Apps";

    @Test
    public void testCompareArticleTitle()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactorie.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring(TITLE_DESCRIPTION_JAVA);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactorie.get(driver);

        if (Platform.getInstance().isIOS()) {
            try {
                // Добавляем ожидание на 5 секунд перед переходом к следующему шагу
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

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
        SearchPageObject SearchPageObject = SearchPageObjectFactorie.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring(TITLE_DESCRIPTION_APPIUM);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactorie.get(driver);
        ArticlePageObject.waitForTitleElement(TITLE_DESCRIPTION_APPIUM);
        ArticlePageObject.swipeToFooter();
    }

    @Test
    public void testArticleHasTitleDescription()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactorie.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring(TITLE_DESCRIPTION_JAVA);
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactorie.get(driver);
        ArticlePageObject.assertElementPresentArticleTitleDescription();
    }
}
