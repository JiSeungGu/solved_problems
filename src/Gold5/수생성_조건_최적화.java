package Gold5;

import java.util.*;

public class 수생성_조건_최적화 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int nums = sc.nextInt();

        int target = sc.nextInt();

        int[] num_list = new int[nums];

        for (int i = 0; i < nums; i++) {
            num_list[i] = sc.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();

        dfs(num_list, target, 0, 0, list);
    }

    public static void dfs(int[] num_list, int target, int sum, int count, ArrayList<Integer> list) {
        System.out.println("호출");

        if (sum >= target) {
            System.out.println("출력");
            if (sum == target) System.out.println(list.size() + " " + list.toString());

        } else {
            if (count >= num_list.length) return;
            else {
                System.out.println(sum);

                list.add(num_list[count]);
                //현재자리수를 다시 더하기
                dfs(num_list, target, sum + num_list[count], count, list);
                list.remove(list.size() - 1);
                //현재자리수를 더하지 않고 다음으로 넘어가기.
                //✅ 3. 올바른 방식: "변수 변경 없이 호출 시 인자만 변경"
                dfs(num_list, target, sum, count + 1, list);
            }
        }
    }
}
