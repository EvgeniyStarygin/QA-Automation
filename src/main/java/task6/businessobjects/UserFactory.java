package task6.businessobjects;

import static task6.random.RandomGenerator.generateRandomIncorrectDomain;

public class UserFactory {

    public static User getUserWithCorrectEmail() {
        return new User()
                .withEmail("itacademyselenium", "@mail.ru");
    }

    public static User getUserWithIncorrectEmailName() {
        return new User()
                .withEmail("!#$%^&", "@mail.ru");
    }

    public static User getUserWithIncorrectEmailDomain() {
        return new User()
                .withEmail("!#$%^&", generateRandomIncorrectDomain());
    }

    public static User getUserWithCorrectCredentials() {
        return new User()
                .withEmail("itacademyselenium", "@mail.ru")
                .withPassword("6MHXZS/O");
    }

    public static User getUserWithIncorrectPassword() {
        return new User()
                .withEmail("itacademyselenium", "@mail.ru")
                .withPassword("password");
    }

}
