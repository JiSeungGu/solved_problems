package RealTest;

import java.util.*;

public class ArcheryGame {
    static int N, K, wantedPoint;
    static int[][] Target;
    static int[] arrows;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        wantedPoint = sc.nextInt();

        Target = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Target[i][j] = sc.nextInt();
            }
        }

        arrows = new int[K];
        for (int i = 0; i < K; i++) {
            arrows[i] = sc.nextInt();
        }

        int result = solve();
        System.out.println(result);
    }

    static int solve() {
        // 점수를 만들기 위한 최소 힘을 저장하는 DP 배열
        int[] dp = new int[wantedPoint + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0}); // {현재 점수, 소모된 힘}

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int score = current[0];
            int power = current[1];

            if (score == wantedPoint) return power; // 목표 도달 시 최소 힘 반환

            for (int k = 0; k < K; k++) {  // 화살 선택
                int arrowSize = arrows[k];

                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < N; y++) {
                        int addScore = getScore(x, y, arrowSize);
                        int newScore = score + addScore;
                        int newPower = power + arrowSize;

                        if (newScore <= wantedPoint && newPower < dp[newScore]) {
                            dp[newScore] = newPower;
                            queue.add(new int[]{newScore, newPower});
                        }
                    }
                }
            }
        }

        return -1; // 목표 점수를 만들 수 없으면 -1 반환
    }

    // 특정 좌표 (x, y)에 size 크기의 화살을 맞췄을 때 얻을 수 있는 점수 계산
    static int getScore(int x, int y, int size) {
        int sum = 0;
        for (int i = x - size + 1; i <= x + size - 1; i++) {
            for (int j = y - size + 1; j <= y + size - 1; j++) {
                if (i >= 0 && i < N && j >= 0 && j < N) {
                    if (Math.abs(x - i) + Math.abs(y - j) < size) {
                        sum += Target[i][j];
                    }
                }
            }
        }
        return sum;
    }
}