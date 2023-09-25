package day01cachingfibonacci;

import java.util.HashMap;
import java.util.Map;

public class Day01CachingFibonacci {

    private static HashMap<Integer, Long> fibsCached = new HashMap<>();
    private boolean isCacheOn;

    public Day01CachingFibonacci(boolean cacheOn) {
        isCacheOn = cacheOn;
        if (isCacheOn) {
            fibsCached.put(0, 0L); // #0
            fibsCached.put(1, 1L); // #1
        }
    }
    
    private int fibsCompCount = 2;
    
    public long getNthFib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("No negative fibonacci exist");
        }
        return computeNthFib(n);
    }
    
    private long computeNthFib(int n) {
        if (isCacheOn && fibsCached.containsKey(n)) {
            return fibsCached.get(n);
        }
        if (n <= 1) { // 0 => 0, 1 => 1
            return n;
        }
        fibsCompCount++;
        long NthFib = computeNthFib(n - 1) + computeNthFib(n - 2);
        if (isCacheOn) {
            fibsCached.put(n,NthFib); // remember the fib you just computed
        }
        return NthFib;
    }

    public int getCountOfFibsComputed() {
        return fibsCompCount;
    }

    // returns all cached Fib values, comma-space-separated on a single line
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<Integer, Long> entry : fibsCached.entrySet()) {
            if (first) {
                result.append(String.format("%d", entry.getValue()));
                first = false;
            } else {
                result.append(String.format(", %d", entry.getValue()));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        final int n = 50;
        Day01CachingFibonacci f1 = new Day01CachingFibonacci(false);
        Day01CachingFibonacci f2 = new Day01CachingFibonacci(true);
        System.out.println("Non-cached fibonacci, 50th item:");
        long startTime1 = System.currentTimeMillis();
        System.out.println(f1.getNthFib(n));
        System.out.println("Time passed (miliseconds): " + (System.currentTimeMillis() - startTime1));
        long startTime2 = System.currentTimeMillis();
        System.out.println("Cached fibonacci, 50th item:");
        System.out.println(f2.getNthFib(n));
        System.out.println("Time passed (miliseconds): " + (System.currentTimeMillis() - startTime2));
        System.out.println("Done");
    }
}
