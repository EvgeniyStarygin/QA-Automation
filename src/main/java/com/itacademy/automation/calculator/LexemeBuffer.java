package com.itacademy.automation.calculator;

import java.util.List;

public class LexemeBuffer {
    private int index;
    private List<Lexeme> lexemes;

    public LexemeBuffer(List<Lexeme> lexemes) {
        this.lexemes = lexemes;
    }
    public Lexeme getNext() {
        return lexemes.get(index++);
    }
    public void decreaseIndex() {
        index--;
    }
    public int getIndex() {
        return index;
    }
}