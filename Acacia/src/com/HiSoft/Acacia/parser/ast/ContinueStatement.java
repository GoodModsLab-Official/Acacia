package com.HiSoft.Acacia.parser.ast;

public final class ContinueStatement extends RuntimeException implements Statement {

    @Override
    public void execute() {
        throw this;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "continue";
    }
}
