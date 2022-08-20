package com.HiSoft.Acacia.parser.ast;

import com.HiSoft.Acacia.lib.Value;

public final class ReturnStatement extends RuntimeException implements Statement {

    public final Expression expression;
    private Value result;

    public ReturnStatement(Expression expression) {
        this.expression = expression;
    }

    public Value getResult() {
        return result;
    }

    @Override
    public void execute() {
        result = expression.eval();
        throw this;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "return " + expression;
    }
}
