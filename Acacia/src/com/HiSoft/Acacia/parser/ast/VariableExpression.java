package com.HiSoft.Acacia.parser.ast;

import com.HiSoft.Acacia.lib.Value;
import com.HiSoft.Acacia.lib.Variables;

public final class VariableExpression implements Expression {

    public final String name;

    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public Value eval() {
        if (!Variables.isExists(name)) throw new RuntimeException("Variable does not exists: " + name);
        return Variables.get(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
