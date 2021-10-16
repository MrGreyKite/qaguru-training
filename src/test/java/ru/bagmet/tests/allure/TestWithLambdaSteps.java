package ru.bagmet.tests.allure;

import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.label;
import static io.qameta.allure.Allure.step;

public class TestWithLambdaSteps {

    private final static String PROFILE = "/eroshenkoam";
    private final static String TAB1 = "Repositories";
    private final static String REPOSITORY = "allure-example";
    private final static String TAB2 = "Issues";
    private final static Integer ISSUE_NUMBER = 66;
    private final static String ISSUE_TEXT = "новая Issue";

    @Test
    @DisplayName("Тест на проверку названия Issue в репозитории")
    public void testGithub() {
        label("owner", "MrGreykite");
        label("severity", SeverityLevel.BLOCKER.toString());

        step("Открыть нужный профиль GitHub: " + PROFILE, () ->
                open("https://github.com" + PROFILE));
//        addAttachment.

        step("Перейти в раздел " + TAB1, () ->
                $(byPartialLinkText(TAB1)).click());

        step("Перейти в репозиторий " + REPOSITORY, () ->
                $$("[itemprop~=codeRepository]").
                findBy(text(REPOSITORY)).click());

        step("Открыть раздел " + TAB2, () ->
                $("span[data-content=" + TAB2 + "]").click());

        step("Проверить, что Issue с номером " + ISSUE_NUMBER + " называется " + ISSUE_TEXT, () ->
            $("#issue_" + ISSUE_NUMBER + "_link").shouldHave(text(ISSUE_TEXT)));
    }

}
