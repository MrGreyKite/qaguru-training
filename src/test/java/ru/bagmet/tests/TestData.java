package ru.bagmet.tests;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.text.SimpleDateFormat;
import java.util.*;

import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true, builderClassName = "Builder")
@NoArgsConstructor
@AllArgsConstructor
public class TestData {

    static Faker faker = new Faker();
    static FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-US"), new RandomService());

    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String email = faker.internet().emailAddress("test");
    private Date dateOfBirth = faker.date().birthday();
    private String userNumber = fakeValuesService.numerify("##########");
    private String currentAddress = faker.address().streetAddress();

    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM,yyyy", Locale.ENGLISH);
    private String dateOfBirthFormatted = dateFormat.format(dateOfBirth);

    private String gender = "Male";
    private String subject1 = "English";
    private String subject2;
    private String hobby1 = "Reading";
    private String hobby2;
    private String state = "NCR";
    private String city = "Noida";

    private String pictureName = "1.jpg";

    void setDateOfBirthFormatted(Date dateOfBirth) {
        this.dateOfBirthFormatted = dateFormat.format(dateOfBirth);
    }
}
