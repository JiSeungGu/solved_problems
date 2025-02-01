package Silver3;

import java.util.*;

public class 회전하는큐ver2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] targets = new int[M];

        for (int i = 0; i < M; i++) {
            targets[i] = sc.nextInt();
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        int count = 0;

        for (int target : targets) {
            int idx = new ArrayList<>(deque).indexOf(target);
            int leftNumber = idx;
            int rightNumber = deque.size() - idx;
            System.out.println("leftNumber"+leftNumber);
            System.out.println("rightNumber"+rightNumber);
            if (leftNumber <= rightNumber) {
                for (int i = 0; i < leftNumber; i++) {
                    System.out.println(Arrays.toString(deque.toArray()));

                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            }
            else {

                for (int i = 0; i < rightNumber; i++) {
                    System.out.println(Arrays.toString(deque.toArray()));
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }
                deque.pollFirst();
        }
        System.out.println("count : "+count);
    }
}
