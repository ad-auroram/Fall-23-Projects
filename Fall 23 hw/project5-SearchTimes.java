/**
 * Assignment 4 for CS 1410
 * This program evaluates the linear and binary searching, along
 * with comparing performance difference between the selection sort
 * and the built-in java.util.Arrays.sort.
 *
 * @author James Dean Mathias
 */
public class EvaluationDriver {
    static final int MAX_VALUE = 1_000_000;
    static final int MAX_ARRAY_SIZE = 100_000;
    static final int ARRAY_INCREMENT = 20_000;
    static final int NUMBER_SEARCHES = 50_000;

    public static void main(String[] args) {
        demoLinearSearchUnsorted();
        demoLinearSearchSorted();
        demoBinarySearchSelectionSort();
        demoBinarySearchFastSort();
    }


    //building blocks
    public static int[] generateNumbers(int howMany, int maxValue) {
        /*
        Creates and returns an array of integers
        uses math.random to generate numbers from 0-1 multiplied by maxValue
        howMany = how many integers the array should have
        if howMany is less than 1 return null
         */
        int[] array = new int[howMany];
        for (int i = 0; i < howMany; i++) {
            array[i] = (int) (Math.random() * maxValue);
        }
        return array;
    }

    public static boolean linearSearch(int[] data, int search) {
    /*
    linear search method that searches an array (data) for a specified value (search)
    return true/false appropriately
     */
        for (int val : data) {
            if (val == search) {
                return true;
            }
        }
        return false;
    }
    public static boolean binarySearch(int[] data, int search){
    /*
    binary search an array (data) for specified value (search)
    return true or false
     */
        int lower = 0;
        int upper = data.length-1;
        int middle = (upper + lower)/2;
        boolean found = false;

        while(!found && lower <= upper){
            if (data[middle] == search){
                return true;
            } else if (data[middle]>search){
                upper = middle - 1;
            } else if (data[middle]<search){
                lower = middle + 1;
            }
            middle = (upper + lower)/2;
        }
        return false;
    }
    public static void selectionSort(int[] data){
        /*
        selection sort that sorts an array lowest to highest
         */
        for (int i=0; i<data.length;i++){
            int min = i;
            for (int j = i+1; j<data.length;j++){
                if (data[j]<data[min]){
                    min=j;
                }
            }
            int temp = data[i];
            data[i] = data[min];
            data[min] = temp;
        }
      }

    //tests down here
    public static String demoLinearSearchUnsorted() {
        /*
        generate random array, count based on current loop index value
        time how long it tales to do a linear search NUMBER_SEARCHES times
        generate random number each time up to MAX_VALUE
        track and report data
         */
        System.out.println("--- Linear Search Timing (unsorted) ---");
        int found = 0;
        int totalTime = 0;
        long time1 = System.currentTimeMillis();
        for (int i = ARRAY_INCREMENT; i <= MAX_ARRAY_SIZE; i += ARRAY_INCREMENT) {
            int[] array = generateNumbers(i, MAX_VALUE);
            for (int j = 0; j <= NUMBER_SEARCHES; j++) {
                int search = (int) (Math.random() * MAX_VALUE);
                if (linearSearch(array, search)) {
                    found += 1;
                }
            }
            long time2 = System.currentTimeMillis();
            totalTime += Math.round(time2 - time1);
            System.out.printf("Number of items: %d \nTimes value was found: %d\nTotal search time: %dms\n", i, found, totalTime);
            System.out.println();

        }
        return "";
    }

    public static String demoLinearSearchSorted(){
        /*
        just like above, except this time we sort first
        selection sort the array then do a bunch of searches for randomly generated numbers
         */
        System.out.println("--- Linear Search Timing (Selection Sort) ---");
        int found = 0;
        int totalTime = 0;
        long time1 = System.currentTimeMillis();
        for (int i = ARRAY_INCREMENT; i <= MAX_ARRAY_SIZE; i += ARRAY_INCREMENT) {
            int[] array = generateNumbers(i, MAX_VALUE);
            selectionSort(array);
            for (int j = 0; j <= NUMBER_SEARCHES; j++) {
                int search = (int) (Math.random() * MAX_VALUE);
                if (linearSearch(array, search)) {
                    found += 1;
                }
            }
            long time2 = System.currentTimeMillis();
            totalTime += Math.round(time2 - time1);
            System.out.printf("Number of items: %d \nTimes value was found: %d\nTotal search time: %dms\n", i, found, totalTime);
            System.out.println();

        }
        return "";
    }

    public static String demoBinarySearchSelectionSort(){
        /*
        like above, expect with binary search
         */
        System.out.println("--- Binary Search Timing (Selection Sort) ---");
        int found = 0;
        int totalTime = 0;
        long time1 = System.currentTimeMillis();
        for (int i = ARRAY_INCREMENT; i <= MAX_ARRAY_SIZE; i += ARRAY_INCREMENT) {
            int[] array = generateNumbers(i, MAX_VALUE);
            selectionSort(array);
            for (int j = 0; j <= NUMBER_SEARCHES; j++) {
                int search = (int) (Math.random() * MAX_VALUE);
                if (binarySearch(array, search)) {
                    found += 1;
                }
            }
            long time2 = System.currentTimeMillis();
            totalTime += Math.round(time2 - time1);
            System.out.printf("Number of items: %d \nTimes value was found: %d\nTotal search time: %dms\n", i, found, totalTime);
            System.out.println();

        }
        return "";
    }

     public static String demoBinarySearchFastSort(){
        /*
        generate array like the others
        use java.util.Arrays.sort
        do a binary search NUMBER_SEARCHES times
         */
         System.out.println("--- Binary Search Timing (Arrays.sort) ---");
         int found = 0;
         int totalTime = 0;
         long time1 = System.currentTimeMillis();
         for (int i = ARRAY_INCREMENT; i <= MAX_ARRAY_SIZE; i += ARRAY_INCREMENT) {
             int[] array = generateNumbers(i, MAX_VALUE);
             java.util.Arrays.sort(array);
             for (int j = 0; j <= NUMBER_SEARCHES; j++) {
                 int search = (int) (Math.random() * MAX_VALUE);
                 if (binarySearch(array, search)) {
                     found += 1;
                 }
             }
             long time2 = System.currentTimeMillis();
             totalTime += Math.round(time2 - time1);
             System.out.printf("Number of items: %d \nTimes value was found: %d\nTotal search time: %dms\n", i, found, totalTime);
             System.out.println();

         }
         return "";
    }


}

