import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 단지내 아파트 개수(cnt) 및 아파트 단지 개수 받아줄 리스트
    static List<Integer> apart;
    static int cnt;
    // 돌아다니면서 체크할 2차원 배열
    static boolean[][] visited;
    static int[][] map;
    static int N;
    // 델타탐색에서 쓸 배열
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    // dfs돌릴 델타 탐색
    static boolean isReal(int i, int j) {
        if (i >= 0 && i < N && j >= 0 && j < N) {
            return true;
        }
        return false;
    }

    static void dfs(int i, int j) {
        // 시작점 방문 체크. 그리고 시작한곳도 아파트니까 cnt ++
        visited[i][j] = true;
        cnt++;
        for (int d = 0; d < 4; d++) {
            int ni = i + dr[d];
            int nj = j + dc[d];
            if (isReal(ni, nj) && !visited[ni][nj] && map[ni][nj] != 0) {
                dfs(ni, nj);
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        // 지도, 방문표시, 그리고 단지수 체크! 몇단지가 나올지 모르니까, 리스트로 선언.
        map = new int[N][N];
        visited = new boolean[N][N];
        apart = new ArrayList<>();

        // 지도 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        // 지도 순회하면서, dfs 델타 조건 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]){
                    dfs(i, j);
                    apart.add(cnt);
                    cnt = 0;
                }
            }
        }
        Collections.sort(apart);
        StringBuilder sb = new StringBuilder();
        sb.append(apart.size()).append("\n");
        for(int ans : apart){
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

}
