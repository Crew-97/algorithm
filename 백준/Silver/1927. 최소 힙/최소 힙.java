import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxQ = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int type = Integer.parseInt(br.readLine());
            if (type == 0) {
                if (maxQ.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(maxQ.poll()).append("\n");
                }
            } else {
                maxQ.offer(type);
            }
        }
        System.out.println(sb);
    }
}
