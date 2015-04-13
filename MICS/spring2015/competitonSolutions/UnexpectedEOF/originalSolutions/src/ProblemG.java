

import java.util.Scanner;

public class ProblemG {

	public static void printMap(int [][] map){
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[i].length;j++){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int x1 = scan.nextInt();
		int y1 = scan.nextInt();
		scan.nextLine();
		int [][] mapC = new int[x1][y1];
		for(int i =0; i < x1; i++){
			String line = scan.nextLine();
			String [] lineWords = line.split(" ");
			for(int j = 0; j < y1; j++){
				mapC[i][j] = Integer.parseInt(lineWords[j]);
			}
		}
		
		int x2 = scan.nextInt();
		int y2 = scan.nextInt();
		scan.nextLine();
		int [][] mapT = new int[x2][y2];
		for(int i =0; i < x2; i++){
			String line = scan.nextLine();
			String [] lineWords = line.split(" ");
			for(int j = 0; j < y2; j++){
				mapT[i][j] = Integer.parseInt(lineWords[j]);
			}
		}
		
		if(x1 > x2 || y1 > y2){
			System.out.println("Photograph C was not found in T");
			return;
		}
		
		int startX = 0;
		int startY = 0;
		int count = 0;
		for(int i = 0; i < x2; i++){
			for(int j =0; j < y2; j++){
				if(mapT[i][j] == mapC[0][0]){
					startX=i;startY=j;
					boolean quit = false;
					for(int x =0; x < x1 && !quit; x++){
						for(int y =0; y < y1 && !quit; y++){
//							System.out.println(mapT[startX+x][startY+y]);
							if(mapT[startX+x][startY+y] == mapC[x][y]){
								count++;
							} else {
								quit = true;
							}
							
							if(startX+x+1 >= x2-1 || startY+y+1 >= y2-1){
								quit = true;
							}
						}
					}
//					System.out.println(count);
				} else {
					count = 0;
				}
				
				if(count >= x1*y1){
					System.out.println("Photograph C was found in T starting at row " + startX + " and column " + startY);
					return;
				}
			}
		}
		
		System.out.println("Photograph C was not found in T");
	}

}
