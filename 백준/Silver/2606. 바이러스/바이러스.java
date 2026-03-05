import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int cnt;

    static void dfs(int node) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) {
                cnt++;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int point = Integer.parseInt(br.readLine());
        int lines = Integer.parseInt(br.readLine());

        visited = new boolean[point + 1];
        graph = new ArrayList[point + 1];

        for (int i = 1; i <= point; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < lines; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }
        cnt = 0;
        dfs(1);
        System.out.println(cnt);

    }
}
