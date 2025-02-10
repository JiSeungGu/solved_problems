package Silver5;

import java.util.*;

public class 단어정렬 {

    public static void main(String[] args) {

        Scanner sx = new Scanner(System.in);
        int count = sx.nextInt();
        HashSet<String> set = new HashSet<>();
//        String[] sortString = new String[count];
        for(int i =0; i < count; i++){
//            sortString[i] = sx.next();
            set.add(sx.next());
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });
//        System.out.println("값 :"+sortString[1].compareTo(sortString[0]));
//        System.out.println("값 :"+sortString[0].compareTo(sortString[1]));
        //1로갔을대 오름차순, -1로갔을때는 내림차순
//        Arrays.sort(sortString, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//
//                if(o1.length() == o2.length()) {
//                    return o1.compareTo(o2);
//                }
////                return o2.compareTo(o1);
//                return o1.length() - o2.length();
//            }
//        });
        System.out.println(Arrays.toString(list.toArray()));
    }
}

