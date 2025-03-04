package Gold5;

import java.util.*;

public class 되돌리기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();


        //type
        String[] type = new String[N];

        //arr
        String[] arr = new String[N];

        //time
        Integer[] time = new Integer[N];

        //print yes or no
        boolean[] check = new boolean[N];

        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();  // 한 줄 전체 읽기
            String[] parts = line.split(" "); // 공백 기준으로 나누기

            type[i] = parts[0]; // 첫 번째 단어가 type

            arr[i] = parts[1]; // 두 번째 값
            time[i] = Integer.parseInt(parts[2]); // 세 번째 값 (숫자)
        }

        List<String> tpyelist = Arrays.asList(type);
        Collections.reverse(tpyelist);
        type = tpyelist.toArray(new String[0]);

        List<String> arrlist = Arrays.asList(arr);
        Collections.reverse(arrlist);
        arr = arrlist.toArray(new String[0]);


        List<Integer> timelist = Arrays.asList(time);
        Collections.reverse(timelist);
        time = timelist.toArray(new Integer[0]);

        for (int i = 0; i < N; i++) {
            String typeValue = type[i];

            if (typeValue.equals("undo")) {
//                if (!check[time[i]-1]) {
                    if (time[i] - 1 >= 0 && time[i] - 1 < N && !check[time[i] - 1]) {

//                    System.out.println("time[i] - Integer.parseInt(arr[i]) :"+(time[i] - Integer.parseInt(arr[i])));

                    int removeTime = time[i] - Integer.parseInt(arr[i]);
//                    System.out.println(time[i]+ "번째부터 "+(removeTime)+"까지");
                    for (int j = time[i]-1; j >= removeTime-1; j--) {
//                        System.out.println(removeTime+"까지");
                        if(j < 0) break;
                        else {
                            check[j] = !check[j];
                        }
                    }
//                    System.out.println(Arrays.toString(check));
                }
            }
        }
        for (int i = 0; i < N / 2; i++) {
            boolean temp = check[i];
            check[i] = check[N - 1 - i];
            check[N - 1 - i] = temp;
        }

        for (int i=N-1; i>=0; i--) {
            if(!check[i] && !type[i].equals("undo")) System.out.print(arr[i]);
        }
    }
}