package Silver1;

import java.util.*;

public class 컴백홈ver2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        int K = sc.nextInt();

        char[][] map = new char[R][C];
        boolean[][] check = new boolean[R][C];
        sc.nextLine();
        for (int i = 0; i < R; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.trim().charAt(j);
            }
        }

        int[] move_x = {1, -1, 0, 0};
        int[] move_y = {0, 0, 1, -1};

        Stack<int[]> st = new Stack<>();

        st.push(new int[]{(R - 1), 0,1});
        check[R - 1][0] = true;
        int count = 0;

        while (!st.isEmpty()) {

            int[] current = st.pop();
            if (current[0] == 0 && current[1] == C - 1 && current[2] == K) {
                count++;
            }


            for (int i = 0; i < 4; i++) {
                int next_x = current[0] + move_x[i];
                int next_y = current[1] + move_y[i];
                int point = current[2];
                if (next_x >= 0 && next_x < R && next_y >= 0 && next_y < C) {
//                    if (!(check[next_x][next_y]) && map[next_x][next_y] != 'T') {
                    if (map[next_x][next_y] != 'T') {
                        if (point+1 <= K) {
                            st.push(new int[]{next_x, next_y, point + 1});
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
