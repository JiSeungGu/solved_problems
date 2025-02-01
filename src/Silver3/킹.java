package Silver3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 킹 {


    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        //오른쪽
        map.put("R", "1,0");
        //왼쪽
        map.put("L", "-1,0");
        //한칸 아래
        map.put("B", "0,-1");
        //한칸 위로
        map.put("T", "0,1");
        //오른쪽 위 대각선
        map.put("RT", "1,1");
        //왼쪽 위 대각선
        map.put("LT", "-1,1");
        //오른쪽 아래 대각선
        map.put("RB", "1,-1");
        //왼쪽 아래 대각선
        map.put("LB", "-1,-1");

        HashMap<String, Integer> X = new HashMap<>();
        X.put("A", 0);
        X.put("B", 1);
        X.put("C", 2);
        X.put("D", 3);
        X.put("E", 4);
        X.put("F", 5);
        X.put("G", 6);
        X.put("H", 7);

        HashMap<Integer, String> reverseX = new HashMap<>();
        reverseX.put(0, "A");
        reverseX.put(1, "B");
        reverseX.put(2, "C");
        reverseX.put(3, "D");
        reverseX.put(4, "E");
        reverseX.put(5, "F");
        reverseX.put(6, "G");
        reverseX.put(7, "H");

        Scanner sc = new Scanner(System.in);
        String king = sc.next();
        String rock = sc.next();
        String[][] chessMap = new String[8][8];
        for (String[] a : chessMap) {
            Arrays.fill(a, "false");
        }
        int move = sc.nextInt();
        String[] movelist = new String[move];
        for (int i = 0; i < move; i++) {
            movelist[i] = sc.next();
        }
        //킹, 돌 좌표에 배치
        //문자열 제거 후 숫자 변환

        chessMap[X.get(king.substring(0, 1))][Integer.parseInt(king.substring(1, 2)) - 1] = "king";
        chessMap[X.get(rock.substring(0, 1))][Integer.parseInt(rock.substring(1, 2)) - 1] = "rock";

        int KingStartX = X.get(king.substring(0, 1));
        int KingStartY = Integer.parseInt(king.substring(1, 2)) - 1;
        for (String moveTo : movelist) {
            int x = Integer.parseInt(map.get(moveTo).substring(0, map.get(moveTo).indexOf(',')));
            int y = Integer.valueOf(map.get(moveTo).substring(map.get(moveTo).indexOf(',') + 1, map.get(moveTo).length()));

            if ((KingStartX + x) >= 0 && (KingStartX + x) < 8 && (KingStartY + y) >= 0 && (KingStartY + y) < 8) {

                if (chessMap[(KingStartX + x)][(KingStartY + y)].equals("rock")) {

                    if ((KingStartX + x + x) < 0 || (KingStartX + x + x) >= 8 || (KingStartY + y + y) < 0 || (KingStartY + y + y) >= 8) {
                        continue;
                    }

                    chessMap[KingStartX][KingStartY] = "false";
                    chessMap[KingStartX + x][KingStartY + y] = "false";
                    chessMap[(KingStartX + x + x)][(KingStartY + y + y)] = "rock";
                    chessMap[(KingStartX + x)][(KingStartY + y)] = "king";
                    KingStartX = KingStartX + x;
                    KingStartY = KingStartY + y;

                } else {
                    chessMap[KingStartX][KingStartY] = "false";
                    chessMap[KingStartX + x][KingStartY + y] = "king";
                    KingStartX = KingStartX + x;
                    KingStartY = KingStartY + y;
                }
            }
        }

        int k = 0;
        int z = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessMap[i][j].equals("king")) {
//                    System.out.println(chessMap[i][j]);
                    System.out.println(reverseX.get((i)) + "" + (j + 1));
                }
                if (chessMap[i][j].equals("rock")) {
                    k = i;
                    z = j;
                }
            }
        }
        System.out.println(reverseX.get((k)) + "" + (z + 1));
    }
}

