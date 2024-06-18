package ds;

import java.util.TreeMap;

public class MultiSet<T> extends TreeMap<T, Integer> {
    private int size;

    public void add(T key) {
        super.put(key, super.getOrDefault(key, 0) + 1);
        this.size++;
    }

    public boolean delete(T key) {
        if (!super.containsKey(key)) return false;
        int freq = super.get(key);
        if (freq == 1) super.remove(key);
        else super.put(key, freq - 1);
        this.size--;
        return true;
    }

    public int size() {
        return this.size;
    }

    public int distinct() {
        return super.size();
    }
}