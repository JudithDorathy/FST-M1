public class Activity_j4 {
    public static void main(String[] args) {
        // Example array to sort
        int[] numbers = {5, 2, 8, 1, 9, 3, 7, 4, 6};
        
        System.out.println("Original array:");
        printArray(numbers);
        
        // Perform insertion sort
        insertionSort(numbers);
        
        System.out.println("\nSorted array:");
        printArray(numbers);
    }
    
    /**
     * Implementation of Insertion Sort algorithm
     * @param array - the array to be sorted
     */
    public static void insertionSort(int[] array) {
        int n = array.length;
        
        for (int i = 1; i < n; i++) {
            int key = array[i];  // Current element to be inserted
            int j = i - 1;
            
            System.out.printf("\nPass %d: Inserting %d\n", i, key);
            System.out.print("Array before insertion: ");
            printArray(array);
            
            // Move elements of array[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;  // Insert key at correct position
            
            System.out.print("Array after insertion:  ");
            printArray(array);
        }
    }
    
    /**
     * Helper method to print an array
     * @param array - the array to print
     */
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}