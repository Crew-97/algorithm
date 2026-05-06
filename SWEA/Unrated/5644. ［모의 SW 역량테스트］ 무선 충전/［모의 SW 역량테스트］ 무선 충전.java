import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    // 이동 시간
    static int M;

    // BC의 개수
    static int AP;

    // 사용자 A와 사용자 B의 이동 정보를 저장하는 배열
    static int[] moveA;
    static int[] moveB;

    // 각 BC의 위치와 충전 범위와 성능을 저장하는 배열
    static int[] bcX;
    static int[] bcY;
    static int[] bcC;
    static int[] bcP;

    static int[] dx = {0, 0, 1, 0, -1};
    static int[] dy = {0, -1, 0, 1, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            AP = Integer.parseInt(st.nextToken());

            // 사용자 A와 사용자 B의 이동 정보를 저장할 배열
            moveA = new int[M];
            moveB = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                moveA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                moveB[i] = Integer.parseInt(st.nextToken());
            }

            // BC 정보를 저장할 배열
            bcX = new int[AP];
            bcY = new int[AP];
            bcC = new int[AP];
            bcP = new int[AP];

            // x와 y는 BC의 위치
            // c는 충전 범위
            // p는 충전 성능
            for (int i = 0; i < AP; i++) {
                st = new StringTokenizer(br.readLine());

                bcX[i] = Integer.parseInt(st.nextToken());
                bcY[i] = Integer.parseInt(st.nextToken());
                bcC[i] = Integer.parseInt(st.nextToken());
                bcP[i] = Integer.parseInt(st.nextToken());
            }
			//시작점
            int ax = 1;
            int ay = 1;

            int bx = 10;
            int by = 10;

            // 두 사용자의 총 충전량을 저장
            int total = 0;

            total += getMaxCharge(ax, ay, bx, by);

            for (int time = 0; time < M; time++) {

                // 사용자 A를 현재 시간의 이동 방향대로 이동시킨다.
                ax += dx[moveA[time]];
                ay += dy[moveA[time]];

                // 사용자 B를 현재 시간의 이동 방향대로 이동시킨다.
                bx += dx[moveB[time]];
                by += dy[moveB[time]];

                // 이동이 끝난 뒤 그 위치에서 받을 수 있는 최대 충전량을 더한다.
                total += getMaxCharge(ax, ay, bx, by);
            }

            // 문제에서 요구한 출력 형식에 맞게 결과를 저장한다.
            sb.append("#").append(tc).append(" ").append(total).append("\n");
        }

        // 모든 테스트 케이스의 결과를 한 번에 출력한다.
        System.out.print(sb);
    }

    static int getMaxCharge(int ax, int ay, int bx, int by) {

        // 현재 시간에서 받을 수 있는 최대 충전량을 저장한다.
        int max = 0;

        // 사용자 A가 선택할 BC를 하나씩 정한다.
        for (int i = 0; i < AP; i++) {

            // 사용자 B가 선택할 BC를 하나씩 정한다.
            for (int j = 0; j < AP; j++) {

                // 사용자 A가 i번 BC에서 받을 수 있는 충전량이다.
                int chargeA = 0;

                // 사용자 B가 j번 BC에서 받을 수 있는 충전량이다.
                int chargeB = 0;

                // 사용자 A가 i번 BC의 충전 범위 안에 있으면 충전할 수 있다.
                if (canCharge(ax, ay, i)) {
                    chargeA = bcP[i];
                }

                // 사용자 B가 j번 BC의 충전 범위 안에 있으면 충전할 수 있다.
                if (canCharge(bx, by, j)) {
                    chargeB = bcP[j];
                }

                // 이번 BC 선택 조합에서의 충전량 합이다.
                int sum = 0;

                // 두 사용자가 같은 BC를 선택한 경우다.
                if (i == j) {

                    // 둘 다 같은 BC에 접속할 수 있다면 성능을 나누어 갖는다.
                    // 하지만 총합만 계산하면 결국 해당 BC의 성능과 같다.
                    if (chargeA > 0 && chargeB > 0) {
                        sum = bcP[i];
                    }

                    // 둘 중 한 명만 접속할 수 있다면 그 사람만 충전한다.
                    // 둘 다 접속할 수 없다면 0이 된다.
                    else {
                        sum = chargeA + chargeB;
                    }
                }

                // 두 사용자가 서로 다른 BC를 선택한 경우다.
                else {

                    // 서로 다른 BC이므로 각각의 성능을 그대로 더한다.
                    sum = chargeA + chargeB;
                }

                // 지금까지 찾은 충전량 중 가장 큰 값을 저장한다.
                max = Math.max(max, sum);
            }
        }

        // 현재 시간에서 가능한 최대 충전량을 반환한다.
        return max;
    }

    static boolean canCharge(int userX, int userY, int bcIndex) {

        // 사용자와 BC 사이의 거리를 계산한다.
        // 문제에서 주어진 거리 공식은 x 차이와 y 차이를 더하는 방식이다.
        int distance = Math.abs(userX - bcX[bcIndex]) + Math.abs(userY - bcY[bcIndex]);

        // 거리가 BC의 충전 범위보다 작거나 같으면 충전할 수 있다.
        return distance <= bcC[bcIndex];
    }
}