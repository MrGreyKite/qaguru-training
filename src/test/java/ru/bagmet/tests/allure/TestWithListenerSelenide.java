package ru.bagmet.tests.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TestWithListenerSelenide {

    @Test
    public void testForCheckingIssueNameWithListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/eroshenkoam");
        $(byPartialLinkText("Repositories")).as("Таб с репозиториями").click();
        $$("[itemprop~=codeRepository]")
                .findBy(text("allure-example")).as("Нужный репозиторий").click();
        $("span[data-content='Issues']").as("Таб со всеми Issue").shouldHave(text("Issues"));
        $("span[data-content='Issues'']").as("Таб со всеми Issue").click();
        $("#issue_66_link").as("Искомая issue").shouldHave(text("новая Issue"));
    }
}
