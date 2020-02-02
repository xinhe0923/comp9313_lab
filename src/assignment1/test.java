package assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {

	public test(String f){
		File file=new File(f);
		try {
			Scanner scan=new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception{
		 
		
		   
		   /** Create the second doubly linked list                         
		    by reading all the strings from the file myfile that contains some strings. */
		  
		   /** Replace the argument by the full path name of the text file */  
		    test secondList=new test("/Users/yangxinhe/Desktop/myfile.rtf");
		    System.out.println(secondList);

}
}

