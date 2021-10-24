package ru.bagmet.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ru.bagmet.pages.RegistrationFormPage;
import ru.bagmet.pages.components.Modal;

import java.util.Date;
import java.util.stream.Stream;

import static ru.bagmet.tests.TestDataOriginal.registrationModalTitle;

public class AutomationPracticeFormParameterizedTest {

    @ParameterizedTest(name = "Test for state and city - set {0}")
    @MethodSource("provideTestDataC")
    void  AutomationPracticeFormWithParametersCityAndState(TestData data) {
        Configuration.baseUrl = "https://demoqa.com";

        RegistrationFormPage registrationFormPage = new RegistrationFormPage();
        Modal registrationModal = new Modal();

        registrationFormPage.openPage();
        registrationFormPage.calendar.setDate(data.getDateOfBirth());
        registrationFormPage.uploadPicture("src/test/resources/img/" + data.getPictureName());
        registrationFormPage.insertFirstName(data.getFirstName())
                .insertLastName(data.getLastName())
                .insertEmail(data.getEmail())
                .chooseGender(data.getGender())
                .insertPhoneNumber(data.getUserNumber())
                .chooseSubject(data.getSubject1())
                .chooseHobby(data.getHobby1())
                .insertAddress(data.getCurrentAddress())
                .chooseState(data.getState())
                .chooseCity(data.getCity());
        registrationFormPage.submitForm();

        registrationModal.checkModalHeaderTitle(registrationModalTitle);

        registrationFormPage.checkResults("State and City", data.getState() + " " + data.getCity());
    }

    @ParameterizedTest(name = "Test for birthdate - {0}")
    @MethodSource("provideTestDataB")
    void  AutomationPracticeFormWithParametersBirthday(int number, TestData data) {
        Configuration.baseUrl = "https://demoqa.com";

        RegistrationFormPage registrationFormPage = new RegistrationFormPage();
        Modal registrationModal = new Modal();

        data.setDateOfBirthFormatted(data.getDateOfBirth());

        registrationFormPage.openPage();
        registrationFormPage.calendar.setDate(data.getDateOfBirth());
        registrationFormPage.uploadPicture("src/test/resources/img/" + data.getPictureName());
        registrationFormPage.insertFirstName(data.getFirstName())
                .insertLastName(data.getLastName())
                .insertEmail(data.getEmail())
                .chooseGender(data.getGender())
                .insertPhoneNumber(data.getUserNumber())
                .chooseSubject(data.getSubject1())
                .chooseHobby(data.getHobby1())
                .insertAddress(data.getCurrentAddress())
                .chooseState(data.getState())
                .chooseCity(data.getCity());
        registrationFormPage.submitForm();

        registrationModal.checkModalHeaderTitle(registrationModalTitle);

        registrationFormPage.checkResults("Date of Birth", data.getDateOfBirthFormatted());

    }

    private static Stream<Arguments> provideTestDataC() {
        return Stream.of(
                Arguments.of(1, new TestData().toBuilder().state("Uttar Pradesh").city("Merrut").build()),
                Arguments.of(2, new TestData().toBuilder().state("NCR").city("Delhi").build()),
                Arguments.of(3, new TestData().toBuilder().state("Hatyana").city("Karnal").build()),
                Arguments.of(4, new TestData().toBuilder().state("Rajasthan").city("Jaiselmer").build())
        );
    }

    private static Stream<Arguments> provideTestDataB() {
        return Stream.of(
                Arguments.of(1, new TestData().toBuilder().dateOfBirth(new Date(92, 7, 31)).build()),
                Arguments.of(2, new TestData().toBuilder().dateOfBirth(new Date(92, 7, 1)).build()),
                Arguments.of(3, new TestData().toBuilder().dateOfBirth(new Date(92, 9, 30)).build())
        );
    }


}


