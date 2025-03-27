package Algorithm;

import java.util.*;

public class ArraysTest {

    public static void main(String[] args) {

        String[] array = {"biski","apple", "banana", "kiwiA", "cherry"};

        Integer[] numbers = {5, 2, 9, 1, 7};

        Character[] chars = {'z', 'c', 'a', 't'};


        Arrays.sort(array, (o1,o2) -> o1.compareTo(o2));
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, (o1,o2) -> o2.compareTo(o1));
        System.out.println(Arrays.toString(array));

        Arrays.sort(array, (o1,o2) -> {
            if(o1.length() == o2.length()) return o1.compareTo(o2);
            return o2.length() - o1.length();
        });

        System.out.println(Arrays.toString(array));

        Arrays.sort(numbers,(o1,o2) -> o1.compareTo(o2));
        System.out.println(Arrays.toString(numbers));
        Arrays.sort(numbers,(o1,o2) -> o2.compareTo(o1));
        System.out.println(Arrays.toString(numbers));


        List<Integer> list = new ArrayList<>(Arrays.asList(10, 3, 7, 5, 1));

        Collections.sort(list);
        System.out.println(list.toString());
        Collections.sort(list, (o1,o2) -> o2-o1);
        System.out.println(list.toString());

        List<String> list2 = new ArrayList<>(Arrays.asList("banana", "apple", "cherry", "dog", "ant", "elephant"));

        Collections.sort(list2);
        System.out.println(list2.toString());
//        Collections.sort(list2, (o1, o2) -> o2.compareTo(o1));
        Collections.sort(list2, (o1, o2) -> {
            return o1.length() - o2.length();
        });
        System.out.println(list2.toString());

        System.out.println("중복 제거 방법");
        List<Integer> arraylist = Arrays.asList(1, 2, 2, 3, 4, 4);
//        Set<Integer> set = new LinkedHashSet<>(arraylist); // 순서 유지 O
        Set<Integer> set = new HashSet<>(arraylist);
        List<Integer> result = new ArrayList<>(set);
        System.out.println(result.toString());

        int[] arr = {1,2,2,3,4,4,5,5};
        Set<Integer> set2 = new LinkedHashSet<>();
        for(int a : arr) set2.add(a);
        List<Integer> result2 = new ArrayList<>(set2);
        System.out.println(result2);

        System.out.println("문자열 중복 제거 ");
        String distinct = "banana";
        Set<Character> set3 = new LinkedHashSet<>();
        for(char temp: distinct.toCharArray()) set3.add(temp);
        System.out.println(set3.toString());


        Stack<Character> stack = new Stack<>();
        stack.push('C');
        stack.pop();
        stack.peek();
        System.out.println(stack.isEmpty());

        Queue<Integer> q = new LinkedList<>();

        q.offer(1);  // 넣기
        q.offer(2);
        System.out.println(q.poll());  // 1 꺼내기
        System.out.println(q.peek());  // 2 (다음 나올 값 확인)
        System.out.println(q.isEmpty());  // 비었는지 확인



    }
}
