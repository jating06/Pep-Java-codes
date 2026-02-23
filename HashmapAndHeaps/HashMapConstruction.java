public class CustomHashMap < K, V > {

    CustomHashMap() {
        initialize(4);
        size = 0;
    }

    class HashNode {
        public K key;
        public V value;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    LinkedList < HashNode > list[];
    int size;

    public void initialize(int size) {
        try {
            list = new LinkedList[size];
            for (int i = 0; i < list.length; i++) {
                list[i] = new LinkedList < > ();
            }
        } catch (Exception e) {

        }
    }


    public void put(K key, V value) throws Exception {
        int bi = getBuckedIndex(key);
        int di = getIndexWithinBucket(bi, key);
        if (di == -1) {
            list[bi].add(new HashNode(key, value));
            size++;
        } else {
            HashNode node = list[bi].get(di);
            node.value = value;
        }
        double lambda = size * 1.0 / list.length;
        if (lambda > 2.0)
            rehash();
    }

    public void rehash() throws Exception {
        LinkedList < HashNode > oldBuckets[] = list;
        initialize(2 * size);
        size = 0;
        for (int i = 0; i < oldBuckets.length; i++) {
            for (HashNode node: oldBuckets[i]) {
                put(node.key, node.value);
            }
        }
    }

    public int getBuckedIndex(K key) throws Exception {
        int hashCode = key.hashCode();
        return (Math.abs(hashCode)) % list.length;
    }

    public int getIndexWithinBucket(int bi, K key) throws Exception {
        int idx = 0;
        for (HashNode node: list[bi]) {
            if (node.key.equals(key)) {
                return idx;
            }
            idx++;
        }
        return -1;
    }

    public V get(K key) throws Exception {
        int bi = getBuckedIndex(key);
        int di = getIndexWithinBucket(bi, key);
        if (di == -1) {
            return null;
        } else {
            HashNode node = list[bi].get(di);
            return node.value;
        }
    }

    public boolean exists(K key) throws Exception {
        int bi = getBuckedIndex(key);
        int di = getIndexWithinBucket(bi, key);
        if (di == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void remove(K key) throws Exception {
        int bi = getBuckedIndex(key);
        int di = getIndexWithinBucket(bi, key);
        if (di == -1) {
            return;
        } else {
            list[bi].remove(di);
        }
    }

}