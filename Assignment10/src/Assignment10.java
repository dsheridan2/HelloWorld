import java.util.ArrayList;
import java.util.Random;

public class Assignment10 {

    public static <T> void main(String[] args) {

        int length = 1000;
        Integer[] BubbleArray = new Integer[length];
        Random rand = new Random();
        long bubbleStart, bubbleEnd, mergeStart, mergeEnd, bubbleTime, mergeTime;

        for (int i = 0; i < length; i++) {
            BubbleArray[i] = rand.nextInt(10000);
        }

        Integer[] mergeArray = BubbleArray;

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
            System.out.println("Merge sort outperformed bubble sort by " + (bubbleTime - mergeTime) + " milliseconds for " + length + " integers.");
        }
        else {
            System.out.println("Merge sort outperformed bubble sort by " + (mergeTime - bubbleTime) + " milliseconds for " + length + " integers.");
        }

    }

    public static <T extends Comparable<T> > void mergeSort(T[] array) {

        mergeSort(array, 0, array.length);

    }

    public static <T extends Comparable<T> > void mergeSort(T[] array, int start, int end) {

        if (end - start <= 1) return;

        int middle = (start + end) / 2;

        mergeSort(array, start, middle);
        mergeSort(array, middle, end);
        merge(array, start, middle, end);

    }

    public static <T extends Comparable<T> > void merge(T[] array, int start, int middle, int end) {

        int i = start;
        int j = middle;
        int k = 0;
        ArrayList<T> tempList = new ArrayList<T>();
        //T[] tempArray = (T[])new Object[end - start];

        while (i < middle && j < end) {
            if (array[i].compareTo(array[j]) > 0) {
                tempList.add(array[i]);
                //tempArray[k] = array[i];
                i++;
            }
            else {
                tempList.add(array[j]);
                //tempArray[k] = array[j];
                j++;
            }
            k++;
        }

        while (i < middle) {
            tempList.add(array[i]);
            //tempArray[k] = array[i];
            i++;
            k++;
        }

        while (j < end) {
            tempList.add((array[j]));
            //tempArray[k] = array[j];
            j++;
            k++;
        }

        for (i = start; i < end; i++) {
            array[i] = tempList.get(i - start);
            //array[i] = tempArray[ i - start];
        }

    }

    public static <T extends Comparable<T> > void bubbleSort(T[] array) {
        
        //Initialize variables
        T tempVal;
        
        //The first loop ensures that we go through the array the correct number of times
        //The second loop actually makes the comparisons and swaps
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {

                //If left value is greater than right value, swap them. Otherwise do nothing
                if (array[j].compareTo(array[j+1]) > 0) {
                    tempVal = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tempVal;
                }
            }
        }
    }

    public static void printArray(int[] array) {
        
        //Loop through array to print each value, with one space in between
        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k] + " ");
        }

        //Carriage return
        System.out.println();
    }
}
