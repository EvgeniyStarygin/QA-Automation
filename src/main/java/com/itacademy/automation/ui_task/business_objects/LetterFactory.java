package com.itacademy.automation.ui_task.business_objects;

import static com.itacademy.automation.ui_task.services.RandomGenerator.*;

public class LetterFactory {

    public static Letter getCorrectLetter() {
        return new Letter()
                .withAddress("itacademyselenium@mail.ru")
                .withSubject(generateRandomLetterSubject())
                .withText(generateRandomLetterText());
    }

    public static Letter getLetterWithoutSubject() {
        return new Letter()
                .withAddress("itacademyselenium@mail.ru")
                .withSubject("")
                .withText(generateRandomLetterText());
    }

    public static Letter getLetterWithoutBody() {
        return new Letter()
                .withAddress("itacademyselenium@mail.ru")
                .withSubject(generateRandomLetterSubject())
                .withText("");
    }

    public static Letter getLetterWithoutAddress() {
        return new Letter()
                .withAddress("");
    }

    public static Letter getLetterWithIncorrectAddress() {
        return new Letter()
                .withAddress("1");
    }
}
