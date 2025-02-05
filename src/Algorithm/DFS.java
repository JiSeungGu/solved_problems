package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DFS {
    static List<Integer>[] graph;
    static Boolean[] visited;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        graph = new ArrayList[N + 1];
        visited = new Boolean[N+1];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 연결 (양방향)
        graph[1].add(2);
        graph[1].add(3);
        graph[2].add(4);
        graph[2].add(5);
        graph[3].add(6);

        System.out.println("DFS (재귀) 탐색 순서:");
        dfs(1); // 1번 노드부터 탐색 시작
    }

    static void dfs(int node) {
        if(visited[node]) return;

        visited[node] = true;
        System.out.println("현재 노드 "+node);

        for(int next: graph[node]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}
