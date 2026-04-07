import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static int answer = 0;
    static char[][] field;
    static boolean[] visited = new boolean[26];
    // 델타
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        field = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                field[i][j] = s.charAt(j);
            }
        }
        // 로직
        visited[field[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(answer);

    }

    static void dfs(int r, int c, int count) {
        answer = Math.max(answer, count);

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if (visited[field[nr][nc] - 'A']) continue;

            visited[field[nr][nc] - 'A'] = true;
            dfs(nr, nc, count + 1);
            visited[field[nr][nc] - 'A'] = false;
        }
    }
}
