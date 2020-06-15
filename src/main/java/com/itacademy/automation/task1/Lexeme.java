package com.itacademy.automation.task1;

public class Lexeme {
    private LexemeType type;
    private String value;

    public LexemeType getType() {
        return type;
    }
    public void setType(LexemeType type) {
        this.type = type;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public Lexeme(LexemeType type, String value) {
        this.type = type;
        this.value = value;
    }
    @Override
    public String toString() {
        return "Lexeme{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
