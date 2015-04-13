

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ProblemE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();
		for(int i =0; i < n; i++){
			arr.add(Integer.parseInt(scan.nextLine()));
		}
		
		Collections.sort(arr);
		Collections.reverse(arr);
		
		for(int i=0;i<n;i++){
			if(i % 2 == 1){
				arr2.add(arr.get(i));
			} else {
				arr1.add(arr.get(i));
			}
		}
		
		Collections.reverse(arr2);
		arr1.addAll(arr2);
		
		System.out.println(n);
		for(Integer x : arr1){
			System.out.println(x);
		}
	}

}
 