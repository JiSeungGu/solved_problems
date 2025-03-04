package Gold5;


import java.util.*;

public class 램프 {

    public static int N;
    public static int M;
    public static int K;
    public static int maxCount = 0;  // 최대 켜진 행 개수 저장

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        M = sc.nextInt();

        int[][] map = new int[N][M];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        K = sc.nextInt();

        dfs(0, 0, map);

        System.out.println(maxCount);
    }

    public static void dfs(int count, int column, int[][] map) {
        if (column >= M) return;
        if (count == K) {
            maxCount = Math.max(maxCount, mapCount(map));
            return;
        }

        int[][] ChangeMap = reverse(map, column);

        if (column < M) {
            dfs(count + 1, column, ChangeMap);
        }
        dfs(count, column + 1, map);
    }

    public static int mapCount(int[][] map) {
        int count = 0;
        int total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                total += map[i][j];
            }
            if (total == M) count++;
            total = 0;
        }
        return count;
    }


    public static int[][] reverse(int[][] map, int position) {

        int[][] newMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            // 원본 복사
            if (M >= 0) System.arraycopy(map[i], 0, newMap[i], 0, M);
            newMap[i][position] = (map[i][position] == 1) ? 0 : 1;  // 해당 열 반전
        }
        return newMap;
    }
}
