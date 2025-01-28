package Silver5;

import java.util.*;

public class 막대기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X_size = sc.nextInt();

        int initSize = 64;
        int harf = 0;
        List<Integer> stick = new ArrayList<>(List.of(64));
        //1.만약 모든합이 x보다 크거나 같으면!
        System.out.println(stick.stream().mapToInt(Integer::intValue).sum());
        while (X_size < stick.stream().mapToInt(Integer::intValue).sum()) {
            //2. 가장 짧은것을 반으로 자른다.
            harf = Collections.min(stick)/2;
            stick.remove(Collections.min(stick));
            System.out.println(harf);
            stick.add(harf);
            if(stick.stream().mapToInt(Integer::intValue).sum() < X_size) {
                stick.add(harf);
            }
            System.out.println(Arrays.toString(stick.toArray()));
        }

        System.out.println("정답 :"+stick.size());

    }
}
