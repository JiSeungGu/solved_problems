package RealTest;

import java.util.*;

public class ArcheryGame {
    static int N, K, wantedPoint;
    static int[][] Target;
    static int[] arrows;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        wantedPoint = sc.nextInt();

        Target = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Target[i][j] = sc.nextInt();
            }
        }

        arrows = new int[K];
        for (int i = 0; i < K; i++) {
            arrows[i] = sc.nextInt();
        }

        int result = solve();
        System.out.println(result);
    }
// 화살을 중복으로 사용하는 경우.
//    static int solve() {
//        // 점수를 만들기 위한 최소 힘을 저장하는 DP 배열
//        int[] dp = new int[wantedPoint + 1];
//        Arrays.fill(dp, INF);
//        dp[0] = 0;
//
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{0, 0}); // {현재 점수, 소모된 힘}
//
//        while (!queue.isEmpty()) {
//            int[] current = queue.poll();
//            int score = current[0];
//            int power = current[1];
//
//            if (score == wantedPoint) return power; // 목표 도달 시 최소 힘 반환
//
//            for (int k = 0; k < K; k++) {  // 화살 선택
//                int arrowSize = arrows[k];
//
//                for (int x = 0; x < N; x++) {
//                    for (int y = 0; y < N; y++) {
//                        int addScore = getScore(x, y, arrowSize);
//                        int newScore = score + addScore;
//                        int newPower = power + arrowSize;
//
//                        if (newScore <= wantedPoint && newPower < dp[newScore]) {
//                            dp[newScore] = newPower;
//                            queue.add(new int[]{newScore, newPower});
//                        }
//                    }
//                }
//            }
//        }
//
//        return -1; // 목표 점수를 만들 수 없으면 -1 반환
//    }

    static int solve() {
        // DP 테이블: 점수별 최소 힘 저장 (사용한 화살 조합 포함)
        Map<String, Integer> dp = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0}); // {현재 점수, 현재 힘}

        Map<Integer, boolean[]> usedMap = new HashMap<>(); // 사용한 화살 기록
        usedMap.put(0, new boolean[K]); // 초기 상태에서 화살 사용 기록 없음

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int score = current[0];
            int power = current[1];

            boolean[] used = usedMap.get(score); // 현재 점수에서 사용된 화살 정보 가져오기

            if (score == wantedPoint) {
                System.out.println(Arrays.toString(used));
                return power; // 목표 점수 도달 시 최소 힘 반환
            }

            for (int k = 0; k < K; k++) {  // 사용하지 않은 화살 선택
                if (used[k]) continue; // 이미 사용한 화살이면 건너뛴다.

                int arrowSize = arrows[k];

                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < N; y++) {
                        int addScore = getScore(x, y, arrowSize);
                        int newScore = score + addScore;
                        int newPower = power + arrowSize;

                        if (newScore <= wantedPoint) {
                            boolean[] newUsed = used.clone(); // 기존 사용 기록을 복사
                            newUsed[k] = true; // 현재 화살을 사용했다고 표시

                            String stateKey = newScore + "-" + Arrays.toString(newUsed);
                            if (!dp.containsKey(stateKey) || newPower < dp.get(stateKey)) {
                                dp.put(stateKey, newPower);
                                usedMap.put(newScore, newUsed); // 새로운 상태 저장
                                queue.add(new int[]{newScore, newPower});
                            }
                        }
                    }
                }
            }
        }

        return -1; // 목표 점수를 만들 수 없으면 -1 반환
    }


// 비트 마스크
//    static int solve() {
//        // DP 테이블: 점수별 최소 힘 저장 (사용한 화살 조합 포함)
//        Map<String, Integer> dp = new HashMap<>();
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{0, 0, 0}); // {현재 점수, 현재 힘, 사용한 화살 상태 (비트마스크)}
//
//        while (!queue.isEmpty()) {
//            int[] current = queue.poll();
//            int score = current[0];
//            int power = current[1];
//            int usedMask = current[2]; // 사용한 화살 정보 (비트마스크)
//
//            if (score == wantedPoint) return power; // 목표 점수 도달 시 최소 힘 반환
//
//            for (int k = 0; k < K; k++) {  // 사용하지 않은 화살 선택
//                if ((usedMask & (1 << k)) != 0) continue; // 이미 사용한 화살이면 건너뛴다.
//
//                int arrowSize = arrows[k];
//                int newMask = usedMask | (1 << k); // 화살 사용 상태 업데이트
//
//                for (int x = 0; x < N; x++) {
//                    for (int y = 0; y < N; y++) {
//                        int addScore = getScore(x, y, arrowSize);
//                        int newScore = score + addScore;
//                        int newPower = power + arrowSize;
//
//                        if (newScore <= wantedPoint) {
//                            String stateKey = newScore + "-" + newMask;
//                            if (!dp.containsKey(stateKey) || newPower < dp.get(stateKey)) {
//                                dp.put(stateKey, newPower);
//                                queue.add(new int[]{newScore, newPower, newMask});
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        return -1; // 목표 점수를 만들 수 없으면 -1 반환
//    }


//    static int solve() {
//        // 점수를 만들기 위한 최소 힘을 저장하는 DP 배열
//        Map<String, Integer> dp = new HashMap<>(); // (현재 점수 + 사용한 화살 조합) -> 최소 힘
//        Queue<State> queue = new LinkedList<>();
//        queue.add(new State(0, 0, new HashSet<>())); // {현재 점수, 현재 힘, 사용한 화살 목록}
//
//        while (!queue.isEmpty()) {
//            State current = queue.poll();
//            int score = current.score;
//            int power = current.power;
//            Set<Integer> usedArrows = current.usedArrows; // 사용한 화살 목록
//
//            if (score == wantedPoint) return power; // 목표 점수 도달 시 최소 힘 반환
//
//            for (int k = 0; k < K; k++) {  // 사용하지 않은 화살 선택
//                if (usedArrows.contains(k)) continue; // 이미 사용한 화살이면 건너뛴다.
//
//                int arrowSize = arrows[k];
//
//                for (int x = 0; x < N; x++) {
//                    for (int y = 0; y < N; y++) {
//                        int addScore = getScore(x, y, arrowSize);
//                        int newScore = score + addScore;
//                        int newPower = power + arrowSize;
//
//                        if (newScore <= wantedPoint) {
//                            Set<Integer> newUsedArrows = new HashSet<>(usedArrows);
//                            newUsedArrows.add(k); // 현재 화살을 사용했다고 표시
//
//                            String stateKey = newScore + "-" + newUsedArrows;
//                            if (!dp.containsKey(stateKey) || newPower < dp.get(stateKey)) {
//                                dp.put(stateKey, newPower);
//                                queue.add(new State(newScore, newPower, newUsedArrows));
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        return -1; // 목표 점수를 만들 수 없으면 -1 반환
//    }

    // 특정 좌표 (x, y)에 size 크기의 화살을 맞췄을 때 얻을 수 있는 점수 계산
    static int getScore(int x, int y, int size) {
        int sum = 0;
        for (int i = x - size + 1; i <= x + size - 1; i++) {
            for (int j = y - size + 1; j <= y + size - 1; j++) {
                if (i >= 0 && i < N && j >= 0 && j < N) {
                    if (Math.abs(x - i) + Math.abs(y - j) < size) {
                        sum += Target[i][j];
                    }
                }
            }
        }
        return sum;
    }
}