package com.HiSoft.Acacia.lib;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class MapValue implements Value {
    private final Map<Value, Value> map;
    
    public MapValue(int size) {
        this.map = new HashMap<>(size);
    }

    public Value get(Value key) {
        return map.get(key);
    }
    
    public void set(Value key, Value value) {
        map.put(key, value);
    }

    @Override
    public double asNumber() {
        throw new RuntimeException("Cannot cast map to number");
    }

    @Override
    public String asString() {
        return map.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.map);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass())
            return false;
        final MapValue other = (MapValue) obj;
        return Objects.equals(this.map, other.map);
    }

    @Override
    public String toString() {
        return asString();
    }
}
