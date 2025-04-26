class Solution {
    public long countInterestingSubarrays(int[] nums, int modulo, int k) {
        long n = nums.length;
        long pos = 0;
        long interesting_subarrays = 0;
        long prefix_count = 0;

        HashMap<Long, Long> mod_freq = new HashMap<>();
        mod_freq.put(0L, 1L);
        while (pos < n) {
            if (nums[(int)pos] % modulo == k)
                prefix_count++;
            
            prefix_count %= modulo;
            long key = (prefix_count - k + modulo) % modulo;
            if (mod_freq.containsKey(key))
                interesting_subarrays += mod_freq.get(key);
            
            mod_freq.put(prefix_count, mod_freq.getOrDefault(prefix_count, 0L) + 1);
            pos++;
        }
        return interesting_subarrays;
    }
}