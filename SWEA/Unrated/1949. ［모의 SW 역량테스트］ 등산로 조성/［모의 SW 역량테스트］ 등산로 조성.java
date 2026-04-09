import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] field;
    static boolean[][] visited;
    static int N, K, length;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            field = new int[N][N];
            visited = new boolean[N][N];
            length = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    field[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 1. 최대값(정상) 찾기
            int top = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    top = Math.max(top, field[i][j]);
                }
            }

            // 2. 정상인 모든 칸에서 DFS 시작
            // 시작점 자체가 1칸이므로 curlength = 1로 시작
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (field[i][j] == top) {
                        visited[i][j] = true;
                        DFS(i, j, false, 1);
                        visited[i][j] = false;
                    }
                }
            }

            System.out.println("#" + tc + " " + length);
        }
    }

    private static void DFS(int r, int c, boolean flag, int curlength) {
        // 현재 경로 길이가 최대인지 갱신
        length = Math.max(length, curlength);

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 범위 체크
            if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            // 방문 체크
            if (visited[nr][nc]) continue;

            // 경우 1. 다음 칸이 현재보다 낮으면 그냥 이동
            if (field[nr][nc] < field[r][c]) {
                visited[nr][nc] = true;
                DFS(nr, nc, flag, curlength + 1);
                visited[nr][nc] = false; // 백트래킹: 방문 복원
            }
            // 경우 2. 다음 칸이 현재보다 높거나 같고, 아직 공사를 안 했으면
            else if (!flag) {
                // 깎아야 하는 양 = field[nr][nc] - (field[r][c] - 1)
                // 즉 현재 칸보다 1 낮게 만들어야 이동 가능
                int gap = field[nr][nc] - field[r][c] + 1;
                if (gap <= K) {
                    int original = field[nr][nc];
                    field[nr][nc] = field[r][c] - 1; // 공사: 이동 가능한 높이로 낮춤
                    visited[nr][nc] = true;
                    DFS(nr, nc, true, curlength + 1); // flag = true, 공사 사용 완료
                    visited[nr][nc] = false; // 백트래킹: 방문 복원
                    field[nr][nc] = original; // 백트래킹: 높이 복원
                }
            }
        }
    }
}