class Solution {
    public int pivotIndex(int[] nums) {
        int backwardsSum = 0;
        int[] arr = new int[nums.length + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            arr[i] += arr[i - 1] + nums[i - 1];
        }
        int index = -1;
        for (int i = arr.length - 1; i > 0; i--) {
            if (backwardsSum == arr[i - 1]) {
                index = i - 1;
            }
            backwardsSum += nums[i - 1];
        }
        return (index != -1) ? index : -1;
    }
}