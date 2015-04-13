

import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			int charVal = Integer.parseInt(scan.nextLine());
			char print = ' ';
			charVal = charVal % 30;
			if(charVal == 0){
				print = ' ';
			} else if(charVal == 27){
				print = '.';
			} else if(charVal == 28){
				print ='?';
			} else if(charVal == 29){
				print = '\n';
			} else {
				print = (char) (charVal + (int) 'A' - 1);
			}
			
			System.out.print(print);
		}
	}

}
