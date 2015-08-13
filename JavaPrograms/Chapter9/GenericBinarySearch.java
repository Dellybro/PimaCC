/*
Developper - Travis Delly
Assignment 9.2
March/18/2015
Purpose - Using templates with methods
*/


public class GenericBinarySearch{
	public static void main(String[] args){

		Integer[] intArray = {new Integer(2), new Integer(3), new Integer(1), new Integer(10), new Integer(2), new Integer(7), new Integer(9), new Integer(6), new Integer(5), new Integer(4)};
		String[] strArray = {new String("Hello"), new String("A2"), new String("B5"), new String("GoodBye")};

		if (binarySearch(intArray, 7) == 1 && binarySearch(strArray, "A2") == 1){
			System.out.println("Key(s) Found");
			//Do true stuffß
		} else {
			System.out.println("Key(s) Not Found");
			//DO false stuff
		}



	}
	public static <E extends Comparable<E>>
		int binarySearch(E[] list, E key){
			int first = 0;
			int last = list.length-1;
			int mid = (first + last) / 2;

			while(true){
				if (mid < first || mid > last){
					//Not trying to get points off for not following
					//Header on assignment
					//0 == false, 1 == true
					return 0;
				}else{
					if(list[mid].compareTo(key) > 0)
						mid--;
					else if(list[mid].compareTo(key) < 0)
						mid++;
					else
						return 1;
				}
			}
		}
}