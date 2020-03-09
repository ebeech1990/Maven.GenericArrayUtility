package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] arr;

    public ArrayUtility(T[] arr){
        this.arr = arr;
    }



    public T[] merger(T[] b){
        return Stream.concat(Arrays.stream(this.arr), Arrays.stream(b))
                .toArray(this::genArray);

    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        this.arr = merger(arrayToMerge);
        int count = getNumberOfOccurrences(valueToEvaluate);
        return count;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {

        return  (int) Arrays.stream(this.arr)
                        .filter(s -> s.equals(valueToEvaluate))
                        .count();

    }

    public T findMostCommon(){
        List<T> list = Arrays.asList(this.arr);
        T maxOccurredElement = list.stream()
                .reduce(BinaryOperator.maxBy(Comparator.comparingInt(o -> Collections.frequency(list, o)))).orElse(null);

        return maxOccurredElement;

    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        this.arr = merger(arrayToMerge);

        return findMostCommon();
    }

    public T[] removeValue(T valueToRemove) {
        return Arrays.stream(arr)
                .filter(s -> !s.equals(valueToRemove))
                .toArray(this::genArray);

    }

    public T[] genArray(int size){
        return (T[]) Array.newInstance(this.arr.getClass().getComponentType(),size);
        //(Class<?> componentType,  int... dimensions)
        //find class of objects in arr
        //new array cast to T
    }

    public static void main(String[] args) {
        String[] inputArray = {"1", "2", "a", "8", "4", "5", "a", "0", "9", "8", "a"};
        String[] arrayToMerge = {"1", "2", "a", "8", "4", "5", "a", "0", "9", "8", "a", "a"};
        ArrayUtility<String> au = new ArrayUtility<>(inputArray);
        au.findMostCommon();



    }
}
