public class Solution {
    public static int[] closestPrimes(int left, int right) {
        // Step 1: Use Sieve of Eratosthenes to find all prime numbers up to 10^6
        int limit = 1000000;
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 2: Collect all prime numbers in the given range
        List<Integer> primes = new ArrayList<>();
        for (int i = Math.max(left, 2); i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // Step 3: Find the closest prime pair
        if (primes.size() < 2) return new int[]{-1, -1}; // No valid pair

        int minDiff = Integer.MAX_VALUE;
        int num1 = -1, num2 = -1;

        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                num1 = primes.get(i - 1);
                num2 = primes.get(i);
            }
        }

        return new int[]{num1, num2};
    }

    // public static void main(String[] args) {
    //     int left = 10, right = 19;
    //     System.out.println(Arrays.toString(closestPrimes(left, right))); // Output: [11, 13]

    //     left = 4;
    //     right = 6;
    //     System.out.println(Arrays.toString(closestPrimes(left, right))); // Output: [-1, -1]
    // }
}
