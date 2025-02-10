package RealTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 메모리제한 {

    public static int solution(String key) {

        String[][] keyboard = new String[][]{
                {"q", "w", "e", "r", "t", "y", "u", "i", "o",},
                {"p", "a", "s", "d", "f", "g", "h", "j", "k"},
                {"l", "z", "x", "c", "v", "b", "n", "m"}
        };
        Map<Character, int[]> map = new HashMap<>();

        for (int i = 0; i < keyboard.length; i++) {
            for (int j = 0; j < keyboard[i].length; j++) {
                map.put(keyboard[i][j].charAt(0), new int[]{i, j});
            }
        }

        long sum = 0;
        int MOD = 1000000007;

//        for(int i=0; i< key.length(); i++ ) {
//            for (int j=i+1; j< key.length();j++) {
//                String first = String.valueOf(key.charAt(j-1));
//                String next = String.valueOf(key.charAt(j));
//                sum += Math.abs(map.get(first)[0] - map.get(next)[0]);
//                sum += Math.abs(map.get(first)[1] - map.get(next)[1]);
//                sum %= MOD;
//            }
//        }
        // 모든 부분 문자열을 생성
        for (int i = 0; i < key.length(); i++) {       // 시작 위치
            for (int j = i + 1; j < key.length(); j++) { // 끝 위치
                long complexity = 0;

                // i부터 j까지의 문자열 복잡도 계산
                for (int k = i; k < j; k++) {
                    char first = key.charAt(k);
                    char next = key.charAt(k + 1);
                    int[] pos1 = map.get(first);
                    int[] pos2 = map.get(next);
                    System.out.println(first+ " -> "+next);

                    complexity += Math.abs(pos1[0] - pos2[0]); // 세로 거리
                    complexity += Math.abs(pos1[1] - pos2[1]); // 가로 거리
                }

                sum = (sum + complexity) % MOD; // 큰 수 방지
            }
        }

        return (int) sum;
    }
    public static void main(String[] args) {

        System.out.println(solution("abcc"));
        System.out.println(solution("tooth"));
        System.out.println(solution("zzz"));
    }
}
