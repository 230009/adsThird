package src;

public class MyTestingClass {
    private int id;
    private String name;
    public MyTestingClass (int id, String name){
        this.id = id;
        this.name = name;
    }
    public boolean equals(Object x){
        if (this == x) return true;
        if (x != null || getClass() != x.getClass()) return false;
        MyTestingClass that = (MyTestingClass) x;
        return id == that.id && name.equals(that.name);
    }
    public int hashCode() {
        int number = 13;
        int result = 1;
        result = number * result + id;
        result = number * result + ((name == null)? 0:hashCode());
        return result;
    }
    public String toString(){
        return "id = " + id + ", name = " + name;
    }
    public static void main(String[] args) {
        MyTestingClass x1 = new MyTestingClass(1, "Liya");
        MyTestingClass x2 = new MyTestingClass(1, "Liya");

        System.out.println("for x1: " + x1.hashCode());
        System.out.println("for x2: " + x2.hashCode());
        System.out.println("x1 equals x2: " + x1.equals(x2));
    }

}

