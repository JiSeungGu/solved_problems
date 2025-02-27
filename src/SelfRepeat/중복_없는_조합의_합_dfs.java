package SelfRepeat;

import java.util.*;

public class 중복_없는_조합의_합_dfs {
    public static int target;
    public static int[] nums;
    public static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        target = sc.nextInt();

        nums = new int[N];
        boolean[] check = new boolean[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        List<Integer> list = new ArrayList<>();

        dfs(0, 0, list, check);
    }

    public static void dfs(int sum, int current, List<Integer> list, boolean[] check) {

        if (sum > target) return;
        if (sum == target) System.out.println(Arrays.toString(list.toArray()));


        if (current < N) {

//            if (!check[current]) {

                list.add(nums[current]);
//                check[current] = true;
                dfs(sum + nums[current], current+1, list, check);

                list.remove(list.size() - 1);
                check[current] = false;
//            }
            dfs(sum, current + 1, list, check);
        }
    }
}
