import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int[] arr = new int[26];

			int N = Integer.parseInt(br.readLine().trim());
			String s = br.readLine();

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c >= 'A' && c <= 'Z') {
					arr[c - 'A']++;
				}
			}
			int max = -1;
			char result = 'A';
			for (int i = 0; i < 26; i++) {
				if (max < arr[i]) {
					max = arr[i];
					result = (char) (i + 'A');

				}
			}
			System.out.println("#" + tc + " " + result);

		}

	}

}
