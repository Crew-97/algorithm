import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w;
    static int h;
    static int[][] field;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0, -1, 1, 1, -1};
    static int[] dc = {0, 0, -1, 1, 1, 1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            // 루프물의 결말은 종료조건에서 생성
            if (w == 0 && h == 0) {
                System.out.println(sb);
                return;
            }
            // 너비 높이로 주어질때, 행 렬 변수 선언 조심할 것
            field = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    field[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // 섬구역 전체 탐색 종료마다 카운트 증가.
                    if (!visited[i][j] && field[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');

        }
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            // 스킵조건 이렇게 쓰기. 한번만 쓰이면 굳이 메서드 따로 빼지 말기
            if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
            if (visited[nr][nc] || field[nr][nc] != 1) continue;
            dfs(nr, nc);
        }
    }
}


