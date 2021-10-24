package ru.bagmet.pages;

import com.codeborne.selenide.SelenideElement;
import ru.bagmet.pages.components.Calendar;
import ru.bagmet.pages.components.Modal;
import ru.bagmet.tests.TestData;

import java.io.File;
import java.util.HashMap;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPageRefactor {

    private final String pageTitle = "Student Registration Form";

    private final SelenideElement firstNameField = $("#firstName");
    private final SelenideElement lastNameField = $("#lastName");
    private final SelenideElement emailField = $("#userEmail");
    private final SelenideElement phoneNumberField = $("#userNumber");
    private final SelenideElement addressField = $("#currentAddress");
    private final SelenideElement subjectField = $("#subjectsInput");
    private final SelenideElement pictureUploader = $("#uploadPicture");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement stateSelector = $("#state");
    private final SelenideElement citySelector = $("#city");

    private final SelenideElement formTitle = $(".practice-form-wrapper");

    public Calendar calendar = new Calendar();

    public RegistrationFormPageRefactor openPage() {
        open("/automation-practice-form");
        formTitle.shouldBe(visible);
        formTitle.shouldHave(text(pageTitle));
        return this;
    }

    public void uploadPicture(String pathname) {
        pictureUploader.uploadFile(new File(pathname));
    }

    public RegistrationFormPageRefactor insertFirstName(String value){
        firstNameField.setValue(value);
        return this;
    }

    public RegistrationFormPageRefactor insertLastName(String value) {
        lastNameField.setValue(value);
        return this;
    }

    public RegistrationFormPageRefactor insertEmail(String value) {
        emailField.setValue(value);
        return this;
    }

    public RegistrationFormPageRefactor chooseGender(String value) {
        $$("div.custom-radio label").findBy(text(value)).click();
        return this;
    }

    public RegistrationFormPageRefactor insertPhoneNumber(String value) {
        phoneNumberField.setValue(value);
        return this;
    }

    public RegistrationFormPageRefactor chooseSubject(String value) {
        subjectField.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPageRefactor chooseHobby(String value) {
        $$("div.custom-checkbox label").findBy(text(value)).click();
        return this;
    }

    public RegistrationFormPageRefactor insertAddress(String value) {
        addressField.setValue(value);
        return this;
    }

    public RegistrationFormPageRefactor chooseState(String value) {
        stateSelector.click();
        $("#react-select-3-input").setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPageRefactor chooseCity(String value) {
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

    public void massCheckResults(TestData data) {

        HashMap<String, String> registrationResults = new HashMap<>();
        registrationResults.put("Student Name", data.getFirstName() + " " + data.getLastName());
        registrationResults.put("Student Email", data.getEmail());
        registrationResults.put("Gender", data.getGender());
        registrationResults.put("Mobile", data.getUserNumber());
        registrationResults.put("Date of Birth", data.getDateOfBirthFormatted());
        registrationResults.put("Subjects", data.getSubject1());
        registrationResults.put("Hobbies", data.getHobby1());
        registrationResults.put("Picture", data.getPictureName());
        registrationResults.put("Address", data.getCurrentAddress());
        registrationResults.put("State and City", data.getState() + " " + data.getCity());

        registrationResults.forEach((label, value) ->
                $$("div.table-responsive td").findBy(text(label))
                        .sibling(0).shouldHave(text(value))
                                     );
    }
}
