package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject {

    private static final String
    STEP_LEARN_MORE_LINK = "xpath://XCUIElementTypeStaticText[@name=\"Узнать подробнее о Википедии\"]",
    STEP_NEW_WAYS_TO_EXPLORE_TEXT = "id:Новые способы изучения",
    STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK = "xpath://XCUIElementTypeStaticText[@name=\"Добавить или изменить предпочтительные языки\"]",
    STEP_LEARN_MORE_ABOUT_PRIVACY_POLITIC_LINK = "xpath://XCUIElementTypeStaticText[@name=\"Узнайте больше о нашей политике конфиденциальности и условиях использования.\"]",
    NEXT_LINK = "xpath://XCUIElementTypeStaticText[@name=\"Далее\"]",
    GET_STARTED_LINK = "xpath://XCUIElementTypeButton[@name=\"Начать\"]";

    public WelcomePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void waitForLearnMoreLink()
    {
        this.waitForElementPresent(
                STEP_LEARN_MORE_LINK,
                "Cannot find 'Узнать подробнее о Википедии'",
                10);
    }

    public void waitForNewWayToExploreText()
    {
        this.waitForElementPresent(
                STEP_NEW_WAYS_TO_EXPLORE_TEXT,
                "Cannot find 'Новые способы изучения'",
                10);
    }

    public void waitForAddOrEditPreferredLangText()
    {
        this.waitForElementPresent(
                STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK,
                "Cannot find 'Добавить или изменить предпочтительные языки'",
                10);
    }

    public void waitForLearnMoreAboutPrivacyPoliticText()
    {
        this.waitForElementPresent(
                STEP_LEARN_MORE_ABOUT_PRIVACY_POLITIC_LINK,
                "Cannot find 'Узнайте больше о нашей политике конфиденциальности и условиях использования.'",
                10);
    }

    public void clickNextButton()
    {
        this.waitForElementAndClick(
                NEXT_LINK,
                "Cannot find and click 'Далее'",
                10);
    }

    public void clickGetStartedButton()
    {
        this.waitForElementAndClick(
                GET_STARTED_LINK,
                "Cannot find and click 'Начать'",
                10);
    }

}
