package Beispiel3;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class JavaStreamsTester {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("bsp", "test", "", "Test2", "", "Test3");
        List<Integer> list2 = Arrays.asList(4, 6, 2, 8, 10);
        System.out.println(getCountEmptyString(list));
        System.out.println(getCountLength3(list));
        System.out.println(deleteEmptyStrings(list));
        System.out.println(getMergedString(list,","));
        System.out.println(getSquares(list2));
        System.out.println(getMax(list2));
        System.out.println(getMin(list2));
        System.out.println(getSum(list2));
        System.out.println(getAverage(list2));
    }


    private static int getCountEmptyString(List<String> strings)
    {
        long counter = strings.stream().filter(x -> x.isEmpty()).count();
        return (int) counter;
    }

    private static int getCountLength3(List<String> strings)
    {
        long counter = strings.stream().filter(x -> x.length() == 3).count();
        return (int) counter;
    }

    private static List<String> deleteEmptyStrings(List<String> strings)
    {
        List<String>  ergebnis = strings.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList());
        return ergebnis;
    }

    private static String getMergedString(List<String> strings, String seperator)
    {
        String ergebnis = strings.stream().collect(Collectors.joining(","));
        return ergebnis;
    }

    private static List<Integer> getSquares(List<Integer> numbers)
    {
        List<Integer> ergebnis = numbers.stream().map(n -> n*n).collect(Collectors.toList());
        return ergebnis;
    }

    private static int getMax(List<Integer> numbers)
    {
        int ergebnis = numbers.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
        return ergebnis;
    }

    private static int getMin(List<Integer> numbers)
    {
        int ergebnis = numbers.stream().mapToInt(v -> v).min().orElseThrow(NoSuchElementException::new);
        return ergebnis;
    }

    private static int getSum(List<Integer> numbers)
    {
        int ergebnis = numbers.stream().reduce(0, (a, b) -> a + b);
        return ergebnis;
    }

    private static int getAverage(List<Integer> numbers)
    {
        double ergebnis = numbers.stream().mapToInt((x) -> x).average().orElse(0);
        return (int) ergebnis;
    }
}
