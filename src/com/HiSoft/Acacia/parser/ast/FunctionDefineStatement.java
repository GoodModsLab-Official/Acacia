package com.HiSoft.Acacia.parser.ast;

import com.HiSoft.Acacia.lib.Functions;
import com.HiSoft.Acacia.lib.UserDefinedFunction;
import java.util.List;

public final class FunctionDefineStatement implements Statement {

    public final String name;
    public final List<String> argNames;
    public final Statement body;

    public FunctionDefineStatement(String name, List<String> argNames, Statement body) {
        this.name = name;
        this.argNames = argNames;
        this.body = body;
    }

    @Override
    public void execute() {
        Functions.set(name, new UserDefinedFunction(argNames, body));
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return String.format("def %s(%s) %s", name, argNames, body);
    }
}
