package com.HiSoft.Acacia.parser.ast;

import com.HiSoft.Acacia.lib.ArrayValue;
import com.HiSoft.Acacia.lib.Value;
import java.util.List;

public final class ArrayExpression implements Expression {

    public final List<Expression> elements;

    public ArrayExpression(List<Expression> arguments) {
        this.elements = arguments;
    }

    @Override
    public Value eval() {
        final int size = elements.size();
        final ArrayValue array = new ArrayValue(size);
        for (int i = 0; i < size; i++) {
            array.set(i, elements.get(i).eval());
        }
        return array;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
