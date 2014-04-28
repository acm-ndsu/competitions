import java.util.Scanner;


public class ProblemF {

	public static int G(int n){
		if(n <= 0){
			return n;
		} else {
			return G(n-6) + G(n-4) + G(n-2);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while(!scan.hasNext("0")){
			int n = scan.nextInt();
			
			if(n <= 5){
				System.out.println("G(" + n + ")" + " = " + G(n));
			} else {
				int [] g = new int[n+1];
				for(int i =0; i <=5; i++){
					g[i] = G(i);
				}
				
				for(int i =6; i <= n; i++){
					g[i] = g[i-6] + g[i-4] + g[i-2];
				}
				
				System.out.println("G(" + n + ")" + " = " + g[n]);
			}
		}
	}

}
