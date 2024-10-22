public class Animal {

    public int age;
    public String gender;

    public static void main(String[] args) {
        Animal aDogNamedMaddox = new Animal(4, "male");
        Fish aSwordfish = new Fish(6, "female", 6);
        Zebra aZebra = new Zebra(7, "male", true);

        aDogNamedMaddox.isMammal();
        aDogNamedMaddox.mate();

        aZebra.isMammal();
        aZebra.mate();
        aZebra.run();
    }

    public Animal (int age, String gender) {
        age = this.age;
        gender = this.gender;
    }
    public  void isMammal () {
        System.out.println("This is a public method called isMammal from class Animal");
    }

    public  void mate() {
        System.out.println("This is a public method called mate from class Animal");
    }
}
