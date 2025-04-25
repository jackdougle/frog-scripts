/*
 * Author: Jack Douglass
 * File: Combiner.java
 * Purpose: The purpose of this program is to get a combined list of elements from a file 
 * that has a list of elements on each line, with each element seperated by ", ".
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class Combiner {
	
	public static ArrayList<String> combineList(File myFile) throws FileNotFoundException {
		// Combines list into one, with no duplicate elements
		
		ArrayList<String> combined = new ArrayList<>();
		Scanner fReader = new Scanner(myFile);
		
		while (fReader.hasNextLine()) {
			String[] list = fReader.nextLine().split(", ");
			for (String s : list) {
				if (!combined.contains(s)) combined.add(s);
			}
		}
		
		fReader.close();
		Collections.sort(combined);
		return combined;
	}

	public static void printList(ArrayList<String> cList) {
		// Prints combined list, with ", " between each element the number of elements last.
		
		String ouput = "";
		
		for (String s : cList) {
			ouput += s + ", ";
		}
		
		System.out.println(ouput.substring(0, ouput.length() - 2));
		System.out.println(cList.size());
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String filename = args[0];
		File myFile = new File(filename);
		
		ArrayList<String> combinedList = combineList(myFile);
		
		printList(combinedList);
	}
	
}
