import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 리스트 선언
		ArrayList<Integer> arr = new ArrayList<>();
		dfs(N,M,1,arr);
		

	}

	static void dfs(int N, int M, int start, ArrayList<Integer> arr) {
		// 종료조건
		if (arr.size() == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr.get(i)+" ");
			}
			System.out.println();
			return;
		}

		// 재귀호출조건
		for (int i = start; i <= N; i++) {
			//핵심 로직
			arr.add(i);
			//재귀 해버리기
			dfs(N, M, i + 1, arr);
			//백트래킹
			arr.remove(arr.size() - 1);

		}

	}

}
