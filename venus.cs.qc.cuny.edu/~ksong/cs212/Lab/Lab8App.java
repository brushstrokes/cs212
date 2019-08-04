package lab8;

import java.io.File;

public class Lab8App {

	public static void main(String[] args) {
		Lab8App recursion = new Lab8App();
		System.out.println(recursion.strToNum("12341"));
		System.out.println(recursion.findMin(new int[] {3,2,1,4,5}, 5, 0));
		System.out.println(recursion.isPalindrome("racecar", 0, 6));
		System.out.println(recursion.reverseString("pots&pans"));
		recursion.traverse(new File("J:/")); 
		recursion.hanoi(4);
		
		LinkedList<String> ulist = new LinkedList<String>(); 
		String[] str = {"hello","this","is","a","test"};
		for(String s : str)
			ulist.insert(s);
		System.out.println(ulist);
		Node<String> node = ulist.getfront();
		System.out.println(recursion.countNodes(node));
	}
	public int strToNum(String str) { 
		if(str.length() < 1) 
			return 0; 
		else 
			return ((str.charAt(str.length() - 1) - '0') + (10 * strToNum(str.substring(0, str.length() - 1)))); 
	}
	private <T> int countNodes(Node<T> trav){ 
		if(trav == null) 
			return 0; 
		return 1 + countNodes(trav.getNext()); 
	}
	public int findMin(int array[], int size, int index) { 
		if(index == size - 1) 
			return array[index]; 
		int result = findMin(array, size, index + 1); 
		if (array[index] < result) 
			return array[index]; 
		else 
			return result; 
	}
	public boolean isPalindrome(String str, int low, int high) { 
		if(high <= low) 
			return true; 
		else if (str.charAt(low)!= str.charAt(high)) 
			return false; 
		else 
			return isPalindrome(str,low+1,high-1); 
	}
	public String reverseString(String s){ 
		if(s.length() == 0) 
			return s; 
		return reverseString(s.substring(1)) + s.charAt(0); 
	}
	public static void traverse(File file) { 
		if(file.isDirectory()) { 
			System.out.println(file); 
			String dirContents[] = file.list(); 
			if (dirContents != null) 
				for (String directory : dirContents) 
					traverse(new File(file, directory)); 
		} 
	}
	public static void hanoi(int discs){ 
		for (int x = 1; x < (1 << discs); x++) { 
			int from = (x & x - 1) % 3; 
			int to = ((x | x - 1) + 1) % 3; 
			System.out.println("Move " + from + " to " + to); 
		} 
	}
	public static int sum(int num) { 
		int result; 
		if(num == 1) 
			result = 1; 
		else result = num + sum(num - 1); 
		return result; 
	}
	/*
	 * 1. Modify the method that calculates the sum of the integers between 1 and N 
	 * shown above. Have the new version match the following recursive definition: 
	 * The sum of 1 to N is the sum of 1 to (N/2) plus the sum of (N/2 + 1) to N. 
	 * Trace your solution using an N of 7.
	 */
	
	/*
	 * 3. Write a recursive definition of x^y, where x and y are integers and y >= 0. 
	 * In addition, write the recursive method.
	 */
	
	/*
	 * 4. Write a recursive method to display the contents of a linked-list in reverse order.
	 */
	
	/*
	 * 5. Write a recursive method to convert a number, n, to a base, b, and return result as a String.
	 */
}
class Node<E>{
	private E data;
	private Node<E> next;
	
	public Node(){
		data = null;
		next = null;
	}
	public Node(E d){
		data = d;
		next = null;
	}
	public Node(E d, Node<E> n){
		data = d;
		next = n;
	}
	public Node<E> getNext(){
		return next;
	}
	public void setNext(Node<E> n){
		next = n;
	}
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}		
}
class LinkedList<T extends Comparable<T>>{
	
	protected Node<T> head = new Node<T>(); // dummy Node
	protected int numItems;
	
	public Node<T> getfront(){
		return head.getNext();
	}
	public int getSize(){
		return numItems;
	}
	public boolean isEmpty(){
		return numItems == 0;
	}
	public void insert(T insertItem) {
		if(insertItem == null)
			throw new   NullPointerException();
		Node<T> trav = head;
		while(trav.getNext() != null)
			trav = trav.getNext();
		trav.setNext(new Node<T>(insertItem));
		++numItems;
	}
	public String toString(){
		String str = "\n==================================\n"
				+ "The list contains " + numItems + " items.\n"
				+ "==================================\n[";
		Node<T> trav = head.getNext();
		while(trav != null){
			// str += trav.data + "\n"; 
			str += trav.getData() + ((trav.getNext() == null) ? "" : "->");
			trav = trav.getNext();
		}
		return str + "]";
	}
}