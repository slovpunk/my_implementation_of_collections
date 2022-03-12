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

        if (keyBucket == null || !keyBucket.contains(key)) {
            return null;
        }

        if (keyBucket.contains(key)) {
            int keyIndex = keyBucket.indexOf(key);
            return values[index].get(keyIndex);
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hash = key.hashCode();
        int index = hash % keys.length;

        List<K> keyBucket = keys[index];

        //если ключа нет, но хранилище есть
        if (keyBucket != null && !keyBucket.contains(key)) {
            keyBucket.add(key);
            values[index].add(value);
            return value;
        }

        //если нет хранилища и нет ключа
        if (keyBucket == null) {
            List<K> bucketKeys = new ArrayList<>();
            bucketKeys.add(key);
            keys[index] = bucketKeys;

            List<V> bucketValues = new ArrayList<>();
            bucketValues.add(value);
            values[index] = bucketValues;
            return value;
        }

        // если ключ есть, но значение другое
        if (keyBucket.contains(key)) {
          List<V> bucketValues = values[index];
          int keyIndex = keyBucket.indexOf(key);
          List<V> temp = new ArrayList<>();
            for (int i = 0; i < bucketValues.size(); i++) {
                if(bucketValues.indexOf(value) != keyIndex) {
                    temp.add(bucketValues.get(i));
                } else {
                    temp.add(value);
                }
            }
            values[index] = temp;
            return value;
        }

        //если ключ есть и значение
       if(keyBucket.contains(key)) {
           int keyIndex = keyBucket.indexOf(key);
           List<V> bucket = values[index];
           if(bucket.contains(value) && bucket.indexOf(value) == keyIndex) {
               return value;
           }
       }
        return null;
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
