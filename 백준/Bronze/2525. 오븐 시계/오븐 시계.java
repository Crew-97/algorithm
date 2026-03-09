

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {public static void main(String[] args)throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	int a = Integer.parseInt(st.nextToken());
	int b = Integer.parseInt(st.nextToken());
	
	int c = Integer.parseInt(br.readLine());
	
	int total = (60*a+b+c);
	if (total >= 1440) {
		total -=1440;
	}
	System.out.println(total/60+" "+total%60);
	
	
}

}
