package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import lib.Platform;

abstract public class ArticlePageObject extends MainPageObject
{
    protected static String
        TITLE,
        TITLE_XPATH_TPL,
        TITLE_TPL,
        FOOTER_ELEMENT,
        SAVE_BUTTON,
        ADD_TO_LIST_BUTTON,
        MY_LIST_INPUT,
        MY_LIST_OK_BUTTON,
        CREATED_LIST_ID,
        TITLE_DESCRIPTION_XPATH,
        NAVIGATE_UP_BUTTON;

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    private static String getTitleDescriptionXpathByTitle (String description_title)
    {
        if (Platform.getInstance().isAndroid()) {
        return TITLE_XPATH_TPL.replace("{TITLE_DESCRIPTION}", description_title);
        } else {
            return TITLE;
        }

    }

    public WebElement waitForTitleElement(String title_description)
    {
        String title_description_xpath = getTitleDescriptionXpathByTitle(title_description);
        return this.waitForElementPresent(title_description_xpath, "Cannot find article on page!", 15);
    }

    public String getArticleTitle(String title_description)
    {
        WebElement title_element = waitForTitleElement(title_description);
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                FOOTER_ELEMENT,
                "Cannot find the end of article",
                20
        );
    }

    public void addArticleToMyList (String name_of_list)
    {
        //Кликаем на Save
        this.waitForElementAndClick(
                SAVE_BUTTON,
                "Cannot find element 'Save'",
                5
        );

        //Кликаем на Add to List
        this.waitForElementAndClick(
                ADD_TO_LIST_BUTTON,
                "Cannot find element 'Add to List'",
                5
        );

        //Задаем данные в Name of this list
        this.waitForElementAndSendKeys(
                MY_LIST_INPUT,
                name_of_list,
                "Cannot find Name of this list",
                5
        );

        //кликаем на Ok
        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot find button Ok",
                5
        );
    }

    public void addArticleToCreatedList (String name_of_list)
    {
        //Кликаем на Save
        this.waitForElementAndClick(
                SAVE_BUTTON,
                "Cannot find element 'Save'",
                5
        );

        //Кликаем на Add to List
        this.waitForElementAndClick(
                ADD_TO_LIST_BUTTON,
                "Cannot find element 'Add to List'",
                5
        );

        //Выбираем нужный нам список
        this.waitForElementAndClick(
                CREATED_LIST_ID,
                "Cannot find list " + name_of_list,
                5
        );
    }

    public void closeArticle()
    {
        //Выходим на страницу поиска
        this.waitForElementAndClick(
                NAVIGATE_UP_BUTTON,
                "Cannot find button Navigate up",
                5
        );

        //Выходим на главную страницу
        this.waitForElementAndClick(
                NAVIGATE_UP_BUTTON,
                "Cannot find button Navigate up in Search",
                5
        );
    }
    public void assertElementPresentArticleTitleDescription()
    {
        // Проверяем наличие элемента pcs-edit-section-title-description, так как у Заголовка нет ID
        this.assertElementPresent(
                TITLE_DESCRIPTION_XPATH,
                "Title description element is not present"
        );
    }
}
