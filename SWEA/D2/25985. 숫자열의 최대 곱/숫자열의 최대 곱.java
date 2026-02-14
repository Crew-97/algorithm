import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] Narr;
			int[] Marr;

			int ans = Integer.MIN_VALUE;

			if (N >= M) {
				// Narr의 앞뒤로 M-1만큼의 여유 공간을 둠
				Narr = new int[N + (M - 1) * 2];
				Marr = new int[M];

				// 실제 값은 중앙(M-1 인덱스부터)에 입력 (나머지는 0으로 자동 초기화)
				for (int i = 0; i < N; i++) {
					Narr[i + (M - 1)] = sc.nextInt();
				}
				for (int i = 0; i < M; i++) {
					Marr[i] = sc.nextInt();
				}

				// 슬라이딩 범위: 처음 한 칸 겹칠 때부터 마지막 한 칸 겹칠 때까지
				// 전체 길이(N+2M-2)에서 Marr(M)이 움직일 수 있는 횟수
				for (int i = 0; i <= Narr.length - M; i++) {
					int sum = 0;
					for (int j = 0; j < M; j++) {
						sum += Marr[j] * Narr[i + j];
					}
					if (sum > ans)
						ans = sum;
				}
			} else {
				// M이 더 클 때: Marr의 앞뒤로 N-1만큼의 여유 공간을 둠
				Marr = new int[M + (N - 1) * 2];
				Narr = new int[N];

				for (int i = 0; i < N; i++) {
					Narr[i] = sc.nextInt();
				}
				for (int i = 0; i < M; i++) {
					Marr[i + (N - 1)] = sc.nextInt();
				}

				for (int i = 0; i <= Marr.length - N; i++) {
					int sum = 0;
					for (int j = 0; j < N; j++) {
						sum += Narr[j] * Marr[i + j];
					}
					if (sum > ans)
						ans = sum;
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}