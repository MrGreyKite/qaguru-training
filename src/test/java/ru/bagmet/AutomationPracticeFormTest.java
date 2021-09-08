package ru.bagmet;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTest {

    @BeforeAll
    static void BeforeTests() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1366x768";
//        Configuration.startMaximized = true;
    }

    @Test
    void FormFilledTest() {
        open("/automation-practice-form");



    }

}
