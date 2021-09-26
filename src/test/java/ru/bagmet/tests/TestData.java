package ru.bagmet.tests;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.text.SimpleDateFormat;
import java.util.*;

public class TestData {

    static Faker faker = new Faker();
    static FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-US"), new RandomService());

    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String email = faker.internet().emailAddress("test");
    public static Date dateOfBirth = faker.date().birthday();
    public static String userNumber = fakeValuesService.numerify("##########");
    public static String currentAddress = faker.address().streetAddress();

    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM,yyyy", Locale.ENGLISH);
    public static String dateOfBirthFormatted = dateFormat.format(dateOfBirth);

    public static String gender = "Male";
    public static String subject = "English";
    public static String hobby = "Reading";
    public static String state = "NCR";
    public static String city = "Noida";

    public static String pictureName = "1.jpg";

    public static String registrationModalTitle = "Thanks for submitting the form";


}
