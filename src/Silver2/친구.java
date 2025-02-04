package Silver2;

import java.util.*;
import java.util.stream.Stream;

/*
* TIP.
*   내 친구의 친구만 친구 이고
*   내 친구의 친구의 친구의 친구의.. 이런식으로 될 순 없다.
*   그러므로 BFS 조건에서 내 친구들만 add해줘야한다. 그래야지 친구들의 친구들만 알 수 있기때문에
* */
public class 친구 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        char[][] friends = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            friends[i] = line.toCharArray();
        }

        char[][] temp_friends = new char[friends.length][friends[0].length];
        for (int i = 0; i < friends.length; i++) {
            temp_friends[i] = Arrays.copyOf(friends[i], friends[i].length);
        }
        Queue<int[]> que = new LinkedList<>();
        List<Integer> countList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {

            que.offer(new int[]{i, i});
//            System.out.println(i + "번째 시작");
            while (!que.isEmpty()) {
//                System.out.println("돈다");
                int[] myself = que.poll();
//                System.out.println(Arrays.toString(myself));
//                System.out.println("myself[0] :" + myself[0]);
                for (int k = 0; k < N; k++) {
                    if (temp_friends[myself[0]][k] == 'Y' && !(k == i)) {
//                        System.out.println("찾았다 x :" + myself[0] + " y:" + k);
                        set.add(k);
                        temp_friends[myself[0]][k] = 'N';
                        if(myself[0]==i) {
                            que.offer(new int[]{k, myself[0]});
                        }
                    }
                }
            }
//            System.out.println("set count:" + set.size());
            countList.add(set.size());
            set.clear();
            for (int z = 0; z < friends.length; z++) {
                temp_friends[z] = Arrays.copyOf(friends[z], friends[z].length);
            }
//            System.out.println(i + " 번째 끝.");
//            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        }
        System.out.println(Collections.max(countList));
    }
}
