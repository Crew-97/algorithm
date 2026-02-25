import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args)throws IOException {
		List<Integer> arr = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		dfs(N,M,arr);
		

	}

	static void dfs(int N, int M, List<Integer> arr) {
		// 종료조건
		if (arr.size() == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.println();
			return;
		}
		// 호출조건
		for (int i = 1; i <= N; i++) {
			// 방문한거 체크
			if (arr.contains(i))
				continue;
			// 진짜 호출
			arr.add(i);
			// 재귀해버리기
			dfs(N, M, arr);
			// 백트래킹
			arr.remove(arr.size() - 1);

		}

	}

}
