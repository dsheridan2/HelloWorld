import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {

        //Initialize variables
        String userInput, convertFrom, convertTo;
        
        //Scan for input from user
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Output to user");

            userInput = scan.next();

            while(!userInput.equalsIgnoreCase("Exit")){
                // while (userInput == "valid input") {}
            }
           
            System.out.println("Thank you for converting!");
        }
    }
}
