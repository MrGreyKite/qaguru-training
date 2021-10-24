package ru.bagmet.tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import ru.bagmet.pages.GitHubSearchPage;
import ru.bagmet.pages.GitHubSearchTab;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import static org.apache.commons.io.FilenameUtils.getBaseName;
import static org.apache.commons.io.FilenameUtils.getExtension;
import static org.assertj.core.api.Assertions.assertThat;

public class ParametrizedTests {

    @ParameterizedTest(name = "Choosing tab in GitHub search")
    @EnumSource(value = GitHubSearchTab.class, names = {"REPOSITORIES", "COMMITS", "ISSUES", "TOPICS", "WIKIS"}, mode = EnumSource.Mode.INCLUDE)
    void GitHubTabs(GitHubSearchTab tab) {
        GitHubSearchPage gsp = new GitHubSearchPage();

        gsp.openSearchPage("selenide");
        SelenideElement selectedTab = gsp.selectTab(tab);
        gsp.selectTab(tab).click();

        gsp.getFirstPosition().shouldHave(text("Selenide"));
        selectedTab.shouldHave(cssClass("selected"));
        selectedTab.shouldHave(pseudo(":before", "color", "rgb(36, 41, 47)"));

    }


    @ParameterizedTest(name = "Выгрузка файла {1} килобайт по {0} -й ссылке в корректном формате")
    @CsvSource(value = {
            "1; 10",
            "2; 20",
            "3; 50",
            "4; 100",
            "5; 200",
            "6; 500",
            "7; 1000",
    }, delimiterString = ";")
    void SampleFilesDownload(int number, String kbInFile) throws FileNotFoundException {

        open("http://sample-videos.com/download-sample-text-file.php");

        File downloadedFile = $("a[data=\"" + number + "\"]").download();

        assertThat(getBaseName(downloadedFile.toString())).isEqualTo("Sample-text-file-" + kbInFile + "kb");
        assertThat(getExtension(downloadedFile.toString())).isEqualTo("txt");

    }
}
