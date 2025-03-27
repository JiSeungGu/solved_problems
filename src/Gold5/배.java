package Gold5;


import java.util.*;

public class 배 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        Integer[] crain = new Integer[N];

        for (int i = 0; i < N; i++) {
            crain[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        Integer[] box = new Integer[M];

        for (int i = 0; i < M; i++) {
            box[i] = sc.nextInt();
        }

        Arrays.sort(crain, (o1, o2) -> o2.compareTo(o1));
        Arrays.sort(box, (o1, o2) -> o2.compareTo(o1));


        int time = 0;
        int leftbox = 0;
        boolean[] visited = new boolean[M];
        Arrays.fill(visited, false);
        if (box[0] > crain[0]) System.out.println("-1");
        else {
            while (leftbox < M) {
                int boxCount = 0;
                for (int i = 0; i < N; i++) {
                    while (boxCount < M) {
                        if (!visited[boxCount] && crain[i] >= box[boxCount]) {
                            visited[boxCount] = true;
                            boxCount++;
                            leftbox++;
                            break;
                        }
                        boxCount++;
                    }
                }
                time++;
            }
            System.out.println(time);
        }
    }
}


