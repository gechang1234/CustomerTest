package com.example.administrator.mycustomertest;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/12/17.
 */

public class NewMap<K, V> implements Map {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();
    private String string;

    public List<K> getKeys() {
        if (keys != null) {
            return keys;
        }
        return null;
    }

    public List<V> getValues() {
        if (values != null) {
            return values;
        }
        return null;
    }

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
        NewMap<K, V> map = (NewMap<K, V>) m;
        List<K> tempKeys = map.getKeys();
        List<V> tempValues = map.getValues();
        for (int i = 0; i < map.size(); i++) {
            if (tempKeys != null && tempValues != null) {
                keys.add(tempKeys.get(i));
                values.add(tempValues.get(i));
            }
        }
    }

    @Override
    public void clear() {
        values.clear();
        keys.clear();
    }

    @Override
    public Set keySet() {
        if (keys != null) {
            Iterator<K> iterator = keys.iterator();
            Set<K> set = new HashSet<>();
            while (iterator.hasNext()) {
                set.add(iterator.next());
            }
            for (K se :
                    set) {
                System.out.println(se);
            }
            return set;
        }
        return null;
    }

    @Override
    public Collection values() {
        Iterator<V> iterator = values.iterator();
        Collection<V> coll = new HashSet();
        while (iterator.hasNext()) {
            coll.add(iterator.next());
        }
        for (V value :
                coll) {
            System.out.println(value);
        }
        return coll;
    }

    @Override
    public Set<Entry> entrySet() {
        Iterator<K> iterator = keys.iterator();
        Iterator<V> iterator1 = values.iterator();
        Set<Entry> set = new HashSet<>();
        while (iterator.hasNext()) {
            set.add(new AbstractMap.SimpleEntry<K, V>(iterator.next(), iterator1.next()));
        }
        for (Entry se :
                set) {
            System.out.println(se);
        }
        return set;
    }
}
