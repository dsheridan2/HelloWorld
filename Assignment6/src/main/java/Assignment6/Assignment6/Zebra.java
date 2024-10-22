package Assignment6;

public class Zebra extends Animal {
    
    public boolean is_Wild;

    public Zebra(int age, String gender, boolean is_Wild) {
        super(age, gender);
        is_Wild = this.is_Wild;
    }
    
    public void run() {
        System.out.println("This is a public method called run from class Zebra");
    }
}
