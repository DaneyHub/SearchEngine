package finder;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Indexer extends DocumentProcessor {


	public DocumentProcessor document;

	ArrayList<String> docFileNames; //Documents that have a searched token
	ArrayList<String> docsStrings; //storage for all document variables in Document class as a String
	ArrayList<Integer> termFrequency;
	ArrayList<String> strFiles;
	ArrayList<String> index;

	public Indexer(){	

		docsStrings = new ArrayList<String>();
		docsStrings.add(document1);
		docsStrings.add(document2);
		docsStrings.add(document3);		
		docsStrings.add(document4);
		document = new DocumentProcessor();			
	}


	public ArrayList<String> createIndex(String word) throws FileNotFoundException {

		ArrayList<String> tokens = new ArrayList<String>();
		Map<String, ArrayList<String>>  map_doc = new HashMap<String, ArrayList<String>>();
		String[] splitString;
		for (int i=0; i<docsStrings.size();i++) {
			splitString = document.tokenizeDoc(docsStrings.get(i));
			for(String str: splitString){
				if (!tokens.contains(str)) //duplicates will not be added
					tokens.add(str);
			}
		}		
		
		//Add each words/tokens with the associated documents by sorting them.
		Collections.sort(tokens);
		for (String str:tokens){			
			map_doc.put(str, getDocumentNames(str));			
		}
		
		//The index table
		System.out.println("----------------- Index ----------------------------------");
		for (String str:tokens){			
			System.out.println(str +"\t --> \t" + map_doc.get(str));				
			}
		System.out.println("----------------------------------------------------------\n");
		
		return (map_doc.get(word));

	}


	//get Documents name from Document class
	@Override
	public ArrayList<String> getDocumentNames(String word) throws FileNotFoundException{


		strFiles = document.getStringFiles();
		docFileNames = new ArrayList<String>();
		termFrequency = new ArrayList<Integer>();
		
		
		int countFreqency = 0; // Count frequency of word in each doc

		String[] splitString;
		for (int i=0; i<docsStrings.size();i++) {
			splitString = document.tokenizeDoc(docsStrings.get(i));
			for(String str: splitString){
				if(word.equals(str)){
					countFreqency++;								
				}
			}

			termFrequency.add(countFreqency);
			countFreqency = 0;				
		}		

		//Sort docs by the searched word frequency
		sortDocs();

		int count_0s=0; //Count number of docs with 0 term frequency

		for (int val:termFrequency ){
			if(val==0)
				count_0s++;
		}


		for (int i=0; i<strFiles.size()-count_0s;i++){
			docFileNames.add(strFiles.get(i));
		}

		return  docFileNames;
	}

	public void sortDocs() {

		String tempStr;
		int tempInt;
		for (int i = 1; i<strFiles.size();i++){

			for (int j=i; j>0;j--){

				if (termFrequency.get(j)>termFrequency.get(j-1)){
					tempStr = strFiles.get(j); 
					strFiles.remove(j);
					strFiles.add(j, strFiles.get(j-1));
					strFiles.remove(j-1);
					strFiles.add(j-1, tempStr);
					tempInt = termFrequency.get(j); 
					termFrequency.remove(j);
					termFrequency.add(j, termFrequency.get(j-1));
					termFrequency.remove(j-1);
					termFrequency.add(j-1, tempInt);
				}

			}				

		}
	}




}
