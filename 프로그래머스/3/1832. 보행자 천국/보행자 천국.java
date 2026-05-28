class Solution {
    private static final int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];

        // 시작점은 하나의 경로로 취급
        right[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // 통행 금지
                if (cityMap[i][j] == 1) {
                    right[i][j] = 0;
                    down[i][j] = 0;
                    continue;
                }

                // 시작점은 이미 초기화했으므로 패스
                if (i == 0 && j == 0) {
                    continue;
                }

                // 왼쪽 칸에서 현재 칸으로 오는 경우
                if (j > 0) {
                    if (cityMap[i][j - 1] == 0) {
                        right[i][j] = (right[i][j - 1] + down[i][j - 1]) % MOD;
                    } else if (cityMap[i][j - 1] == 2) {
                        right[i][j] = right[i][j - 1];
                    }
                }

                // 위쪽 칸에서 현재 칸으로 오는 경우
                if (i > 0) {
                    if (cityMap[i - 1][j] == 0) {
                        down[i][j] = (right[i - 1][j] + down[i - 1][j]) % MOD;
                    } else if (cityMap[i - 1][j] == 2) {
                        down[i][j] = down[i - 1][j];
                    }
                }
            }
        }

        return (right[m - 1][n - 1] + down[m - 1][n - 1]) % MOD;
    }
}