package com.itacademy.automation.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleCalculator implements Calculator {
    @Override
    public List<Lexeme> analyzeLexeme(List<String> list) {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        int index = 1;
        while (index < list.size()) {
            String element = list.get(index);
            switch (element) {
                case "(":
                    lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, element));
                    index++;
                    continue;
                case ")":
                    lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, element));
                    index++;
                    continue;
                case "+":
                    lexemes.add(new Lexeme(LexemeType.OP_PLUS, element));
                    index++;
                    continue;
                case "-":
                    lexemes.add(new Lexeme(LexemeType.OP_MINUS, element));
                    index++;
                    continue;
                case "*":
                    lexemes.add(new Lexeme(LexemeType.OP_MUL, element));
                    index++;
                    continue;
                case "/":
                    lexemes.add(new Lexeme(LexemeType.OP_DIV, element));
                    index++;
                    continue;
                default:
                    char[] chars = element.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        if (chars[i] >= 'a' && chars[i] <= 'z' || chars[i] >= 'A' && chars[i] <= 'Z') {
                            throw new RuntimeException("Unexpected token: " + element);
                        } else {
                            lexemes.add(new Lexeme(LexemeType.NUMBER, element));
                            index++;
                            continue;
                        }
                    }
            }
        }
        lexemes.add(new Lexeme(LexemeType.EOF, ""));
        return lexemes;
    }
    @Override
    public double factor(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.getNext();
        switch (lexeme.getType()) {
            case NUMBER:
                return Double.parseDouble(lexeme.getValue());
            case LEFT_BRACKET:
                double value = plusminus(lexemes);
                lexeme = lexemes.getNext();
                if (lexeme.getType() != LexemeType.RIGHT_BRACKET) {
                    throw new RuntimeException("Unexpected token: " + lexeme.getValue()
                            + " at position: " + lexemes.getIndex());
                }
                return value;
            default:
                throw new RuntimeException("Unexpected token: " + lexeme.getValue()
                        + " at position: " + lexemes.getIndex());
        }
    }
    public double multdiv(LexemeBuffer lexemes) {
        double value = factor(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.getNext();
            switch (lexeme.getType()) {
                case OP_MUL:
                    value *= factor(lexemes);
                    break;
                case OP_DIV:
                    value /= factor(lexemes);
                    break;
                case EOF:
                case RIGHT_BRACKET:
                case OP_PLUS:
                case OP_MINUS:
                    lexemes.decreaseIndex();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + lexeme.getValue()
                            + " at position: " + lexemes.getIndex());
            }
        }
    }
    @Override
    public double plusminus(LexemeBuffer lexemes) {
        double value = multdiv(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.getNext();
            switch (lexeme.getType()) {
                case OP_PLUS:
                    value += multdiv(lexemes);
                    break;
                case OP_MINUS:
                    value -= multdiv(lexemes);
                    break;
                case EOF:
                case RIGHT_BRACKET:
                case OP_MUL:
                case OP_DIV:
                    lexemes.decreaseIndex();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + lexeme.getValue()
                            + " at position: " + lexemes.getIndex());
            }
        }
    }
    @Override
    public double expr(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.getNext();
        if (lexeme.getType() == LexemeType.EOF) {
            return 0;
        } else {
            lexemes.decreaseIndex();
            return plusminus(lexemes);
        }
    }
    @Override
    public double func(LexemeBuffer lexemeBuffer) {
        throw new RuntimeException("Incorrect operation for calculator type");
    }
    @Override
    public Map<String, Function> getFunctionTable() {
        throw new RuntimeException("Incorrect operation for calculator type");
    }
}