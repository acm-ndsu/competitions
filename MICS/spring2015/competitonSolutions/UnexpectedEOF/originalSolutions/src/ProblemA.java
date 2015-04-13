

import java.util.ArrayList;
import java.util.Scanner;

public class ProblemA {
	public static String [] U = {
			"|   |",
			"|   |",
			"@___/"
	}; 
	
	public static String [] N = {
			"|@  |",
			"| @ |",
			"|  @|"
	};
	
	public static String [] D = {
			" ___ ",
			"|   @",
			"|   |",
			"|___/",
	};
	
	public static void enlargePrintN(int scale){
		int height = scale*2 + 1;
		int width = scale*5 - scale*2;
		ArrayList<String> lines = new ArrayList<>();
		String slashes = "";
		String line = "";
		for(int i = 0; i < scale; i ++){
			slashes += "\\";
		}
		
		for(int x = 0; x<height;x++){
			for(int y=0;y<x;y++){
				line += " ";
			}
			line += slashes;
			while(line.length() < width){
				line += " ";
			}
			lines.add(line);
			line = "";
		}
		
		for(String x : lines){
			for(int i = 0; i < scale; i++){
				System.out.print("|");
			}
			System.out.print(x);
			for(int i = 0; i < scale; i++){
				System.out.print("|");
			}
			System.out.println();
		}
		
	}
	
	public static void enlargePrintU(int scale, String [] str){
		for (int x = 0; x < str.length; x++) {
			for (int asd = 0; asd < scale; asd++) {
				for (int j = 0; j < str[x].length(); j++) {
					for (int y = 0; y < scale; y++) {
						if (str[x].charAt(j) == '@') {
							if(asd == scale - 1){
								System.out.print('\\');
							} else {
								System.out.print('|');
							}
						} else if(str[x].charAt(j) == '/'){
							if(asd == scale - 1){
								System.out.print('/');
							} else {
								System.out.print('|');
							}	
						}else {
							System.out.print(str[x].charAt(j));
						}
					}
				}
				System.out.println();
			}
		}
	}
	
	public static void enlargePrintD(int scale, String [] str){
		int height = scale*5;
		int width = scale*5 - scale*2;

		ArrayList<String> lines = new ArrayList<>();
		String left = "";
		for(int x = 0; x < scale; x++){
			left += "|";
		}
		
		for(int x = 0; x < scale;x++){
			System.out.print(" ");
		}
		
		
		for(int i = 1; i < scale;i++){
			String line = "";
			for(int j = 0; j < width; j++){
				line += "_";
			}
			if(i == 1) System.out.print(line);
			
			lines.add(line);
		}
		
		for(int x = 0; x < scale;x++){
			System.out.print(" ");
		}
		System.out.println();
		
		for(int i =0; i < height - 2*scale; i++){
			String line = "";
			for(int j = 0; j < width; j++){
				line += " ";
			}
			lines.add(line);
		}
		
		for(int i = 0; i < scale;i++){
			String line = "";
			for(int j = 0; j < width; j++){
				line += "_";
			}
			
			lines.add(line);
		}
		
		ArrayList<String> rights = new ArrayList<>();
		
		String righT = "";
		for(int i = 0; i < scale; i ++){
			righT += "\\";
		}
		rights.add(righT);
		
		String asd = "";
		for(int i = 0; i < scale; i ++){
			asd += "|";
		}
		
		for(int i = 0; i < height-2;i++){
			rights.add(asd);
		}
		
		righT = "";
		for(int i = 0; i < scale; i ++){
			righT += "/";
		}
		rights.add(righT);
		
		
		for(int i = 0; i < rights.size()-1; i++){
			System.out.print(left);
			System.out.print(lines.get(i));
			System.out.print(rights.get(i));
			System.out.println();
		}
	}
	
	public static void enlargePrint(int scale, String [] str){
		for (int x = 0; x < str.length; x++) {
			for (int asd = 0; asd < scale; asd++) {
				for (int j = 0; j < str[x].length(); j++) {
					for (int y = 0; y < scale; y++) {
						if (str[x].charAt(j) == '@') {
							System.out.print('\\');
						} else {
							System.out.print(str[x].charAt(j));
						}
					}
				}
				System.out.println();
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()){
			int scale = Integer.parseInt(scan.nextLine());
			
			enlargePrintU(scale, U);
			for(int i = 0; i < scale;i++){
				System.out.println();
			}
			
			enlargePrintN(scale);
			for(int i = 0; i < scale-1;i++){
				System.out.println();
			}
			
			enlargePrintD(scale, D);
		}
	}

}
