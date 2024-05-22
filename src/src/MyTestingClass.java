package src;

import java.util.Objects;

public class MyTestingClass {
    private int id;
    private String name;

    /**
     * @param id the identifier for this instance
     * @param name the name for this instance
     *
     */
    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @param x the object to compare to
     * @return true if the objects are equal, false otherwise
     * Checks if this instance is equal to another object.
     */
    public boolean equals(Object x) {
        if (this == x) return true;
        if (x != null || getClass() != x.getClass()) return false;
        MyTestingClass that = (MyTestingClass) x;
        return id == that.id && name.equals(that.name);
    }

    /**
     * @return returns the hash code value
     */
    @Override
    public int hashCode() {
        int number = 13;
        int result = 1;
        result = number * result + id;
        result = number * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /**
     * @return  returns a string representation
     */
    @Override
    public String toString() {
        return "id = " + id + ", name = " + name;
    }



    public static void test() {
        MyTestingClass x1 = new MyTestingClass(1, "Liya");
        MyTestingClass x2 = new MyTestingClass(1, "Liya");

        System.out.println("for x1: " + x1.hashCode());
        System.out.println("for x2: " + x2.hashCode());
        System.out.println("x1 equals x2: " + x1.equals(x2));
    }

}

