package com.HiSoft.Acacia.lib;

import java.util.Objects;

public class FunctionValue implements Value {
 
    private final Function value;

    public FunctionValue(Function value) {
        this.value = value;
    }
    
    @Override
    public double asNumber() {
        throw new RuntimeException("Cannot cast function to number");
    }
    
    @Override
    public String asString() {
        return value.toString();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.value);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass())
            return false;
        final FunctionValue other = (FunctionValue) obj;
        return Objects.equals(this.value, other.value);
    }
    
    public Function getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return asString();
    }
}
