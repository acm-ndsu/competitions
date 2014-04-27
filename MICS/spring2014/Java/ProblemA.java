import java.util.Scanner;

/**
 * Goals:
 * Scale the original given figure by a scale.
 * 
 * For my solution, I just have the original figure stored as a String array.
 * Iterate through each character, and scale each character.
 * @author Wei Kang Lim
 *
 */
public class ProblemA {

	public static void printXTimes(int x, String word){
		for(int i = 0; i < x; i++){
			System.out.print(word);
		}
	}
	public static void printXTimes(int x, char word){
		for(int i = 0; i < x; i++){
			System.out.print(word);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int scale = scan.nextInt();
		String [] original = {"EEEEE", 
							  "E    ", 
							  "EEEEE", 
							  "E    ", 
							  "EEEEE",
							  "\n",
							  "PPPPP",
							  "P   P",
							  "PPPPP",
							  "P    ",
							  "P    ",
							  "\n",
							  "IIIII",
							  "  I  ",
							  "IIIII",
							  "  I  ",
							  "IIIII",
							  "\n",
							  "CCCCC",
							  "C    ",
							  "C    ",
							  "C    ",
							  "CCCCC"};
		for(String line : original){
			if(!line.equals("\n")){
				for(Character c: line.toCharArray()){
					printXTimes(scale, c);
				}				
				System.out.println();
			} else {
				printXTimes(scale, line);
			}
		}
	}

}
