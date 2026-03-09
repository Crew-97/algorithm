import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		// 이거랑 List<Integer> arr = new ArrayList<>(); 한다음 
		// dfs(N, M, arr); 이거하는거랑 똑같음. 왜? 참조자료형에 대한 이해가 절실히 필요함;;
		dfs(N, M, new ArrayList<>());
		System.out.println(sb.toString());

	}

	static void dfs(int N, int M, List<Integer> arr) {
		// 기저 조건
		if (arr.size() == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr.get(i)).append(" ");
			}
			sb.append("\n");
			// 반드시 return 으로 종료시킬것...
			return;
		}
		// 재귀 조건
		for (int i = 1; i <= N; i++) {
			// 중복 조건 없음. 처음부터 다 카운트
			// 핵심조건
			arr.add(i);
			// 재귀
			dfs(N, M, arr);
			// 백트래킹
			arr.remove(arr.size() - 1);
		}

	}

}
