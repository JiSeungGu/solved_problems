package Silver3;

import java.util.Arrays;
import java.util.Scanner;

public class DP_연속부분증가수열 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] Subsequence = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            Subsequence[i] = sc.nextInt();
        }
        int count=1;
        for(int i=1; i < N; i++) {

            if(Subsequence[i-1]<Subsequence[i]) {
                count++;
                dp[i] = count;
            } else {
                count = 1;
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
