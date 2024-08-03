package array;

import java.util.*;

// Date : 30 Jul 2024
public class Main {
    static Random random = new Random();
    private static int num;

    static int largestElement(int[] arr) {
        int largest = arr[0];
        for (int elm : arr) {
            largest = Math.max(largest, elm);
        }
        return largest;
    }

    static int secondLargest(int[] arr) {
        int largest = arr[0];
        int second = -1;
        for (int elm : arr) {
            if (elm > largest) {
                second = largest;
                largest = elm;
            } else if (largest > elm && second < elm) {
                second = elm;
            }
        }
        return second;
    }

    static int secondSmallest(int[] arr) {
        int small = arr[0];
        int ssmall = Integer.MAX_VALUE;
        for (int elm : arr) {
            if (elm < small) {
                ssmall = small;
                small = elm;
            } else if (small != elm && elm < ssmall) {
                ssmall = elm;
            }
        }
        return ssmall;
    }

    static boolean isSorted(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) {
            } else
                return false;
        }
        return true;
    }

    static int removeDuplicate(int[] arr) {
        int ptr = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[ptr] != arr[i]) {
                ptr++;
                arr[ptr] = arr[i];
            }
        }
        printIntArray(arr);
        return ptr;
    }

    // Date : 31 Jul 2024
    static boolean rotateLeftByOne(int[] arr) {
        int num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = num;

        return true;
    }

    static boolean rotateByN(int[] arr, int num) {
        // First do ${num} % ${arr.length} if num is greater
        num = num % arr.length;

        // BF : call rotateLeftByOne ${num} times in a loop
        for (int i = 0; i < num; i++) {
            rotateLeftByOne(arr);
        }

        // Optimal Sol
        // reverse(0,num)
        // reverse(num,arr.length)
        // reverse(0,arr.length)


        return true;
    }

    static boolean moveZeroToEnd(int[] arr) {

        // BF : add non-zero to tmp arr then add it back to main and fill others with zero

        int ptr = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                ptr = i;
                break;
            }
        }
        if (ptr == -1) {
            return false;
        }
        for (int i = ptr + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr, i, ptr);
                ptr++;

            }
        }
        printIntArray(arr);

        return true;
    }

    static void swap(int arr[], int idx, int idx2) {
        int tmp = arr[idx];
        arr[idx] = arr[idx2];
        arr[idx2] = tmp;
    }

    static int linearSearch(int[] arr, int elm) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elm) {
                return i;
            }
        }
        return -1;
    }

    static List<Integer> unionOfTwoSortedArray(int[] first, int[] second) {
        // BF : Create a Set all elm from first and second to it then add all from set to result arr
        // Optimal : Use two pointer
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < first.length && j < second.length) {
            if (first[i] <= second[j]) {
                if (res.isEmpty() || res.get(res.size() - 1) != first[i])
                    res.add(first[i]);
                i++;
            } else {
                if (res.isEmpty() || res.get(res.size() - 1) != second[j])
                    res.add(second[j]);
                j++;
            }
        }
        while (i < first.length) {
            if (res.isEmpty() || res.get(res.size() - 1) != first[i])
                res.add(first[i]);
            i++;
        }

        while (j < second.length) {
            if (res.isEmpty() || res.get(res.size() - 1) != second[j])
                res.add(second[j]);
            j++;
        }

        return res;
    }

    static List<Integer> intersectionOfTwoSortedArray(int[] first, int[] second) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < first.length && j < second.length) {
            if (first[i] == second[j]) {
                res.add(first[i]);
                i++;
                j++;
            } else if (first[i] > second[j]) {
                j++;
            } else if (first[i] < second[j]) {
                i++;
            }
        }
        return res;
    }

    static int missingNumber(int[] arr, int n) {
//        int finalSum = (n * (n + 1)) / 2;
//        int sum = Arrays.stream(arr).sum();
//        return finalSum - sum;

        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < n - 1; i++) {
            xor2 = xor2 ^ arr[i];
            xor1 = xor1 ^ (i + 1);
        }
        xor1 = xor1 ^ n;
        return xor1 ^ xor2;
    }

    static int maxConsecutive(int[] arr, int num) {
        int maxc = 0;
        int count = 0;
        for (int elm : arr) {
            if (elm == num) {
                count++;
                maxc = Math.max(count, maxc);
            } else
                count = 0;
        }
        return maxc;
    }

    static int numberAppearOnceOtherNumberTwice(int[] arr) {
        int number = 0;
        for (int elm : arr)
            number = number ^ elm;
        return number;
    }

    static void generateAllSubArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k < j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

    static int longestSubArrayWithSumK(int[] arr, int key) {
        int sum = 0, len = 0;
        Map<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == key)
                len = Math.max(len, i + 1);

            if (hash.containsKey(sum - key)) {
                int prev = hash.get(sum - key);
                len = Math.max(len, i - prev);
            }
            if (!hash.containsKey(sum))
                hash.put(sum, i);
        }
        return len;
    }

    static void sort012(int[] arr) {
        // BF count 0,1,2 then fill the org arr accod
        // OP Dutch National Flag algo

        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }

    }


    static void majorityElement(int[] arr) {
        // BF: pick one elm and scan and count and check n/2
        // Better: use map to store the count and then calculate
        // OS: Moore's Voting Algorithm

        int count = 0, elm = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                count++;
                elm = arr[i];
            } else if (elm == arr[i]) {
                count++;
            } else
                count--;
        }

        System.out.println(elm);
    }

    static void maximumSubArraySum(int[] arr) {
        // BF: Generate all sub array and sum and take max

        // Better
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);

        // OS: Kadane's Algorithm

        int sum = arr[0], kmaxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            kmaxSum = Math.max(sum, kmaxSum);
        }
        System.out.println(maxSum);

    }

    static void leaderInArray(int[] arr) {
        int leader = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > leader) {
                System.out.print(leader + " ");
                leader = arr[i];
            }
        }
        System.out.println(leader);
    }

    public static void main(String[] args) {
        var arr = new int[10];
        fillIntArray(arr, 3);

//        printIntArray(arr);
//        System.out.println("Largest is " + largestElement(arr));
//        System.out.println("Second Largest is " + secondLargest(arr));
//        System.out.println("Second Smallest is " + secondSmallest(arr));
//        System.out.println("isSorted is " + isSorted(new int[]{1, 2, 3, 4, 5, 5, 6}));
//        System.out.println("removeDuplicate is " + removeDuplicate(new int[]{1, 1, 1, 2, 3, 3, 4, 5, 5, 6}));
//        System.out.println("rotateLeftByOne is " + rotateLeftByOne(arr));
//        System.out.println("rotateByN is " + rotateByN(arr, 3));
//        System.out.println("moveZeroToEnd is " + moveZeroToEnd(new int[]{1, 0, 20, 0, 0, 3, 4, 6, 7, 0, 13, 31, 234}));

//        var first = new int[10];
//        var second = new int[10];
//        fillIntArray(first, 10);
//        fillIntArray(second, 10);
//
//        Arrays.sort(first);
//        Arrays.sort(second);
//        printIntArray(first);
//        printIntArray(second);
//        System.out.println(unionOfTwoSortedArray(first, second));
//        System.out.println(intersectionOfTwoSortedArray(first, second));

//        System.out.println(missingNumber(new int[]{1, 2, 3, 5}, 5));

//        System.out.println(maxConsecutive(new int[]{1, 3, 2, 2, 3, 3, 3, 4, 3, 3}, 3));
//        System.out.println(numberAppearOnceOtherNumberTwice(new int[]{1, 2, 1, 2, 3, 3, 4, 5, 5, 4, 6}));
//        generateAllSubArray(arr);
//        System.out.println(longestSubArrayWithSumK(new int[]{2, 0, 0, 3}, 3));

//        printIntArray(arr);
//        sort012(arr);
//        printIntArray(arr);

//        majorityElement(new int[]{2, 2, 1, 3, 1, 1, 3, 3, 3});
        leaderInArray(new int[]{10,22,12,3,0,6});
    }

    private static void fillIntArray(int[] arr, int range) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(range);
        }


    }

    private static void printIntArray(int[] arr) {
        for (int o : arr) {
            System.out.print(o + " ");
        }
        System.out.println();
    }


}


