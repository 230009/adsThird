package src;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BST<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node current, K key, V val) {
        if (current == null) return new Node(key, val);
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
        if (node == null) {
            return null;
        }
        return node.val;
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
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            current.key = findSmallestValue(current.right);
            current.right = delete(current.right, current.key);
        }
        return current;
    }
    private K findSmallestValue(Node node) {
        return node.right == null ? node.key : findSmallestValue(node.right);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    public Iterable<K> iterator() {
        List<K> keys = new ArrayList<>();
        inOrderTraversal(root, keys);
        return keys;
    }
    private void inOrderTraversal(Node node, List<K> keys) {
        if (node != null) {
            inOrderTraversal(node.left, keys);
            keys.add(node.key);
            inOrderTraversal(node.right, keys);
        }
    }
}


