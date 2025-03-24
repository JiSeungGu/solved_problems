package Gold4;


import java.util.*;

public class 호텔 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt(); // 목표 고객 수
        int N = sc.nextInt(); // 도시 수

        int[] cost = new int[N];
        int[] customer = new int[N];

        for (int i = 0; i < N; i++) {
            cost[i] = sc.nextInt();
            customer[i] = sc.nextInt();
        }
        int max = 10000000;
        int[] dp = new int[C + 101];

        Arrays.fill(dp, max);

        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = customer[i]; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - customer[i]] + cost[i]);
            }
        }

        int min = 10000000;
        for(int i=C; i<dp.length;i++) {
            min = Math.min(min, dp[i]);
        }

        System.out.println(min);
    }
}
