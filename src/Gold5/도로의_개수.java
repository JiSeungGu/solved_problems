package Gold5;


import java.util.*;


public class 도로의_개수 {
    // 오른쪽, 왼쪽, 아래, 위
    public static int[] move_x = {1,  0};
    public static int[] move_y = {0,  1};
    public static int N;
    public static int M;
    public static int K;
    public static int routeCase = 0;
    public static List<int[]> block;
    public static List<int[]> block_move;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //가로
        N = sc.nextInt();
        //세로
        M = sc.nextInt();
        //공사
        K = sc.nextInt();

        block = new ArrayList<>();
        block_move = new ArrayList<>();
        boolean[][][] blocked = new boolean[N+1][M+1][2];
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int next_x = sc.nextInt();
            int next_y = sc.nextInt();
            if (x < next_x) {
                blocked[x][y][0] = true;  // (x, y) → (x+1, y) 이동 막힘
                blocked[next_x][next_y][1] = true;  // (x+1, y) → (x, y) 이동 막힘 (반대)
            }
            if (y < next_y) {
                blocked[x][y][1] = true;  // (x, y) → (x, y+1) 이동 막힘
                blocked[next_x][next_y][0] = true;  // (x, y+1) → (x, y) 이동 막힘 (반대)
            }

        }

        long[][] dp = new long[N+1][M+1];

        for(int i=0;i<N; i++) {
            Arrays.fill(dp[i],0);
        }



//        dp[0][0] = 0;

//        for(int i=0; i<=N ;i++) {
//            for(int j=0; j<=M; j++) {
//                if (i == 0 && j == 0) {
//                    dp[i][j] = 1;  // 시작점은 1로 설정
//                } else if (i == 0) {
//                    if(!blocked[i][j][0]) dp[i][j] = dp[i][j - 1];  // 첫 행은 왼쪽에서만 올 수 있음
//                } else if (j == 0) {
//                    if(!blocked[i][j][1]) dp[i][j] = dp[i - 1][j];  // 첫 열은 위에서만 올 수 있음
//                } else {
//                    if(!blocked[i][j][0] && !blocked[i][j][1])  dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//                    else if(!blocked[i][j][0]) dp[i][j] = dp[i][j - 1];
//                    else if(!blocked[i][j][1]) dp[i][j] = dp[i - 1][j];
//
//                }
//            }
//        }
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;  // 시작점
                } else {
                    if (i > 0 && !blocked[i-1][j][1]) {
                        dp[i][j] += dp[i-1][j]; // 위쪽에서 오는 경우
                    }
                    if (j > 0 && !blocked[i][j-1][0]) {
                        dp[i][j] += dp[i][j-1]; // 왼쪽에서 오는 경우
                    }
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}
