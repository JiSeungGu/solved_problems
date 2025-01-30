package Silver4;

import java.util.Scanner;

public class 체스판_다시_칠하기ver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = sc.next().toCharArray();
        }

        int minCount = Integer.MAX_VALUE;

        // 8×8 체스판을 자를 수 있는 모든 시작점 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minCount = Math.min(minCount, getRepaintCount(board, i, j));
            }
        }

        System.out.println(minCount);
    }

    private static int getRepaintCount(char[][] board, int x, int y) {
        String[] correctBoard1 = { // 'W' 시작 체스판
                "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW",
                "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW"
        };
        String[] correctBoard2 = { // 'B' 시작 체스판
                "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB",
                "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB"
        };

        int repaint1 = 0, repaint2 = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[x + i][y + j] != correctBoard1[i].charAt(j)) repaint1++;
                if (board[x + i][y + j] != correctBoard2[i].charAt(j)) repaint2++;
            }
        }

        return Math.min(repaint1, repaint2);
    }
}
