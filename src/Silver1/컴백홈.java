package Silver1;

import java.util.*;

public class 컴백홈 {

    public static char[][] map;
    public static boolean[][] check;
    public static int count = 0;
    public static int R;
    public static int C;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        int K = sc.nextInt();

        map = new char[R][C];
        check = new boolean[R][C];
        sc.nextLine();
        for (int i = 0; i < R; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.trim().charAt(j);
            }
        }

        Stack<int[]> st = new Stack<>();

        st.push(new int[]{(R - 1), 0});
        check[R - 1][0] = true;

        Map<String, Integer> result = new HashMap<>();
        result.put(Arrays.toString(new int[]{R - 1, 0}), 1);

        dfs((R-1),0,1  ,K);

        System.out.println(count);
    }

    public static void dfs(int x, int y, int CurrentCost, int K) {
        int[] move_x = {1, -1, 0, 0};
        int[] move_y = {0, 0, 1, -1};

        if (CurrentCost == K && x==0 && y==(C-1)) {
            count++;
        }

        for (int i = 0; i < 4; i++) {
            int next_x = x + move_x[i];
            int next_y = y + move_y[i];

            if (next_x >= 0 && next_x < R && next_y >= 0 && next_y < C) {
                if (!(check[next_x][next_y]) && map[next_x][next_y] != 'T') {
                    if (CurrentCost + 1 <= K) {
//                        System.out.println("이동위치 :"+next_x+","+next_y);
                        check[next_x][next_y] = true;  // 방문 체크
                        dfs(next_x, next_y, CurrentCost + 1, K);
                        check[next_x][next_y] = false;  // 방문 체크
                    }
                }
            }
        }
    }
}

//
//import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        int R = sc.nextInt();
//        int C = sc.nextInt();
//        int K = sc.nextInt();
//
//        char[][] map = new char[R][C];
//        boolean[][] check = new boolean[R][C];
//        sc.nextLine();
//        for (int i = 0; i < R; i++) {
//            String temp = sc.nextLine();
//            for (int j = 0; j < C; j++) {
//                map[i][j] = temp.trim().charAt(j);
//            }
//        }
//
//        int[] move_x = {1, -1, 0, 0};
//        int[] move_y = {0, 0, 1, -1};
//
//        Stack<int[]> st = new Stack<>();
//
//        st.push(new int[]{(R - 1), 0});
//        check[R - 1][0] = true;
//        int count = 0;
//
//        int[][] dp = new int[R][C];
//        for (int[] temp : dp) {
//            Arrays.fill(temp, Integer.MAX_VALUE);
//        }
//
//        dp[R - 1][0] = 1;
//        while (!st.isEmpty()) {
//
//            int[] current = st.pop();
//            if (current[0] == 0 && current[1] == C - 1 && dp[current[0]][current[1]] == K) {
//
//                count++;
//            }
//
//
//            for (int i = 0; i < 4; i++) {
//                int next_x = current[0] + move_x[i];
//                int next_y = current[1] + move_y[i];
//
//                if (next_x >= 0 && next_x < R && next_y >= 0 && next_y < C) {
//                    if (!(check[next_x][next_y]) && map[next_x][next_y] != 'T') {
//                        if ((dp[current[0]][current[1]] + 1) <= K) {
//                            if (dp[next_x][next_y] >= (dp[current[0]][current[1]]) + 1) {
//                                dp[next_x][next_y] = Math.min(dp[next_x][next_y], (dp[current[0]][current[1]]) + 1);
//                                st.push(new int[]{next_x, next_y});
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(count);
//    }
//}