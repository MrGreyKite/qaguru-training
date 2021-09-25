package ru.bagmet.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTest {

    @BeforeAll
    static void BeforeTests() {
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browserSize = "1366x768";
        Configuration.startMaximized = true;
    }

    String firstName = "Rudolf";
    String lastName = "Bagmet";
    String email = "r@ya.ru";

    @Test
    void FormFilledTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $$("div.custom-radio label").findBy(text("Male")).click();
        $("#userNumber").setValue("0000000000");
        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").selectOption("May");
        $("select[class*=\"month-select\"]").selectOption("May");
        $("select[class*=\"year-select\"]").selectOption("1992");
        $(".react-datepicker__day--026:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $$("div.custom-checkbox label").findBy(text("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.jpg"));
        $("#currentAddress").setValue("My street, my home");
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Noida").pressEnter();

        $("#submit").scrollIntoView(true).click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $x("//table/tbody/tr[1]/td[2]").shouldHave(text(firstName + " " + lastName));
        $x("//table/tbody/tr[2]/td[2]").shouldHave(text(email));
        $$("div.table-responsive td").findBy(text("State and City"))
                .sibling(0).shouldHave(text("NCR Noida"));
    }

    @Test
    void emptyFillFormTest() {
        open("/automation-practice-form");
        $("#firstName").shouldBe(empty);
        $("#submit").scrollIntoView(true).click();

        $("#firstName").scrollIntoView(true)
                .shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }

}
