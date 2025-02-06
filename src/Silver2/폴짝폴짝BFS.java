package Silver2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 폴짝폴짝BFS {


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
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        while (!que.isEmpty()) {

            start = que.poll();
            for (int i = 1; i <= N; i++) {
                if ((Math.abs(start - i) % rock[start]) == 0 && !(i == start)) {
//                    if (dp[i] != Integer.MAX_VALUE) {
                    if (dp[i] > dp[start] + 1) que.add(i);
                    dp[i] = Math.min(dp[i], dp[start] + 1);
//                    }
                }
            }
//            System.out.println(Arrays.toString(dp));
        }
        System.out.println(dp[end] == Integer.MAX_VALUE ? "-1" : dp[end]);
    }
}
