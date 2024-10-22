//Class imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Assignment5 {
    public static void main(String[] args) throws FileNotFoundException {
        
        //Variable declaration
        String matrixName1 = null, matrixName2 = null;
        int[][] matrix1 = {{}};
        int[][] matrix2 = {{}};
        int matrixSize;
        
        //If the input argugment is 1, then we need to create our own matrices
        if (args.length == 1) {
            matrixSize = Integer.parseInt(args[0]);

            matrix1 = createMatrix(matrixSize);
            matrix2 = createMatrix(matrixSize);
        }
        //If the input argument is greater than 1, then set the name of the files
        else if (args.length > 1) {

            matrixName1 = args[0];
            matrixName2 = args[1];

            matrix1 = readFile(matrixName1);
            matrix2 = readFile(matrixName2);
        }
        //If the program was run with no arguments, then ask for the file names
        else{

            boolean invalidInput = true;

            try (Scanner scan = new Scanner(System.in)){

                while(invalidInput) {

                System.out.println("Enter the name of each .txt file in one line seperated by a space");

                String userInput = scan.nextLine();
                String[] inputLine = userInput.split(" ");

                    if (inputLine.length == 2) {
                        invalidInput = false;

                        matrixName1 = inputLine[0];
                        matrixName2 = inputLine[1];
                    }
                    else {
                        System.out.println("Invalid input. Try again.");
                    }
                }

                matrix1 = readFile(matrixName1);
                matrix2 = readFile(matrixName2);
            }
        }

        //printMatrix(matrix1);

        matrixMult(matrix1, matrix2);

    }

    public static int[][] createMatrix(int size) {

        Random rand = new Random();

        int[][] randomMatrix = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            for ( int j = 0; j < size; j++) {
                randomMatrix[i][j] = rand.nextInt(100);
            }
        }

        return randomMatrix;
    }

    public static int[][] readFile(String fileName) throws FileNotFoundException {
        
        //Variable declaration
        int rowCounter = 0, writeCounter = 0, lengthCounter = 0;
        String[] tempStringArray;
        String tempString;
        ArrayList<Integer> tempArrayList = new ArrayList<>();

        try (Scanner scan = new Scanner(new File(fileName))) {

            //Run through each line in the file
            while (scan.hasNextLine()) {
                
                tempString = scan.nextLine();
                tempStringArray = tempString.split(" ");
                lengthCounter = 0;
                
                //Convert strings to ints and add to temp array
                for(String i : tempStringArray) {
                    tempArrayList.add(Integer.valueOf(i));
                    lengthCounter++;
                }

                //Count number of rows to declare final array
                rowCounter++;
            }
        }

        //Declare final matrix size
        int[][] finalMatrix = new int[rowCounter][lengthCounter];

        //Write array list to final array
        for (int i = 0; i < rowCounter; i++) {
            for (int j = 0; j < lengthCounter; j++) {
                finalMatrix[i][j] = tempArrayList.get(writeCounter);
                writeCounter++;
            }
        }
        
        return finalMatrix;
    }

    public static void printMatrix(int[][] finalMatrix) {
        
        for (int i[] : finalMatrix) {
            for ( int j : i ) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void matrixMult(int[][] matrix1, int[][] matrix2) {
        int[][] finalAnswer = new int[matrix1.length][matrix2[0].length];
        int cellValue = 0;
        //System.out.println(matrix1.length + " " + matrix2[0].length);

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                cellValue = cellValue + (matrix1[i][j] * matrix2[j][i]);
            }
            
        }

        printMatrix(finalAnswer);
       // return finalAnswer;
    }
}
