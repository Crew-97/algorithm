

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {public static void main(String[] args)throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int a = Integer.parseInt(br.readLine());
	
	for (int b = 1; b < 10; b++) {
	//	System.out.printf("%d * %d = %d%n", a, b, a*b);
		System.out.println(a+" * "+b+" = "+(a*b));
	}
	
}

}
