
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = a; i >= 1; i--) {
			for (int j = 1; j <= a-i; j++) {
				sb.append(" ");
			}
			for (int k = 1; k <= (2*i-1); k++) {
				sb.append("*");
				
			}
			sb.append("\n");
		}
		
		
		System.out.println(sb.toString());
		

	}

}
