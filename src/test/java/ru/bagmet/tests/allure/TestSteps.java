package ru.bagmet.tests.allure;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byPartialLinkText;
import static com.codeborne.selenide.Selenide.*;

public class TestSteps {

    @Step("Перейти в профиль {profile}")
    public void openProfilePage(String profile){
        open(profile);
        takeScreenshot();
    }

    @Step("Открыть раздел {tab}")
    public void goToTab(String tab) {
        $(byPartialLinkText(tab)).click();
        takeScreenshot();
    }

    @Step("Найти репозиторий {repository}")
    public void searchForRepository(String repository){
        $$("[itemprop~=codeRepository]").findBy(text(repository)).click();
        takeScreenshot();
    }

    @Step("Проверить, что Issue с номером {number} имеет название {text}")
    public void checkIssueForText(int number, String text) {
        $("#issue_" + number + "_link").shouldHave(text(text));
        takeScreenshot();
    }

    @Attachment(value = "Скриншот", type = "image/png")
    public byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}
