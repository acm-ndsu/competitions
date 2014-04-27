import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


/**
 * Goals: Given a list of words, identity the most 'difficult' word of all words of a given length. 
 * The 'difficulty' of each word is denoted by the sum of the individual frequencies of each letter in the word.
 * The most 'difficult' word would be the word with the least sum of letter frequencies.
 * The output should be sorted by length, in ascending order.
 * If no word is found of a particular length, the output should be 'Hardest word of length x: No word of that length is in the dictionary!'
 * Otherwise, the normal output should be 'Hardest word of length x: ', followed by the lower-case version of the hardest word.
 * If two words of same length share the same difficulty, the word that's later alphabetically is harder.
 * 
 * Strategy:
 * Generate a set containing all the words (everything should be lower-case).
 * For each lower-case alphabet in the English language, loop through the set of all words to figure out the frequency.
 * Store a hashmap containing the letter as key, and its frequency as value.
 * Loop through all words, use the hashmap to obtain frequency of each letter, and sum it up.
 * To obtain best complexity, sort all words by their lengths, calculate the most 'difficult' word for each length.
 * Be careful to handle word lengths that do not appear in the input list.
 * @author wk
 *
 */
public class ProblemE {
	
	public static class Word implements Comparable{
		public Word(String word, int freq){
			this.word = word;
			this.freq = freq;
			length = word.length();
		}
		String word;
		int length;
		int freq;
		
		public String toString(){
			return word + " " + length +  " " + freq;
		}
		
		@Override
		public int compareTo(Object arg0) {
			Word w = (Word) arg0;
			if(this.length > w.length){
				return 1;
			} else if(this.length < w.length){
				return -1;
			} else {
				return 0;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> letters = new HashMap<>();
		for(int i =97; i <= 122;i++){
			letters.put((char) i, 0);
		}
		
		Scanner scan = new Scanner(System.in);
		HashSet<String> dictionary = new HashSet<String>();
		while(scan.hasNext()){
			String word = scan.next().toLowerCase();
			if(word.equals("*")){
				break;
			} else if(word.equals(" ")){
				continue;
			}
			dictionary.add(word);
		}
		
		for(Character c : letters.keySet()){
			for(String word : dictionary){
				char [] ltrs = word.toCharArray();
				for(Character s : ltrs){
					if(c.equals(s)){
						letters.put(c, letters.get(c)+1);
					}
				}
			}
		}
		ArrayList<Word> frequencies = new ArrayList<>();
		for(String word : dictionary){
			char [] ltrs = word.toCharArray();
			int freq = 0;
			for(Character s : ltrs){
				freq += letters.get(s);
			}
			frequencies.add(new Word(word, freq));
		}
		
		Collections.sort(frequencies);
		Word minWord = frequencies.get(0);
		for(int i=0;i<frequencies.size();i++){
			if(i== frequencies.size()-1){
				System.out.println("Hardest word of length " + minWord.length +": " + minWord.word);				
				break;
			}
			Word next = frequencies.get(i+1);
			if(minWord.length == next.length){
				if(minWord.freq > next.freq){
					minWord = next;
				} else if(minWord.freq == next.freq){
					if(minWord.word.compareTo(next.word) == -1){
						minWord = next;
					}
				}
			} else {
				System.out.println("Hardest word of length " + minWord.length +": " + minWord.word);
				if((i+1) >= frequencies.size()){
					break;
				}
				
				int skippedLengths = frequencies.get(i+1).length - minWord.length;
				if(skippedLengths >= 1){
					for(int j =1;j < skippedLengths; j++){
						System.out.println("Hardest word of length " + (minWord.length+j) +": " + "No word of that length is in the dictionary!");
					}
				}
				
				minWord = frequencies.get(i+1);
			}
		}
	}

}
