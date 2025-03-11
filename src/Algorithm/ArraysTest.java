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
        Collections.sort(list2, (o1, o2) -> o2.compareTo(o1));
        System.out.println(list2.toString());


    }
}
