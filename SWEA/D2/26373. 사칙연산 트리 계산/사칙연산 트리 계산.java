import java.io.*;
import java.util.*;

public class Solution {
	static String[] token;
	static int[] left, right;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine().trim());

			token = new String[N + 1];
			left = new int[N + 1];
			right = new int[N + 1];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int idx = Integer.parseInt(st.nextToken());
				token[idx] = st.nextToken();
				left[idx] = Integer.parseInt(st.nextToken());
				right[idx] = Integer.parseInt(st.nextToken());
			}

			int result = dfs(1);

			System.out.println("#" + tc + " " + result);
		}
	}

	static int dfs(int node) {

		// 리프 노드
		if (left[node] == 0 && right[node] == 0) {
			return Integer.parseInt(token[node]);
		}

		int a = dfs(left[node]);
		int b = dfs(right[node]);

		char op = token[node].charAt(0);

		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		default:
			return a / b;
		}
	}
}