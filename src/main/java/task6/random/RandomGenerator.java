package task6.random;

import java.util.Random;

public class RandomGenerator {

    private static Random random = new Random();

    public static String generateRandomIncorrectDomain() {
        String[] domains = {"@inbox.ru", "@list.ru", "@bk.ru"};
        int index = random.nextInt(domains.length);
        return domains[index];
    }
}
