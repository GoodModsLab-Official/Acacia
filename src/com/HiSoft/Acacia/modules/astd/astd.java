package com.HiSoft.Acacia.modules.astd;

import com.HiSoft.Acacia.lib.*;
import com.HiSoft.Acacia.modules.*;
import java.util.*;

public final class astd implements Module {
    
    public static void initConstants() {}
    
    @Override
    public void init() {
        
        Functions.set("echo", new astd_echo());
        
        // Arrays and maps
        Functions.set("newArray", new astd_newArray());
        
        // Threads
        Functions.set("sleep", new astd_sleep()); 

  
        Functions.set("thread", new Function() {
                @Override
                public Value execute(Value... args) {
                    if (args.length == 1) {
                        //   Thread thread = new Thread(Functions.get(args[0].asString()).execute());
                        //   thread.start();
                    }
                    return NumberValue.ZERO;
                }
            });
    }
}
