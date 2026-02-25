import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        Deque<Integer> q = new ArrayDeque<>();

        for (int tc = 1; tc <= T; tc++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            String cmd = st.nextToken();

            switch (cmd) {
                case "push": {
                    int x = Integer.parseInt(st.nextToken());
                    q.offerLast(x); // rear에 삽입
                    break;
                }
                case "pop": {
                    if (q.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(q.pollFirst()).append('\n'); // front 제거
                    }
                    break;
                }
                case "size": {
                    sb.append(q.size()).append('\n');
                    break;
                }
                case "empty": {
                    sb.append(q.isEmpty() ? 1 : 0).append('\n');
                    break;
                }
                case "front": {
                    if (q.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(q.peekFirst()).append('\n');
                    break;
                }
                case "back": {
                    if (q.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(q.peekLast()).append('\n');
                    break;
                }
            }
        }

        System.out.print(sb.toString());
    }
}