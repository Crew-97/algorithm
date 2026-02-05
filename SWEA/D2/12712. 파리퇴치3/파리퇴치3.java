import java.util.Scanner;

public class Solution {
	static int dr[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int dc[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int pw = sc.nextInt();

			int[][] field = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					field[i][j] = sc.nextInt();
				}
			}

			int max = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					// 1. + 모양 0~3
					int sumPlus = field[i][j];
					for (int d = 0; d < 4; d++) {
						for (int p = 1; p < pw; p++) {
							int nr = i + dr[d] * p;
							int nc = j + dc[d] * p;

							// 범위를 벗어난 경우 '패스'
							if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
								continue;
							}
							sumPlus += field[nr][nc];
						}
					}
					max = Math.max(max, sumPlus);

					// 2. x 모양 4~7 
					int sumX = field[i][j];
					for (int d = 4; d < 8; d++) {
						for (int p = 1; p < pw; p++) {
							int nr = i + dr[d] * p;
							int nc = j + dc[d] * p;

							// 여기도 패스
							if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
								continue;
							}
							sumX += field[nr][nc];
						}
					}
					max = Math.max(max, sumX);
				}
			}
			System.out.println("#" + tc + " " + max);
		}

	}
}