package RealTest;

import java.util.*;

public class 메모리제한self2 {

    public static int solution(String key) {

        int MOD = 1_000_000_007;

        // 키보드 좌표 매핑
        String[][] keyboard = {
                {"q", "w", "e", "r", "t", "y", "u", "i", "o"},
                {"p", "a", "s", "d", "f", "g", "h", "j", "k"},
                {"l", "z", "x", "c", "v", "b", "n", "m"}
        };


        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < keyboard.length; i++) {
            for (int j = 0; j < keyboard[i].length; j++) {
                map.put(keyboard[i][j].charAt(0), new int[]{i, j});
            }
        }

        int n = key.length();
        long sum = 0;

        long[][] prefixSum = new long[n][2];

        for (int i = 1; i < n; i++) {
            char prev = key.charAt(i - 1);
            char curr = key.charAt(i);
            int[] prevPos = map.get(prev);
            int[] currPos = map.get(curr);

            int dx = Math.abs(prevPos[1] - currPos[1]);
            int dy = Math.abs(prevPos[0] - currPos[0]);

            prefixSum[i][0] = (prefixSum[i - 1][0] + dx) % MOD;
            prefixSum[i][1] = (prefixSum[i - 1][1] + dy) % MOD;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(prefixSum[i]));
        }

        for (int i = 0; i < key.length(); i++) {
            for (int j= i+1 ; j<key.length(); j++) {
                sum += prefixSum[j][0] - prefixSum[i][0] % MOD;
                sum += prefixSum[j][1] - prefixSum[i][1] % MOD;
            }
        }
        return (int) sum;
    }

    public static void main(String[] args) {

        System.out.println(solution("tooth"));


    }
}
