import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) throws FileNotFoundException {

        int[] userArray;
        String unsortedArray = "UnsortedArray.txt";
        String SortedArray = "SortedArray.txt";
        String userInput;
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Bubble Sorter.\nTo generate a random array, enter an integer for the length of the array.");
        System.out.println("To sort an aray stored in a .txt file, enter the name of the file.");

        userInput = scan.nextLine();
        
        if (isInteger(userInput)) {

            userArray = createRandomArray(Integer.parseInt(userInput));

            writeArrayToFile(userArray, unsortedArray);

        }
        else {

            userArray = readFileToArray(userInput);
            bubbleSort(userArray);
            writeArrayToFile(userArray, SortedArray);

        }

        }

    // Given arrayLength as argument, create an array of random integers between 0 and 100; return the created array.
    public static int[] createRandomArray(int arrayLength) {

        int[] randArr = new int[arrayLength];
        Random rand = new Random();

        for (int i = 0; i < arrayLength; i++) {

            randArr[i] = rand.nextInt(100);
            
        }

        return randArr;

    }

    // Given an integer array and filename, write the array to the file, with each line containing one integer in the array.
    public static void writeArrayToFile(int[] array, String filename) {

        try {
            FileWriter writing = new FileWriter(filename);
            
            for (int i : array) {

                writing.write(i + "\n");

            }

            writing.close();

        } catch (Exception e) {

            System.out.println("Something went wrong");

        }
        
    }
 
    // This is the reverse of writeArrayToFile; Given the filename, read the integers (one line per integer) to an array, and return the array
    public static int[]  readFileToArray(String filename) throws FileNotFoundException {

        String commaString = "";
        String[] newArrayString;
        
        try (Scanner scan = new Scanner(new File (filename))) {

            while(scan.hasNextLine()) {

                commaString = commaString + scan.nextLine() + ",";

            }

            newArrayString = commaString.split(",");
        }

        int[] newArrayInt = new int[newArrayString.length];
        
        for (int i = 0; i < newArrayString.length; i++) {

            newArrayInt[i] = Integer.parseInt(newArrayString[i]);

        }

        return newArrayInt;
    }

    // Given an integer array, sort it in-place, i.e., the order of the elements will be changed so that the final array is in sorted order.
    public static void bubbleSort(int[] array) {

        int tempVal;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {

                if(array[j] > array[j + 1]) {

                    tempVal = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tempVal;

                }
            }
        }

    }

    public static void printArray(int[] array) {

        System.out.print("Array: ");
        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + " ");

        }

        System.out.println();
    }

    public static boolean isInteger(String arg) {

        try {
            Integer.parseInt(arg);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
