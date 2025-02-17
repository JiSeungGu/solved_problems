package Silver1;

import java.util.*;

public class 효율적인해킹AI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        Map<Integer, List<Integer>> result = new HashMap<>();

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            result.putIfAbsent(B, new ArrayList<>());
            result.get(B).add(A);
        }

        Map<Integer, Integer> calculation = new HashMap<>();

        // 각 노드에서 해킹 가능한 수를 저장
        for (int node = 1; node <= N; node++) {
            calculation.put(node, dfs(node, result, new boolean[N + 1])); // visited 배열 활용
        }

        // 정렬: value 내림차순 -> key 오름차순
        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(calculation.entrySet());
        sortedList.sort((o1, o2) -> {
            int valueCompare = Integer.compare(o2.getValue(), o1.getValue()); // value 기준 내림차순
            return (valueCompare != 0) ? valueCompare : Integer.compare(o1.getKey(), o2.getKey()); // value 같으면 key 기준 오름차순
        });

        // 최대 해킹 가능한 컴퓨터 찾기
        int max = sortedList.get(0).getValue();
        for (Map.Entry<Integer, Integer> entry : sortedList) {
            if (entry.getValue() == max) {
                System.out.print(entry.getKey() + " ");
            }
        }
    }

    // DFS 탐색 (Stack 기반)
    private static int dfs(int start, Map<Integer, List<Integer>> graph, boolean[] visited) {
        Stack<Integer> st = new Stack<>();
        st.push(start);
        visited[start] = true;

        int count = 0; // 해킹 가능한 컴퓨터 개수

        while (!st.isEmpty()) {
            int node = st.pop();
            count++;

            List<Integer> neighbors = graph.get(node);
            if (neighbors != null) {
                for (Integer next : neighbors) {
                    if (!visited[next]) {
                        visited[next] = true;
                        st.push(next);
                    }
                }
            }
        }
        return count;
    }
}