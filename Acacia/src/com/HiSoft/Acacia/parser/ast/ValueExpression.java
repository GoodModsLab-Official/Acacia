package com.HiSoft.Acacia.parser.ast;

import com.HiSoft.Acacia.lib.NumberValue;
import com.HiSoft.Acacia.lib.StringValue;
import com.HiSoft.Acacia.lib.Value;

public final class ValueExpression implements Expression {

    public final Value value;

    public ValueExpression(double value) {
        this.value = new NumberValue(value);
    }

    public ValueExpression(String value) {
        this.value = new StringValue(value);
    }

    @Override
    public Value eval() {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return value.asString();
    }
}
