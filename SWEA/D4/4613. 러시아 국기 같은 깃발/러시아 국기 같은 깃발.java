import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;
    static char[][] flag;
    static int[] costW, costB, costR;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            flag = new char[N][M];
            for (int i = 0; i < N; i++) {
                flag[i] = br.readLine().trim().toCharArray();
            }

            // 각 행을 칠할떄 만들 때 비용 미리 계산
            costW = new int[N];
            costB = new int[N];
            costR = new int[N];

            for (int i = 0; i < N; i++) {
                int w = 0, b = 0, r = 0;
                for (int j = 0; j < M; j++) {
                    char c = flag[i][j];
                    if (c != 'W') w++;
                    if (c != 'B') b++;
                    if (c != 'R') r++;
                }
                costW[i] = w;
                costB[i] = b;
                costR[i] = r;
            }

            //  완전탐색으로 최소 비용 찾기 => 반복문 마구 중첩
            int ans = Integer.MAX_VALUE;

            // wEnd: 흰색 구간의 마지막 행 (0 ~ N-3)
            for (int wEnd = 0; wEnd <= N - 3; wEnd++) {
                // bEnd: 파란색 구간의 마지막 행 (wEnd+1 ~ N-2)
                for (int bEnd = wEnd + 1; bEnd <= N - 2; bEnd++) {

                    int sum = 0;

                    // W 구간: 0 ~ wEnd
                    for (int i = 0; i <= wEnd; i++) sum += costW[i];

                    // B 구간: wEnd+1 ~ bEnd
                    for (int i = wEnd + 1; i <= bEnd; i++) sum += costB[i];

                    // R 구간: bEnd+1 ~ N-1
                    for (int i = bEnd + 1; i < N; i++) sum += costR[i];

                    ans = Math.min(ans, sum);
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
    }
}
