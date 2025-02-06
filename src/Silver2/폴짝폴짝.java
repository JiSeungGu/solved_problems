package Silver2;

import java.util.Arrays;
import java.util.Scanner;

public class 폴짝폴짝 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] rock = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            rock[i] = sc.nextInt();
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        int[] dp = new int[N + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[start] = 0;
        for (int i = 1; i <= N; i++) {

            for (int j = 1; j <= N; j++) {
//                System.out.println((Math.abs(start-j)));
                if ((Math.abs(start-j) % rock[start])==0 && !(j==start)) {
//                    if(dp[start] != Integer.MIN_VALUE) {
                    if((dp[start] + 1) > 0) {
                        dp[j] = Math.min(dp[j], dp[start] + 1);
//                        System.out.println("dp[start] :"+dp[start]);
//                        System.out.println("i :"+i);
//                        System.out.println("dp[j] :"+dp[j]);
//                        System.out.println("rock[start] :"+rock[start]);
//                        System.out.println(Arrays.toString(dp));
//                    }
//                    }

                    }
                }
            }
            start = i+1;
        }
        System.out.println(dp[end] == Integer.MAX_VALUE ? "-1" : dp[end]);

    }
}
