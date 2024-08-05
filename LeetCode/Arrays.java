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
