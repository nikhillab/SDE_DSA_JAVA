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
