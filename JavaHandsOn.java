package org.javabin.springbootdemo;

import com.sun.source.tree.TypeParameterTree;
import org.javabin.entity.BinaryTree;
import org.javabin.entity.Book;
import org.javabin.entity.TreeNode;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaHandsOn {
    public static void main(String[] args) {
        /*String[] arr = {"a", "b", "c", "d", "e"};
        List<String> list = Arrays.asList(arr);*/
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        int[] arr = {1, 2, 4, 7, 1, 3, 5, 2, 13, 22, 21, 4};
        int[] arr2 = {1, 3, 5, 3, 67, 56, 23, 41};
        int[] arr3 = {1, 10, -6, 8, 9, 12, -20, 18, 15, -7};

        List<Integer> integerList = Arrays.stream(arr).boxed().toList();
        List<Integer> integerList2 = Arrays.stream(arr2).boxed().toList();

        /**
         * Integer array v.s. int array v.s. Integer list
         */
        Integer[] arrInteger = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        List<Integer> intList = Arrays.stream(arr).boxed().toList();
        //------------------//
        int[] arrInt = Arrays.stream(arrInteger).mapToInt(Integer::valueOf).toArray();
        intList = Arrays.stream(arrInteger).toList();
        intList = Arrays.asList(arrInteger);
        //------------------//
        arrInteger = intList.toArray(new Integer[intList.size()]);
        int[] arrayInt = intList.stream().mapToInt(Integer::intValue).toArray();

        Book[] bookArray = new Book[]{
                new Book("2", "book2", 10, "author2"),
                new Book("1", "book1", 10, "author1"),
                new Book("6", "book5", 10, "author5"),
                new Book("3", "book3", 10, "author3"),
                new Book("4", "book4", 10, "author4"),
                new Book("5", "book5", 10, "author5"),
                new Book("7", "book3", 10, "author3"),
        };
        Book[] bookArray1 = new Book[]{
                new Book("2", "book2", 10, "author2"),
                new Book("1", "book1", 10, "author1"),
                new Book("6", "book5", 10, "author5"),
                new Book("3", "book3", 10, "author3"),
                new Book("4", "book4", 10, "author4"),
                new Book("5", "book5", 10, "author5"),
                new Book("7", "book3", 10, "author3"),
        };
        List<Book> bookList = Arrays.stream(bookArray).toList();

        //reverseArray(arr);
        //reverseArrayWithScope(arr, 4, 10);
        /*Arrays.stream(arrInteger).forEach(i -> System.out.print(i + "\t"));
        System.out.println();
        reverseArrayWithScope(arrInteger, 4, 8);
        Arrays.stream(arrInteger).forEach(i -> System.out.print(i + "\t"));*/
        //rightRotateArray(arr, 4);
        //leftRotateArray(arr, 4);
        //reverseList(list);
        //reverseString("HelloWorld!");
        //maxNumberInArray(new int[]{85, 23, 42, -1, 103, 96, 88, 34});
        //swapTwoNums(54, 67);
        //checkVowel("HelloWorld!");
        //checkPrimeNum(81);
        //factorial(9);
        //printFibonacci(0, 1, 56);
        //printFibonacciMaxCount(0, 1, 0, 10);
        //removeDuplicateFromList(integerList);
        //removeDuplicateFromList(bookList);
        /*List<Book> duplicateElems = findDuplicateElems(bookList);
        System.out.println("duplicateElems = " + duplicateElems);*/
        //checkOddNum(integerList2);

        /*char c = nonRepeatChar("achedswklcadehskwfl");
        if(c != 0) {
            System.out.println("the first non-repeating char is " + c);
        } else {
            System.out.println("Not found non-repeating char.");
        }*/

        //isPalindrome("Radar");

        //removeSpace("Hello, this is Java world!");

        //sortArray(bookArray, t -> ((Book)t).getName());

        /*try {
            deadlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //reverseLinkedList(new LinkedList<>(integerList));

        //binarySearch(10, 0, arr3.length - 1, arr3);

        /*int[] sortedArr = mergeSorting(0, arr.length - 1, arr);
        Arrays.stream(sortedArr).forEach(i -> System.out.print(i + "\t"));*/

        /*printTPSingleNum(9, false);
        printTPSequenceNum(9, false);
        printTPReversedSeqNum(9, true);*/

        /*boolean result = compareTwoArrays(bookArray, bookArray1, Comparator.comparing(book -> ((Book) book).getName()));*/

        /*boolean result = compareTwoArraysBySet(bookArray1, bookArray);
        System.out.println("Two arrays have " + (result ? "the same" : "different") + " elements.");*/

        /*BinaryTree tree = BinaryTree.generateTree();
        int maxDepth = maxDepthOfBinTree(tree.getRoot());
        System.out.println("maxDepth = " + maxDepth);*/

        /*int target = 71;
        int[] twoSum = findTwoSum(arr, target);
        if(twoSum == null) {
            System.out.println("Not found the indices of elements that sum up to the target.");
        } else {
            System.out.println(String.format(
                    "Elem %d on index[%d] + Elem %d on index[%d] = Target %d",
                    arr[twoSum[0]],
                    twoSum[0],
                    arr[twoSum[1]],
                    twoSum[1],
                    target));
        }*/

        /*String str = "madame";
        allUniqueChars(str);*/

        /*LinkedHashMap<Double, Integer> counts = leastBillsOfAmount(333.8);
        counts.entrySet().forEach(entry -> {
            if(entry.getValue() != 0) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        });*/

        int[] indices = findMaxSumOfSubArray(arr3);
        System.out.println("The max sum of the array is observed between " + indices[0] + " and " + indices[1]);
    }

    /**
     * Reverse an array of primary type
     */
    private static void reverseArray(int[] arr) {
        Arrays.stream(arr).forEach(i -> System.out.print(i + "\t"));
        System.out.println();
        int len = arr.length;
        for (int i = 0, n = len / 2; i < n; i++) {
            int tmp = arr[len - i - 1];
            arr[len - i - 1] = arr[i];
            arr[i] = tmp;
        }
        Arrays.stream(arr).forEach(i -> System.out.print(i + "\t"));
    }

    /**
     * Reverse an array of object type
     */
    private static <T> void reverseArrayWithScope(T[] arr, int start, int end) {
        if(start < 0 || end < 0 || start > end || end > arr.length) {
            System.out.println("Invalid scope.");
            return;
        }
        int len = end - start + 1;
        for (int i = 0, n = len / 2; i < n; i++) {
            T tmp = arr[end - i];
            arr[end - i] = arr[start + i];
            arr[start + i] = tmp;
        }
    }

    /**
     * Reverse an array
     */
    private static void reverseArrayWithScope(int[] arr, int start, int end) {
        if(start < 0 || end < 0 || start > end || end > arr.length) {
            System.out.println("Invalid scope.");
            return;
        }
        Arrays.stream(arr).forEach(i -> System.out.print(i + "\t"));
        System.out.println();
        int len = end - start + 1;
        for (int i = 0, n = len / 2; i < n; i++) {
            int tmp = arr[end - i];
            arr[end - i] = arr[start + i];
            arr[start + i] = tmp;
        }
        Arrays.stream(arr).forEach(i -> System.out.print(i + "\t"));
        System.out.println();
    }

    /**
     * Rotate an array to right with k steps
     */
    private static void rightRotateArray(int[] arr, int k) {
        reverseArrayWithScope(arr, 0, arr.length - 1);
        reverseArrayWithScope(arr, 0, k - 1);
        reverseArrayWithScope(arr, k, arr.length - 1);
    }

    /**
     * Rotate an array to left with k steps
     */
    private static void leftRotateArray(int[] arr, int k) {
        reverseArrayWithScope(arr, 0, arr.length - 1);
        reverseArrayWithScope(arr, 0, arr.length - k - 1);
        reverseArrayWithScope(arr, arr.length - k, arr.length - 1);
    }

    /**
     * Write a program to reverse a string.
     */
    private static void reverseString(String str) {
        System.out.println("str = " + str);
        char[] charArr = str.toCharArray();
        int len = charArr.length;
        for (int i = 0, n = len / 2; i < n; i++) {
            char tmp = charArr[i];
            charArr[i] = charArr[len - i - 1];
            charArr[len - i - 1] = tmp;
        }
        String reversedStr = String.copyValueOf(charArr);
        System.out.println("reversedStr = " + reversedStr);

        /**
         * by leveraging StringBuilder
         */
        System.out.println("str = " + str);
        StringBuilder sb = new StringBuilder(str);
        String reversedSBStr = sb.reverse().toString();
        System.out.println("reversedSBStr = " + reversedSBStr);
    }

    /**
     * Write a program to reverse a list.
     */
    private static void reverseList(List<String> list) {
        System.out.println("list = " + list);
        String[] array = new String[list.size()];
        list.toArray(array);
        int len = array.length;
        for (int i = 0, n = len/2; i < n; i++) {
            String temp = array[i];
            array[i] = array[len - i - 1];
            array[len - i - 1] = temp;
        }
        System.out.println("Reversed List = " + Arrays.asList(array));
    }

    /**
     * Write a program to find the largest number in an array.
     */
    private static void maxNumberInArray(int[] arr) {
        /**
         * by leveraging Arrays.sort method
         *
         * Time Complexity
         * Average case: O(n log n)
         * Worst case: O(n^2)
         */
        Arrays.sort(arr);
        System.out.println("max number in array = " + arr[arr.length - 1]);

        /**
         * loop each number in array
         *
         * Time Complexity: O(n)
         */
        int maxNum = arr[0];
        for (int i = 1, n = arr.length; i < n; i++) {
            maxNum = Math.max(maxNum, arr[i]);
        }
        System.out.println("maxNum = " + maxNum);
    }

    /**
     * Swap two numbers without using a third variable.
     */
    private static void swapTwoNums(int num1, int num2) {
        System.out.println("num1 : " + num1 + ", num2 : " + num2);
        /*num1 = num1 * 2 + num2;
        num2 = (num1 - num2) / 2;
        num1 = num1 - num2 * 2;*/
        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;
        System.out.println("num1 : " + num1 + ", num2 : " + num2);
    }

    /**
     * Check if a vowel is present in a string.
     */
    private static void checkVowel(String str) {
        String vowels = "aeiou";
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if(vowels.indexOf(String.valueOf(c).toLowerCase()) >=0) {
                System.out.println("Found vowel character : " + c);
            }
        }

        /**
         * by leveraging regular expression
         */
        boolean matches = str.toLowerCase().matches(".*[aeiou].*");
        System.out.println("matches = " + matches);
    }

    /**
     * Check if a given number is prime number.
     */
    private static void checkPrimeNum(int num) {
        boolean isPrime = true;
        if (num == 0 || num == 1) {
            isPrime = false;
        }
        if (num == 2) {
            isPrime = true;
        }
        for (int i = 2; i < Math.sqrt(num); i++) {
            if((num % i) == 0) {
                isPrime = false;
                break;
            }
        }

        if(isPrime) {
            System.out.println(String.format("%d is a prime number", num));
        } else {
            System.out.println(String.format("%d is not a prime number", num));
        }
    }

    /**
     * Find the factorial of a given number.
     */
    private static void factorial(int num) {
        int factorial = 1;
        if(num == 0 || num == 1) {
            factorial = num;
        } else {
            for (int i = num; i > 1; i--) {
                factorial *= i;
            }
        }

        System.out.println("factorial = " + factorial);
    }

    /**
     * Print a Fibonacci sequence using recursion. ceiling.
     */
    private static void printFibonacci(int num1, int num2, int ceiling) {
        System.out.print(num1 + "\t");
        int num = num1 + num2;
        if(num > ceiling) {
            System.out.print(num2);
            return;
        } else {
            printFibonacci(num2, num, ceiling);
        }
    }

    /**
     * Print a Fibonacci sequence using recursion. max count.
     */
    private static void printFibonacciMaxCount(int num1, int num2, int currCount, int maxCount) {
        System.out.print(num1 + "\t");
        currCount++;
        if(currCount >= maxCount) {
            return;
        }
        printFibonacciMaxCount(num2, num1 + num2, currCount, maxCount);
    }

    /**
     * Remove duplicate elements from an array. The order of the array will be changed.
     * Use removeDuplicateFromList instead.
     */
    private static void removeDuplicateFromArray(int[] arr) {
        Arrays.stream(arr).forEach(i -> System.out.print(i + "\t"));
        //Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet()); // the order of the array will be changed
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0, n = arr.length; i < n; i++) {
            set.add(Integer.valueOf(arr[i]));
        }
        int[] newArr = new int[set.size()];
        Iterator<Integer> iter = set.iterator();
        for (int i = 0, n = set.size(); i < n; i++) {
            newArr[i] = iter.next();
        }

        Arrays.stream(newArr).forEach(i -> System.out.print(i + "\t"));
    }

    /**
     * Remove duplicate elements from a list, without changing the order of insertion
     */
    private static <T> void removeDuplicateFromList(List<T> list) {
        System.out.println("list with duplicate :  " + list);
        LinkedHashSet<T> integerSet = new LinkedHashSet<>(list);
        List<T> newList = integerSet.stream().toList();
        System.out.println("list removed duplicate = " + newList);

    }

    /**
     * Find duplicate elements from a list
     */
    private static <T> List<T> findDuplicateElems(List<T> list) {
        LinkedHashSet<T> set = new LinkedHashSet<>();
        ArrayList<T> duplicateList = new ArrayList<>();
        list.forEach(t -> {
            boolean newAdded = set.add(t);
            if(!newAdded) {
                duplicateList.add(t);
            }
        });
        return duplicateList;
    }

    /**
     * Check if a list of integers contains only odd numbers.
     */
    private static void checkOddNum(List<Integer> list) {
        /*boolean onlyOddNum = true;
        for (Integer i : list) {
            if((i.intValue() % 2) == 0) {
                onlyOddNum = false;
            }
        }
        if(onlyOddNum) {
            System.out.println("Only odd numbers contained in the list");
        } else {
            System.out.println("Found even number in the list");
        }*/

        /**
         * by leveraging the parallel stream, it will get better performance when handling list with large size
         */
        boolean hasEvenNum = list.parallelStream().anyMatch(i -> i % 2 == 0);
        if(hasEvenNum) {
            System.out.println("Found even number in the list");
        } else {
            System.out.println("Only odd numbers contained in the list");
        }
    }

    /**
     * Check whether a string is a palindrome.
     * palindrome is a word reads the same backwards as forwards, examples : “civic”, “madam”, “radar”, and “deified”
     */
    private static void isPalindrome(String str) {
        boolean isPalindrome = true;
        char[] chars = str.toLowerCase().toCharArray();
        int len = chars.length;
        for (int i = 0, n = len / 2; i < n; i++) {
            if(chars[i] != chars[len - i - 1]) {
                isPalindrome = false;
                break;
            }
        }

        if(isPalindrome) {
            System.out.println(String.format("%s is palindrome", str));
        } else {
            System.out.println(String.format("%s is not palindrome", str));
        }
    }

    /**
     * Find the first non-repeating character in a string.
     */
    private static char nonRepeatChar(String str) {
        char a = 'a';
        int[] repeatArr = new int[26];
        char[] arr = str.toCharArray();
        for (int i = 0, n = arr.length; i < n; i++) {
            repeatArr[arr[i] - a]++;
        }
        for (int i = 0, m = arr.length; i < m; i++) {
            if(repeatArr[arr[i] - a] == 1) {
                return str.charAt(i);
            }
        }
        return 0;
    }

    /**
     * Remove spaces from a string.
     */
    private static void removeSpace(String str) {
        System.out.println("str = " + str);
        String newStr = str.replace(" ", "");
        System.out.println("str after space removed = " + newStr);
    }

    /**
     * Sort an array of class type T
     */
    private static <T> void sortArray(T[] arr, Function compareFunc) {
        System.out.println("Before sorting:");
        Arrays.stream(arr).forEach(System.out::println);

        Arrays.sort(arr, Comparator.comparing(compareFunc));

        System.out.println("After sorting:");
        Arrays.stream(arr).forEach(System.out::println);
    }

    /**
     * Create a deadlock scenario programmatically.
     */
    private static void deadlock() throws InterruptedException {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        Thread t1 = new Thread(new SyncThread(obj1, obj2), "t1");
        Thread t2 = new Thread(new SyncThread(obj2, obj3), "t2");
        Thread t3 = new Thread(new SyncThread(obj3, obj1), "t3");

        t1.start();
        Thread.sleep(5000);
        t2.start();
        Thread.sleep(5000);
        t3.start();
    }

    private static class SyncThread implements Runnable {
        private Object obj1;
        private Object obj2;

        public SyncThread(Object o1, Object o2) {
            this.obj1 = o1;
            this.obj2 = o2;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();

            System.out.println(name + " acquiring lock on " + obj1);
            synchronized (obj1) {
                System.out.println(name + " acquired lock on " + obj1);
                work();
                System.out.println(name + " acquiring lock on " + obj2);
                synchronized (obj2) {
                    System.out.println(name + " acquired lock on " + obj2);
                    work();
                }
                System.out.println(name + " released lock on " + obj2);
            }
            System.out.println(name + " released lock on " + obj1);
            System.out.println(name + " finished execution.");
        }

        private void work() {
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Reverse a linked list.
     */
    private static void reverseLinkedList(LinkedList<Integer> list) {
        System.out.println("list = " + list);
        int len = list.size();
        for (int i = 0, n = len / 2; i < n; i++) {
            Integer temp = list.get(i);
            list.set(i, list.get(len - i - 1));
            list.set(len - i - 1, temp);
        }
        System.out.println("list reversed = " + list);
    }

    /**
     * Implement a binary search.
     * The array elements must be sorted before performing the binary search.
     *
     * The binary search algorithm is based on the following conditions:
     * If the key is less than the middle element, then you now need to search only in the first half of the array.
     * If the key is greater than the middle element, then you need to search only in the second half of the array.
     * If the key is equal to the middle element in the array, then the search ends.
     * Finally, if the key is not found in the whole array, it indicates that the element is not present.
     */
    private static void binarySearch(int elem, int start, int end, int[] arr) {
        if(start > end) {
            System.out.println(String.format("Failed to find the elem %d",elem));
            return;
        }

        //int mid = (end - start) / 2 + start;
        int mid = (end + start) / 2;
        if(elem == arr[mid]) {
            System.out.println(String.format("Found the elem %d in the index %d",elem, mid));
            return;
        } else if(elem < arr[mid]) {
            binarySearch(elem, start, mid - 1, arr);
        } else if(elem > arr[mid]) {
            binarySearch(elem, mid + 1, end, arr);
        }
    }

    private static void binarySearch2(int elem, int start, int end, int[] arr) {
        int mid = (start + end) / 2;

        while (start <= end) {
            if (arr[mid] < elem) {
                start = mid + 1;
            } else if (arr[mid] == elem) {
                System.out.println(String.format("Found the elem %d in the index %d",elem, mid));
                return;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }

        System.out.println(String.format("Failed to find the elem %d",elem));
        return;
    }

    /**
     * Implement merge sorting.
     *
     * Merge sort is one of the most efficient sorting algorithms.
     * It works on the principle of “divide and conquer”.
     * It is based on the idea of breaking down a list into several sub-lists until each sub-list consists of a single element,
     * and then merging those sub-lists in a manner that results in a sorted list.
     */
    private static int[] mergeSorting(int start, int end, int[] arr) {
        if(start == end) {
            int[] sortedArr = new int[1];
            sortedArr[0] = arr[start];
            return sortedArr;
        }
        int mid = (start + end) / 2;
        int[] sortedArr1 = mergeSorting(start, mid, arr);
        int[] sortedArr2 = mergeSorting(mid + 1, end, arr);
        return mergeTwoSortedArray(sortedArr1, sortedArr2);
    }

    private static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] mergedArr = new int[len1 + len2];
        int iArr1 = 0;
        int iArr2 = 0;
        int iMergedArr = 0;

        while(iArr1 < len1 && iArr2 < len2) {
            if(arr1[iArr1] <= arr2[iArr2]) {
                mergedArr[iMergedArr++] = arr1[iArr1++];
            } else {
                mergedArr[iMergedArr++] = arr2[iArr2++];
            }
        }

        if(iArr1 == len1) {
            for (int i = iArr2; i < len2; i++) {
                mergedArr[iMergedArr++] = arr2[i];
            }
        }

        if(iArr2 == len2) {
            for (int i = iArr1; i < len1; i++) {
                mergedArr[iMergedArr++] = arr1[i];
            }
        }

        return mergedArr;
    }

    /**
     * Triangle Pattern Programs.
     *
     * n : pyramid level
     * i : the current level, i = 1...n
     *
     * maxLen = n * 2 - 1
     * midLoc = maxCount / 2 + 1
     * printStartLoc = midLoc - i + 1
     * printEndLoc (inclusive) = midLoc + i - 1
     */
    private static void numericTrianglePattern(int level, boolean bottomUp, Consumer<Integer> printPattern) {
        if(level < 1 || level > 9) {
            System.out.println("Invalid value of Pyramid level");
            return;
        }
        if(bottomUp) {
            for (int i = level; i >= 1; i--) {
                printTrianglePattern(level, i, printPattern);
            }
        } else {
            for (int i = 1; i <= level; i++) {
                printTrianglePattern(level, i, printPattern);
            }
        }
    }
    private static void printTrianglePattern(int level, int i, Consumer<Integer> printPattern) {
        int maxLen = level * 2 - 1;
        int midLoc = maxLen / 2 + 1;
        int pStartLoc = midLoc - i + 1;
        int pEndLoc = midLoc + i - 1;   // inclusive
        for (int j = 0; j < pStartLoc; j++) {
            System.out.print(" ");
        }
        printPattern.accept(i);
        for (int j = pEndLoc + 1; j <= maxLen; j++) {
            System.out.print(" ");
        }
        System.out.println();
    }
    /**
     *          1
     *         2 2
     *        3 3 3
     *       4 4 4 4
     *      5 5 5 5 5
     *     6 6 6 6 6 6
     *    7 7 7 7 7 7 7
     *   8 8 8 8 8 8 8 8
     *  9 9 9 9 9 9 9 9 9
     */
    private static void printTPSingleNum(int level, boolean bottomUp) {
        numericTrianglePattern(level, bottomUp, (integer) -> {
            int i = integer.intValue();
            for (int j = 1; j < i; j++) {
                System.out.print(i + " ");
            }
            System.out.print(i);
        });
    }
    /**
     *          1
     *         1 2
     *        1 2 3
     *       1 2 3 4
     *      1 2 3 4 5
     *     1 2 3 4 5 6
     *    1 2 3 4 5 6 7
     *   1 2 3 4 5 6 7 8
     *  1 2 3 4 5 6 7 8 9
     */
    private static void printTPSequenceNum(int level, boolean bottomUp) {
        numericTrianglePattern(level, bottomUp, (integer) -> {
            int i = integer.intValue();
            int j;
            for (j = 1; j < i; j++) {
                System.out.print(j + " ");
            }
            System.out.print(j);
        });
    }
    /**
     *          1
     *         2 1
     *        3 2 1
     *       4 3 2 1
     *      5 4 3 2 1
     *     6 5 4 3 2 1
     *    7 6 5 4 3 2 1
     *   8 7 6 5 4 3 2 1
     *  9 8 7 6 5 4 3 2 1
     */
    private static void printTPReversedSeqNum(int level, boolean bottomUp) {
        numericTrianglePattern(level, bottomUp, (integer) -> {
            int i = integer.intValue();
            int j;
            for (j = i; j > 1; j--) {
                System.out.print(j + " ");
            }
            System.out.print(j);
        });
    }

    /**
     * Check if two arrays contain the same elements.
     * The order of the two arrays will be changed after comparison.
     */
    private static <T> boolean compareTwoArrays(T[] arr1, T[] arr2, Comparator<T> comparator) {
        if(arr1.length != arr2.length) {
            System.out.println("Two arrays have different size.");
            return false;
        }
        Arrays.sort(arr1, comparator);
        Arrays.sort(arr2, comparator);
        for (int i = 0, n = arr1.length; i < n; i++) {
            if(!arr1[i].equals(arr2[i])) {
                System.out.println("Found different elements: array1 contains " + arr1[i] + ", whereas array2 contains " + arr2[i]);
                return false;
            }
        }
        return true;
    }

    /**
     * Check if two arrays contain the same elements.
     * The order of the two arrays will NOT be changed after comparison.
     */
    private static <T> boolean compareTwoArraysBySet(T[] arr1, T[] arr2) {
        if(arr1.length != arr2.length) {
            System.out.println("Two arrays have different size.");
            return false;
        }

        Set<Book> set1 = (Set<Book>)Arrays.stream(arr1).collect(Collectors.toSet());
        Set<Book> set2 = (Set<Book>)Arrays.stream(arr2).collect(Collectors.toSet());
        if(set1.containsAll(set2) && set2.containsAll(set1)) {
            return true;
        }
        return false;
    }

    /**
     * Find the Maximum Depth of a Binary Tree.
     */
    private static int maxDepthOfBinTree(TreeNode node) {
        if(node == null || node.getData() == null) {
            return 0;
        }
        return 1 + Math.max(maxDepthOfBinTree(node.getLeftSub()), maxDepthOfBinTree(node.getRightSub()));
    }

    /**
     * Find indices of the two numbers such that they add up to a specific target.
     */
    private static int[] findTwoSum(int[] arr, int target) {
        int[] indices = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, n = arr.length; i < n; i++) {
            Integer elem = Integer.valueOf(target - arr[i]);
            if(map.containsKey(elem)) {
                indices[0] = map.get(elem);
                indices[1] = i;
                return indices;
            }
            map.put(arr[i], i);
        }
        return null;
    }

    /**
     * Determine if a String has all Unique Characters
     */
    private static boolean allUniqueChars(String str) {
        char[] chars = str.toCharArray();
        HashSet<String> set = new HashSet<>();
        for (int i = 0, n = chars.length; i < n; i++) {
            boolean newAdded = set.add(String.valueOf(chars[i]));
            if(!newAdded) {
                System.out.println(String.format("String %s contains duplicate char : %s", str, chars[i]));
                return false;
            }
        }
        return true;
    }

    /**
     * Find the least pieces of bills or coins that sum up a given amount.
     * The face value includes 0.1, 0.25, 0.5, 1, 5, 10, 20, 50, 100
     */
    private static LinkedHashMap<Double, Integer> leastBillsOfAmount(double amount) {
        double[] faceValues = {0.1, 0.25, 0.5, 1, 5, 10, 20, 50, 100};
        LinkedHashMap<Double, Integer> counts = new LinkedHashMap<>();
        for (int i = faceValues.length - 1; i >= 0; i--) {
            int count = (int)(amount / faceValues[i]);
            counts.put(faceValues[i], count);
            amount -= (count * faceValues[i]);
        }
        return counts;
    }

    /**
     * Find the maximum sum of the sub array in an array.
     */
    private static int[] findMaxSumOfSubArray(int[] arr) {
        int maxSum = arr[0];
        int currMaxSum = arr[0];
        int[] subArrIndex = new int[2];
        subArrIndex[0] = -1;
        for (int i = 1, n = arr.length; i < n; i++) {
            if(currMaxSum <= currMaxSum + arr[i]){
                currMaxSum = currMaxSum + arr[i];
                if(maxSum < currMaxSum) {
                    maxSum = currMaxSum;
                    if(subArrIndex[0] == -1) {
                        subArrIndex[0] = i;
                    }
                    subArrIndex[1] = i;
                }
            } else {
                currMaxSum = 0;
                subArrIndex[0] = -1;
            }
        }
        System.out.println("maxSum = " + maxSum);
        return subArrIndex;
    }
}

