package finder;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

public class DocumentProcessor extends Document {


	

	ArrayList<String> allFiles;
	Field field[]; 	
	static File path = new File("/home/daney/Desktop/Files");
	static File[] listOfFiles = path.listFiles();

	public DocumentProcessor(){
		allFiles = new ArrayList<String>();
		field = Document.class.getFields();
	}

	//get files from folder
	public ArrayList<String> getDocumentNames(String word) throws FileNotFoundException{


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

	//check is the passed word exist in the given file from the folder
	public boolean wordExist(Scanner scanner, String myWord){

		while(scanner.hasNext()){		
			if (scanner.next().equals(myWord))
				return true;		      
		}
		return false;
	}

	//get declared document names in Document class. 
	@Override
	public ArrayList<String> getStringFiles(){

		ArrayList<String> docs_ = new ArrayList<String>();

		for (int i = 0; i < field.length; i++)
		{
			docs_.add(field[i].getName());
		} 


		return docs_;
	}


	//divide each document into individual words.
	public String[] tokenizeDoc(String str) {
		String[] splitStr = str.split(" ");
		return splitStr;

	}
	
	//alternative get Documents in Path
	public void getDocumentNames(){
		ArrayList<String> filesList = new ArrayList<String>();

		File[] files = new File("/home/daney/Desktop/Files/").listFiles();

		for (File file : files) {
			if (file.isFile()) {
				filesList.add(file.getName());
			}
		}
	}




}
