import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner; // Import the Scanner class to read text files

class ReadFile {
    public static void main(String[] args) {

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);

        String path = "data/filename.txt";
        boolean fileNotFound = true;

        int i = 0;
        while(fileNotFound) {
            Scanner myReader = null;
            try {
                File myObj = new File(path);
                myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                int y = 10 / i;
                fileNotFound = false;
            } catch (FileNotFoundException e) {
                System.out.println("The file was not found.");
                e.printStackTrace();
                path = "data2/filename.txt";
            } catch (ArithmeticException e) {
                i++;
                System.out.println(e.toString());
            } finally {
                // will be entered whether or not an exception was thrown
                if(myReader != null) {
                    myReader.close();
                }
            }
        }
    }
}