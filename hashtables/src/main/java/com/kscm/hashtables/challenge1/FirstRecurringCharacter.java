package com.kscm.hashtables.challenge1;

import java.util.Arrays;
import java.util.HashSet;

//Google Question
//Given an array = [2,5,1,2,3,5,1,2,4]: It should return 2
//Given an array = [2,1,1,2,3,5,1,2,4]: It should return 1
//Given an array = [2,3,4,5]: It should return null
//Given an array = [2,5,5,2,3,5,1,2,4]: return 5 because the pairs are before 2,2
public class FirstRecurringCharacter {

    public static Object getFirstRecurringObject(Object[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if(inputArray[i].equals(inputArray[j])) {
                    return inputArray[i];
                }
            }
        }
        return null;
    }

    public static Object getFirstRecurringObjectBetter(Object[] inputArray) {
        HashSet<Object> map = new HashSet<>();
        for (Object obj : inputArray) {
            if(map.contains(obj)) {
                return obj;
            } else {
                map.add(obj);
            }
        }
        return null;
    }

    public static Object getFirstRecurringObjectBetter2(Object[] inputArray) {
        HashSet<Object> map = new HashSet<>(Arrays.asList(inputArray)); //Filling the hash table before checking if the item exist
        for (Object obj : inputArray) {
            if (map.contains(obj)) {
                return obj;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //Object[] arr = {1,5,8,5,1,8,8,7,4,4,10};
        Object[] arr1 = {2,1,1,2,3,5,1,2,4};
        Object[] arr2 = {2,5,1,2,3,5,1,2,4};
        Object[] arr3 = {2,3,4,5};
        Object[] arr4 = {2,5,5,2,3,5,1,2,4};
        System.out.println(getFirstRecurringObjectBetter(arr1)); // Returns 1 because the pairs are before 2,2

        System.out.println(getFirstRecurringObjectBetter(arr2));

        System.out.println(getFirstRecurringObjectBetter(arr3));

        System.out.println(getFirstRecurringObjectBetter(arr4)); //return 5 because the pairs are before 2,2

        //System.out.println(getFirstRecurringObjectBetter2(arr));
        //System.out.println(getFirstRecurringObject(arr));
    }
}

