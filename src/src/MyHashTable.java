package src;

public class MyHashTable <K, V>{
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable(int capacity){
        chainArray = new HashNode[capacity];
        size = 0;
    }
    private int hash (K key){
        return key.hashCode()%chainArray.length;
    }
    public void put(K key, V value){
        int index = hash(key);
        HashNode<K, V> newHashNode = new HashNode<>(key, value);
        if (chainArray[index] == null){
            chainArray[index] = newHashNode;
        }
        else {
            HashNode<K, V> current = chainArray[index];
            while (current.next != null){
                if(current.key.equals(key)){
                    current.value = value;
                    return;
                }
                current.next = newHashNode;
            }
            size++;
        }
    }
    public V get (K key){
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        while (current != null){
            if (current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    public V remove (K key){
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        HashNode<K, V> previous = null;
        while (current != null){
            if (current.key.equals(key)){
                if(previous == null){
                    chainArray[index] = current.next;
                }
                else{
                    previous.next = current.next;
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }
    public boolean contains(K key){
        return get(key) != null;
    }
    public K getKey(HashNode<K, V> node){
        return node.key;
    }
}

