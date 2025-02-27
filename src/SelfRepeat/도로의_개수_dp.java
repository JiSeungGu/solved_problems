package SelfRepeat;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 도로의_개수_dp {

    // 오른쪽, 왼쪽, 아래, 위
    public static int[] move_x = {1, 0};
    public static int[] move_y = {0, 1};
    public static int N;
    public static int M;
    public static int K;
    public static int routeCase = 0;
    public static List<int[]> block;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //가로
        N = sc.nextInt();
        //세로
        M = sc.nextInt();
        //공사
        K = sc.nextInt();


        boolean[][][] check = new boolean[N + 1][M + 1][2];
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int move_x = sc.nextInt();
            int move_y = sc.nextInt();

            if (x == move_x) {
                check[x][Math.min(y,move_y)][0] = true;
//                check[move_x][move_y][0] = true;  // 왼쪽(←) 이동 금지 (반대 방향)
            }else  {
                check[Math.min(x,move_x)][y][1] = true;
//                check[move_x][move_y][1] = true;
            }
        }

        long[][] dp = new long[N + 1][M + 1];

        for(int i=0;i<N; i++) {
            Arrays.fill(dp[i],0);
        }
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    if (i > 0 && !check[i - 1][j][1]) {

                        dp[i][j] += dp[i - 1][j];
                    }
                    if (j > 0 && !check[i][j - 1][0]) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }
            System.out.println(dp[N][M]);
    }
}
