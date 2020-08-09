package com.itacademy.automation.ui_task.services;

import com.itacademy.automation.ui_task.loggers.CustomLogger;

import java.io.File;
import java.io.IOException;

public class FileCreator {

    private static File file;
    private static final String SEPARATOR = File.separator;
    private static final String FILE_NAME = RandomGenerator.generateRandomFileName();
    private static final String PATH_TO_FILE = "." + SEPARATOR
            + "src" + SEPARATOR
            + "test" + SEPARATOR
            + "resources" + SEPARATOR
            + "com.itacademy.automation/ui_task";

    public static File getFile() {
        return file;
    }

    public static String getSeparator() {
        return SEPARATOR;
    }

    public static String getFileName() {
        return FILE_NAME;
    }

    public static void createTestFile() {
        file = new File(PATH_TO_FILE, FILE_NAME);
        CustomLogger.logCreateTestFile(file);
        try {
            file.createNewFile();
        } catch (IOException e) {
            CustomLogger.logException(e);
        }
    }

    public static void deleteTestFile() {
        CustomLogger.logDeleteTestFile(file);
        file.delete();
    }
}

