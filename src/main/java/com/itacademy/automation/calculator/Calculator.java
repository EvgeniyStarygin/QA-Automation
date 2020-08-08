package com.itacademy.automation.calculator;

import java.util.List;
import java.util.Map;

public interface Calculator {
    /*------------------------------------------------------------------
     * PARSER RULES
     *------------------------------------------------------------------*/

//    expr : plusminus* EOF ;
//
//    plusminus: multdiv ( ( '+' | '-' ) multdiv )* ;
//
//    multdiv : factor ( ( '*' | '/' ) factor )* ;
//
//    factor : func | unary | NUMBER | '(' expr ')' ;
//
//    unary : '-' factor
//
//    func : NAME '(' (expr (',' expr)+)? ')'

    public List<Lexeme> analyzeLexeme(List<String> list);
    public double factor(LexemeBuffer lexemes);
    public double multdiv(LexemeBuffer lexemes);
    public double plusminus(LexemeBuffer lexemes);
    public double expr(LexemeBuffer lexemes);
    public double func(LexemeBuffer lexemeBuffer);
    public Map<String, Function> getFunctionTable();
}
