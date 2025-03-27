package SelfRepeat;

import java.util.*;

public class 공장최단이동계산 {

    //맵
    public static int[][] map;
    // 좌표    아래 위 오른쪽 왼쪽
    public static int[] Gox = {0, 0, 1, -1};
    public static int[] Goy = {1, -1, 0, 0};
    //방문 체크
    public static int min = Integer.MAX_VALUE;

    public static int N;
    public static int M;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                visited[i][j] = false;
            }
        }
        visited[0][0]= true;
        dfs(0,0,0 ,visited);
        System.out.println(min);
    }

    public static void dfs(int count, int x, int y, boolean[][] visited) {

        if (x >= map.length || x < 0 || y >= map[0].length || y < 0) return;

        if (x == N-1 && y == M-1) min = Math.min(min, count);

        for (int i = 0; i < 4; i++) {

            int move_x = Gox[i];
            int move_y = Goy[i];
            int currentX = x + move_x;
            int currentY = y + move_y;
            if(currentX >= map.length || currentX < 0 || currentY >= map[0].length || currentY <0) continue;

            if (!visited[currentX][currentY] && map[currentX][currentY] == 1){
                visited[currentX][currentY] = true;
                dfs(count+1, currentX, currentY, visited);
                visited[currentX][currentY] = false;
            }
        }
    }
}
