package com.HiSoft.Acacia.modules.math;

import com.HiSoft.Acacia.lib.*;
import com.HiSoft.Acacia.modules.*;
import java.util.*;

public final class math implements Module {
    
    public static void initConstans() {
        Variables.set("PI", new NumberValue(Math.PI));
        Variables.set("E", new NumberValue(Math.E));
    }
    @Override
    public void init() {
        initConstans();
        Functions.set("rand", new Rand());
        
        Functions.set("abs", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.abs(args[0].asNumber()));
                }
        });
        Functions.set("cbrt", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.cbrt(args[0].asNumber()));
                }
        });
        Functions.set("ceil", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.ceil(args[0].asNumber()));
                }
        });
        Functions.set("exp", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.exp(args[0].asNumber()));
                }
        });
        Functions.set("expm1", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.expm1(args[0].asNumber()));
                }
        });
        Functions.set("floor", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.floor(args[0].asNumber()));
                }
        });
        Functions.set("getExponent", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.getExponent(args[0].asNumber()));
                }
        });
        Functions.set("log", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.log(args[0].asNumber()));
                }
        });
        Functions.set("log10", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.log10(args[0].asNumber()));
                }
        });
        Functions.set("log1p", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.log1p(args[0].asNumber()));
                }
        });
        Functions.set("nextDown", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.nextDown(args[0].asNumber()));
                }
        });
        Functions.set("nextUp", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.nextUp(args[0].asNumber()));
                }
        });
        Functions.set("rint", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.rint(args[0].asNumber()));
                }
        });
        Functions.set("round", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.round(args[0].asNumber()));
                }
        });
        Functions.set("signum", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.signum(args[0].asNumber()));
                }
        });
        Functions.set("sqrt", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.sqrt(args[0].asNumber()));
                }
        });
        Functions.set("toDegrees", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.toDegrees(args[0].asNumber()));
                }
        });
        Functions.set("toRadians", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.toRadians(args[0].asNumber()));
                }
        });
        Functions.set("ulp", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.ulp(args[0].asNumber()));
                }
        });
            
        Functions.set("sin", new Function() {
            @Override
            public Value execute(Value... args) {
                if(args.length != 1) throw new RuntimeException("One argument excepted");
                return new NumberValue(Math.sin(args[0].asNumber()));
            }
        });
        Functions.set("sinh", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.sinh(args[0].asNumber()));
                }
        });
        Functions.set("asin", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.asin(args[0].asNumber()));
                }
        });
        Functions.set("cos", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.cos(args[0].asNumber()));
                }
        });
        Functions.set("acos", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.acos(args[0].asNumber()));
                }
        });
        Functions.set("cosh", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.cosh(args[0].asNumber()));
                }
        });
        Functions.set("tan", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.tan(args[0].asNumber()));
                }
        });
        Functions.set("tanh", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.tanh(args[0].asNumber()));
                }
        });
        Functions.set("atan", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 1) throw new RuntimeException("One argument excepted");
                    return new NumberValue(Math.atan(args[0].asNumber()));
                }
        });
        
        
        Functions.set("atan2", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 2) throw new RuntimeException("Two argument excepted");
                    return new NumberValue(Math.atan2(args[0].asNumber(), args[1].asNumber()));
                }
        });
        Functions.set("hypot", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 2) throw new RuntimeException("Two argument excepted");
                    return new NumberValue(Math.hypot(args[0].asNumber(), args[1].asNumber()));
                }
        });
        Functions.set("IEEEremainder", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 2) throw new RuntimeException("Two argument excepted");
                    return new NumberValue(Math.IEEEremainder(args[0].asNumber(), args[1].asNumber()));
                }
        });
        Functions.set("max", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 2) throw new RuntimeException("Two argument excepted");
                    return new NumberValue(Math.max(args[0].asNumber(), args[1].asNumber()));
                }
        });
        Functions.set("min", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 2) throw new RuntimeException("Two argument excepted");
                    return new NumberValue(Math.min(args[0].asNumber(), args[1].asNumber()));
                }
        });
        Functions.set("nextAfter", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 2) throw new RuntimeException("Two argument excepted");
                    return new NumberValue(Math.nextAfter(args[0].asNumber(), args[1].asNumber()));
                }
        });
        Functions.set("pow", new Function() {
                @Override
                public Value execute(Value... args) {
                    if(args.length != 2) throw new RuntimeException("Two argument excepted");
                    return new NumberValue(Math.pow(args[0].asNumber(), args[1].asNumber()));
                }
        });
        
    }

    private static class Rand implements Function {

        private static final Random RND = new Random();

        @Override
        public Value execute(Value... args) {
            if (args.length == 0) return new NumberValue(RND.nextDouble());

            int from = 0;
            int to = 100;
            if (args.length == 1) {
                to = (int) args[0].asNumber();
            } else if (args.length == 2) {
                from = (int) args[0].asNumber();
                to = (int) args[1].asNumber();
            }
            return new NumberValue(RND.nextInt(to - from) + from);
        }
    }

}
