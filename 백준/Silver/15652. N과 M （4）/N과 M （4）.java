import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static ArrayList<Integer> arr;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		dfs(N, M, arr);
		System.out.println(sb);

	}

	static void dfs(int N, int M, ArrayList<Integer> arr) {
		// 기저조건
		if (arr.size() == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr.get(i)).append(" ");
			}
			sb.append("\n");
			return;
		}
		// 재귀조건
		for (int i = 1; i <= N; i++) {
			// 스킵조건 : arr 의 이전 요소가 다음 요소보다 크다면 스킵
			if (!arr.isEmpty() && arr.get(arr.size() - 1) > i)
				continue;
			// 핵심로직
			arr.add(i);
			// 재귀
			dfs(N, M, arr);
			// 백트래킹
			arr.remove(arr.size() - 1);

		}

	}

}
