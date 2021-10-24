package ru.bagmet.pages;

import com.codeborne.selenide.SelenideElement;
import ru.bagmet.pages.components.Calendar;
import ru.bagmet.pages.components.Modal;

import static com.codeborne.selenide.Condition.*;
import static ru.bagmet.tests.TestDataOriginal.*;


import java.io.File;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private final String pageTitle = "Student Registration Form";

    private SelenideElement
        firstNameField = $("#firstName"),
        lastNameField = $("#lastName"),
        emailField = $("#userEmail"),
        phoneNumberField = $("#userNumber"),
        addressField = $("#currentAddress"),
        subjectField = $("#subjectsInput"),
        pictureUploader = $("#uploadPicture"),
        submitButton = $("#submit"),
        stateSelector = $("#state"),
        citySelector = $("#city"),

        formTitle = $(".practice-form-wrapper");

    public Calendar calendar = new Calendar();

    public SelenideElement getFirstNameField() {
        return firstNameField;
    }

    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldBe(visible);
        formTitle.shouldHave(text(pageTitle));
    }

    public void uploadPicture(String pathname) {
        pictureUploader.uploadFile(new File(pathname));
    }

    public RegistrationFormPage insertFirstName(String value){
        firstNameField.setValue(value);
        return this;
    }

    public RegistrationFormPage insertLastName(String value) {
        lastNameField.setValue(value);
        return this;
    }

    public RegistrationFormPage insertEmail(String value) {
        emailField.setValue(value);
        return this;
    }

    public RegistrationFormPage chooseGender(String value) {
        $$("div.custom-radio label").findBy(text(value)).click();
        return this;
    }

    public RegistrationFormPage insertPhoneNumber(String value) {
        phoneNumberField.setValue(value);
        return this;
    }

    public RegistrationFormPage chooseSubject(String value) {
        subjectField.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage chooseHobby(String value) {
        $$("div.custom-checkbox label").findBy(text(value)).click();
        return this;
    }

    public RegistrationFormPage insertAddress(String value) {
        addressField.setValue(value);
        return this;
    }

    public RegistrationFormPage chooseState(String value) {
        stateSelector.click();
        $("#react-select-3-input").setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage chooseCity(String value) {
        citySelector.click();
        $("#react-select-4-input").setValue(value).pressEnter();
        return this;
    }

    public void checkBorderColorWithError(SelenideElement element) {
        element.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    public Modal submitForm() {
        submitButton.scrollIntoView(true).click();
        return new Modal();
    }

    public void checkResults(String key, String value) {
        $$("div.table-responsive td").findBy(text(key))
                .sibling(0).shouldHave(text(value));
    }

    public void massCheckResults() {

        HashMap<String, String> registrationResults = new HashMap<>();
        registrationResults.put("Student Name", firstName + " " + lastName);
        registrationResults.put("Student Email", email);
        registrationResults.put("Gender", gender);
        registrationResults.put("Mobile", userNumber);
        registrationResults.put("Date of Birth", dateOfBirthFormatted);
        registrationResults.put("Subjects", subject);
        registrationResults.put("Hobbies", hobby);
        registrationResults.put("Picture", pictureName);
        registrationResults.put("Address", currentAddress);
        registrationResults.put("State and City", state + " " + city);

        registrationResults.forEach((label, value) ->
                $$("div.table-responsive td").findBy(text(label))
                        .sibling(0).shouldHave(text(value))
                                     );
    }
}
