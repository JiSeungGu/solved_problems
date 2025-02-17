package Silver1;

import java.util.*;

public class 효율적인해킹 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int M = sc.nextInt();


        Map<Integer, List<Integer>> result = new HashMap<>();

        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();


            List<Integer> list = result.get(B);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(A);
            result.put(B, list);
        }


        Stack<Integer> st = new Stack<>();

        Map<Integer, Integer> calculation = new HashMap<>();

        for (Map.Entry<Integer, List<Integer>> a : result.entrySet()) {

            st.push(a.getKey());
            while (!st.isEmpty()) {
                calculation.put(a.getKey(), (calculation.getOrDefault(a.getKey(), 0) + 1));

                int number = st.pop();
                List<Integer> resultList = result.get(number);

                if(resultList != null) {
                    for (Integer numberlist : resultList) {

                        st.push(numberlist);
                    }
                }
            }
        }

        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(calculation.entrySet());

        sortedList.sort((o1, o2) -> {
            int valueCompare = Integer.compare(o2.getValue(), o1.getValue()); // value 기준 내림차순
            return (valueCompare != 0) ? valueCompare : Integer.compare(o1.getKey(), o2.getKey()); // value 같으면 key 기준 오름차순
        });

    // 결과 출력 (예제)

        int max = sortedList.get(0).getValue();
        for (Map.Entry<Integer, Integer> entry : sortedList) {
            if (entry.getValue() == max) {
                System.out.print(entry.getKey()+" ");
            }
//            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

    }
}
