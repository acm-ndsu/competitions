

import java.util.Scanner;

public class ProblemF {

	public String toBinaryStr(int x){
		switch(x){
		case 9: return "1001";
		case 8: return "1000";
		case 7: return "111";
		case 6: return "110";
		case 5: return "101";
		case 4: return "100";
		case 3: return "11";
		case 2: return "10";
		case 1: return "1";
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			String line = scan.nextLine();
			String [] split = line.split(" ");
			String ori = split[0];
			char [] str = split[0].toCharArray();
			String result = "";
			int target = Integer.parseInt(split[1]);
			
			if(ori.length() >= target){
				System.out.println("Old password " + ori + " expanded to length " + target + " is " + ori);
			}
			
			for(int i = 0; i < str.length; i++){
				try{
					if(((int) str[i]) >= (int) '0' && (int) str[i] <= (int) '9'){
						int x = (int) str[i];
						String result += Integer.toBinaryString(x);
					}
				}catch(Exception e){
					
				}
			}
		}
	}

}
