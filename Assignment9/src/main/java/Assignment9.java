import java.util.Random;

public class Assignment9 {

    public static void main(String[] args) {

        int length = 10;
        int[] randArr = new int[length];
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            randArr[i] = rand.nextInt(100);
        }

        int[] bubbleArray = {75, 12, 16, 80, 101, 100, 5};
        //int[] bubbleArray = {12, 75, 16};

        printArray(randArr);
        //bubbleSort(bubbleArray);
        mergeSort(randArr, 0, length - 1);
        printArray(randArr);

    }

    public static void  mergeSort(int[] arr, int left, int right) {

        if (right - left > 0) {

            int mid = (right + left) / 2;
            
            System.out.println(left);
            System.out.println(mid);
            System.out.println(right);
            System.out.println("TEST");

            int[] arrLeft = new int[mid - left + 1];
            int[] arrRight = new int[right - mid];
            int countLeft = 0, countRight = 0, count = 0;

            System.out.println(arr.length);
            System.out.println(arrLeft.length);
            System.out.println(arrRight.length);
            System.out.println("--------------------");

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            //System.out.print("Left: " + arrLeft.length + ":   ");
            for (int i = 0; i < arrLeft.length; i++) {
                arrLeft[i] = arr[left + i];
                //System.out.print(arrLeft[i] + " ");
            }
            //System.out.print("\nRight: " + arrRight.length + ":   ");
            for (int j = 0; j < arrRight.length; j++) {
                arrRight[j] = arr[mid + j];
                //System.out.print(arrRight[j] + " ");
            }

            while (countLeft < arrLeft.length && countRight < arrRight.length) {
                if (arrLeft[countLeft] < arrRight[countRight]) {
                    arr[left + count] = arrLeft[countLeft];
                    countLeft++;
                    count++;
                }
                else {
                    arr[left + count] = arrRight[countRight];
                    countRight++;
                    count++;
                }
            }

            while (countLeft < arrLeft.length) {
                arr[left + count] = arrLeft[countLeft];
                countLeft++;
                count++;
            }

            while (countRight < arrRight.length) {
                arr[left + count] = arrRight[countRight];
                countRight++;
                count++;
            }

            System.out.println();
        }
        
    }

    public static void bubbleSort(int[] arr) {
        
        //Initialize variables
        int tempVal;
        
        //The first loop ensures that we go through the array the correct number of times
        //The second loop actually makes the comparisons and swaps
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {

                //If left value is greater than right value, swap them. Otherwise do nothing
                if (arr[j] > arr[j + 1]) {
                    tempVal = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tempVal;
                }
            }
        }
    }

    public static void printArray(int[] arr) {
        
        //Loop through array to print each value, with one space in between
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }

        //Carriage return
        System.out.println();
    }
}
