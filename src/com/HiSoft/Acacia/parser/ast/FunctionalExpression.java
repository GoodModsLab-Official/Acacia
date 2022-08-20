package com.HiSoft.Acacia.parser.ast;

import com.HiSoft.Acacia.lib.Function;
import com.HiSoft.Acacia.lib.Functions;
import com.HiSoft.Acacia.lib.UserDefinedFunction;
import com.HiSoft.Acacia.lib.Value;
import com.HiSoft.Acacia.lib.Variables;
import java.util.ArrayList;
import java.util.List;

public final class FunctionalExpression implements Expression {

    public final String name;
    public final List<Expression> arguments;

    public FunctionalExpression(String name) {
        this.name = name;
        arguments = new ArrayList<>();
    }

    public FunctionalExpression(String name, List<Expression> arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    public void addArgument(Expression arg) {
        arguments.add(arg);
    }

    @Override
    public Value eval() {
        final int size = arguments.size();
        final Value[] values = new Value[size];
        for (int i = 0; i < size; i++) {
            values[i] = arguments.get(i).eval();
        }

        final Function function = Functions.get(name);
        if (function instanceof UserDefinedFunction) {
            final UserDefinedFunction userFunction = (UserDefinedFunction) function;
            if (size != userFunction.getArgsCount()) throw new RuntimeException("Args count mismatch");

            Variables.push();
            for (int i = 0; i < size; i++) {
                Variables.set(userFunction.getArgsName(i), values[i]);
            }
            final Value result = userFunction.execute(values);
            Variables.pop();
            return result;
        }
        return function.execute(values);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return name + "(" + arguments.toString() + ")";
    }
}
