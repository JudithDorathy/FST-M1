public class Activity_j2 {
    public static void main(String[] args) {
        // Initialize the array
        int[] numbers = {10, 77, 10, 54, -11, 10};
        
        // Variables to track sum and target
        int sum = 0;
        int targetValue = 30;
        
        // Find all 10's in the array and add them
        for (int num : numbers) {
            if (num == 10) {
                sum += num;
            }
        }
        
        // Check if sum is exactly 30
        boolean result = (sum == targetValue);
        
        // Display the result
        System.out.println("Sum of all 10's in the array: " + sum);
        System.out.println("Is the sum exactly 30? " + result);
        

    }
}