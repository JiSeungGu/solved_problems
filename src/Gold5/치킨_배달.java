package Gold5;


import java.util.*;

public class 치킨_배달 {

    public static List<List<int[]>> distance;
    public static List<int[]> house;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int M = sc.nextInt();

        int[][] map = new int[N][N];

        List<int[]> chicken = new ArrayList<>();
        house = new ArrayList<>();
        distance = new ArrayList<>();

        // 치킨, 집 좌표 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = sc.nextInt();
                map[i][j] = value;

                if (value == 1) {
                    house.add(new int[]{i, j});
                } else if (value == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        // 집마다 치킨 거리 구하기
        for (int[] house_position : house) {

            List<int[]> temp = new ArrayList<>();
            for (int[] chicken_position : chicken) {

                int xy_distance = Math.abs(house_position[0] - chicken_position[0]) + Math.abs(house_position[1] - chicken_position[1]);

                temp.add(new int[]{xy_distance, chicken_position[0], chicken_position[1]});
            }
            distance.add(temp);
        }

        List<int[]> current = new ArrayList<>();

        dfs(M, 0, chicken, current);

        System.out.println(min);
    }

    public static void dfs(int M, int count, List<int[]> chicken, List<int[]> current) {

        if (current.size() == M) {
            int temp = calculation(current);
            if (temp < min) min = temp;
            return;
        }

        if (count < chicken.size()) {
            // chicken 좌표를 구해야한다.
            current.add(chicken.get(count));
            dfs(M, count + 1, chicken, current);
            current.remove(current.size() - 1);
            dfs(M, count + 1, chicken, current);
        }
    }

    public static int calculation(List<int[]> current) {
        int citiyChickenDistance = 0;

        for (int i = 0; i < house.size(); i++) { //모든 집에 대해서

            int minDist = Integer.MAX_VALUE;
            for (int[] chiken : current) {

                for (int[] distance : distance.get(i)) {
                    if (chiken[0] == distance[1] && chiken[1] == distance[2]) {
                        minDist = Math.min(minDist, distance[0]);
                    }
                }
            }
            citiyChickenDistance += minDist;
        }
        return citiyChickenDistance;
    }
}
