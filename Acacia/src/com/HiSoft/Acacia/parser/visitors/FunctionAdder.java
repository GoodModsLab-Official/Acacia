package com.HiSoft.Acacia.parser.visitors;

import com.HiSoft.Acacia.parser.ast.*;

public final class FunctionAdder extends AbstractVisitor {

    @Override
    public void visit(FunctionDefineStatement s) {
        super.visit(s);
        s.execute();
    }
}
