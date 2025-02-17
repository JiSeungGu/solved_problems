package Silver1;

import java.util.*;

public class 효율적인해킹ver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

//        boolean[] visited = new boolean[N+1];
        List<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            graph[B].add(A);

        }

        int[] tempValue = new int[N+1];
        for(int i =1 ;i<= N ; i++) {
               tempValue[i] = dfs(i,graph);
        }

        int max = Arrays.stream(tempValue).max().getAsInt();

        for(int i=1; i<= N ; i++) {
            if(tempValue[i] == max) {
                System.out.print(i+" ");
            }
        }
    }

    // DFS 탐색 (Stack 기반)
    private static int dfs(int start, List<Integer>[] graph ) {
//        Stack<Integer> st = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[graph.length];
        visited[start] = true;

        int count = 0; // 해킹 가능한 컴퓨터 개수

        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            List<Integer> neighbors = graph[node];
            if (neighbors != null) {
                for (Integer next : neighbors) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
        }
        return count;
    }
}