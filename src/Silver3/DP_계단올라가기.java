package Silver3;

import java.util.Arrays;
import java.util.Scanner;

public class DP_계단올라가기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stair = sc.nextInt();
        int[] dp = new int[stair+1];

        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<=stair ; i++) {

            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(Arrays.toString(dp));
    }
}
