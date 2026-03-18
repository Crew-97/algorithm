import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int[] numbers;
    static int[] cal; // +, -, *, / 순서로 개수 저장
    static int max, min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            // 연산자 카드 개수 입력
            cal = new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                cal[i] = Integer.parseInt(st.nextToken());
            }

            // 숫자 입력
            numbers = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            // 최대/최소 초기화
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            // DFS 시작: 슬롯 0번부터, 첫 번째 숫자를 cur로 시작
            dfs(0, numbers[0]);

            sb.append("#").append(t).append(" ").append(max - min).append("\n");
        }

        System.out.print(sb);
    }

    // depth: 현재 채우려는 슬롯 인덱스 (0 ~ N-2)
    // cur: 지금까지 왼쪽부터 계산한 결과값
    static void dfs(int depth, int cur) {

        // 종료 조건: 슬롯을 다 채웠을 때
        if (depth == N - 1) {
            max = Math.max(max, cur);
            min = Math.min(min, cur);
            return;
        }

        // 4가지 연산자 시도
        for (int i = 0; i < 4; i++) {
            if (cal[i] > 0) {
                cal[i]--;  // 연산자 사용
                dfs(depth + 1, calculate(cur, numbers[depth + 1], i));
                cal[i]++;  // 연산자 복원 (백트래킹)
            }
        }
    }

    // 계산 메서드
    static int calculate(int a, int b, int op) {
        switch (op) {
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            case 3:
                return a / b;  // 소수점 이하 버림 (int 나눗셈)
        }
        return 0; // 어차피 도달 불가능
    }
}