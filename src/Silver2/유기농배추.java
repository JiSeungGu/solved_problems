package Silver2;

import java.util.*;
/*
*
✅ 코드 개선 포인트
1️⃣ Boolean[][] root 대신 map을 직접 수정하면 메모리 절약 가능!

root 배열을 따로 만들지 않고, 방문한 곳을 map[i][j] = 0 으로 처리하면 메모리를 아낄 수 있음.
어차피 방문한 곳은 다시 방문할 필요가 없으니까!
2️⃣ HashMap<String, int[]> 대신 dx, dy 배열 사용하면 코드가 더 깔끔해짐!

dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1} 로 하면 이동 방향을 간단하게 처리 가능!
3️⃣ BFS 큐의 초기 설정을 List<int[]> 없이 진행 가능!

불필요한 Map.Entry<String, int[]> 탐색을 줄이고, 단순한 for 루프로 처리하면 성능 향상 가능.

* */
public class 유기농배추 {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        //테스트 케이스
        int T = sc.nextInt();
        int[] totalCount = new int[T];
        for (int z = 0; z < T; z++) {
            //배추밭 가로길이
            int M = sc.nextInt();

            //배추밭 세로길이
            int N = sc.nextInt();

            //배추 위치의 개수
            int K = sc.nextInt();

            //지도
            int[][] map = new int[M][N];
            for (int[] x : map) {
                Arrays.fill(x, 0);

            }
            //false, true 경로체크
            Boolean[][] root = new Boolean[M][N];
            for (Boolean[] x : root) {
                Arrays.fill(x, false);

            }

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
//            System.out.println("x :"+x+" y:"+y);
                map[x][y] = 1;
            }

            Map<String, int[]> list = new HashMap<>();
            list.put("down", new int[]{0, 1});
            list.put("up", new int[]{0, -1});
            list.put("left", new int[]{-1, 0});
            list.put("right", new int[]{1, 0});


            Queue<int[]> qe = new LinkedList<>();
            int count = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    //dfs 시작
//                    System.out.println(map[i][j]);
                    if (map[i][j] == 1 && !root[i][j]) {
                        root[i][j] = true;
//                    System.out.println("찾았다 1 !"+i+" "+j);
                        qe.offer(new int[]{i, j});
                        count++;
                        while (!qe.isEmpty()) {

                            int[] a = qe.poll();
//                        System.out.println("x :"+a[0]+" y:"+a[1]);
                            for (Map.Entry<String, int[]> entry : list.entrySet()) {

                                int move_x = entry.getValue()[0];
                                int move_y = entry.getValue()[1];
//                            System.out.println("a[0] + move_x  :"+a[0] + move_x );
//                            System.out.println("a[1] + move_y  :"+a[1] + move_y);
                                if ((a[0] + move_x) >= 0 && (a[0] + move_x) < M && (a[1] + move_y) >= 0 && (a[1] + move_y) < N) {

                                    if (map[(a[0] + move_x)][a[1] + move_y] == 1 && !root[(a[0] + move_x)][a[1] + move_y]) {
//                                    System.out.println("1의 좌표 map[(a[0] + move_x)][a[1] + move_y]  :"+(a[0] + move_x)+" "+(a[1] + move_y));
                                        qe.offer(new int[]{a[0] + move_x, a[1] + move_y});
                                        root[(a[0] + move_x)][a[1] + move_y] = true;
                                    }
                                }
                            }
                        }

                    }
                }
            }
//            System.out.println("count : " + count);
            totalCount[z] = count;
        }

    for (int k = 0; k < T; k++) {
        System.out.println(totalCount[k]);
    }
    }
}
