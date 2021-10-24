package ru.bagmet.tests.allure;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestWithAnnotatedSteps {

    @BeforeAll
    static void BeforeTests() {
        Configuration.baseUrl = "https://github.com";
    }

    private final static String PROFILE = "/selenide";
    private final static String REPOSITORY = "selenide-for-selenium-ide";
    private final static String TAB1 = "Repositories";
    private final static String TAB2 = "Issues";
    private final static Integer ISSUE_NUMBER = 6;
    private final static String ISSUE_TEXT = "Not working on Chromium Edge";

    @Test
    @Feature("Issue")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Тест на проверку названия Issue в репозитории")
    public void IssueTextTest() {

        TestSteps steps = new TestSteps();

        steps.openProfilePage(PROFILE);
//        steps.takeScreenshot();
        steps.goToTab(TAB1);
//        steps.takeScreenshot();
        steps.searchForRepository(REPOSITORY);
//        steps.takeScreenshot();
        steps.goToTab(TAB2);
//        steps.takeScreenshot();
        steps.checkIssueForText(ISSUE_NUMBER, ISSUE_TEXT);
//        steps.takeScreenshot();
    }
}
