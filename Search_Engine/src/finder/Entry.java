package finder;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Entry {

	private String word;
	private Scanner input;

	public Entry(){
		
		input = new Scanner(System.in);
	}

	public static void main(String[] args) throws FileNotFoundException {
		Entry entry = new Entry();
		entry.start();
//		DocumentProcessor ind = new Indexer();
//		ind.getFilesInPath("word");

	}

	public void start() throws FileNotFoundException{

		SearchEngine mainEngine = new SearchEngine();

		//		do {
		//			System.out.println("Enter a word (without Space) to search");			
		//			word = input.nextLine().trim();
		//		} while (mainEngine.hasSpace(word));	

		do{
			System.out.println("Enter a word to search or 'qx' to Quit");	

			word = input.nextLine().trim();
			while (mainEngine.hasSpace(word)){			
				System.out.println("The word has to be without space");	
				word = input.nextLine().trim();
			};

			
			//mainEngine.SearchWord_LocalFolder(word); //An alternative to read files from folder 
			mainEngine.SearchWord(word);
			
		}while(!word.equals("qx"));
		
		input.close();
		System.out.println("Exited");	
		System.exit(0);
	}

}
