package RealTest;

import java.util.*;

public class 목표점수 {
/*
* 화살을 쏴서 과녁에 맞추어 목표점수를 얻는 백준알고리즘 문제가 있다.

문제를 자세히 설명하자면.

N의 과녁 크기를 입력받고
K의 화살 개수가 주어진다.
그리고 목표점수가 주어진다.

과녁 판은 N*N인 배열이다.

또한 각 화살의 화살크기가 주어지는데  화살크기별로 과녁을 맞출떄 옆에 있는 점수 또한 얻을 수 있다.
예를들면
2굵기의 화살을 발사하였을때. 좌우 양옆 위아래를
|x1-x2| +|y1-y2|를 하여 굵기보다 '미만'일 경우 그 점수또한 포함한다.

각 화살은 전부 발사하지않아도 되며.
쐈던 화살은 다시발사할 수 없다.
같은 곳을 여러번 맞출 수 도 있다.

i굵기의 화살을 발사할떄 소모되는 힘은 b[i]와 같다.
Ex)2화살을 발사하면 2힘이 든다.

여기 문제에서는  목표점수를 얻기 위한 최소한의 힘은 얼마인가를 구하는 문제이다.

추가적으로
1. 과녁판의 점수는 양수만 가능하다.
2. 화살의 굵기와 힘은 ..음..int내에서 관리 가능하다.
4. 모든 점수는 중복 획득 가능하다. (화살을 한발 쏠때마다 그냥 화살굵기에 따라 점수를 얻는다고 생각하면 된다.)

3번의 질문의도를 모르겠다 여러개의 화살을 동시에 맞춰 점수를 얻어야하는 경우?

4발의 화살을 가지고 있을때 4발을 똑같은 곳에 맞춰서 점수를 얻을 수 있다. 다만 목표점수보다 크거나 작으면 안된다.


1굵기 화살은 힘이 1이들고.
2굵기 화살은 힘이 2가 든다. 결국 굵기 = 힘. 이라고 생각하면된다.


ex) 4굵기의 화살을 쏜다면?
4*4의 과녁판에 4굵기의 화살을 쏜다는 가정을하면

0,0 0,1 0,2 0,3
1,0 1,1  1,2 ,13
2,0 2,1 2,2 2,3
3,0 3,1 3,2 ,3,3

만약 2.2에 4굵기화살을 쏜다면
0.0 을 제외한 모든 범위의 점수를 얻을 수 있다. 거리 4(미만인) 점수를 얻을 수 있다는 말이다. 이해했는가.


ex)
3 2 8
1 1 1
1 1 1
1 1 3
1 2

가 주어졌을경우에.

8점을 얻기위해서
1 화살을 3에 쏴서 = 3점획득
2굵기 화살을 3에 쏴서 = 3점 + 왼쪽  위 각 1점씩 획득 =5점

도합 8점이다.

여기까지는 쉬우나.

4 4 326
1 1 1 1
1 1 1 1
1 1 1 100
1 1 1 1
1 2 4 6

위 케이스는 매우 어려운케이스다.

329점을 만들기 위해서는 일부로 옆에 맞추는 케이스도 존재한다 예를들면

1 을 100에 맞춰 100점획득
4를 100왼쪽 1점짜리에 맞춰서 4거리만큼 포함한 점수 = 114점을 획득
6을 100에 맞춰 115점을 획득 .

도합 329점을  얻을 수 있다.
이렇게 2번째 화살을 사용하지 않는경우와 . 각 화살의 최대 점수를 맞추기 위해 다른곳에 맞추는 로직이 전부 계산을 해야한다.
*
* 자바를 사용하려고한다.
입력받는형식은 아래와 같다.


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //과녁 크기
        int N = sc.nextInt();

        //화살 갯수
        int K = sc.nextInt();

        //목표점수
        int wantedPoint = sc.nextInt();

        //과녁판
        int[][] Target = new int[N][N];


 이이후에 어떤알고리즘을 사용해야하는가?
 *
* */
    static int minCost = Integer.MAX_VALUE;  // 최소 비용을 저장하는 전역 변수


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //과녁 크기
        int N = sc.nextInt();

        //화살 갯수
        int K = sc.nextInt();

        //목표점수
        int wantedPoint = sc.nextInt();

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

        int[] power = new int[K];
        for (int i = 0; i < K; i++) {
            power[i] = sc.nextInt();
        }

