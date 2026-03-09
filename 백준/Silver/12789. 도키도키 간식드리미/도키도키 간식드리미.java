import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N명이 줄을 서 있음
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> stack = new ArrayDeque<>(); // 새치기 공간 (보조 스택)
        int next = 1;       // 현재 나가야 할 번호 (1번부터 순서대로)
        boolean possible = true;

        for (int i = 0; i < N; i++) {
            int person = arr[i]; // 줄에서 한 명씩 꺼냄

            if (person == next) {
                // 현재 사람이 나가야 할 번호와 일치 → 바로 통과
                next++;

                // 통과 후, 스택 top에 다음 번호가 있으면 연속으로 통과시킴
                // ex) next=3일때 스택 top이 3이면 꺼내고, 그 다음 top이 4면 또 꺼내고...
                while (!stack.isEmpty() && stack.peek() == next) {
                    stack.pop();
                    next++;
                }
            } else {
                // 현재 사람이 아직 나갈 차례가 아님 → 스택(새치기 공간)에 임시 보관

                // 스택 top이 현재 사람 번호보다 작으면 실패
                // ex) 스택 top=2, 현재 person=5 라면
                //     2가 5 아래 깔려서 영원히 꺼낼 수 없음 → 불가능
                if (!stack.isEmpty() && stack.peek() < person) {
                    possible = false;
                    break;
                }

                // 문제 없으면 스택에 push (나중에 꺼낼 예정)
                stack.push(person);
            }
        }

        // 모든 과정이 가능했으면 "Nice", 중간에 막혔으면 "Sad"
        System.out.println(possible ? "Nice" : "Sad");
    }
}