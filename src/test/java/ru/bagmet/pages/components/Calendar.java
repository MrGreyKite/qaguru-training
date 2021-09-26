package ru.bagmet.pages.components;

import java.util.Date;

import static com.codeborne.selenide.Selenide.$;

public class Calendar {

    public void setDate(Date dateOfBirth) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(dateOfBirth.getMonth());
        $(".react-datepicker__year-select").selectOption(dateOfBirth.getYear());
        if (dateOfBirth.getDate() < 10) {
            $(".react-datepicker__day--00" + dateOfBirth.getDate() +
                    ":not(.react-datepicker__day--outside-month)").click();
        } else {
            $(".react-datepicker__day--0" + dateOfBirth.getDate() +
                    ":not(.react-datepicker__day--outside-month)").click();
        }
    }
}
