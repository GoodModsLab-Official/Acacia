package com.HiSoft.Acacia.modules.astd;

import com.HiSoft.Acacia.lib.Function;
import com.HiSoft.Acacia.lib.NumberValue;
import com.HiSoft.Acacia.lib.Value;

public final class astd_echo implements Function {

    @Override
    public Value execute(Value... args) {
        final StringBuilder sb = new StringBuilder();
        for (Value arg : args) {
            sb.append(arg.asString());
            sb.append(" ");
        }
        System.out.println(sb.toString());
        return NumberValue.ZERO;
    }
}
