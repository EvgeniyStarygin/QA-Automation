package com.itacademy.automation.ui_task.services;

import java.util.Random;

public class RandomGenerator {

    private static Random random = new Random();

    private static String getRandomValue(String[] array) {
        int index = random.nextInt(array.length);
        return array[index];
    }

    public static String generateRandomIncorrectDomain() {
        String[] domains = {"@inbox.ru", "@list.ru", "@bk.ru"};
        return getRandomValue(domains);
    }

    public static String generateRandomDomain() {
        String[] domains = {"@inbox.ru", "@list.ru", "@bk.ru", "@mail.ru"};
        return getRandomValue(domains);
    }

    public static String generateRandomLetterSubject() {
        return "Subject " + System.currentTimeMillis();
    }

    public static String generateRandomLetterText() {
        return "Text " + System.currentTimeMillis();
    }

    public static String generateRandomFolderName() {
        return "Folder " + System.currentTimeMillis();
    }

    public static String generateRandomFileName() {
        return "File" + System.currentTimeMillis() + ".txt";
    }

    public static String generateRandomScreenshotName() {
        return "Screenshot" + System.currentTimeMillis() + ".png";
    }
}
