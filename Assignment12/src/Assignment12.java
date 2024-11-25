
import java.util.Scanner;

public class Assignment12 {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        String password;

        System.out.println("Please enter your password.");
        System.out.println("A valid password must be between 8 and 16 characters inclusive.");
        System.out.println("It must have at least one lower case letter, one upper case letter, and one number.");
        System.out.println("It must have at least one special symbol.");

        password = scan.nextLine();

        scan.close();

        checkPassword(password);
    }

    public static void checkPassword(String password){

        char[] tempArray = password.toCharArray();
        char[] PassArray = new char[tempArray.length];
        int passCounter = 0;

        for (int i = 0; i < tempArray.length; i++) {

            PassArray[i] = tempArray[i];
        }

        passCounter = checkSymbols(PassArray) + checkLower(PassArray) + checkUpper(PassArray) + checkNumbers(PassArray);

        if (passCounter >= 3 && checkLength(PassArray)) {

            System.out.println("This is a valid password.");

        }
        else {
            System.out.println("This password is not valid.");
        }
    }

    public static boolean checkLength(char[] password) {

        return password.length >= 8 && password.length <= 16;

    }

    public static int checkLower(char[] password) {

        int pass = 0;

        for (int i = 0; i < password.length; i++) {

            if (Character.isLowerCase(password[i])) {

                pass = 1;
            }
        }

        return pass;
    }

    public static int checkUpper(char[] password) {

        int pass = 0;

        for (int i = 0; i < password.length; i++) {

            if (Character.isUpperCase(password[i])) {

                pass = 1;
            }
        }

        return pass;
    }

    public static int checkNumbers(char[] password) {

        int pass = 0;

        for (int i = 0; i < password.length; i++) {

            if (Character.isDigit(password[i])) {

                pass = 1;
            }
        }

        return pass;
    }

    public static int checkSymbols(char [] password) {

        int pass = 0;

        for (int i = 0; i < password.length; i++) {

            if (!Character.isLetterOrDigit(password[i])) {

                pass = 1;
            }
        }

        return pass;
    }
}
