import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int arr[];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int ans = sumReal();
			System.out.println("#" + tc + " " + ans);

		} // tc for문 종료

	}// main
		// 처음에 입력값도 단조상승판정해야하는줄 암..
//	static boolean isReal() {
//		int cur = -1;
//		for (int i = 0; i < N; i++) {
//			if (arr[i] < cur) {
//				return false;
//			} else {
//				cur = arr[i];
//			}
//		}
//		return true;
//	}

	static int sumReal() {
		int max = -1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int product = arr[i] * arr[j];
				if (isDanzo(product) && product > max) {
					max = product;
				}

			}
		}
		return max;
	}

	static boolean isDanzo(int num) {

		String s = String.valueOf(num);

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) > s.charAt(i + 1)) {
				return false;
			}
		}
		return true;
	}

}
