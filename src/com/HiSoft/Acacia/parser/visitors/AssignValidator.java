package com.HiSoft.Acacia.parser.visitors;

import com.HiSoft.Acacia.lib.Variables;
import com.HiSoft.Acacia.parser.ast.*;

public final class AssignValidator extends AbstractVisitor {

    @Override
    public void visit(AssignmentStatement s) {
        super.visit(s);
        if (Variables.isExists(s.variable)) {
            throw new RuntimeException("Cannot assign value to constant");
        }
    }
}
