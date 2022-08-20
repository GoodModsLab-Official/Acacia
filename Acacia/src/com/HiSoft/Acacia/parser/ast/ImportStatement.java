package com.HiSoft.Acacia.parser.ast;

import com.HiSoft.Acacia.lib.modules.Module;

public final class ImportStatement implements Statement {

    private static final String PACKAGE = "com.HiSoft.Acacia.lib.modules.";

    public final Expression expression;

    public ImportStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void execute() {
        try {
            final String moduleName = expression.eval().asString();
            final Module module = (Module) Class.forName(PACKAGE + moduleName).newInstance();
            module.init();
        } catch (Exception ex) { }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "import " + expression;
    }
}
