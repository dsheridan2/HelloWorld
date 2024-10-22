public class Fish extends Animal {
    
    private int sizeInFeet;

    public Fish(int age, String gender, int sizeInFeet) {
        super(age, gender);
        sizeInFeet = this.sizeInFeet;
    }

    private void canEat() {
        System.out.println("This is a private method called canEat from class Fish");
    }
    
}
