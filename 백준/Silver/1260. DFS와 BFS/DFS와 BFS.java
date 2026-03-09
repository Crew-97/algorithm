import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visted;
    static int cnt;
    static StringBuilder sb;

    static void dfs(int node) {
        // 시작점은 바로 체크
        visted[node] = true;
        sb.append(node).append(" ");
        // 이제 어떻게하냐....반복문을 돌면서,방문 안한곳은 다돌꺼임(재귀). 방문 안한건 어케암? visited 체크.
        for (int next : graph[node]) {
            if (!visted[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        // 일단 deque 선언.
        ArrayDeque<Integer> q = new ArrayDeque<>();
        // 시작점은 무지성 방문체크.
        visted[start] = true;
        // q에 집어넣기 offer : 뒤에 집어넣기, poll : 앞에서 삭제. peek : 조회
        q.offer(start);
        // 반복문 돌려. 정점 집어넣고, 간선 순회 돌리는거지. 방문안한애들? 일단 q에 집어넣어버려.
        // while 문 돌아가면서 자동적으로 너비우선탐색이 된다.\
        // 그럼 다음 간선이 ? 정점이 되고, 또 반복. 해당 정점의 간선을 순회해. 결국엔 q가 다 비어버리고, bfs가 완성.
        while (!q.isEmpty()) {
            int u = q.poll();
            sb.append(u).append(" ");
            for (int v : graph[u]) {
                if (!visted[v]) {
                    visted[v] = true;
                    q.offer(v);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // 자료구조 초기화

        graph = new ArrayList[N + 1];
        visted = new boolean[N + 1];
        // 배열에 리스트 세팅하기
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        // 데이터 입력받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        //오름차순으로 출력 조건. 간선리스트 싹다 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
//            Collections.sort(graph[i], Collections.reverseOrder()); 이건 역순으로 정렬(내림차순)
        }
        cnt = 1;
        sb = new StringBuilder();
        dfs(V);
        // 이중반복문으로 ..? 출력을 어떻게 하지

        sb.append("\n");

        // 배열 값 싹다 val 값으로 초기화
        Arrays.fill(visted, false);
//        visted = new boolean[N + 1]; 아니면 초기화
        cnt = 1;
        bfs(V);

        System.out.println(sb);

    }
}
