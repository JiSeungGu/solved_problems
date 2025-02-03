package Silver3;

import java.util.Arrays;
import java.util.Scanner;

/*

📌 문제 1: 계단 오르기 (Stair Climbing)
🟢 [문제 설명]
계단을 오를 때 한 번에 1칸 또는 2칸을 이동할 수 있다.
각 계단에는 밟을 때 얻는 점수가 있다.
"연속된 3개의 계단을 밟으면 안 된다"는 조건이 있을 때,
마지막 계단까지 올라가는 최대 점수를 구하라.

✅ 입력 형식

첫째 줄에 계단 개수 N (1 ≤ N ≤ 300)
둘째 줄에 N개의 정수 (각 계단의 점수, 1 ≤ 점수 ≤ 10,000)
✅ 출력 형식

마지막 계단까지 도착했을 때 얻을 수 있는 최대 점수를 출력하라.
🔹 예제 입력 1

복사
편집
5
10 20 15 25 10
🔹 예제 출력 1

복사
편집
75
🔹 설명
가능한 경로 중 10 → 20 → 25 → 10 을 선택하면 75점이 됨.
(연속으로 3칸을 밟으면 안 되는 제약이 있음!)

📌 문제 2: 포도주 시음 (Wine Tasting)
🟢 [문제 설명]
연속으로 놓여 있는 N개의 포도주 잔이 있다.
각 포도주 잔에는 특정한 양의 포도주가 들어 있다.
한 번에 마실 수 있는 포도주의 양은 제한이 없지만, 연속해서 3잔을 마시면 안 된다.
이 조건을 만족하면서 가장 많은 양의 포도주를 마시는 방법을 찾아라.

✅ 입력 형식

첫째 줄에 포도주 잔의 개수 N (1 ≤ N ≤ 10,000)
둘째 줄부터 N개의 정수가 주어짐 (각 포도주 잔에 들어 있는 양, 0 ≤ 양 ≤ 1,000)
✅ 출력 형식

마실 수 있는 포도주의 최대 양을 출력하라.

* */
public class DP_포도주 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] grape = new int[N];

        for(int i=0;i<N ;i++) {
            grape[i] = sc.nextInt();
        }
        int[] dp = new int[N];
        dp[0] = grape[0];
        for(int i=1; i<N; i++) {

            if(i>2) {
                dp[i] = Math.max(dp[i-2]+grape[i],dp[i-3]+grape[i-1]+grape[i]);
            } else {
                dp[i] = Math.max(grape[i-1] + grape[i],grape[0]+grape[i]);
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
