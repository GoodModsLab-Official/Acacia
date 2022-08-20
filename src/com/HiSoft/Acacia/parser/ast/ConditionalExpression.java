package com.HiSoft.Acacia.parser.ast;

import com.HiSoft.Acacia.lib.NumberValue;
import com.HiSoft.Acacia.lib.StringValue;
import com.HiSoft.Acacia.lib.Value;

public final class ConditionalExpression implements Expression {

    public static enum Operator {
        EQUALS("=="),
        NOT_EQUALS("!="),

        LT("<"),
        LTEQ("<="),
        GT(">"),
        GTEQ(">="),

        AND("&&"),
        OR("||");

        private final String name;

        private Operator(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public final Expression expr1, expr2;
    public final Operator operation;

    public ConditionalExpression(Operator operation, Expression expr1, Expression expr2) {
        this.operation = operation;
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public Value eval() {
        final Value value1 = expr1.eval();
        switch (operation) {
            case AND: return NumberValue.fromBoolean(
                    (value1.asNumber() != 0) && (expr2.eval().asNumber() != 0) );
            case OR: return NumberValue.fromBoolean(
                    (value1.asNumber() != 0) || (expr2.eval().asNumber() != 0) );
        }


        final Value value2 = expr2.eval();

        double number1, number2;
        if (value1 instanceof StringValue) {
            number1 = value1.asString().compareTo(value2.asString());
            number2 = 0;
        } else {
            number1 = value1.asNumber();
            number2 = value2.asNumber();
        }

        boolean result;
        switch (operation) {
            case EQUALS: result = number1 == number2; break;
            case NOT_EQUALS: result = number1 != number2; break;

            case LT: result = number1 < number2; break;
            case LTEQ: result = number1 <= number2; break;
            case GT: result = number1 > number2; break;
            case GTEQ: result = number1 >= number2; break;

            default:
                throw new RuntimeException("Operation " + operation + " is not supported");
        }
        return NumberValue.fromBoolean(result);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", expr1, operation.getName(), expr2);
    }
}
