import java.util.*;

public class HashMapImplementation {

    // HashMap data structure which will be used to store data
    static class HashMap<K, V> {// generics

        // defining the LinkedList node
        private class Node {
            K key;
            V value;

            // constructor
            public Node(K key, V value) {
                this.key = key;
                this.value = value;

            }

        }

        private int n; // n - no of nodes
        private int N; // N - no of buckets
        private LinkedList<Node> bucket[]; // array of linked list

        // to remove warning
        @SuppressWarnings("unchecked")
        public HashMap() { // constructer
            this.N = 4;
            this.bucket = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.bucket[i] = new LinkedList<>();
            }
        }

        

        // put operation
        public void put(K key, V value) {
            int bucketIndex = hashFunction(key);
            int dataIndex = serachInLinkedList(key, bucketIndex);

            // update or create node
            if (dataIndex == -1) {
                bucket[bucketIndex].add(new Node(key, value));
                n++;
            } else {
                Node data = bucket[bucketIndex].get(dataIndex);
                data.value = value;
            }

            // lambda value
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                // rehashing
                reHash();
            }
        }

        //get function
        public V get(K key){
            int bucketIndex = hashFunction(key);
            int dataIndex = serachInLinkedList(key, bucketIndex);

            // update or create node
            if (dataIndex == -1) { //key doesnot exist
                return null;
            } else {
                Node data = bucket[bucketIndex].get(dataIndex);
                return data.value;
            }
        }

        //containsKey function
        public boolean containsKey(K key){
            int bucketIndex = hashFunction(key);
            int dataIndex = serachInLinkedList(key, bucketIndex);

            // update or create node
            if (dataIndex == -1) { // key doesnot exist
                return false;
            } else {
                return true;
            }
        }

        //remove function
        public V remove(K key){
            int bucketIndex = hashFunction(key);
            int dataIndex = serachInLinkedList(key, bucketIndex);

            // update or create node
            if (dataIndex == -1) { // key doesnot exist
                return null;
            } else {
                Node data = bucket[bucketIndex].remove(dataIndex);
                n--;
                return data.value;
            }

        }

        //keySet function
        public ArrayList<K> keySet(){
            ArrayList<K> keySet = new ArrayList<>();

            for(int i = 0; i < bucket.length; i++){//bucket index
                LinkedList<Node> linkedList = bucket[i];

                for(int j = 0; j < linkedList.size(); j ++){//data index
                    Node node = linkedList.get(j);
                    keySet.add(node.key);

                }

            }
            return keySet;
        }

        //isEmpty function
        public boolean isEmpty(){
            return n == 0;
        }


        // hashing function
        private int hashFunction(K key) {
            int bucketIndex = key.hashCode();

            return Math.abs(bucketIndex) % N; // need a positive value and the value should be between 0-N
        }


        // serach the key
        private int serachInLinkedList(K key, int bucketIndex) {
            LinkedList<Node> linkedList = bucket[bucketIndex];

            // to fiend the node
            for (int i = 0; i < linkedList.size(); i++) {
                if (linkedList.get(i).key == key) {
                    return i; // data index
                }
            }
            return -1;
        }

        // rehash function
        @SuppressWarnings("unchecked")
        private void reHash() {
            LinkedList<Node> oldBucket[] = bucket;
            bucket = new LinkedList[N * 2];

            // create new node
            for (int i = 0; i < N * 2; i++) {
                bucket[i] = new LinkedList<>();
            }

            // distrube key and value
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> linkedList = oldBucket[i];

                for (int j = 0; j < linkedList.size(); j++) {
                    Node node = linkedList.get(j);
                    put(node.key, node.value);
                }
            }
        }

    }

    //main function
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        //put
        hashMap.put("India", 190);
        hashMap.put("China", 200);
        hashMap.put("US", 50);

        ArrayList<String> keys = hashMap.keySet();
        for(int i = 0; i < keys.size(); i++){
            System.out.println(keys.get(i) + "-" + hashMap.get(keys.get(i)));
        }

        hashMap.remove("India");
        System.out.println(hashMap.get("India"));

    }
}
