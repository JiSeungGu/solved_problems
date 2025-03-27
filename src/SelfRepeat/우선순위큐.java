package SelfRepeat;

import java.util.*;

public class 우선순위큐 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int prod = sc.nextInt();
        Map<String,PriorityQueue<Integer>> map = new HashMap<>();
        sc.nextLine();
        for(int i=0;i<prod;i++) {
            String input = sc.nextLine();
            String[] temp = input.split(" ");
            if(temp[0].equals("IN")) {
                if(map.containsKey(temp[1])){
                    PriorityQueue<Integer> queue = map.get(temp[1]);
                    queue.offer(Integer.parseInt(temp[2]));
                    map.put(temp[1],queue);
                } else {
                    PriorityQueue<Integer> queue = new PriorityQueue<>();
                    queue.offer(Integer.parseInt(temp[2]));
                    map.put(temp[1],queue);
                }
            }
            else {
                if(!map.get(temp[1]).isEmpty()) System.out.println(map.get(temp[1]).poll());
                else System.out.println("EMPTY");
            }
        }
    }
}
