package task6.businessobjects;

public class UserFactory {

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

    public static User getUserWithEmptyPassword() {
        return new User()
                .withEmail("itacademyselenium", "@mail.ru")
                .withPassword("");
    }
}
