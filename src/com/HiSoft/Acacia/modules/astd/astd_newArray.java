package com.HiSoft.Acacia.modules.astd;

import com.HiSoft.Acacia.lib.*;
import com.HiSoft.Acacia.modules.*;
import java.util.*;

public final class astd_newArray implements Function {

    @Override
    public Value execute(Value... args) {
        return createArray(args, 0);
    }
    
    private ArrayValue createArray(Value[] args, int index) {
        final int size = (int) args[index].asNumber();
        final int last = args.length - 1;
        ArrayValue array = new ArrayValue(size);
        if (index == last) {
            for (int i = 0; i < size; i++) {
                array.set(i, NumberValue.ZERO);
            }
        } else if (index < last) {
            for (int i = 0; i < size; i++) {
                array.set(i, createArray(args, index + 1));
            }
        }
        return array;
    }
}
