package main;

import java.io.*;
import java.util.*;

public class Document {

	ArrayList<String> allFiles;

	public ArrayList<String> getFilesInPath(String word) throws FileNotFoundException{
		allFiles = new ArrayList<String>();
		File path = new File("/home/daney/Desktop/Files");
		File[] listOfFiles = path.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				//allFiles.add(listOfFiles[i].getName()); //just add everyfile
				Scanner scanner=new Scanner(new File("/home/daney/Desktop/Files/" + listOfFiles[i].getName()));
				if (wordExist(scanner, word))
					allFiles.add(listOfFiles[i].getName());
			} 
		}		  
		return  allFiles;
	}


	public boolean wordExist(Scanner scanner, String myWord){

		while(scanner.hasNext()){		
			if (scanner.next().equals(myWord))
				return true;		      
		}
		return false;
	}


	//alternative get Files Path
	public void getFilesInPath(){
		ArrayList<String> filesList = new ArrayList<String>();

		File[] files = new File("/home/daney/Desktop/Files/").listFiles();

		for (File file : files) {
			if (file.isFile()) {
				filesList.add(file.getName());
			}
		}
	}

}
