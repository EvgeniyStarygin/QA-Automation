package com.itacademy.automation.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EngineeringCalculator extends SimpleCalculator {

    private HashMap<String, Function> functionTable = getFunctionTable();

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
                case ",":
                    lexemes.add(new Lexeme(LexemeType.COMMA, element));
                    index++;
                    continue;
                default:
                    if (functionTable.containsKey(element)) {
                        lexemes.add(new Lexeme(LexemeType.NAME, element));
                        index++;
                        continue;
                    } else {
                        lexemes.add(new Lexeme(LexemeType.NUMBER, element));
                        index++;
                        continue;
                    }
            }
        }
        lexemes.add(new Lexeme(LexemeType.EOF, ""));
        return lexemes;
    }

    @Override
    public double factor(LexemeBuffer lexemes) {
        Lexeme lexeme = lexemes.next();
        switch (lexeme.type) {
            case NAME:
                lexemes.back();
                return func(lexemes);
            case OP_MINUS:
                double value = factor(lexemes);
                return -value;
            case NUMBER:
                return Double.parseDouble(lexeme.value);
            case LEFT_BRACKET:
                value = plusminus(lexemes);
                lexeme = lexemes.next();
                if (lexeme.type != LexemeType.RIGHT_BRACKET) {
                    throw new RuntimeException("Unexpected token: " + lexeme.value
                            + " at position: " + lexemes.getIndex());
                }
                return value;
            default:
                throw new RuntimeException("Unexpected token: " + lexeme.value
                        + " at position: " + lexemes.getIndex());
        }
    }

    @Override
    public double multdiv(LexemeBuffer lexemes) {
        double value = factor(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_MUL:
                    value *= factor(lexemes);
                    break;
                case OP_DIV:
                    value /= factor(lexemes);
                    break;
                case EOF:
                case RIGHT_BRACKET:
                case COMMA:
                case OP_PLUS:
                case OP_MINUS:
                    lexemes.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + lexeme.value
                            + " at position: " + lexemes.getIndex());
            }
        }
    }

    @Override
    public double plusminus(LexemeBuffer lexemes) {
        double value = multdiv(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.type) {
                case OP_PLUS:
                    value += multdiv(lexemes);
                    break;
                case OP_MINUS:
                    value -= multdiv(lexemes);
                    break;
                case EOF:
                case RIGHT_BRACKET:
                case COMMA:
                case OP_MUL:
                case OP_DIV:
                    lexemes.back();
                    return value;
                default:
                    throw new RuntimeException("Unexpected token: " + lexeme.value
                            + " at position: " + lexemes.getIndex());
            }
        }
    }


    @Override
    public double func(LexemeBuffer lexemeBuffer) {
        String name = lexemeBuffer.next().value;
        Lexeme lexeme = lexemeBuffer.next();

        if (lexeme.type != LexemeType.LEFT_BRACKET) {
            throw new RuntimeException("Wrong function call syntax at " + lexeme.value);
        }

        ArrayList<Double> args = new ArrayList<>();

        lexeme = lexemeBuffer.next();
        if (lexeme.type != LexemeType.RIGHT_BRACKET) {
            lexemeBuffer.back();
            do {
                args.add(expr(lexemeBuffer));
                lexeme = lexemeBuffer.next();

                if (lexeme.type != LexemeType.COMMA && lexeme.type != LexemeType.RIGHT_BRACKET) {
                    throw new RuntimeException("Wrong function call syntax at " + lexeme.value);
                }

            } while (lexeme.type == LexemeType.COMMA);
        }
        return functionTable.get(name).apply(args);
    }

    @Override
    public HashMap<String, Function> getFunctionTable() {
        HashMap<String, Function> functionTable = new HashMap<>();
        functionTable.put("cos", args -> {
            if (args.size() != 1) {
                throw new RuntimeException("Wrong argument count for function cosinus: " + args.size());
            }
            return Math.cos(args.get(0));
        });
        functionTable.put("exp", args -> {
            if (args.size() != 1) {
                throw new RuntimeException("Wrong argument count for function exp: " + args.size());
            }
            return Math.exp(args.get(0));
        });
        functionTable.put("sqrt", args -> {
            if (args.size() != 1) {
                throw new RuntimeException("Wrong argument count for function sqrt: " + args.size());
            }
            return Math.sqrt(args.get(0));
        });
        return functionTable;
    }
}
