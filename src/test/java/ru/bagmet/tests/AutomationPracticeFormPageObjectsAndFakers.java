package ru.bagmet.tests;

import org.junit.jupiter.api.Test;
import ru.bagmet.pages.RegistrationFormPage;
import ru.bagmet.pages.components.Modal;

import static com.codeborne.selenide.Condition.*;
import static ru.bagmet.tests.TestDataOriginal.*;

public class AutomationPracticeFormPageObjectsAndFakers extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Modal registrationModal = new Modal();

    @Test
    void FormFilledTest() {
        registrationFormPage.openPage();
        registrationFormPage.calendar.setDate(dateOfBirth);
        registrationFormPage.uploadPicture("src/test/resources/img/" + pictureName);
        registrationFormPage.insertFirstName(firstName)
                            .insertLastName(lastName)
                            .insertEmail(email)
                            .chooseGender(gender)
                            .insertPhoneNumber(userNumber)
                            .chooseSubject(subject)
                            .chooseHobby(hobby)
                            .insertAddress(currentAddress)
                            .chooseState(state)
                            .chooseCity(city);
        registrationFormPage.submitForm();

        registrationModal.checkModalHeaderTitle(registrationModalTitle);
        registrationModal.checkIfModalBodyHaveTable();

        //одиночные проверки
        registrationFormPage.checkResults("Date of Birth", dateOfBirthFormatted);
        registrationFormPage.checkResults("State and City", state + " " + city);

        //проверка сразу всех значений в таблице
        registrationFormPage.massCheckResults();

//        registrationModal.closeLargeModalWithButton(); - не отрабатывает из-за рекламного баннера
    }

    @Test
    void emptyFillFormTest() {
        registrationFormPage.openPage();
        registrationFormPage.getFirstNameField().shouldBe(empty);
        registrationFormPage.submitForm();

        registrationFormPage.checkBorderColorWithError
                (registrationFormPage.getFirstNameField().scrollIntoView(true));

    }

}
