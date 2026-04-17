import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] map;
    static List<int[]> cores;
    static int totalCore;
    static int maxCore;
    static int minWire;

    // 상, 하, 좌, 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            cores = new ArrayList<>();

            for (int r = 0; r < N; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                    if (map[r][c] == 1 && r != 0 && r != N - 1 && c != 0 && c != N - 1) {
                        cores.add(new int[]{r, c});
                    }
                }
            }

            totalCore = cores.size();
            maxCore = 0;
            minWire = Integer.MAX_VALUE;

            dfs(0, 0, 0);

            sb.append("#").append(tc).append(" ").append(minWire).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int idx, int cnt, int len) {
        // 가지치기: 남은 코어 다 연결해도 max 못 넘으면 중단
        if (cnt + (totalCore - idx) < maxCore) return;

        // 모든 코어에 대한 결정 완료
        if (idx == totalCore) {
            if (cnt > maxCore) {
                maxCore = cnt;
                minWire = len;
            } else if (cnt == maxCore) {
                minWire = Math.min(minWire, len);
            }
            return;
        }

        int[] core = cores.get(idx);
        int r = core[0];
        int c = core[1];

        // 4방향 연결 시도
        for (int d = 0; d < 4; d++) {
            int wireLen = canInstall(r, c, d);
            if (wireLen > 0) {
                install(r, c, d, wireLen);
                dfs(idx + 1, cnt + 1, len + wireLen);
                uninstall(r, c, d, wireLen);
            }
        }

        // 포기 선택지: 이 코어는 연결 안 함
        dfs(idx + 1, cnt, len);
    }

    // 설치 가능하면 전선 길이 반환, 불가능하면 -1
    static int canInstall(int r, int c, int d) {
        int nr = r + dr[d];
        int nc = c + dc[d];
        int length = 0;

        while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
            if (map[nr][nc] != 0) return -1;
            length++;
            nr += dr[d];
            nc += dc[d];
        }
        return length;
    }

    static void install(int r, int c, int d, int length) {
        int nr = r + dr[d];
        int nc = c + dc[d];
        for (int i = 0; i < length; i++) {
            map[nr][nc] = 2;
            nr += dr[d];
            nc += dc[d];
        }
    }

    static void uninstall(int r, int c, int d, int length) {
        int nr = r + dr[d];
        int nc = c + dc[d];
        for (int i = 0; i < length; i++) {
            map[nr][nc] = 0;
            nr += dr[d];
            nc += dc[d];
        }
    }
}