import java.math.BigInteger;
class Solution {
    public String addBinary(String a, String b) {
        BigInteger n1 = new BigInteger(a, 2);
        BigInteger n2 = new BigInteger(b, 2);
        BigInteger sum = n1.add(n2);
        return sum.toString(2);
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int res=0;
        for(int i=0;i<=nums.length;i++){
            res=res^i;
        }
        for(int i=0;i<nums.length;i++){
            res=res^nums[i];
        }
        return res;
    }
}
class Solution {
    public int singleNumber(int[] nums) {
        var res=nums[0];
        for(var i=1;i<nums.length;i++)
            res=res^nums[i];

        return res;
    }

}
