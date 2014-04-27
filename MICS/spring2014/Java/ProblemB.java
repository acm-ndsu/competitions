import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Goals: 
 * Given a list of numbers, print smallest even at index 0, smaller odd at index 1, etc.
 * If either even or odd runs out, print the other remaining list.
 * 
 * Technique: 
 * Sort input list into evens and odds lists.
 * Print evens and odds in an alternating manner.
 * Handle cases for list ending.
 * @author wei
 *
 */
public class ProblemB {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> evens = new ArrayList<Integer>();
		ArrayList<Integer> odds = new ArrayList<Integer>();
		while(!scan.hasNext("0")){
			int num = scan.nextInt();
			if(num % 2 == 0){ // even
				evens.add(num);
			} else {
				odds.add(num);
			}
		}
		
		// sort evens and odds
		Collections.sort(evens);
		Collections.sort(odds);
		
		int k=0;
		int j=0;
		for(int i = 0; i < evens.size() + odds.size(); i++){
			if(j >= evens.size()){
				while(k < odds.size()){ // print out remaining evens
					System.out.println(odds.get(k++));
				}
			} else if(k >= odds.size()){
				while(j < evens.size()){ // print out remaining odds
					System.out.println(evens.get(j++));
				}
			} else {
				if(i % 2 == 0){
					System.out.println(evens.get(j++));
				} else {
					System.out.println(odds.get(k++));
				}
			}
		}
	}

}
