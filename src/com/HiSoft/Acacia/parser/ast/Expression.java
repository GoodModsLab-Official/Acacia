package com.HiSoft.Acacia.parser.ast;

import com.HiSoft.Acacia.lib.Value;

public interface Expression extends Node {

    Value eval();
}
