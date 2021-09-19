package ru.bagmet;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GithubTests {

    @BeforeAll
    static void BeforeTests() {
        Configuration.baseUrl = "https://github.com";
//        Configuration.startMaximized = true;
    }

    @Test
    void SearchTest() {
        open("/");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        ElementsCollection repositoriesLinks = $$("ul.repo-list a.v-align-middle");
        repositoriesLinks.first().click();
        $("[data-target='readme-toc.content'] h1")
                .shouldHave(text("Selenide = UI Testing Framework powered by Selenium WebDriver"));
    }

    @Test
    void TestPageSoftAssertsHaveJUnit5Example() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".wiki-more-pages-link>button").click();
        $$("#wiki-pages-box .Box-row").findBy(text("SoftAssertions")).click();
        $$("ol li").findBy(text("Using JUnit5")).shouldBe(visible);

        $$("ol").findBy(text("Using JUnit5")).sibling(0).shouldHave(text("SoftAsserts"));
        $$("ol").findBy(text("Using JUnit5")).sibling(0).shouldHave(cssClass("highlight-source-java"));
//        $$("div").findBy(text("SoftAsserts")).closest("ol").shouldHave(text("JUnit5")); // не работает

/*     альтернативный вариант ассертов
    $("ol li", 5).shouldHave(text("JUnit5"));
     $("div pre", 4).shouldHave(text("SoftAsserts"));*/
    }

}
