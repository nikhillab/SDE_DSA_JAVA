class Solution {
    public int search(int[] nums, int target) {
        int idx=-1;
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target)
                return mid;

//             [4,5,6,7,0,1,2], target = 0

            if (nums[mid] >= target) {
                if (nums[mid] >= nums[low] && nums[low] > target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (nums[mid] < nums[high] && nums[high] < target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }
      public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target || nums[low]==target || nums[high]==target)
                return true;

            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low++;
                high--;
            } else if (nums[mid] >= target) {
                if (nums[mid] >= nums[low] && nums[low] > target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (nums[mid] < nums[high] && nums[high] < target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return false;
    }
}
