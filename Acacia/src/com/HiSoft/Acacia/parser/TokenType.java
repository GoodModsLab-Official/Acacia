package com.HiSoft.Acacia.parser;

public enum TokenType {

    NUMBER,
    HEX_NUMBER,
    WORD,
    TEXT,

    // keywords
    PRINT,
    IF,
    ELSE,
    WHILE,
    FOR,
    DO,
    BREAK,
    CONTINUE,
    DEF,
    RETURN,
    IMPORT,

    PLUS, // +
    MINUS, // -
    STAR, // *
    SLASH, // /
    PERCENT,// %
    EQ, // =
    EQEQ, // ==
    EXCL, // !
    EXCLEQ, // !=
    LTEQ, // <=
    LT, // <
    GT, // >
    GTEQ, // >=

    LTLT, // <<
    GTGT, // >>
    GTGTGT, // >>>

    TILDE, // ~
    CARET, // ^
    BAR, // |
    BARBAR, // ||
    AMP, // &
    AMPAMP, // &&

    QUESTION, // ?
    COLON, // :

    LPAREN, // (
    RPAREN, // )
    LBRACKET, // [
    RBRACKET, // ]
    LBRACE, // {
    RBRACE, // }
    COMMA, // ,

    EOF  
}
