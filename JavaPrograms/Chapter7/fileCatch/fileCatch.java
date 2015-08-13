/*
Developper - Travis Delly
Assignment 7.2
March/19/2015
Purpose - Learn how to handle exceptions with files.
*/

import java.util.*;

public class fileCatch{

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		//Create var file with possible nil file
		java.io.File file = new java.io.File("Exercise12_15.txt");
		//Check if file is nil
		if (file.exists()){
			System.out.println("File already exists");
		}else{//This try/catch is weird, basically it already knows exception was raised, so no need for second catch
			System.out.println("File Created.");
			try(//Create the file using printWriter
				java.io.PrintWriter out = new java.io.PrintWriter(file)
			) {//Input random numbers.
				Random rand = new Random();
				for (int x = 0; x<100; x++ ) {
					int randNum = rand.nextInt(583490)+1;
					out.print(randNum + " ");
				}
			}
		}

		//print from file.
		Scanner input = new Scanner(file);
		//Couldve used vector, or linkedlist even a stack etc,etc.
		List<Integer> myInts = new ArrayList<Integer>();
		while(input.hasNext()){
			myInts.add(input.nextInt());
		}
		//Couldve sorted with bubble sort etc/etc/etc/etc/etc
		//Thousand and 10 ways to sort, but i used collections instead
		Collections.sort(myInts);
		//Easier forLoop to print through numbers without index.
		//Not always acceptable in every situation though!
		for(int temp : myInts){
			System.out.print(temp + ", ");
		}
	}
}