package Silver1;

import java.util.*;

public class 나무꾼_이다솜 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //나무 개수
        int N = sc.nextInt();

        //나무를 자를때 드는 비용
        int C = sc.nextInt();

        //나무 한단위 가격
        int W = sc.nextInt();

        int[] tree = new int[N];
        int maxTree = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
            maxTree = Math.max(tree[i], maxTree);

        }


        int treeCount = 0;
        int spendMoney = 0;
        long max = 0;

        //나무를 자르지 않고 바로 판매하는 경우
        long sum = 0;
        long maxSum = 0;
        for (int i = 1; i <= maxTree; i++) {

            sum = 0;
//            if (i == 0) {
//                for (int treesize : tree) {
//                    String temp = Arrays.toString(tree);
//                    int count = temp.length() - temp.replace(String.valueOf(treesize), "").length();
//                    count /= String.valueOf(treesize).length();
////                    max[1] = count;
//                    if (count >= 2) {
//                        max = Math.max(((long) treesize * count * W), max);
//                        maxSum = Math.max(maxSum, max);
////                        System.out.println("max1 :" + max);
////                        max[2] = Math.max(((long) treesize *count*W),max[2]);
//                    } else {
//                        max = Math.max(((long) treesize * W), max);
//                        maxSum = Math.max(maxSum, max);
////                        System.out.println("max2 :" + max);
////                        max[2] = Math.max((long) treesize *W, max[2]);
//                    }
//                }
//                continue;
//            }
            for (int j = 0; j < N; j++) {
                if (tree[j] >= i) {
                    if (tree[j] % i == 0) {
                        spendMoney = (tree[j] / i) - 1;
                    } else {
                        spendMoney = (tree[j] / i);
                    }
                    long value = ( (tree[j] / i) * i * W) - (spendMoney * C);
                    if (value > 0) sum += value;
                }
            }
//            System.out.println("treeCount :"+treeCount);
//            System.out.println(" i : "+ i);
//            System.out.println(" w : "+ W);
//            System.out.println("(treeCount*i*W) :"+(treeCount*i*W));
//            System.out.println("spendMoney :"+spendMoney);
            maxSum = Math.max(maxSum, sum);
//                max[0] = i;
//                max[1] = treeCount;

            spendMoney = 0;
        }

//        System.out.println(Arrays.toString(max));
        System.out.println(maxSum);
    }
}
