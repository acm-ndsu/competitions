import java.util.Scanner;


public class ProblemC {
	static char [][] map;
	static int matches=0;
	
	public static void shiftOne(int [] pos){
		for(int i = 0;i<pos.length;i++){
			pos[i] = pos[i] + 1;
		}
	}
	
	public static int [] match(int centerX, int centerY, String word){
		int [] pos = new int[2];
		int offset = word.length()-1;
		int up = -offset;
		int down = offset;
		int right = offset;
		int left = -offset;
		if(match(up, 0, centerX, centerY, word)){ // right
			pos[0] = centerX + up;
			pos[1] = centerY;
		} else if(match(down, 0, centerX, centerY, word)){
			pos[0] = centerX + down;
			pos[1] = centerY;
		} else if(match(0, left, centerX, centerY, word)){
			pos[0] = centerX;
			pos[1] = centerY + left ;
		} else if(match(0, right, centerX, centerY, word)){
			pos[0] = centerX;
			pos[1] = centerY + right;
		}else if(match(up, right, centerX, centerY, word)){
			pos[0] = centerX + up;
			pos[1] = centerY + right;
		} else if(match(up, left, centerX, centerY, word)){
			pos[0] = centerX + up;
			pos[1] = centerY + left;
		} else if(match(down, left, centerX, centerY, word)){
			pos[0] = centerX + down;
			pos[1] = centerY + left;
		} else if(match(down, right, centerX, centerY, word)){
			pos[0] = centerX + down;
			pos[1] = centerY + right;
		} else {
			pos[0] = -2;
			pos[1] = -2;
		}
		
		shiftOne(pos);
		return pos;
	}
	
	private static boolean match(int xOffset, int yOffset, int centerX, int centerY, String word){
		try{
			if(xOffset == 0 && yOffset == 0){
				if(map[centerX][centerY] == word.charAt(0)){
					 return true; 
				}else {
					return false;
				}
			} else{
				int charIndex = Math.max(Math.abs(xOffset),Math.abs(yOffset));
				if(map[centerX+xOffset][centerY+yOffset]!=word.charAt(charIndex)){
					return false;
				} else {
					matches++;
					return match(xOffset - ((int) Math.signum(xOffset)), yOffset -  ((int) Math.signum(yOffset)), centerX, centerY, word);
				}
			}
		}catch(Exception e){
			return false;
		}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		map = new char[size][size];
		
		// parse the map
		for(int i =0; i <size; i++){
			String line = scan.next();
			for(int j =0;j<size;j++){
				map[i][j] = line.charAt(j);
			}
		}
		
		while(!scan.hasNext("0")){
			String word = scan.next();
			boolean found = false;
			for(int i=0;i<size && !found;i++){
				for(int j=0;j<size && !found;j++){
					if(word.charAt(0) ==map[i][j]){
						int [] pos = match(i,j, word);
						if(pos[0] > 0 && pos[1] > 0){ // map starts at {1,1} indexing for results
							found = true;
							System.out.println(word + ": (" + (i+1) +  "," + (j+1) + ") to " +  
													    "(" + pos[0] + "," + pos[1] + ")");
						}
					}
				}
			}
			if(!found){
				System.out.println(word + ": Not found");
			}
		}
	}

}
