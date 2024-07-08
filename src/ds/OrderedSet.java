package ds;

public class OrderedSet<T extends Comparable<T>> extends PBDS<T, Boolean> {

    public void add(T key) {
        insert(key, true);
    }

    public void remove(T key) {
        erase(key);
    }

    public boolean contains(T key) {
        return find(key);
    }

    public T get(int index) {
        return getKeyAtIndex(index);
    }

    public int getRank(T key) {
        return rank(key);
    }
}
