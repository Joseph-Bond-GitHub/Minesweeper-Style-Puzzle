/*
To test:
- can a list of files be loaded from a folder 
- can each of these file names be accessed 
- can new files be added to this list 
- can each of the files be accessed and edited 
 */
package TextFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadingFilesFromFolder {
    
    public static void main(String[] args) throws FileNotFoundException {      
        String username = "hello" + ".txt";
        
        if (usernameCheck(username)){
            System.out.println("Username already in use");
        }else{
            System.out.println("Not in use");
        }
            
    }
    private static boolean usernameCheck(String username){
        //Declare the folder being accessed and add its files to a list
        File folder = new File("P:\\Component 3\\ProjectTest\\User Files");
        File[] listOfFiles = folder.listFiles();
        
        //iterate through all files in the folder
        for( File file: listOfFiles){
            //if there is already a file created for this user, return false
            if (file.getName().equals(username)){
                return true;
            }
        }
        return false;
    }
} 
