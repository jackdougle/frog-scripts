/*
 * Author: Jack Douglass
 * File: Formatter.java
 * Purpose: The purpose of this program is to format a list of amphibian species
 * in a line-by-line fashion to paste into Excel spreadsheets.
 */

 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.HashSet;
 import java.util.Scanner;
 
 import java.io.File;
 import java.io.FileNotFoundException;
 
 public class Formatter {
 
     public static void formattedPrint(File myFile) throws FileNotFoundException {
         Scanner fReader = new Scanner(myFile);
         HashSet<String> species = new HashSet<>();

         while (fReader.hasNextLine()) {
            String[] line = fReader.nextLine().split(", ");
            for (String s : line) species.add(s);
         }

         ArrayList<String> sorted = new ArrayList<>(species);
         Collections.sort(sorted);

         for (Object s: sorted) {
            System.out.println(s);
         }

         fReader.close();
     }
     
     public static void main(String[] args) throws FileNotFoundException {
         String filename = "temp.txt";
         File myFile = new File(filename);
         
         formattedPrint(myFile);
     }
     
 }
 