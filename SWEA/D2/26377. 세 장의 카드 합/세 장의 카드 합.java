import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			// map[sum] = 빈도수
			Map<Integer, Integer> map = new HashMap<>();
			// 최대 빈도수 일단 0으로 설정
			int max = 0;
			
			// A세트 조합의 합
			for(int i =1; i<= N; i++) {
				for(int j = i+1; j<=N; j++) {
					int Asum = i+j;
					
					
					for(int k = 1; k<=M; k++) {
						int total = Asum + k;
						// map 메서드
						int newCount = map.getOrDefault(total, 0)+1;
						map.put(total, newCount);
						
						if(newCount > max) max = newCount;
					}
				}
			}
			// 최빈합 모아서 정렬 후 출력
			List<Integer> ans = new ArrayList<>();
			for(Map.Entry<Integer, Integer> e : map.entrySet()) {
				if(e.getValue() == max) {
					ans.add(e.getKey());
				}
			}
			Collections.sort(ans);
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for(int v : ans) sb.append(v).append(" ");
			System.out.println(sb);

		} // tc for

	}// main

}
