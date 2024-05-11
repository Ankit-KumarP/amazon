// (07/05/2024, 22:02)
// The value of the k-repetitiveness feature for the string user_history is defined as the maximum number of substrings of the given string such that some  character in that substring appeared at least k times.
// Find the value of the k-repetitiveness feature for the given string user_history
// Example:  String = "ceccca"; k = 3  // 7

package amazon;

import java.util.*;
import java.lang.*;

public class Q04substringFeature {

    // LOGIC
    // (I) SLIDING WINDOW APPROACH BY TAKING TWO POINTER SLOW AND FAST.
    // T = O(N) | S = O(N)

    // function
    public static int totalNumber(String s, int k) {

        int n = s.length();
        if (k == 0)
            return 0;
        if (k == 1) {
            int ans = 1;
            for (int i = 2; i <= n; i++) {
                ans *= i;
                return ans;
            }
        }
        Map<Character, Integer> hm = new HashMap<>();
        int maxF = 0, answer = 0;

        int slow = 0, fast = 0;

        while (fast < n) {

            if (maxF == k) {
                answer = answer + (n - (fast - 1));
                if (s.charAt(fast - 1) == s.charAt(slow)) {
                    maxF--;
                }
                int val = hm.get(s.charAt(slow)) - 1;
                hm.put(s.charAt(slow), val);
                slow++;
            } else {
                int val = hm.getOrDefault(s.charAt(fast), 0) + 1;
                hm.put(s.charAt(fast), val);
                maxF = Math.max(maxF, val);
                fast++;
            }
        }

        return answer;

    }

    public static void main(String[] args) {

        // String s = "ceccca";
        // int k = 3; //7

        // String s = "acaab";
        // int k = 3; //2

        String s = "accad";
        int k = 2; // 6

        int ans = totalNumber(s, k);
        System.out.println(ans);

    }
}