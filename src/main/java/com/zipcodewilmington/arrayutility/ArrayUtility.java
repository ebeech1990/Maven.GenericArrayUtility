package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] arr;

    public ArrayUtility(T[] arr){
        this.arr = arr;
    }


    public Integer countDuplicatesInMerge(String[] arrayToMerge, T valueToEvaluate) {
        return 0;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {

        List<T> list = Arrays.asList(arr);
        int count = (int) list
                        .stream()
                        .filter(s -> s.equals(valueToEvaluate))
                        .count();
        return  count;
    }

    public T getMostCommonFromMerge(Integer[] arrayToMerge) {
        return null;
    }

    public T[] removeValue(T valueToRemove) {
        T[] list = Arrays.stream(arr)
                .filter(s -> !s.equals(valueToRemove))
                .toArray(this::genArray);
        return list;


    }

    public T[] genArray(int size){
        T[] result = (T[]) Array.newInstance(arr.getClass().getComponentType(),size);
        return result;
        //(Class<?> componentType,  int... dimensions)
        //find class of objects in arr
        //new array cast to T
    }

    public static void main(String[] args) {
        Integer[] inputArray = {1, 2, 7, 8, 4, 5, 7, 0, 9, 8, 7};
        ArrayUtility<Integer> au = new ArrayUtility<>(inputArray);
        au.getNumberOfOccurrences(7);
    }
}
