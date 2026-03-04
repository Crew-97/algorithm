import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] order;

    public static void bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int cnt = 1;

        visited[start] = true;     // 시작 정점 방문
        order[start] = cnt++;      // 방문 순서 1
        q.offer(start);            // 큐에 넣기

        while (!q.isEmpty()) {
            int u = q.poll();      // 큐에서 하나 꺼냄(현재 정점)

            // 인접 정점을 오름차순으로 확인
            for (int v : graph[u]) {
                if (!visited[v]) { // 아직 방문 안했으면
                    visited[v] = true;   // 방문 처리(큐에 넣기 전에!)
                    order[v] = cnt++;    // 방문 순서 기록
                    q.offer(v);          // 큐 뒤에 추가
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N + 1];

        // 정점별 리스트 생성
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        // 간선 입력(무방향이라 양쪽에 추가)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        // 오름차순 방문 조건
        for (int i = 1; i <= N; i++) 
            Collections.sort(graph[i], Collections.reverseOrder());
        
        

        bfs(R);

        // i번째 줄 = 정점 i의 방문 순서(못가면 0)
        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
    }
}