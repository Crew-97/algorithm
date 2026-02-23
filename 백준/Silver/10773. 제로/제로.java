import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();

		for (int tc = 1; tc <= T; tc++) {
			int a = Integer.parseInt(br.readLine());
			if (a == 0) {
				dq.pollLast();

			} else {
				dq.offerLast(a);
			}
		}
		int sum = 0;
		for (int x : dq) {
			sum += x;
		}
		System.out.println(sum);

	}

}
