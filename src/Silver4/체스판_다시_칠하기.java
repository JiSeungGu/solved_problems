package Silver4;

import java.util.*;

public class 체스판_다시_칠하기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x_size = sc.nextInt();
        int y_size = sc.nextInt();
        String[][] chess = new String[x_size][y_size];
        for (int i = 0; i < x_size; i++) {
            String line = sc.next();
            for (int j = 0; j < y_size; j++) {
                chess[i][j] = String.valueOf(line.charAt(j));

            }
        }
        String[][] chess_copy = new String[x_size][y_size];

        for (int i = 0; i < chess.length; i++) {
            chess_copy[i] = chess[i].clone();
        }

        int x = 0;
        int y = 0;
        int count = 0;

        int start_x = 0;
        int start_y = 0;
        List<Integer> countList = new ArrayList<>();

        boolean stop = true;
        while (stop) {

            int end_x = start_x + 7;
            int end_y = start_y + 7;
            for (int k = 0; k <= 2; k++) {
                String fist = chess[start_x][start_y];
                for (int i = start_x; i <= end_x; i++) {
                    if (!(i == start_x) && chess[i][start_y].equals(chess[i - 1][start_y])) {
                        fist = chess[i][start_y].equals("W") ? "B" : "W";
                        chess[i][start_y] = fist;
                        count++;
                    }
                    for (int j = start_y; j <= end_y; j++) {

                        if (i == start_x && j == start_y) {
                            continue;
                        }
                        if (!(j == start_y) && chess[i][j].equals(chess[i][j - 1])) {
                            chess[i][j] = chess[i][j - 1].equals("W") ? "B" : "W";
                            count++;
                        }
                    }
                }
                countList.add(count);
                count = 0;
                //맨처음 기입했던 데이터로 배열 초기화
                for (int i = 0; i < chess.length; i++) {
                    chess[i] = chess_copy[i].clone();
                }
                chess[start_x][start_y] = chess[start_x][start_y].equals("W") ? "B" : "W";
                count++;
            }


            for (int i = 0; i < chess.length; i++) {
                chess[i] = chess_copy[i].clone();
            }

            if (end_x + 1 < chess.length) {
                start_x += 1;
            } else if (end_y + 1 < chess[0].length) {
                start_x = 0;
                start_y += 1;
            } else {
                stop = false;
            }

        }
        System.out.println(Collections.min(countList));
    }
}