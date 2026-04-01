import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] field;
    static boolean[][] visited;
    static int N, ans;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        // 필드입력

        field = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 로직
        // 1. 우선 최대 높이 (안전지대 마지노선) 찾기
        int height = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                height = Math.max(field[i][j], height);
            }
        }
        // 2. field 순회하면서 안전지대 탐색 (bfs) -> 최대높이만큼 반복
        // 순회하면서 BFS를 최대 높이만큼 반복해야할듯 3중 for
        for (int curHeight = 0; curHeight < height; curHeight++) {
            // 방문배열 초기화 및 해당 높이에서의 안전지대 초기화.
            visited = new boolean[N][N];
            int safeCount = 0;
            // 해당 높이 순회하면서 안전지대 카운트하기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 미방문 하고, 높이가 더 높다면? 안전지대
                    if (!visited[i][j] && field[i][j] > curHeight) {
                        bfs(i, j, curHeight);
                        safeCount++;
                    }
                }
            }
            // ans 값에 지속적으로 갱신해주기
            ans = Math.max(ans, safeCount);
        }

        // 출력
        System.out.println(ans);


    }

    static void bfs(int i, int j, int height) {
        // 일단 집어넣기
        visited[i][j] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            //꺼내고 델타탐색
            for (int d = 0; d < 4; d++) {

                int ni = curr[0] + dr[d];
                int nj = curr[1] + dc[d];
                // 범위밖? 체크
                if (isReal(ni, nj)) continue;
                // 재방문? 체크
                if (visited[ni][nj]) continue;
                // 침수? 체크
                if (field[ni][nj] <= height) continue;
                // 다 통과하면 여긴 안전지대. 방문체크 후 큐에 집어넣기.
                visited[ni][nj] = true;
                q.offer(new int[]{ni, nj});

            }
        }
    }

    static boolean isReal(int i, int j) {
        if (i < 0 || i >= N || j < 0 || j >= N) {
            return true;
        }
        return false;
    }

}
