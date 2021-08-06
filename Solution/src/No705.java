import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class No705 {
    private static final int BASE = 769;
    private List[] buckets;

    /** Initialize your data structure here. */
    public No705() {
        buckets = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            buckets[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int index = hash(key);
        Iterator<Integer> iterator = buckets[index].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (key == element) {
                return;
            }
        }
        buckets[index].add(key);
    }

    public void remove(int key) {
        int index = hash(key);
        Iterator<Integer> iterator = buckets[index].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (key == element) {
                buckets[index].remove(element);
                return;
            }
        }
    }

    private static int hash(int num) {
        return num % BASE;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hash(key);
        Iterator<Integer> iterator = buckets[index].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (key == element) {
                return true;
            }
        }
        return false;
    }
}
