package src;
public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();

        bst.put(5, "five");
        bst.put(3, "three");
        bst.put(4, "four");
        bst.put(2, "two");
        bst.put(6, "six");
        bst.put(7, "seven");

        bst.inOrder();
        System.out.println();
        System.out.println("Root data before remove: " +bst.getRoot().getKey());
        bst.delete(5);
        System.out.println();
        bst.inOrder();
        System.out.println();
        System.out.println("Root data after remove: " +bst.getRoot().getKey());

        MyTestingClass.test();
    }
}
