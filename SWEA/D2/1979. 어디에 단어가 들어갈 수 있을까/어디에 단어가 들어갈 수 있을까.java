
import java.util.Scanner;

public class Solution {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			// 1. 배열받기
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			// 델타 배열문제가 아닌거 같다...
			// 조건문 설정이 도저히 안됨
			int ans = 0;

			for (int i = 0; i < N; i++) {
				int count = 0;
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1)
						count++;
					else {
						if (count == K)
							ans++;
						count = 0;
					}
				}
				if (count == K) ans++;

			}
			

			for (int i = 0; i < N; i++) {
				int count = 0;
				for (int j = 0; j < N; j++) {
					if (arr[j][i] == 1)
						count++;
					else {
						if (count == K)
							ans++;
						count = 0;
					}
				}
				if (count == K) ans++;

			}
			
			System.out.println("#"+tc+" "+ans);
			

		} // tc for문 종

	}// main 종료
}
