package com.HiSoft.Acacia.parser.ast;

import com.HiSoft.Acacia.lib.*;
import java.util.*;


public final class ArrayAccessExpression implements Expression {

    public final String variable;
    public final List<Expression> indices;

    public ArrayAccessExpression(String variable, List<Expression> indices) {
        this.variable = variable;
        this.indices = indices;
    }

    @Override
    public Value eval() {
        Value container = Variables.get(variable);
        if (container instanceof ArrayValue) {
            return getArray().get(lastIndex());
        }
        return consumeMap(container).get(indices.get(0).eval());
    }

    public ArrayValue getArray() {
        ArrayValue array = consumeArray(Variables.get(variable));
        final int last = indices.size() - 1;
        for (int i = 0; i < last; i++) {
            array = consumeArray( array.get(index(i)) );
        }
        return array;
    }

    public int lastIndex() {
        return index(indices.size() - 1);
    }

    private int index(int index) {
        return (int) indices.get(index).eval().asNumber();
    }

    private ArrayValue consumeArray(Value value) {
        if (value instanceof ArrayValue) {
            return (ArrayValue) value;
        } else {
            throw new RuntimeException("Array expected");
        }
    }
    
    private MapValue consumeMap(Value value) {
        if (value instanceof MapValue) {
            return (MapValue) value;
        } else {
            throw new RuntimeException("Map expected");
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return variable + indices;
    }
}
