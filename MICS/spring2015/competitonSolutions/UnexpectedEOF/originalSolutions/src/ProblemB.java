

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ProblemB {
	public static HashSet<Integer> allSums;
	
	public static int [] splice(int [] array, int x){
		int [] ret = new int[array.length - 1];
		for(int i =0; i < array.length; i++){
			if(i < x){
				ret[i] = array[i];
			} else if(i > x){
				ret[i-1] = array[i];
			}
		}
		
		return ret;
	}
	public static void recF(int sum, int [] array){
		allSums.add(sum);
		
		for(int i =0; i < array.length; i++){
			int newSum = sum + array[i];
			int [] arrayLess =splice(array, i);
			recF(newSum, arrayLess);
		}
	}
	
	public static void recF(int [] array){
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int replace = Integer.parseInt(scan.nextLine());
		String [] arr = scan.nextLine().split(" ");
		int [] array = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			if(arr[i].equals("F")){
				array[i] = replace;
			} else {
				array[i] = Integer.parseInt(arr[i]);
			}
		}
		
		int totalSum = 0;
		for(int i = 0; i < array.length; i++){
			totalSum += array[i];
		}
		
		allSums = new HashSet<>(totalSum);
		
		for(int i = 0; i < array.length; i++){
			recF(array[i], splice(array,i));
		}


		
		ArrayList<Integer> q = new ArrayList<>();
		int []  arrList = new int[totalSum];
		
		for(int x = 0; x < totalSum; x++){
			arrList[x] = x+1;
		}
		
		ArrayList<Integer> temp = new ArrayList<>();
		temp.addAll(allSums);
		Collections.sort(temp);
		for(Integer x : arrList)
		{
			if(Collections.binarySearch(temp, x) <= -1){
				q.add(x);
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < q.size(); i++){
			if(q.get(i) < min){
				min = q.get(i);
			}
		}
		
		System.out.println("The least amount that cannot be made exactly is " + min);
		System.out.println("The number of amounts between 0 and 186 that cannot be made exactly is " + q.size());
		
	}

}
