package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        //Stream<Attachment> stream = Arrays.stream(atts);
        //stream.forEach(System.out::println);
        Comparator<Attachment> comparator = (left, right) -> left.getSize() - right.getSize();
        //Arrays.sort(atts, comparator);
        //Stream<Attachment> stream2 = Arrays.stream(atts);
        //stream2.forEach(System.out::println);
        String[] strings = new String[]{"big", "and", "eyes", "circle", "dimension"};
        System.out.println("Before sort: " + Arrays.toString(strings));
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Arrays.sort(strings, cmpText);
        System.out.println("After sort: " + Arrays.toString(strings));
        Comparator<String> cmpDescSize = (left, right) -> left.length() - right.length();
        Arrays.sort(strings, cmpDescSize);
        System.out.println("After sort by length: " + Arrays.toString(strings));
    }
}
