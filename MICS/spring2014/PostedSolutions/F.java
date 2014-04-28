/*
 Solution to Problem F.  Solve the recursive function:
	G(n) = n for all value of n <= 0
	G(n) = G(n-6) + G(n-4) + G(n-2)  for all values of n > 0.
*/
import java.io.*;

class F { 
    static boolean PROMPTS = false;
    public static void main(String[] args) throws IOException { 
	BufferedReader bufReader;
	String inputStr;
	int n;

	bufReader = new BufferedReader( new InputStreamReader( System.in));
	while (true) {
	    if (PROMPTS) {
		System.out.print("Enter n: ");
	    } // end if
	    n = Integer.parseInt(bufReader.readLine());
	    if (n == 0) {
		break;
	    } // end if
	    System.out.print("G(");
	    System.out.print(n);
	    System.out.print(") = ");
	    System.out.println(G(n));

	} // end while
    } // end main

    public static long G_rec(int n) {
	//NOTE:  Recursive function is too slow (O(3**n)), but useful when n is small
	if (n <= 0) {
	    return (long) n;
	} else {
	    return G_rec(n-6) + G_rec(n-4) + G_rec(n-2);
	} // end if
    } // end G_rec

    public static long G(int n) {
	int i;
	long [] g;
	if (n <= 5) {
	    return G_rec(n);
	} // end if

	g = new long[n+1];
	// Fill base cases
	for (i = 0; i <= 5; i++) {
	    g[i] = G_rec(i);
	} // end for
	
	// Store remaining answers in g array and build it up in dynamic programming fashion
	for (i = 6; i <= n; i++) {
	    g[i] = g[i-6] + g[i-4] + g[i-2];
	} // end for
	return g[n];
    } // end G

} // end class F

