package Silver3;

import java.util.Arrays;
import java.util.Scanner;

public class DP_점프게임 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] jump = new int[N];
        for (int i = 0; i < N; i++) {
            jump[i] = sc.nextInt();
        }

        int[] dp = new int[N];
        int maxJump = Arrays.stream(jump).max().getAsInt();
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < N; i++) {

            if (!(jump[i-1] == 0) && dp[i-1] != Integer.MAX_VALUE) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = Integer.MAX_VALUE;
            }
            System.out.println(Arrays.toString(dp));
            for (int j = 1; j <= maxJump; j++) {
                if (i >= j) {
                    if ((jump[i - j] + (i - j)) >= i && dp[i] != Integer.MAX_VALUE) {
                        System.out.println("(jump[i - j] :" + (jump[i - j]));
                        System.out.println("(i - j) :" + (i - j));

                        dp[i] = Math.min(dp[i], dp[i - j] + 1);
                    }
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        System.out.println(dp[N-1]==Integer.MAX_VALUE ? "-1" : dp[N-1]);
    }
}
