package Silver2;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/*
* 연속된 자연수의 합
*
* */
public class 수열의_합 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Long N = sc.nextLong();
        int L = sc.nextInt();

        Long[] dp = new Long[Math.toIntExact(N)];
        dp[0] = 0L;
//        dp[1] = 1L;
        for (int i = 1; i < N; i++) {
            dp[i] = dp[i-1] + i;
            if (dp[i] > N) {
                dp[i] = (long) i;
                for(int j=0; j<i ;j++) {
//                    System.out.println("dp[i] :"+dp[i]);
//                    System.out.println("i-j :"+(i-j));
                    dp[i-j-1]= dp[i-j] + (i-j-1);
                    if(Objects.equals(dp[i - j - 1], N)){
                        System.out.println(j);
                        System.out.println(i);
                        break;
                    }
                }
                System.out.println(Arrays.toString(dp));
                break;
            }
        }

    }
}
