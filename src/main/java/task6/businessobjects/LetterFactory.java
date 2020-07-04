package task6.businessobjects;

import static task6.random.RandomGenerator.*;

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
