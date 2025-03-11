package Gold5;

import java.util.*;

//n(n+1)/2 >= (Y - X) 를 만족하는 최소의 n을 찾아야 함
//수학적 계산 보다는 알고리즘이 우선이기때문에 일단 멈춤.

public class 멍멍이_쓰다듬기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int monkey = sc.nextInt();

        int dog = sc.nextInt();

        Queue<int[]> que = new LinkedList<>();

        que.add(new int[]{1, 0});
        int count = 1;
        if(monkey != dog) {
            while (!que.isEmpty()) {
                int[] keydata = que.poll();
                monkey += keydata[0];
//            System.out.println("monkey: " + monkey);
                if (monkey > dog || monkey < 0) continue;
                if (monkey == dog) {
//                System.out.println("키가 똑같다."+keydata[1]);
                    break;
                }
//                System.out.println("시작");
            count++;
//            System.out.println("count:"+count);

                if (keydata[0] >= 2) {
                    que.add(new int[]{(keydata[0] + 1), count});
                    que.add(new int[]{keydata[0], count});
                    que.add(new int[]{(keydata[0] - 1), count});
                } else {
                    que.add(new int[]{keydata[0], count});
                    que.add(new int[]{(keydata[0] + 1), count});
                }
            }
        }
        System.out.println(count);
    }
}
