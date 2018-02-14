package finder;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Indexer extends DocumentProcessor {

	
	
	public DocumentProcessor document;
	
	ArrayList<String> docFileNames;
	ArrayList<String> docsStrings;
	Map<String, String> map_doc;
	ArrayList<Integer> wordFoundTimes;
	ArrayList<String> strFiles;
	
	public Indexer(){	
		
		document = new DocumentProcessor();
		docFileNames = new ArrayList<String>();
		docsStrings = new ArrayList<String>();
		map_doc = new HashMap<String, String>();
		wordFoundTimes = new ArrayList<Integer>();
		strFiles = document.getStringFiles();
		
		docsStrings.add(document1);
		docsStrings.add(document2);
		docsStrings.add(document3);		
		docsStrings.add(document4);	
	}
	
	//get Files from document files
	@Override
	public ArrayList<String> getFilesInPath(String word) throws FileNotFoundException{
				
		int counterFreq = 0; // Count frequency of word in each doc

		String[] splitString;
		for (int i=0; i<docsStrings.size();i++) {
			splitString = tokenizeDoc(docsStrings.get(i));
			for(String str: splitString){
				if(word.equals(str)){
					counterFreq++;								
				}
			}
			
			wordFoundTimes.add(counterFreq);
			counterFreq = 0;				
		}		
		
		//Sort docs by the searched word frequency
		sortDocs();

		int count_0s=0; //Count number of docs with the word is found 0 times.
		
		for (int val:wordFoundTimes ){
			if(val==0)
				count_0s++;
		}
		
	
		for (int i=0; i<strFiles.size()-count_0s;i++){

			docFileNames.add(strFiles.get(i));

		}
		
		return  docFileNames;
	}

	//divide each document into individual words.
	private String[] tokenizeDoc(String str) {
		String[] splitStr = str.split(" ");
		return splitStr;
		
	}


	public ArrayList<String> sort(ArrayList<String> docs) {

		return docs;
	}

	public void sortDocs() {
		 		
		String tempStr;
		int tempInt;
		for (int i = 1; i<wordFoundTimes.size();i++){
							
				for (int j=i; j>0;j--){
					
					if (wordFoundTimes.get(j)>wordFoundTimes.get(j-1)){
						tempStr = strFiles.get(j); 
						strFiles.remove(j);
						strFiles.add(j, strFiles.get(j-1));
						strFiles.remove(j-1);
						strFiles.add(j-1, tempStr);
						tempInt = wordFoundTimes.get(j); 
						wordFoundTimes.remove(j);
						wordFoundTimes.add(j, wordFoundTimes.get(j-1));
						wordFoundTimes.remove(j-1);
						wordFoundTimes.add(j-1, tempInt);
					}
					
				}				
			
		}
	}



	
}
