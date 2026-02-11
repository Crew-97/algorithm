import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());// st 선언 항상 조심하자

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			int[] Aarr = new int[A];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < A; i++) {
				Aarr[i] = Integer.parseInt(st.nextToken());
			}

			int[] Barr = new int[B];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < B; i++) {
				Barr[i] = Integer.parseInt(st.nextToken());
			}

			boolean ans = isReal(Aarr, Barr);
			sb.append("#").append(tc).append(" ");
			sb.append(ans ? "YES\n" : "NO\n");

		} // tc for
		System.out.println(sb);

	}// main

	static boolean isReal(int[] Aarr, int[] Barr) {
		int i = 0; // 짧은 배열 시작점
		for (int j = 0; j < Aarr.length; j++) { // 긴배열 순회 ㄱ
			if (i < Barr.length && Aarr[j] == Barr[i]) { // 만약 B배열의 길이를 넘지 않은 B배열의 요소들이 Aarr과 같다면 i++
				i++;// B배열의 인덱스만 늘린다. 이전의 A배열은 계속 그 다음부터 탐색 => 자동으로 순서 보장함
				if (i == Barr.length) {// 마지막 배열의 요소를 찾았다면 모든 조건을 만족한 채로 i가 크기가 1 늘어났을테고, 이는 마지막 인덱스에서 +1한것과 같으므로,
					// 길이와 값이 같아짐 따라서 즉시 반복문 종료 (A가 길이가 한참 더 길수도 있으니까 쓸데없는 반복 줄이기.
					return true;
				}
			}
		}
		return false;

	}

}// solu
