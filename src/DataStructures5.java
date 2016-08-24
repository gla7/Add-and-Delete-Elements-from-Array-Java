import java.util.Arrays;

public class DataStructures5 {// ADDING AND DELETING ARRAY ELEMENTS

	public static int orderedSearch(int toFind, int[] arr) {// ordered search function from DataStructures4 ex.
		int counter = 0;
		int found = (int) Math.floor((arr.length)/2);
		while (toFind != arr[found] && counter < arr.length) {
			if (arr[found] < toFind) {
				found = found + (int) Math.floor((arr.length - found)/2);
			} else if (arr[found] > toFind) {
				found = (int) Math.floor((found)/2);
			} else {
				break;
			}
			counter++;
		}
		if (toFind != arr[found]) {
			return -1;
		}
		return found;
	}
	
	public static int[] deleteElement(int toDelete, int[] arr) {// creates new array with one less element (omits including said element)
		int indexToDelete = orderedSearch(toDelete, arr);
		int[] modifiedArray = new int[arr.length - 1];
		for (int i = 0; i < indexToDelete; i++) {
			modifiedArray[i] = arr[i];
		}
		for (int j = indexToDelete + 1; j < arr.length; j++) {
			modifiedArray[j-1] = arr[j];
		}
		return modifiedArray;
	}
	
	public static int[] addElement(int numberToAdd, int indexTo, int[] arr) {// creates new array with one more element (includes said element)
		int[] modifiedArray = new int[arr.length + 1];
		for (int i = 0; i < indexTo; i++) {
			modifiedArray[i] = arr[i];
		}
		modifiedArray[indexTo] = numberToAdd;
		for (int j = indexTo + 1; j <= arr.length; j++) {
			modifiedArray[j] = arr[j-1];
		}
		return modifiedArray;
	}
	
	public static void main(String[] args) {
		System.out.println("DEMONSTRATING ADDING AND DELETING ARRAY ITEMS");
		int[] a = {1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(deleteElement(8,a)));
		System.out.println(Arrays.toString(deleteElement(1,a)));
		System.out.println(Arrays.toString(deleteElement(3,a)));
		System.out.println(Arrays.toString(deleteElement(5,a)));
		System.out.println(Arrays.toString(deleteElement(9,a)));
		System.out.println(Arrays.toString(addElement(0,0,a)));
		System.out.println(Arrays.toString(addElement(8,0,a)));
		System.out.println(Arrays.toString(addElement(99,3,a)));
		System.out.println(Arrays.toString(addElement(10,8,a)));
		System.out.println(Arrays.toString(addElement(5,5,a)));
	}

}
