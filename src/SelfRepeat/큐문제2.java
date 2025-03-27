package SelfRepeat;

import java.util.*;

public class 큐문제2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int machine = sc.nextInt();

        int[] packagetime = new int[machine];
        List<Integer> time = new ArrayList<>();

        for (int i = 0; i < machine; i++) {
            packagetime[i] = sc.nextInt();
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.offer(0);
        queue.offer(0);

        Arrays.sort(packagetime);

        int total = 0;
        for (int i = 0; i < machine; i++) {
            int workTime = queue.poll();
            int realTime = packagetime[i];
            int result = realTime + workTime;
            total += result;
            System.out.println("workTime : "+ workTime);
            System.out.println("realTime : "+ realTime);
            System.out.println("result :"+ result);

            queue.offer(result);
//            time.add(total);
        }
//
//        int result =0;
//        for(int i=0; i<time.size(); i++) {
//            result += time.get(i);
//        }

        System.out.println(total);
    }
}
