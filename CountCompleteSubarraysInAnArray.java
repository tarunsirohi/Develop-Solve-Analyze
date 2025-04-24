class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int num : nums) {
            uniqueElements.add(num);
        }
        int uniqueCount = uniqueElements.size();
        
        int left = 0;
        int right = 0;
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        int completeSubarrays = 0;
        
        while (left < n) {
            while (right < n && freq.size() < uniqueCount) {
                freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
                right++;
            }
            if (freq.size() < uniqueCount) {
                break;
            }
            
            completeSubarrays += n - right + 1;
            
            // Remove left
            freq.put(nums[left], freq.get(nums[left]) - 1);
            if (freq.get(nums[left]) == 0) {
                freq.remove(nums[left]);
            }
            left++;
        }
        return completeSubarrays;
    }
}