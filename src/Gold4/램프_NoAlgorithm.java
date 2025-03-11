package Gold4;

import java.util.*;

public class 램프_NoAlgorithm {

    public static int N;
    public static int M;
    public static int K;
    public static int maxCount = 0;  // 최대 켜진 행 개수 저장

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        M = sc.nextInt();

        String[] map = new String[N];
        int[][] mapCheck = new int[N][2];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            map[i] = line;
            int count = 0;
            for (int j = 0; j < M; j++) {

                if (line.charAt(j) - '0' == 0) count++;
            }
            mapCheck[i][0] = count % 2 == 0 ? 1 : 0;
            mapCheck[i][1] = count;

        }

        K = sc.nextInt();
        int check = K % 2 == 0 ? 1 : 0;
        if (K > 50) {
            K = 50;
        }

        //K가 짝수인지 홀수 인지 확인.

//        System.out.println("check :" + check);
        //0의 갯수가 짝수인지 홀수 인지  확인 (나는 위에서 했음)

        //0의 개수가 K보다 같거나 작아야함. (위에서 했음)

        //해당 열과 똑같은 라인이 있는지 검사.
        for (int i = 0; i < N; i++) {

            // 0이랑 K가 홀수거나 짝수인경우에
//            System.out.println("mapCheck[i][0]: " + mapCheck[i][0]);
            if (mapCheck[i][0] == check) {
//                System.out.println("일치");
                // 홀수 짝수가 맞아도 K보다 크면 안됨
                if (mapCheck[i][1] <= K) {
//                    System.out.println("mapCheck[i][1]: " + mapCheck[i][1]);
                    int count = 0;
                    //해당 열과 똑같은 라인이 있는지 검사.
                    for (int j = 0; j < N; j++) {
//                        System.out.println("map[i]: " + map[i]);
//                        System.out.println("map[j]: " + map[j]);
                        if (map[i].equals(map[j])) {
                            count++;
                        }
                    }
                    maxCount = Math.max(count, maxCount);
                }
            }
        }
        System.out.println(maxCount);
    }
}
