class MyHashSet {
    int arr[]= new int [10000000];
    public MyHashSet() {
        Arrays.fill(arr,-1);
    }
    
    public void add(int key) {
        arr[key]=key;
    }
    
    public void remove(int key) {
        arr[key]=-1;
    }
    
    public boolean contains(int key) {
        return arr[key]!=-1;
    }
}

class MyHashMap {
    int arr[]= new int[10000000];
    public MyHashMap() {
        Arrays.fill(arr,-1);
    }
    
    public void put(int key, int value) {
        arr[key]=value;
    }
    
    public int get(int key) {
        return arr[key];
    }
    
    public void remove(int key) {
        arr[key]=-1;
    }
}

    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            var c1 = s.charAt(i);
            var c2 = s.charAt(j);
            if (!Character.isLetterOrDigit(c1)) {
                i++;
                continue;
            } else if (!Character.isLetterOrDigit(c2)) {
                j--;
                continue;
            }
            if (c1 == c2) {
                i++;
                j--;
            } else
                return false;
        }
        return true;        
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();

        int i = 0, j = 0;

        while (i < word1.length() && j < word2.length()) {
            res.append(word1.charAt(i));
            res.append(word2.charAt(j));
            i++;
            j++;

        }

        while (i < word1.length()) {
            res.append(word1.charAt(i));
            i++;
        }
        while (j < word2.length()) {
            res.append(word2.charAt(j));
            j++;
        }

        return res.toString();
    }

    public void reverseString(char[] s) {
        int i=0,j=s.length-1;
        while(i<=j) swap(s, i++, j--);
    }

    void swap(char[] arr, int idx, int idx2) {
        char tmp = arr[idx];
        arr[idx] = arr[idx2];
        arr[idx2] = tmp;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            copyArray(nums2,nums1);
            return;
        }

        int i = 0, j = 0;
        int[] res = new int[m + n];
        int count = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[count++] = nums1[i++];
            } else {
                res[count++] = nums2[j++];
            }
        }

        while (i < m) {
            res[count++] = nums1[i++];
        }
        while (j < n) {
            res[count++] = nums2[j++];
        }

        copyArray(res,nums1);

    }

    public void copyArray(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[i];
        }
    }
    public int removeDuplicates(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                nums[i - 1] = -102;
            }
        }

        int pnt = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -102) {
                pnt = i;
                break;
            }
        }
        if (pnt == -1) {
            return nums.length;
        }

        for (int i = pnt + 1; i < nums.length; i++) {
            if (nums[i] != -102) {
                swap(nums, i, pnt);
                pnt++;
            }
        }

        return pnt;
    }

    void swap(int[] arr, int idx, int idx2) {
        int tmp = arr[idx];
        arr[idx] = arr[idx2];
        arr[idx2] = tmp;
    }
    public void rotate(int[] nums, int k) {

        k=k%nums.length;

        reverse(nums,0,(nums.length-1)-k);
        reverse(nums,(nums.length-1)-k+1,nums.length-1);
        reverse(nums,0,nums.length-1);
    }

    void reverse(int nums[],int start,int end){
        while(start<=end) swap(nums,start++,end--);
    }
    public String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (pal(words[i]))
                return words[i];
        }
        return "";
    }

    public boolean pal(String word) {
        int i = 0, j = word.length() - 1;
        while (i <= j) {
            if (word.charAt(i++) != word.charAt(j--))
                return false;
        }
        return true;
    }
    public int[] sortArrayByParity(int[] nums) {
        int i = -1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 != 0) {
                i = j;
                break;
            }
        }
        if (i == -1) {
            return nums;
        }

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] % 2 == 0) {
                swap(nums, i, j);
                i++;
            }
        }

        return nums;
    }
    public String reverseWords(String s) {

        int start = 0, end = 0;
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                end = i;
                reverse(builder, start, end - 1);
                start = end + 1;
            }
        }
        reverse(builder, start, s.length() - 1);

        return builder.toString();
    }

    void reverse(StringBuilder builder, int start, int end) {
        while (start < end) {
            char ch = builder.charAt(start);
            builder.setCharAt(start++, builder.charAt(end));
            builder.setCharAt(end--, ch);
        }
    }
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;

        while (i <= j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }

        return new int[]{-1, -1};
    }
