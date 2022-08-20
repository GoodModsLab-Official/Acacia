package com.HiSoft.Acacia.parser.ast;

import com.HiSoft.Acacia.lib.Value;

public final class TernaryExpression implements Expression {

    public final Expression condition;
    public final Expression trueExpr, falseExpr;

    public TernaryExpression(Expression condition, Expression trueExpr, Expression falseExpr) {
        this.condition = condition;
        this.trueExpr = trueExpr;
        this.falseExpr = falseExpr;
    }

    @Override
    public Value eval() {
        if (condition.eval().asNumber() != 0) {
            return trueExpr.eval();
        } else {
            return falseExpr.eval();
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return String.format("%s ? %s : %s", condition, trueExpr, falseExpr);
    }
}
