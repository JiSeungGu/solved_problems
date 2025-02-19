package Silver1;

import java.util.*;

public class 후보_추천하기 {

    public static void main(String[] args) {
//
        Scanner sc = new Scanner(System.in);

        //사진 개수
        int N = sc.nextInt();

        //학생 총 추천 횟수
        int K = sc.nextInt();

        int[] vote_list = new int[K];

        for (int i = 0; i < K; i++) {
            vote_list[i] = sc.nextInt();
        }

        int[] picture = new int[N];
//        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> list = new HashMap<>();
        int count = 0;
        int start = 0;
        for (int i = 0; i < K; i++) {
            start++;
//            if (i >= K) break;

            if ((list.getOrDefault(vote_list[i], 0) == 0)) {
                if (count == N) break;
                if (count < N) {

                    picture[count] = vote_list[i];
//                    System.out.println("picture[z] :" + picture[count] + " :" + list.getOrDefault(picture[count], 0));
                    count++;
                }
            }
            list.put(vote_list[i], list.getOrDefault(vote_list[i], 0) + 1);
        }

//        for (int z = 0; z < N; z++) {
//            System.out.println("picture[z] :" + picture[z] + " :" + list.get(picture[z]));
//        }

//        System.out.println("1:" + Arrays.toString(picture));
        for (int i = start - 1; i < K; i++) {
//            System.out.println("시작");
//            System.out.println("시작하는거요 vote_list[i]:"+vote_list[i]);
            if (list.getOrDefault(vote_list[i], 0) != 0) {
                list.put(vote_list[i], list.get(vote_list[i]) + 1);
//                System.out.println("2:" + Arrays.toString(picture));
//                System.out.println("똑같은게 들어왔음 "+vote_list[i]);
//                break;
                continue;
            }

            int min = list.get(picture[0]);
            int temp = 0;
            for (int j = 1; j < N; j++) {
//                System.out.println("j: "+j);
//                System.out.println("picture[j] :"+picture[j]);
//                System.out.println("list.get(picture[j]) :"+list.get(picture[j]));
                if (min > list.get(picture[j])) {
//                    System.out.println("바꾼다 ");
                    temp = j;
                    min = list.get(picture[j]);
                }
            }
            list.put(picture[temp], 0);
            for (int k = temp; k < N - 1; k++) {
//                System.out.println("picture[temp]이동" + picture[k]);
                picture[k] = picture[k + 1];
            }
            picture[N - 1] = vote_list[i];
            list.put(vote_list[i], list.getOrDefault(vote_list[i], 0) + 1);
//            System.out.println("vote_list[i] 추가요"+vote_list[i]);
//            System.out.println("3:" + Arrays.toString(picture));
        }

        Arrays.sort(picture);
        for (int i = 0; i < N; i++) {
            System.out.print(picture[i] != 0 ? picture[i] + " " : "");
        }
    }
}
