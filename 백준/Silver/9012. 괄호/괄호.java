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

		for (int tc = 1; tc <= T; tc++) {
			Deque<Character> dq = new ArrayDeque<>();
			String s = br.readLine();
			char[] arr = s.toCharArray();

			for (int i = 0; i < s.length(); i++) {
				if (arr[i] == '(') {
					dq.offerLast('(');
				} else {
					if (dq.isEmpty()) {
						dq.offerLast(')');
						break;
					}
					dq.pollLast();
				}

			}
			
			System.out.println(dq.isEmpty() ? "YES" : "NO");
		}

	}

}
