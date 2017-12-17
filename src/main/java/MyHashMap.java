import java.util.ArrayList;

/**
 * @Author Mayank Gupta
 * @Date 8/24/17
 */
public class MyHashMap<I, O> {

    private Entry<I, O>[] entries;

    private int capacity;

    private int size;


    MyHashMap() {

        capacity = 1;
        entries = new MyHashMap.Entry[capacity];
    }

    void put(I key, O value) {

        if (size >= capacity) {
            resize();
        }

        int hashCode = getHash(key);

        if (entries[hashCode] == null) {
            entries[hashCode] = new Entry<>(key, value);
        } else {

            while (entries[hashCode].next != null) {
                entries[hashCode] = entries[hashCode].next;
            }

            entries[hashCode].next = new Entry<>(key, value);
        }

        ArrayList<Integer> integers = new ArrayList<>();



        size++;
    }

    public O get(I key) {

        int hashCode = getHash(key);

        while (true) {

            Entry<I, O> entry = entries[hashCode];
            if (entry.key.equals(key)) {
                return entry.value;
            } else if (entries[hashCode].next != null) {
                entries[hashCode] = entries[hashCode].next;
            } else {
                return null;
            }

        }

    }

    public int size() {
        return size;
    }

    private int getHash(I key) {

        return key.hashCode() % capacity;
    }

    private void resize() {

        int oldCapacity = capacity;
        capacity = capacity << 1;

        Entry<I, O>[] newEntries = new Entry[capacity];

        int i = 0;


        while (i < oldCapacity && entries[i] != null) {


            I key = entries[i].key;
            O value = entries[i].value;

            int newHash = getHash(key);

            if (newEntries[newHash] == null) {
                newEntries[newHash] = new Entry<>(key, value);
            } else {
                while (newEntries[newHash].next != null) {
                    newEntries[newHash] = newEntries[newHash].next;
                }
                newEntries[newHash].next = new Entry<I,O>(key, value);
            }


            while (entries[i].next != null) {

                entries[i] = entries[i].next;

                I k = entries[i].key;
                O v = entries[i].value;

                int newh = getHash(k);

                if (newEntries[newh] == null) {
                    newEntries[newh] = new Entry<>(k, v);
                } else {
                    while (newEntries[newh].next != null) {
                        newEntries[newh] = newEntries[newh].next;
                    }
                    newEntries[newh].next = new Entry<>(k, v);
                }
            }
            i++;
        }

        entries = newEntries;

    }


    class Entry<I, O> {

        public I key;
        public O value;

        public Entry<I, O> next;

        public Entry(I key, O value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Entry)) return false;

            Entry<I, O> entry = (Entry<I,O>) o;

            if (key != null ? !key.equals(entry.key) : entry.key != null) return false;
            if (value != null ? !value.equals(entry.value) : entry.value != null) return false;
            return next != null ? next.equals(entry.next) : entry.next == null;
        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }
    }
}
