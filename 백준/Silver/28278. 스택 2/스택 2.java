import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                dq.offerLast(b);                 // 스택 push
            } 
            else if (a == 2) {
                if (!dq.isEmpty()) {
                    System.out.println(dq.pollLast());  // 스택 pop
                } else {
                    System.out.println(-1);
                }
            } 
            else if (a == 3) {
                System.out.println(dq.size());
            } 
            else if (a == 4) {
                if (!dq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            } 
            else {
                if (!dq.isEmpty()) {
                    System.out.println(dq.peekLast());  // 스택 top
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}