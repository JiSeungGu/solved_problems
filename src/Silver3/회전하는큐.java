package Silver3;

import java.util.*;

public class 회전하는큐 {

    public static void main(String[] args) {
        // 궁금한것 1. 배열에서 인덱스로 값을 가져오는것 처럼 queue에서 인덱스로 가져오는건?. 그렇다면 맨뒤에있는걸 가져오는건?
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int purpose = sc.nextInt();
        int[] target = new int[purpose];
        Queue<Integer> qe = new LinkedList<>();
        List<Integer> alist = new ArrayList<>(purpose);

        for (int i = 0; i < size; i++) alist.add(i + 1);
        for (int i = 0; i < purpose; i++) target[i] = sc.nextInt();

//        System.out.println(Arrays.toString(alist.toArray()));

        //찾기.
        int min =0;
        for (int i = 0; i < purpose; i++) {
            int front = findMin(alist,alist.size(),target[i],"front");
            int back = findMin(alist,alist.size(),target[i],"back");
//            System.out.println("front :"+front+", back :"+back);
            min += Math.min(front,back);
            if(front < back ) {
                if(front==0) {
                    alist.remove(0);
//                    System.out.println(Arrays.toString(alist.toArray()));
                }else {
                    for (int j = 1; j <= front; j++) {
                        alist.add(alist.get(0));
                        alist.remove(0);
//                        System.out.println(Arrays.toString(alist.toArray()));
                    }
                    alist.remove(0);
                }
            } else {
                for(int j = 1; j<back+1 ;j++) {
                    alist.add(0,alist.get(alist.size()-1));
//                    alist.remove(alist.get(alist.size()-1));
                    alist.remove(alist.size()-1);
//                    System.out.println(Arrays.toString(alist.toArray()));
                }
                alist.remove(0);
            }
//            System.out.println(Arrays.toString(alist.toArray()));
//            System.out.println(Arrays.toString(alist.toArray()));
        }
        System.out.println(min);
    }
    public static int findMin(List<Integer> list, int size, int target, String type) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (type.equals("front")) {
                if (list.get(i) == target) {
//                    count++;
                    break;
                }
                count++;
            } else {
                if (list.get((size-1) - i) == target) {
                    count++;
                    break;
                }
                count++;
            }
        }
        return count;
    }
}