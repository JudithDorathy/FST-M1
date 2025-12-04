import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Activity_j14 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a new text file using the default File Class
            File file = new File("example.txt");
            boolean fStatus = file.createNewFile();
            
            if (fStatus) {
                System.out.println("File created successfully: " + file.getName());
            } else {
                System.out.println("File already exists: " + file.getName());
            }
            
            // Step 2: Write some text into the text file
            String content = "Hello, this is a sample text written to the file!\n" +
                           "This is the second line of the file.\n" +
                           "FileUtils makes file operations easier.";
            FileUtils.writeStringToFile(file, content, "UTF8");
            System.out.println("Text written to file successfully.");
            
            // Step 3: Read the file using readFileToString()
            System.out.println("\nData in file: " + FileUtils.readFileToString(file, "UTF8"));
            
            // Step 4: Create a new directory named "destDir"
            File destDir = new File("destDir");
            boolean dirStatus = destDir.mkdir();
            
            if (dirStatus) {
                System.out.println("Directory created successfully: " + destDir.getName());
            } else {
                System.out.println("Directory already exists: " + destDir.getName());
            }
            
            // Step 5: Copy the text file into this directory using copyFileToDirectory()
            FileUtils.copyFileToDirectory(file, destDir);
            System.out.println("File copied to directory successfully.");
            
            // Step 6: Read data from the new file in the directory
            // Get file from new directory
            File newFile = new File(destDir, file.getName());
            
            // Read data from file
            String newFileData = FileUtils.readFileToString(newFile, "UTF8");
            System.out.println("\nData in copied file: " + newFileData);
            
            // Optional: Clean up - delete created files and directory
            System.out.println("\n--- Cleaning up ---");
            boolean newFileDeleted = newFile.delete();
            boolean fileDeleted = file.delete();
            boolean dirDeleted = destDir.delete();
            
            if (newFileDeleted && fileDeleted && dirDeleted) {
                System.out.println("All created files and directory deleted successfully.");
            }
            
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}