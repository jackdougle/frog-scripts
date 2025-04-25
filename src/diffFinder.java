import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class diffFinder {
	
	public static String[] getArray(String filename) throws FileNotFoundException {
		File myFile = new File(filename);
		Scanner fReader = new Scanner(myFile);
		
		String species = fReader.nextLine();
		
		fReader.close();
		
		String[] speciesList = species.split(", ");
		
		return speciesList;
	}
	
	public static ArrayList<String> getDifferences(String[] newList, String[] oldList) {
		ArrayList<String> differences = new ArrayList<String>();
		
		for (int i = 0; i < oldList.length; i++) {
			boolean includes = Arrays.asList(newList).contains(oldList[i]);
			if (!includes) differences.add(oldList[i]);
		}
		
		return differences;
	}
	
	public static void printList(ArrayList<String> dList) {
		// Prints combined list, with ", " between each element the number of elements last.
		
		String ouput = "";
		
		for (String s : dList) {
			ouput += s + "\n";
		}
		
		System.out.println(ouput.substring(0, ouput.length() - 2));
		System.out.println(dList.size());
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		String filename1 = "southAmerica.txt";
		String filename2 = "southAmericaOld.txt";
		
		String[] newList = getArray(filename1);
		String[] oldList = getArray(filename2);
		
		ArrayList<String> differences = getDifferences(newList, oldList);
		
		printList(differences);
	}
}
