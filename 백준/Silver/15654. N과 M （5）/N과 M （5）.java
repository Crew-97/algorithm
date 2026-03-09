import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static StringBuilder sb;
	static int[] arr;
	static List<Integer> arr2;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 배열 선언
		arr2 = new ArrayList<>();
		arr = new int[N];
		visited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 배열 정렬
		Arrays.sort(arr);
		// 재귀
		dfs();
		System.out.println(sb);

	}

	static void dfs() {
		// 기저조건
		if (arr2.size() == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr2.get(i)).append(" ");
			}
			sb.append("\n");
			return;
		}
		// 재귀조건
		for (int i = 0; i < N; i++) {
			// 스킵조건
			if (visited[i]) continue;
			// 핵심조건
			visited[i]=true;
			arr2.add(arr[i]);
			// 재귀
			dfs();
			// 백트래킹
			arr2.remove(arr2.size() - 1);
			visited[i] = false;
		}

	}

}
