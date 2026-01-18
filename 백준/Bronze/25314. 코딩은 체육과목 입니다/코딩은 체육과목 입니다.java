

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int a = N / 4;

        for (int i = 0; i < a; i++) {
            System.out.print("long ");
        }

        System.out.print("int");
	}

}
