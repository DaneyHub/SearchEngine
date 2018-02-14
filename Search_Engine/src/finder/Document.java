package finder;

import java.util.ArrayList;

public abstract class Document {
	
	/*
	 These public fields can be accessed by getFields Method in DocumentProcessor class.
	 If they are private, use getDeclaredFields instead. This might create a problem if we declare another private
	 variable that's not a document. So making them public is safer. 	 
	*/
	public String document1 = "the brown fox jumped over the brown dog";
	public String document2 = "the lazy brown dog sat in the corner";
	public String document3 = "the red fox bit the lazy dog";
	public String document4 = "dog and dog sat with dog ";
	public abstract ArrayList<String> getStringFiles();
}
