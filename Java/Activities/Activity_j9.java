import java.util.ArrayList;

public class Activity_j9 {
    public static void main(String[] args) {
        // Create an ArrayList named myList of type String
        ArrayList<String> myList = new ArrayList<>();
        
        // Add 5 names to the ArrayList using add() method
        myList.add("Alice");
        myList.add("Bob");
        myList.add("Charlie");
        myList.add("David");
        myList.add("Eva");
        
        // Print all the names using for loop
        System.out.println("All names in the list:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
        
        // Use get() method to retrieve the 3rd name in the ArrayList
        String thirdName = myList.get(2);
        System.out.println("\nThe 3rd name is: " + thirdName);
        
        // Use contains() method to check if a name exists in the ArrayList
        String searchName = "David";
        boolean hasName = myList.contains(searchName);
        System.out.println("\nDoes the list contain '" + searchName + "'? " + hasName);
        
        // Use size() method to print the number of names in the ArrayList
        System.out.println("\nNumber of names in the list: " + myList.size());
        
        // Use remove() method to remove a name from the list
        myList.remove(1); // Removes "Bob" at index 1
        System.out.println("\nAfter removing name at index 1:");
        
        // Print the updated list
        System.out.println("Updated list:");
        for (String name : myList) {
            System.out.println(name);
        }
        
        // Print the size() of the list again
        System.out.println("\nNumber of names after removal: " + myList.size());
        
        // Additional examples of the other methods mentioned:
        
        // 1. add(int, Object) - Add "Frank" at index 2
        myList.add(2, "Frank");
        System.out.println("\nAfter adding 'Frank' at index 2:");
        System.out.println("List: " + myList);
        
        // 2. set(int, Object) - Replace name at index 0 with "Anna"
        myList.set(0, "Anna");
        System.out.println("\nAfter setting index 0 to 'Anna':");
        System.out.println("List: " + myList);
        
        // 3. remove(int) - Already demonstrated above
        // 4. get(int) - Already demonstrated above  
        // 5. size() - Already demonstrated multiple times
    }
}