package main;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class MainEngine{

	ArrayList<String> files = new ArrayList<String>();



	



	public static void main(String[] args) throws FileNotFoundException {

		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "type of animal");
		System.out.println(map.get(1));
		/*
		Scanner input = new Scanner(System.in);
		MainEngine mainEngine = new MainEngine();
		String word;		
		do {
			System.out.println("Enter a word (without Space) to search");			
			word = input.nextLine().trim();
		} while (mainEngine.hasSpace(word));	
		input.close();

		mainEngine.SearchWord(word);*/
	}




	private void SearchWord(String word) throws FileNotFoundException {

		Document doc = new Document();
		ArrayList<String> docs = doc.getFilesInPath(word);
		String listText = "";
		for (String file : docs) {
			listText += file + ", ";
		}
		listText = listText.substring(0, listText.length()-2);
		System.out.print("[" + listText+ "]");

	}





	public boolean hasSpace(String word) {
		if (word.trim().contains(" ")) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	


	
	//Getters and Setters
	public ArrayList<String> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<String> files) {
		this.files = files;
	}


}
