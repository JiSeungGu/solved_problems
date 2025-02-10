package RealTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 목표점수 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //과녁 크기
        int N = sc.nextInt();

        //화살 갯수
        int K = sc.nextInt();

        //목표점수
        int Point = sc.nextInt();

        //과녁판
        int[][] Target = new int[N][N];

        //최대점수 좌표 구하기
        int max = 0;
        int max_X = 0;
        int max_Y = 0;

        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Target[i][j] = sc.nextInt();
                points.add(new int[]{Target[i][j], i, j});
            }
        }

        points.sort((a, b) -> Integer.compare(b[0], a[0])); // 점수 기준 내림차순 정렬
        for (int[] p : points) {
            System.out.println("점수: " + p[0] + " 위치: (" + p[1] + ", " + p[2] + ")");
        }
    }
}
