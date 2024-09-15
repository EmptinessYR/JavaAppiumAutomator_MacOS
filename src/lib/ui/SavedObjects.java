package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;

abstract public class SavedObjects extends MainPageObject{

    protected static String
        LIST_BY_NAME_TPL,
        ARTICLE_BY_TITLE_TPL,
        ARTICLE_TITLE_DESCRIPTION_ID,
        CLOSE_SYNC_MESSAGE,
        READING_LISTS,
        DELETE_ARTICLE_FROM_LIST_BUTTON;


    private static String getListXpathByName (String name_of_list)
    {
        return LIST_BY_NAME_TPL.replace("{LIST_NAME}", name_of_list);
    }

    private static String getListIdByName (String name_of_list)
    {
        return LIST_BY_NAME_TPL.replace("{NAME_OF_LIST}", name_of_list);
    }

    private static String getSavedArticleXpathByTitle (String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    public SavedObjects (AppiumDriver driver)
    {
        super(driver);
    }

    public void openListByName(String name_of_list)
    {
        String folder_name_xpath = getListXpathByName(name_of_list);
        //Прокрутим до нужного списка
        this.swipeUpToFindElement(
                folder_name_xpath,
                "Cannot find list by name" + name_of_list,
                20
        );

        //Заходим в нужный список статей
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find list by name" + name_of_list,
                5
        );
    }

    public void waitForArticleToAppearByTitle (String article_title)
    {
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(article_title_xpath, "Cannot find saved article by title " + article_title, 15);
    }

    public void waitForArticleToDisappearByTitle (String article_title)
    {
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(article_title_xpath, "Saved article still present with title " + article_title, 15);
    }

    public void swipeByArticleToDelete (String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_title_xpath = getSavedArticleXpathByTitle(article_title);
        System.out.println(article_title_xpath);
        if (Platform.getInstance().isAndroid()) {
            //Убеждаемся что есть нужная статья
            this.assertElementHasText(
                    ARTICLE_TITLE_DESCRIPTION_ID,
                    article_title,
                    "Cannot find right article",
                    15
            );

            //Свайпаем элемент налево для удаления
            this.swipeElementToLeft(
                    article_title_xpath,
                    "Cannot find saved article"
            );

            this.waitForArticleToDisappearByTitle(article_title);
        } else {

            this.assertElementHasText(
                    ARTICLE_TITLE_DESCRIPTION_ID,
                    article_title,
                    "Cannot find right article",
                    15
            );

            //Свайпаем элемент налево для удаления
            this.swipeElementToLeft(
                    article_title_xpath,
                    "Cannot find saved article"
            );

            this.waitForElementAndClick(DELETE_ARTICLE_FROM_LIST_BUTTON, "Cannot find delete article from list button", 5);
            this.waitForArticleToDisappearByTitle(article_title);
        }

    }

    public void swipeByArticleToDelete2 (String article_title) {
        String articleElement = getSavedArticleXpathByTitle(article_title);
        this.swipeElementToLeft(
                articleElement,
                "Cannot find saved article");
    }

    public void closeMessageAboutSync()
    {
        this.waitForElementAndClick(CLOSE_SYNC_MESSAGE, "Cannot find Close button in Sync message", 5);
    }

    public void goToTargetReadingLists(String name_of_list)
    {
        String folder_name_id = getListIdByName(name_of_list);
        this.waitForElementAndClick(READING_LISTS,"Cannot find Reading lists", 5);
        this.waitForElementAndClick(folder_name_id,"Cannot find target list", 5);
    }

}
