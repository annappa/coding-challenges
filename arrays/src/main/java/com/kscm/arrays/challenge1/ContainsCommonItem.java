package com.kscm.arrays.challenge1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class ContainsCommonItem {
    private static Object[] array1 = {'a', "asd", '7', 'r', "null"};
    private static Object[] array2 = {'z', new String("asd"), null, 'x'};

    public static void main(String[] args) {
        System.out.println(containsCommonItems(array1, array2));

        System.out.println(containsCommonItemsBetter(array1, array2));

        System.out.println(containsCommonItemsBetterAndCleaner(array1, array2));
    }

    /**
     * A "naive" approach for solving the question, with
     * time complexity of O(a * b) - exponential
     * space complexity of O(1) - constant.
     * Please note that we have to use {@link Objects#equals(Object, Object)} method so strings would work properly and we are using the
     * equals method in {@link Objects} class so we could accept null inputs without null exception
     * @param array1 - the first input array
     * @param array2 - the second input array
     * @return A boolean indicating whether those two arrays have any common items
     */
    public static boolean containsCommonItems(Object[] array1, Object[] array2) {
        for (Object obj1 : array1) {
            for (Object obj2 : array2) {
                if (Objects.equals(obj1, obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * A better solution which includes the use of {@link HashSet}, here we are using {@link HashSet}
     * and NOT {@link HashMap} (key, value data structure) as it was demonstrated in the course as
     * there is no reason to store true for each key and we can check for common objects using the {@link HashSet#contains(Object)} method.
     * time complexity of O(b) - linear
     * space complexity of O(a) - linear
     * @param array1 - the first input array
     * @param array2 - the second input array
     * @return A boolean indicating whether those two arrays have any common items
     */
    public static boolean containsCommonItemsBetter(Object[] array1, Object[] array2) {
        HashSet<Object> mapOfFirstArray = new HashSet<Object>();
        for (Object obj1: array1) {
            mapOfFirstArray.add(obj1);
        }

        for (Object obj2 : array2) {
            if(mapOfFirstArray.contains(obj2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * A better and cleaner solution which includes the use of {@link HashSet}, here we are using {@link HashSet}
     * and NOT {@link HashMap} (key, value data structure) as it was demonstrated in the course as
     * there is no reason to store true for each key and we can check for common objects using the {@link HashSet#contains(Object)} method.
     * This method also takes advantage of features added in Java SE8 ({@link Stream})
     * time complexity of O(b) - linear
     * space complexity of O(a) - linear
     * @param array1 - the first input array
     * @param array2 - the second input array
     * @return A boolean indicating whether those two arrays have any common items
     */
    public static boolean containsCommonItemsBetterAndCleaner(Object[] array1, Object[] array2) {
        HashSet<Object> mapOfFirstArray = new HashSet<>(Arrays.asList(array1));
        return Stream.of(array2).anyMatch(mapOfFirstArray::contains);
    }
}

/*
// Given 2 arrays, create a function that let's a user know (true/false) whether these two arrays contain any common items
//For Example:
//const array1 = ['a', 'b', 'c', 'x'];//const array2 = ['z', 'y', 'i'];
//should return false.
//-----------
//const array1 = ['a', 'b', 'c', 'x'];//const array2 = ['z', 'y', 'x'];
//should return true.

// 2 parameters - arrays - no size limit
// return true or false

function containsCommonItem(arr1, arr2) {
  for (let i=0; i < arr1.length; i++) {
    for ( let j=0; j < arr2.length; j++) {
      if(arr1[i] === arr2[j]) {
        return true;
      }
    }
  }
  return false
}

//O(a*b)
//O(1) - Space Complexity

const array1 = ['a', 'b', 'c', 'x'];
const array2 = ['z', 'y', 'a'];

function containsCommonItem2(arr1, arr2) {
  // loop through first array and create object where properties === items in the array
  // can we assume always 2 params?

  let map = {};
  for (let i=0; i < arr1.length; i++) {
    if(!map[arr1[i]]) {
      const item = arr1[i];
      map[item] = true;
    }
  }
  // loop through second array and check if item in second array exists on created object.
  for (let j=0; j < arr2.length; j++) {
    if (map[arr2[j]]) {
      return true;
    }
  }
  return false
}

//O(a + b) Time Complexity
//O(a) Space Complexity

// containsCommonItem2(array1, array2)

function containsCommonItem3(arr1, arr2) {
  return arr1.some(item => arr2.includes(item))
}

containsCommonItem(array1, array2)
containsCommonItem2(array1, array2)
containsCommonItem3(array1, array2)

 */
