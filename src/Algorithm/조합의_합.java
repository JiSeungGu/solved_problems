package Algorithm;

import java.util.*;

public class 조합의_합 {
    public static int[] nums;
    public static int target;
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

        dfs(check, list, 0, 0);
    }

    public static void dfs(boolean[] check, List<Integer> list, int total, int current) {

        if (total <= target) {

            if (total == target) System.out.println(Arrays.toString(list.toArray()));

            else {

                if (current < N) {
                    list.add(nums[current]);

                    dfs(check, list, total+nums[current], current);
                    list.remove(list.size() - 1);
                    dfs(check, list, total, current + 1);

                }
            }
        }
    }
}
