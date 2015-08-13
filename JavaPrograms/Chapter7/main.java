import java.io.FileNotFoundException;
import java.util.*;


public class main {
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Name of File: ");
		String fileName = input.nextLine();
		//Ask user for filename using commandline
		
		java.io.File file = new java.io.File(fileName);
		if(file.exists()){
			System.out.println("File exists...");
		}else{
			System.out.println("File does not exist.. Exiting");
			System.exit(1);
		}//Check if file exists if it doesnt exit.

		//Create ArrayList
		ArrayList<String> myList = new ArrayList<>();
		//Create Scanner for file
		Scanner scanFile = new Scanner(file);
		//Loop over Scanner
		while(scanFile.hasNext()){
			String word = scanFile.nextLine();
			if(word.matches(".*[^a-z].*") == false){
				myList.add(word);
			}//Check word using Regex.
		}
		Collections.sort(myList);
		//Sort ArrayList
		for(String temp : myList){
			System.out.print(temp + "\n");		
		}//Print
	}
}