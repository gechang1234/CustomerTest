package com.example.administrator.mycustomertest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/12/17.
 */

public class NewMap<K, V> implements Map {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    @Override
    public int size() {
        return keys.size() == values.size() ? keys.size() : 0;
    }

    @Override
    public boolean isEmpty() {
        return keys.size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values.contains(value);
    }

    @Override
    public V get(Object key) {
        return values.get(keys.indexOf(key));
    }

    @Override
    public Object put(Object key, Object value) {
        if (keys.contains(key)) {
            values.remove(keys.indexOf(key));
            values.add(keys.indexOf(key), (V) value);
        } else {
            keys.add((K) key);
            values.add((V) value);
        }
        return value;
    }

    @Override
    public Object remove(Object key) {
        values.remove(keys.indexOf(key));
        keys.remove(key);
        return key;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {
        values.clear();
        keys.clear();
    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
