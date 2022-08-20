package com.HiSoft.Acacia.modules.astd;

import com.HiSoft.Acacia.lib.*;
import com.HiSoft.Acacia.lib.Function;
import com.HiSoft.Acacia.lib.NumberValue;
import com.HiSoft.Acacia.lib.Value;

public final class astd_sleep implements Function { 
    @Override
    public Value execute(Value... args) {
        if(args.length == 1) {
            try {
                Thread.sleep((long) args[0].asNumber());
            } 
            catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        return NumberValue.ZERO;
    }

    
}
