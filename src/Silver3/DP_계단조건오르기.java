package Silver3;

import java.util.Arrays;
import java.util.Scanner;

public class DP_계단조건오르기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] point = new int[N];
        for (int i = 0; i < N; i++) {
            point[i] = sc.nextInt();
        }

        int[] dp = new int[N];
        dp[0] = point[0];
        for (int i = 1; i < N; i++) {

            if (i > 2) {
                dp[i] = Math.max((point[i] + dp[i - 2]), ((dp[i - 3] + point[i] + point[i - 1])));
            } else {
                dp[i] = Math.max(point[i-1]+point[i],point[0]+point[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
