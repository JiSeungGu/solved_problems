package Silver3;

import java.util.Arrays;
import java.util.Scanner;

public class DP_동전거스름돈 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int amount = sc.nextInt();
        int[] coin = new int[N];
        int[] dp = new int[amount+1];
        for (int i=0; i<N ; i++) {
            coin[i] = sc.nextInt();
        }
        dp[0] = 0;
        if(Arrays.stream(coin).min().getAsInt()==1) {
            dp[1] =1;
        } else{
            dp[1] = Integer.MAX_VALUE;
        }
        for(int i=2 ; i<=amount ; i++) {
//            dp[i] = dp[i-1]+1;
            dp[i] = Integer.MAX_VALUE;
            for (int k : coin) {

                if(i == k) {
                    dp[i] = 1;
                    break;
                }
                else if ((i - k) > 0) {
                    if(!(dp[i-k] == Integer.MAX_VALUE)) {
                        System.out.println(" i :" + i);
                        System.out.println(" k :" + k);
                        System.out.println("i-k : " + (i - k));
                        System.out.println("dp[i] :" + dp[i]);
                        System.out.println("dp[i-k]:" + dp[i - k]);
                        System.out.println("Math.min :" + Math.min(dp[i], dp[i - k] + 1));
//                    System.out.println("dp["+i+"]"+dp[i]);
                        dp[i] = Math.min(dp[i], dp[i - k] + 1);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        if(dp[amount]==Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[amount]);
        }
//        System.out.println(Arrays.toString(dp));
    }
}