        points.sort((a, b) -> Integer.compare(b[0], a[0])); // 점수 기준 내림차순 정렬


//        dfs(0, 0, 0, power, Target, points, wantedPoint, Integer.MAX_VALUE);
        // 최소 비용 저장용 변수
        // DFS 실행 (모든 화살을 탐색하면서 최소 비용 찾기)
        dfs(0, 0, 0, power, Target, points, wantedPoint);

        // 최종 출력 (만약 minCost가 갱신되지 않았다면 -1 출력)
        if (minCost == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minCost);
        }
    }

    public static void dfs(int index, int currentScore, int currentCost, int[] power, int[][] board, List<int[]> points, int targetScore) {
        if (currentScore == targetScore) {
            minCost = Math.min(minCost, currentCost);
            return;
        }

        if (index >= power.length) return;

        int size = power[index];

        // 1. 현재 화살을 사용하지 않는 경우
        dfs(index + 1, currentScore, currentCost, power, board, points, targetScore);

        // 2. 현재 화살을 사용하여 여러 위치에서 점수를 얻는 경우
        for (int[] p : points) {
            int x = p[1];
            int y = p[2];
            int bestScore = getTotalScore(x, y, size, board, currentScore, targetScore);

            // 목표 점수를 초과하는 경우 제외
            if (currentScore + bestScore <= targetScore) {
                dfs(index + 1, currentScore + bestScore, currentCost + size, power, board, points, targetScore);
            }
        }
    }

    private static int[] findBestArrowPosition(int[][] board, int size, List<int[]> points, int currentScore, int targetScore) {
        int[] bestPosition = {-1, -1};
        int minDifference = Integer.MAX_VALUE; // 현재 점수와 목표 점수 차이를 최소화하는 점수 차이
        int maxValidScore = 0; // 목표 점수를 넘지 않는 선에서 얻을 수 있는 최대 점수

        for (int[] p : points) {
            int x = p[1];
            int y = p[2];

            int score = getTotalScore(x, y, size, board, currentScore, targetScore);

            // 목표 점수를 초과하지 않는 범위에서 최적의 위치 찾기
            int newScore = currentScore + score;
            int difference = Math.abs(targetScore - newScore);

            if (newScore <= targetScore && (difference < minDifference || (difference == minDifference && score > maxValidScore))) {
                minDifference = difference;
                maxValidScore = score;
                bestPosition[0] = x;
                bestPosition[1] = y;
            }
        }

        // 좌표를 찾지 못하면 기본값 반환
        if (bestPosition[0] == -1 || bestPosition[1] == -1) {
            return new int[]{0, 0};
        }
        return bestPosition;
    }


    public static int getTotalScore(int x, int y, int size, int[][] board, int CurrentScore, int TargetScore) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            System.out.println("ERROR: getTotalScore() - 잘못된 좌표! (" + x + ", " + y + ")");
            return 0;
        }

        int N = board.length;  // 과녁판 크기
        boolean[][] value = new boolean[N][N]; // 한 번만 생성 (자동 false 초기화됨)

        //위 아래 왼쪽 오른쪽
        int[] move_x = {-1, 1, 0, 0};
        int[] move_y = {0, 0, -1, 1};

        Queue<int[]> que = new LinkedList<>();
        int sum = board[x][y];

        que.offer(new int[]{x, y});
        value[x][y] = true;
        while (!que.isEmpty()) {

            int[] next = que.poll();

            for (int i = 0; i < 4; i++) {
                int next_move_x = next[0] + move_x[i];
                int next_move_y = next[1] + move_y[i];

                if (next_move_x >= 0 && next_move_x < board.length && next_move_y >= 0 && next_move_y < board[0].length && !value[next_move_x][next_move_y]) {

                    if ((Math.abs(x - next_move_x) + Math.abs(y - next_move_y)) < size) {
                        System.out.println("현재 CurrentScore :" + CurrentScore);
                        System.out.println("CurrentScore + sum :"+ (CurrentScore + sum));
                        System.out.println("에다가 더하려는 점수 :" + board[next_move_x][next_move_y]);

                        if ((CurrentScore + sum) <= TargetScore) {
                            sum += board[next_move_x][next_move_y];
                            System.out.println("DEBUG: (" + x + ", " + y + ") 위치에서 size=" + size + "로 계산된 점수: " + sum);
                            System.out.println("BFS 탐색: 현재 위치 (" + next_move_x + ", " + next_move_y + ") | 점수 추가: " + board[next_move_x][next_move_y] + " | 현재 합계: " + sum);

                            value[next_move_x][next_move_y] = true;
                            que.offer(new int[]{next_move_x, next_move_y});
                        }
                    }
                }
            }
        }
        return sum;
    }
}
