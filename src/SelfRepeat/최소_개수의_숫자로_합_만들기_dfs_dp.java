package SelfRepeat;

import java.util.*;

public class 최소_개수의_숫자로_합_만들기_dfs_dp {

    public static int N;
    public static int target;
    public static int[] nums;
    public static int Max = Integer.MAX_VALUE;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        target = sc.nextInt();

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

//        HashMap<Integer,int[]> result = new HashMap<>();

        List<Integer> listCount = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        list.add(0,new int[]{0,0});
        dfs(0,0,list, listCount);

        System.out.println(Arrays.toString(list.get(0)));
    }
    public static void dfs(int sum, int current,List<int[]> list, List<Integer> listCount) {

        if(sum > target) return;

        if(sum == target) {
            if(listCount.size() < Max) {
                Max = listCount.size()-1;
                int[] arr = listCount.stream().mapToInt(i -> i).toArray();
                list.set(0,arr);
            }
        }

        if(current < N) {

            listCount.add(nums[current]);
            dfs(sum+nums[current], current, list, listCount);
            listCount.remove(listCount.size()-1);
            dfs(sum, current+1, list, listCount);
        }
    }
}
