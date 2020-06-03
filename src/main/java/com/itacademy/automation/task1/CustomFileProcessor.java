package com.itacademy.automation.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomFileProcessor {

    private Scanner scanner;
    private String path;
    private List<String> list = new ArrayList<>();
    private StringBuilder expression;
    private String fileName;
    private Calculator calculator;



    public void readFile(Path path) throws IOException {
        list = Files.lines(path).collect(Collectors.toList());
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public Calculator getCalculator() {
        return calculator;
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setExpression(StringBuilder expression) {
        this.expression = expression;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileName() {
        System.out.println("Enter file name:");
        scanner = new Scanner(System.in);
        fileName = scanner.nextLine();
        scanner.close();
    }

    private String getExpression() {
        expression = new StringBuilder();
        for (int i = 1; i < list.size(); i++) {
            expression.append(list.get(i));
        }
        return expression.toString();
    }

    private void printFile() {
        System.out.println("File contains:");
        list.forEach(System.out::println);
        System.out.println();
    }

    private void printCalculatorType() {
        CalculatorType calculatorType;
        switch (list.get(0)) {
            case "1":
                calculatorType = CalculatorType.SIMPLE;
                break;
            case "2":
                calculatorType = CalculatorType.SIMPLE_WITH_MEMORY;
                break;
            case "3":
                calculatorType = CalculatorType.ENGINEERING;
                break;
            case "4":
                calculatorType = CalculatorType.ENGINEERING_WITH_MEMORY;
                break;
            default:
                throw new RuntimeException("Incorrect type of calculator");
        }
        System.out.println("Calculator Type: " + calculatorType);
    }

    private void printExpression() {
        System.out.println("Expression: " + getExpression());
    }

    public void printAll() {
        printFile();
        printCalculatorType();
        printExpression();
    }

    public Calculator initializeCalculator() {
        switch (list.get(0)) {
            case "1":
                calculator = new SimpleCalculator();
                break;
            case "2":
                calculator = new SimpleCalculatorWithMemory();
                break;
            case "3":
                calculator = new EngineeringCalculator();
                break;
            case "4":
                calculator = new EngineeringCalculatorWithMemory();
                break;
            default:
                throw new RuntimeException("Incorrect type of calculator");
        }
        return calculator;
    }

}
