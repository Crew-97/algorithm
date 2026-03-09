import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] field;
    static int[][] distance;
    static int N, M;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 필드 선언 및 스태틱 다 선언
        visited = new boolean[N][M];
        field = new int[N][M];
        distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                field[i][j] = line.charAt(j) - '0';
            }
        }
        // 0,0  부터 시작
        bfs(0, 0);
        System.out.println(distance[N - 1][M - 1]);


    }

    public static boolean isReal(int i, int j) {
        if (i >= 0 && i < N && j >= 0 && j < M) return true;
        else return false;
    }

    static void bfs(int i, int j) {
        visited[i][j] = true;
        distance[i][j] = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            if (r == N - 1 && c == M - 1)
                return;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (isReal(nr, nc) && !visited[nr][nc] && field[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    distance[nr][nc] = distance[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }


    }
}
