package Silver3;

import java.util.Arrays;
import java.util.Scanner;

public class DP_연속된합 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] sequence = new int[N];
        for (int i=0; i< N ; i++){
            sequence[i] = sc.nextInt();
        }
        int[] dp = new int[N];
        dp[0] = sequence[0];
        for(int i=1; i<N ; i++) {
            dp[i] = Math.max(sequence[i], dp[i-1]+sequence[i]);
            System.out.println(Arrays.toString(dp));
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
