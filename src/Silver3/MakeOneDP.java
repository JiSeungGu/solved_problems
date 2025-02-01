package Silver3;

import java.util.Scanner;

public class MakeOneDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;  // 1을 빼는 경우 (기본적으로 1 추가)

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);  // 2로 나누는 경우 비교
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);  // 3으로 나누는 경우 비교
            }
        }

        System.out.println(dp[N]);  // 최적의 연산 횟수 출력
    }
}