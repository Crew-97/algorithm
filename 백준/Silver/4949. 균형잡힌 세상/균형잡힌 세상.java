import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String s;

    public static void main(String[] args) throws IOException {

        while (true) {
            s = br.readLine();

            // 종료 조건
            if (s.equals(".")) break;

            char[] arr = s.toCharArray();
            Deque<Character> dq = new ArrayDeque<>();
            boolean isReal = true;

            for (int i = 0; i < arr.length; i++) {
            	// 덱에 넣기
                if (arr[i] == '(' || arr[i] == '[') {
                    dq.addLast(arr[i]);
                }
                // 닫힌가로 판별
                // 1. 덱이 비어있거나
                // 2. 마지막 요소가 열린 괄호가 아니라면? 다른게 왔다는 뜻이니...
                else if (arr[i] == ')') {
                    if (dq.isEmpty() || dq.peekLast() != '(') {
                        isReal = false;
                        break;
                    }
                    dq.removeLast();
                }
                else if (arr[i] == ']') {
                    if (dq.isEmpty() || dq.peekLast() != '[') {
                        isReal = false;
                        break;
                    }
                    dq.removeLast();
                }
            }
            // 모든조건을 완수했으면서 덱이 비어있어야 완전조화.
            if (isReal && dq.isEmpty()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}