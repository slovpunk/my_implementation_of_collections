package ru.didyk.map;

import java.util.*;

public class MyMap<K, V> implements Map<K, V> {

    private List<V>[] values = new ArrayList[10];
    private List<K>[] keys = new ArrayList[10];

    @Override
    public V get(Object key) {
        int hash = key.hashCode();
        int index = hash % values.length;

        List<K> keyBucket = keys[index];

        if(keyBucket == null || !keyBucket.contains(key)) {
            return null;
        }

        int keyIndex = keyBucket.indexOf(key);
        V value = values[index].get(keyIndex);

        return value;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
