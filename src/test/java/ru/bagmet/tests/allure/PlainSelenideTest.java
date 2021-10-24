package ru.bagmet.tests.allure;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PlainSelenideTest {

    @Test
    @DisplayName("Test for checking issue name and number")
    public void testForCheckingIssueNameWithPureSelenide() {
        Configuration.baseUrl = "https://github.com";

        open("/eroshenkoam");
        $(byPartialLinkText("Repositories")).click();
        $$("[itemprop~=codeRepository]").findBy(text("allure-example")).click();
        $("span[data-content='Issues']").shouldHave(text("Issues"));
        $("span[data-content='Issues']").click();
        $("#issue_66_link").shouldHave(text("новая Issue"));
    }
}

