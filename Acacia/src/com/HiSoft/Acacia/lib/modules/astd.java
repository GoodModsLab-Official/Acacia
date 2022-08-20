package com.HiSoft.Acacia.lib.modules;

import com.HiSoft.Acacia.lib.*;
import java.util.Random;

public final class astd implements Module {
    @Override
    public void init() {
        
        Functions.set("newArray", new Function() {

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
            });
        
        Functions.set("sleep", new Function() {

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
            });
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
