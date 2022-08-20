package com.HiSoft.Acacia.parser.ast;

public interface Node {

    void accept(Visitor visitor);
}
