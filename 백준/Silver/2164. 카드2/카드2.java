import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 순회하면서 Queue 선언
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }
        // q 크기가 1일이 될때까지
        while (q.size() != 1) {
            // 맨앞 제거
            q.poll();
            // 맨앞 맨뒤로
            int x = q.poll();
            q.offer(x);
        }
        System.out.println(q.poll());

    }
}
