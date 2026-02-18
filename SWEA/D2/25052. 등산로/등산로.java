import java.util.*;

public class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// logic
			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int r = i;
					int c = j;
					int length = 1; // 시작칸 포함
					// 4방향 탐색해서 지금 출발 좌표보다 낮고, 그중에서도 최솟값을 찾아야함
					while (true) {

						int min = Integer.MAX_VALUE;
						int nrBest = 0, ncBest = 0;
						boolean found = false;

						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];

							if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] < arr[r][c]
									&& arr[nr][nc] < min) {
								min = arr[nr][nc];
								nrBest = nr;
								ncBest = nc;
								found = true;

							}

						}
						if (!found)
							break;

						r = nrBest;
						c = ncBest;
						length++;

					}
					ans = Math.max(ans, length);
				}

			}
			System.out.println("#" + tc + " " + ans);

		} // tc for

	}// MAIN
}
