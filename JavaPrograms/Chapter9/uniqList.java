/*
Developper - Travis Delly
Assignment 9.1
March/18/2015
Purpose - Using templates with methods, arraylist
*/

import java.util.*;

public class uniqList{
	public static void main(String[] args){

		ArrayList<Integer> numbArr = new ArrayList<>();

		for(int x = 0;x < 10 ;x++ ){
			numbArr.add(x);
			numbArr.add(x);		
		}//Populate ArrayList with values.....


		System.out.print("numbArr before: ");
		print(numbArr);

		numbArr = removeDuplicates(numbArr);

		System.out.print("numbArr after: ");
		print(numbArr);


		ArrayList<String> strArray = new ArrayList<>();
		for(int x = 0;x < 10 ;x++ ){
			strArray.add("a"+x);
			strArray.add("a"+x);		
		}//Populate ArrayList with values.....


		System.out.print("Testing <E> Interface: ");
		print(strArray);
		strArray = removeDuplicates(strArray);
		System.out.print("After: ");
		print(strArray);




	}

	//Templating <E> Interface, Generic Types
	public static <E>
		void print(ArrayList<E> list){
			for(int x = 0;x < list.size() ;x++ )
				System.out.print(list.get(x));	
			System.out.println();
			//Just for kicks and gigs.
		}

	public static <E> 
		ArrayList<E> removeDuplicates(ArrayList<E> list){
			ArrayList<E> noDuplicates = new ArrayList<>();
			for (int i = 0;i<list.size();i++ ) {
				if(!noDuplicates.contains(list.get(i))){
					noDuplicates.add(list.get(i));
				}
			}//So happy Arraylist has .contains just like Ruby!
			return noDuplicates;
	}
}