package SelfRepeat;


import java.util.*;

public class 큐 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue<String> que = new LinkedList<>();

        List<String> temp = new ArrayList<>();

        int count = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<count;i++) {
            temp.add(sc.nextLine());
        }

        System.out.println(temp.toString());

        for(String value: temp) {
            String[] array = value.split(" ");
            if(array[0].equals("ORDER"))
                que.offer(array[1]);
            else if(array[0].equals("CANCEL"))
                que.removeIf(quevalue -> quevalue.equals(array[1]));
            else
                System.out.println(que.isEmpty() ? "EMPTY" : que.poll());
        }
    }
}
