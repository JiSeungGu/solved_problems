package SelfRepeat;

import java.util.*;


public class 큐문제 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int prod = sc.nextInt();
        int machine = sc.nextInt();

        List<Queue<Integer>> list = new ArrayList<>();
        sc.nextLine();
        int count = 0;
        for(int i=0;i<prod;i++) {
            String array = sc.nextLine();
            String[] value = array.split(" ");
            Queue<Integer> que = new LinkedList<>();
            count += Integer.parseInt(value[0]);
            for( int j=1;j< value.length; j++) {
                que.offer(Integer.parseInt(value[j]));
            }
            list.add(que);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<machine; i++) {
            queue.offer(0);
        }

        List<Integer> time = new ArrayList<>();
        for(int i=0; i<prod;i++) {
            time.add(0);
        }

        while(count > 0) {
            for(int i=0; i< list.size();i++) {
                if(!list.get(i).isEmpty()) {
                    int workTime = list.get(i).poll();
                    int nowTime = time.get(i);
                    int waitTime =  queue.poll();

                    int maxValue = Math.max(nowTime, waitTime);
                    int totalTime = workTime + maxValue;

                    time.set(i,totalTime);
                    queue.offer(totalTime);
                    count--;
                }
            }
        }
        System.out.println(Collections.max(time));
    }
}
