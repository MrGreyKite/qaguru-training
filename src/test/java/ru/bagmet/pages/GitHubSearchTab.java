package ru.bagmet.pages;

public enum GitHubSearchTab {
    CODE("Code"),
    COMMITS("Commits"),
    ISSUES("Issues"),
    DISCUSSIONS("Discussions"),
    PACKAGES("Packages"),
    MARKETPLACE("Marketplace"),
    TOPICS("Topics"),
    WIKIS("Wikis"),
    USERS("Users"),
    REPOSITORIES("Repositories");

    private String text;

    GitHubSearchTab(String text) {
        this.text = text;
    }

    public String getTabText() {
        return text;
    }
}
