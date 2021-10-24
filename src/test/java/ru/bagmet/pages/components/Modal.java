package ru.bagmet.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Modal {

    public void checkModalHeaderTitle(String title) {
        $(".modal-title").shouldHave(text(title));
    }

    public void checkModalBodyText(String text) {
        $(".modal-body").shouldHave(text(text));
    }

    public void checkIfModalBodyHaveTable() {
        $(".table-responsive").shouldBe(visible);
    }

    public void closeLargeModalWithButton() {
        $("#closeLargeModal").click();
    }

    public void closeSmallModalWithButton() {
        $("#closeSmallModal").click();
    }
}
