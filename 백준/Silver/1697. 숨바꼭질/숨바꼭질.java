import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int MAX = 100001;
        boolean[] visited = new boolean[MAX]; // 방문 여부
        int[] dist = new int[MAX];            // 걸린 시간

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == end) {
                System.out.println(dist[cur]);
                return;
            }

            int[] moves = {cur - 1, cur + 1, cur * 2};

            for (int next : moves) {

                // 범위 벗어나거나 이미 방문했으면 건너뜀
                if (next < 0 || next >= MAX || visited[next]) continue;

                visited[next] = true;
                dist[next] = dist[cur] + 1; // 현재 시간 + 1초
                q.offer(next);
            }
        }
    }
}


