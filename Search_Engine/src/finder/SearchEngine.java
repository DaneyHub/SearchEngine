package finder;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import finder.DocumentProcessor;

public class SearchEngine {


	//Search the passed word in documents from Document class
	public void SearchWord(String word) throws FileNotFoundException {


		Indexer indexer = new Indexer();
		ArrayList<String> docs = indexer.getFilesInPath(word);
		
		//docs = indexer.sort(docs);
		
		String listText = "";
		for (String file : docs) {
			listText += file + ", ";
		}
		if (listText.length() > 1)
			listText = listText.substring(0, listText.length()-2);
		System.out.print("[" + listText+ "]");
		System.out.println("\n");

	}
	
	//Search the passed word inside files in a folder
	public void SearchWord_LocalFolder(String word) throws FileNotFoundException {

		DocumentProcessor document = new DocumentProcessor();
		
		ArrayList<String> docs = document.getFilesInPath(word);
		

		
		String listText = "";
		for (String file : docs) {
			listText += file + ", ";
		}
		if (listText.length() > 1)
			listText = listText.substring(0, listText.length()-2);
		System.out.print("[" + listText+ "]");
		System.out.println("\n");

	}


	
	public boolean hasSpace(String word) {
		if (word.trim().contains(" ")) {
			return true;
		}
		return false;
	}



}
