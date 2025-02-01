package Silver3;
//📌 문제: 개구리 점프 (Frog Jump)
//🟢 [문제 설명]
//
//개구리가 0번 돌에서 N번 돌까지 이동하려고 해!
//개구리는 한 번에 1칸 or 2칸 점프 가능해.
//돌마다 점프할 때 드는 에너지 비용이 주어져.
//개구리가 N번 돌에 도착할 때 최소 에너지를 구하는 프로그램을 작성하라!
//        🟢 [입력 형식]
//
//첫째 줄에 돌의 개수 N (1 ≤ N ≤ 100,000)이 주어져.
//둘째 줄에 N개의 정수 E[i]가 주어지는데, 이는 i번 돌에 착지할 때 드는 에너지 비용을 의미해.
//        🟢 [출력 형식]
//
//개구리가 0번에서 N번 돌까지 이동할 때 최소 에너지 비용을 출력해라!

import java.util.Arrays;
import java.util.Scanner;

public class DP_개구리점프 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rock = sc.nextInt();
        int[] energe = new int[rock];
        for(int i=0; i<rock; i++) {
            energe[i] = sc.nextInt();
        }
        int[] dp = new int[rock];
        dp[0] = 0; //초기값 10
        dp[1] = energe[0];
        for(int i=2; i<rock ;i++) {

            dp[i] = Math.min(energe[i-2]+dp[i-2], energe[i-1]+dp[i-1]);

        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[rock-1]);
    }
}
