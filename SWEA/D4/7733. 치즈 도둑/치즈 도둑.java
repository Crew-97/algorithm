import java.util.*;
import java.io.*;

public class Solution {

    static int N;
    static int[][] cheese;
    static boolean[][] removed;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            cheese = new int[N][N];
            removed = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cheese[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxCount = 0;

            for (int day = 0; day <= 100; day++) {

                // 1단계: 오늘 날짜에 해당하는 칸 제거
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (cheese[i][j] == day) {
                            removed[i][j] = true;
                        }
                    }
                }

                // 2단계: 덩어리 수 계산
                visited = new boolean[N][N];
                int count = 0;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!removed[i][j] && !visited[i][j]) {
                            bfs(i, j);
                            count++;
                        }
                    }
                }

                // 3단계: 최댓값 갱신
                maxCount = Math.max(maxCount, count);
            }

            System.out.println("#" + tc + " " + maxCount);
        }
    }

    static void bfs(int startR, int startC) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 범위 체크, 제거 안됐는지, 방문 안했는지
                if (nr >= 0 && nr < N && nc >= 0 && nc < N
                        && !removed[nr][nc] && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}