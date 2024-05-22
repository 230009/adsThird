package src;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A binary search tree (BST) is a data structure for efficient searching, inserting, and deleting data
 * @param <K> the type of keys (which must be comparable)
 * @param <V> the type of value
 */
public class BST<K extends Comparable<K>, V> {
    protected Node root;
    private int size;

    protected class Node {
        private K key;
        private V val;
        private Node left, right;

        /**
         *  Constructs a new Node with the given key and value.
         * @param key the key related to this node
         * @param val the value related to this node
         */
        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return key;
        }

        public V getVal() {
            return val;
        }
    }

    public BST() {
        this.size = 0;
    }

    /**
     * This method returns mapped value with key in BST
     *
     * @param key The key value
     * @param val The value that mapped with key
     */
    public void put(K key, V val) {
        root = put(root, key, val);
    }
    private Node put(Node current, K key, V val) {
        if (current == null) {
            size++;
            return new Node(key, val);
        }
        int comp = key.compareTo(current.key);
        if (comp < 0) {
            current.left = put(current.left, key, val);
        } else if (comp > 0) {
            current.right = put(current.right, key, val);
        } else {
            current.val = val;
        }
        return current;
    }

    public V get(K key) {
        Node node = get(root, key);
        return node == null ? null : node.val;
    }

    private Node get(Node current, K key) {
        if (current == null) {
            return null;
        }
        int comp = key.compareTo(current.key);
        if (comp < 0) {
            return get(current.left, key);
        } else if (comp > 0) {
            return get(current.right, key);
        } else {
            return current;
        }
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node current, K key) {
        if (current == null) {
            return null;
        }
        int comp = key.compareTo(current.key);
        if (comp < 0) {
            current.left = delete(current.left, key);
        } else if (comp > 0) {
            current.right = delete(current.right, key);
        } else {
            if (current.left == null) {
                size--;
                return current.right;
            }
            if (current.right == null) {
                size--;
                return current.left;
            }
            Node temp = current;
            current.key = findSmallestValue(temp.right);
            current.right = delete(temp.right, current.key);
        }
        return current;
    }

    private K findSmallestValue(Node node) {
        return node.left == null ? node.key : findSmallestValue(node.left);
    }

    public int size() {
        return size;
    }

    public Node getRoot() {
        return root;
    }

    public Iterator<K> iterator() {
        List<K> keys = new ArrayList<>();
        inOrderTraversalKeys(root, keys);
        return keys.iterator();
    }

    private void inOrderTraversalKeys(Node node, List<K> keys) {
        if (node != null) {
            inOrderTraversalKeys(node.left, keys);
            keys.add(node.getKey());
            inOrderTraversalKeys(node.right, keys);
        }
    }

    public void inOrder() {
        List<Node> nodes = new ArrayList<>();
        inOrderTraversalNodes(root, nodes);
        for (Node node : nodes) {
            System.out.println("Key: " + node.getKey() + ", Value: " + node.getVal());
        }
    }

    private void inOrderTraversalNodes(Node node, List<Node> nodes) {
        if (node != null) {
            inOrderTraversalNodes(node.left, nodes);
            nodes.add(node);
            inOrderTraversalNodes(node.right, nodes);
        }
    }
}
