package ru.bagmet.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubSearchPage {
    private final ElementsCollection menuItems = $$(".menu-item");
    private final SelenideElement firstPosition = $$("div.f4").first();

    public GitHubSearchPage openSearchPage(String searchText) {
        open("https://github.com/search?q=" + searchText);
        return this;
    }

    public SelenideElement selectTab(GitHubSearchTab tab) {
        return menuItems.find(text(tab.getTabText()));
    }

    public SelenideElement getFirstPosition() {
        return firstPosition;
    }
}
