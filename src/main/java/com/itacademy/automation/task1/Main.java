package com.itacademy.automation.task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// file name - example.txt

public class Main {
    private static final String SEPARATOR = File.separator;
    private Calculator calculator;

    public static void main(String[] args) throws IOException {
        CustomFileProcessor customFileProcessor = new CustomFileProcessor();
        customFileProcessor.setFileName();
        String fileName = customFileProcessor.getFileName();
        customFileProcessor.setPath("." + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "resources" + SEPARATOR);
        Path fullPath = Paths.get(customFileProcessor.getPath() + fileName);
        customFileProcessor.readFile(fullPath);
        List<String> list = customFileProcessor.getList();
        customFileProcessor.printAll();
        customFileProcessor.initializeCalculator();
        Calculator calculator = customFileProcessor.getCalculator();
        List<Lexeme> lexemes = calculator.analyzeLexeme(list);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        System.out.println("Result: " + calculator.expr(lexemeBuffer));
    }
}
