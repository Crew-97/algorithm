import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for(int j = 1; j <=T; j++) {
			int tc = Integer.parseInt(br.readLine());
			String P = br.readLine();
			String S = br.readLine();
			
			int count = 0;
			
			for(int i =0; i<=(S.length()-P.length()); i++) {
				if(S.substring(i,i+P.length()).equals(P)) {
					count++;
				}
			}
			System.out.println("#"+tc+" "+count);
			
		}
		
	}

}
