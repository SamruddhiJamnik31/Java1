import java.io.*;
import java.util.Scanner;

public class FileAnalysis {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // replace with the path of your text file

        int vowelsCount = 0;
        int wordsCount = 0;
        int aCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
               
                for (char c : line.toCharArray()) {
                  
                    if (isVowel(c)) {
                        vowelsCount++;
                    }
                   
                    if (c == 'a' || c == 'A') {
                        aCount++;
                    }
                }
             
                String[] words = line.split("\\s+");
                wordsCount += words.length;
            }

 
            System.out.println("Total number of vowels: " + vowelsCount);
            System.out.println("Total number of words: " + wordsCount);
            System.out.println("Number of times 'a' appears: " + aCount);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c); 
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
