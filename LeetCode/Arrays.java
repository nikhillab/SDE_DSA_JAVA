    public boolean containsDuplicate(int[] nums) {
        var map= new HashMap<Integer,Integer>();
        for (int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else
                map.put(num,1);
        }
        for (Map.Entry<Integer, Integer> ent : map.entrySet()) {
            if(ent.getValue()>1){
                return true;
            }
        }
        return false;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map= new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(map.get(target-nums[i])==null)
                map.put(nums[i],i);
            else{
                return new int[]{i,map.get(target-nums[i])};
            }
        }
           

        return new int[]{-1,-1};
        
    }

    public boolean isAnagram(String s, String t) {
        int[] arr = new int[257];

        for (var c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        for (var c : t.toCharArray()) {
            arr[c - 'a']--;
        }

        for (int count : arr) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public int[] getConcatenation(int[] nums) {
        int ans[]= new int [(nums.length*2)];

        for(int i =0; i<nums.length;i++){
            ans[i]=nums[i];
            ans[i+(nums.length)]=nums[i];
        }

        return ans;
    }

    public int[] replaceElements(int[] arr) {
        int res[] = new int[arr.length];
        int leader = arr[arr.length - 1];
        res[arr.length-1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (leader > arr[i]) {
                res[i] = leader;
            } else {
                res[i] = leader;
                leader = arr[i];
            }
        }

        return res;
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int n = s.length();
        int m = t.length();

        while (n > i && m > j) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        if (n == i)
            return true;
        return false;
    }

    public int lengthOfLastWord(String s) {
        s=s.trim();
        var words=s.split(" ");

        return words[words.length-1].length();
    }

    public int removeElement(int[] nums, int val) {
        int idx = -1;
        int count = 0;
        // got the first occ
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                idx = i;
                count++;
                break;
            }
        }

        if(idx==-1){
            return nums.length;
        }

        for (int i = idx + 1; i < nums.length; i++) {
            if(nums[i]==val)
                count++;

            if (nums[i] != val) {
                // swap nums[i] and nums[idx]
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                idx++;
            }

            
        }

        // System.out.println(Arrays.toString(nums));

        return nums.length - count;
    }

    public int search(int[] nums, int target) {
        int idx = -1;

        int low = 0, high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low=mid+1;
            }

        }

        return idx;
    }
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if (strs.length == 0) {
            return res;
        }
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                // return didn't match
                // System.out.println(i+" "+strs[j].length() + " " + strs[0].charAt(i) + " " +
                // strs[j].charAt(i));

                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return res;
                }
            }
            // add to res
            res += strs[0].charAt(i);
            // System.out.println(res);
        }

        return res;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs) {
            var arr = s.toCharArray();
            Arrays.sort(arr);
            var key = new String(arr);
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList<>() {
                    {
                        add(s);
                    }
                });
            } else {
                res.get(key).add(s);
            }
        }
        return new ArrayList<>(res.values());
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        // // 0 [4,3,2,7,8,2,3,1]
        // // 1 [-1,3,2,4,8,2,3,1] t=7
        // // 2 [-1,2,3,4,8,2,3,1] t=7
        // // 3 [-1,2,3,4,8,2,3,1]
        // // 4 [-1,2,3,4,8,2,3,1]
        // // 5 [-1,2,3,4,-1,2,3,1] t=7,8
        // // 6 [-1,2,3,4,-1,-1,3,1] t=7,8
        // // 7 [-1,2,3,4,-1,-1,7,1] t=8
        // // 8 [1,2,3,4,-1,-1,7,8] t
        // Set<Integer> temps = new TreeSet<>();
        // for (int i = 1; i <= nums.length; i++) {
        //     if (nums[i - 1] != i) {
        //         int temp = nums[i - 1];
        //         nums[i - 1] = -1;
        //         if (temps.contains(i)) {
        //             temps.remove(i);
        //             nums[i - 1] = i;
        //         }
        //         temps.add(nums[temp - 1]);
        //         nums[temp - 1] = temp;
        //     }
        // }
        // for (int num : temps) {
        //     if (num > 0) {
        //         nums[num - 1] = num;
        //     }
        // }

        // List<Integer> res = new ArrayList<>();
        // for (int i = 1; i <= nums.length; i++) {
        //     if (nums[i - 1] == -1) {
        //         res.add(i);
        //     }
        // }

        // return res;

        boolean[] isAvailable = new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            isAvailable[nums[i]-1] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<isAvailable.length;i++){
            if(!isAvailable[i]){
                ans.add(i+1);
            }
        }
        return ans;
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapping = new HashMap<>();
        Set<Character> tracker= new HashSet<>();
        for (int i = 0; i < s.toCharArray().length; i++) {

            if (mapping.containsKey(s.charAt(i))) {
                if(mapping.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else {
                if(tracker.contains(t.charAt(i))){
                    return false;
                }
                mapping.put(s.charAt(i),t.charAt(i));
                tracker.add(t.charAt(i));
            }
        }
        // System.out.println(mapping);


        return true;  
    }

    public int arraySign(int[] nums) {
        int product = Arrays.stream(nums).map(num->Integer.compare(num, 0)).reduce(1, (elm, el) -> elm * el);
        if (product == 0)
            return 0;
        else if(product>0)
            return 1;
        else
            return -1;

    }

public void moveZeroes(int[] arr) {
        int ptr = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                ptr = i;
                break;
            }
        }
        if (ptr == -1) {
            return ;
        }
        for (int i = ptr + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr, i, ptr);
                ptr++;

            }
        }
    }

    void swap(int[] arr, int idx, int idx2) {
        int tmp = arr[idx];
        arr[idx] = arr[idx2];
        arr[idx2] = tmp;
    }
