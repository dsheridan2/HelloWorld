import java.util.Random;

public class Assignment9 {

    public static void main(String[] args) {

        int length = 100000;
        int[] BubbleArray = new int[length];
        Random rand = new Random();
        long bubbleStart, bubbleEnd, mergeStart, mergeEnd, bubbleTime, mergeTime;

        for (int i = 0; i < length; i++) {
            BubbleArray[i] = rand.nextInt(10000);
        }

        int[] mergeArray = BubbleArray;

        bubbleStart = System.currentTimeMillis();
        bubbleSort(BubbleArray);
        bubbleEnd = System.currentTimeMillis();
        bubbleTime = bubbleEnd - bubbleStart;

        mergeStart = System.currentTimeMillis();
        mergeSort(mergeArray);
        mergeEnd = System.currentTimeMillis();
        mergeTime = mergeEnd - mergeStart;

        System.out.println("Bubble sort time: " + bubbleTime + " milliseconds.");
        System.out.println("Merge sort time: " + mergeTime + " milliseconds.");

        if (mergeTime < bubbleTime) {
            System.out.println("Merge sort outperformed bubble sort by " + (bubbleTime - mergeTime) + " milliseconds");
        }
        else {
            System.out.println("Merge sort outperformed bubble sort by " + (mergeTime - bubbleTime) + " milliseconds");
        }

    }

    public static void mergeSort(int[] array) {

        mergeSort(array, 0, array.length);

    }

    public static void mergeSort(int[] array, int start, int end) {

        if (end - start <= 1) return;

        int middle = (start + end) / 2;

        mergeSort(array, start, middle);
        mergeSort(array, middle, end);
        merge(array, start, middle, end);

    }

    public static void merge(int[] array, int start, int middle, int end) {

        int i = start;
        int j = middle;
        int k = 0;
        int[] tempArray = new int[end - start];

        while (i < middle && j < end) {
            if (array[i] <= array[j]) {
                tempArray[k] = array[i];
                i++;
            }
            else {
                tempArray[k] = array[j];
                j++;
            }
            k++;
        }

        while (i < middle) {
            tempArray[k] = array[i];
            i++;
            k++;
        }

        while (j < end) {
            tempArray[k] = array[j];
            j++;
            k++;
        }

        for (i = start; i < end; i++) {
            array[i] = tempArray[ i - start];
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
