package utils;

import java.util.*;

public class Utils {

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public long lcm(int a, int b) {
        return (long) a * b / gcd(a, b);
    }

    public long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public long modLcm(long a, long b, long m) {
        return modDiv(modMul(a, b, m), gcd(a, b), m);
    }

    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    public boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public Map<Character,Integer> countOccurrences(String str) {
        Map<Character,Integer> count = new HashMap<>();
        for (char ch : str.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        return count;
    }

    public Map<Integer,Integer> countOccurrences(int[] arr) {
        Map<Integer,Integer> count = new HashMap<>();
        for (int a : arr) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }
        return count;
    }

    public Map<Integer,Integer> countOccurrences(int[][] mat) {
        Map<Integer,Integer> count = new HashMap<>();
        for (int[] arr : mat) {
            for (int a: arr) {
                count.put(a, count.getOrDefault(a, 0) + 1);
            }
        }
        return count;
    }

    public Map<Long,Integer> countOccurrences(long[] arr) {
        Map<Long,Integer> count = new HashMap<>();
        for (long a : arr) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }
        return count;
    }

    public void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }

    public void reverse(long[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            long temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }

    public int findMax(int... arr) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    public long findMax(long... arr) {
        long max = arr[0];
        for (long num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    public int findMin(int... arr) {
        int min = arr[0];
        for (int num : arr) {
            min = Math.min(min, num);
        }
        return min;
    }

    public long findMin(long... arr) {
        long min = arr[0];
        for (long num : arr) {
             min = Math.min(min, num);
        }
        return min;
    }

    public int lower_bound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int lower_bound(int low, int high, int[] arr, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int upper_bound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int upper_bound(int low, int high, int[] arr, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int lower_bound(List<Integer> arr, int target) {
        int low = 0, high = arr.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int lower_bound(int low, int high, List<Integer> arr, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int upper_bound(List<Integer> arr, int target) {
        int low = 0, high = arr.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int upper_bound(int low, int high, List<Integer> arr, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean[] sieve(int n) {
        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= n; j += i) {
                    sieve[j] = false;
                }
            }
        }
        return sieve;
    }

    public int modAdd(int a, int b, int m) {
        return ((a % m) + (b % m)) % m;
    }

    public int modSub(int a, int b, int m) {
        return ((a % m) - (b % m) + m) % m;
    }

    public int modMul(int a, int b, int m) {
        return ((a % m) * (b % m)) % m;
    }

    public int power(int x, int y, int p) {
        int res = 1;
        x = x % p;
        if (x == 0)
            return 0;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    // Assumption: m is prime
    public int modInverse(int a, int m) {
        return power(a, m - 2, m);
    }

    public int modDiv(int a, int b, int m) {
        a = a % m;
        int inv = modInverse(b, m);
        return (inv * a) % m;
    }

    public long modAdd(long a, long b, long m) {
        return ((a % m) + (b % m)) % m;
    }

    public long modSub(long a, long b, long m) {
        return ((a % m) - (b % m) + m) % m;
    }

    public long modMul(long a, long b, long m) {
        return ((a % m) * (b % m)) % m;
    }

    public long power(long x, long y, long p) {
        long res = 1;
        x = x % p;
        if (x == 0)
            return 0;
        while (y > 0) {
            if ((y & 1L) == 1)
                res = (res * x) % p;
            y = y >> 1L;
            x = (x * x) % p;
        }
        return res;
    }

    // Assumption: m is prime
    public long modInverse(long a, long m) {
        return power(a, m - 2, m);
    }

    public long modDiv(long a, long b, long m) {
        a = a % m;
        long inv = modInverse(b, m);
        return (inv * a) % m;
    }

    public long nCr(long n, long r, long mod) {
        long numerator = 1;
        long denominator = 1;
        for (int i = 0; i < r; i++) {
            numerator = (numerator * (n - i)) % mod;
        }
        for (int i = 1; i <= r; i++) {
            denominator = (denominator * i) % mod;
        }
        return (numerator * modInverse(denominator, mod)) % mod;
    }

    public int[] getIntArray(Collection<Integer> collections) {
        int n = collections.size();
        var it = collections.iterator();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = it.next();
        }
        return arr;
    }

    public long[] getLongArray(Collection<Long> collections) {
        int n = collections.size();
        var it = collections.iterator();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = it.next();
        }
        return arr;
    }

    public long[] factorial(int n, int mod) {
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
            fact[i] %= mod;
        }
        return fact;
    }

    public long[] factorialInv(int n, int mod) {
        long[] factInv = factorial(n, mod);
        for (int i = 0; i <= n; i++) {
            factInv[i] = modInverse(factInv[i], mod);
        }
        return factInv;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
