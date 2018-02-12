package main;

import java.io.*;
import java.util.*;

public class MainEngine extends Document{

	ArrayList<String> files = new ArrayList<String>();


	public static void main(String[] args) throws FileNotFoundException {

		Scanner input;
		MainEngine mainEngine = new MainEngine();
		input = new Scanner(System.in);
		String word;		
		do {
			System.out.println("Enter a word to search (No Space)");			
			word = input.nextLine();
		} while (mainEngine.hasSpace(word));	
		input.close();

		mainEngine.SearchWord(word);
	}




	private void SearchWord(String word) throws FileNotFoundException {

		Document doc = new Document();
		ArrayList<String> docs = doc.getFilesInPath(word);
		System.out.print("[");
		for (String file : docs) {
			System.out.print(file + ", ");
		}
		System.out.print("]");

	}





	public boolean hasSpace(String word) {
		if (word.trim().contains(" ")) {
			return true;
		}
		return false;
	}



}
