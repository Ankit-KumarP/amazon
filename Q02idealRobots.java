// // (07/05/2024, 12:10 AM)
// A robot is said to be idle if it has a robot located above, below withX, and right of it, it is guaranteed that no two robots are at the same location. Given locations of n robots find the number of ideal robots.
package amazon;

import java.util.*;
import java.lang.*;

public class Q02idealRobots {

    // LOGIC:
    // (I) USING HASH MAP OF <INTEGER, List <Integer>> type.
    // (II) USE OF '2' HASH MAP, FIRST HASH MAP KEEP PAIR OF (X,Y) SECOND HASH MAP
    // KEEP PAOR OF (Y,X).
    // T = O(n) | S = O(n)

    public static int idealRobots(int x[], int y[]) {

        int n = x.length;
        Map<Integer, List<Integer>> withY = new HashMap<>();
        Map<Integer, List<Integer>> withX = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!withY.containsKey(y[i])) {
                withY.put(y[i], new ArrayList());
                withY.get(y[i]).add(x[i]);
            } else {
                withY.get(y[i]).add(x[i]);
            }
            if (!withX.containsKey(x[i])) {
                withX.put(x[i], new ArrayList());
                withX.get(x[i]).add(y[i]);
            } else {
                withX.get(x[i]).add(y[i]);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {

            if (withX.get(x[i]).size() < 3 || withY.get(y[i]).size() < 3) {
                continue;
            }
            if (min(withX.get(x[i])) < y[i] && max(withX.get(x[i])) > y[i] && min(withY.get(y[i])) < x[i]
                    && max(withY.get(y[i])) > x[i]) {
                System.out.println(x[i] + " " + y[i]);
                count++;
            }
        }

        return count;

    }

    // min
    static int min(List<Integer> arr) {
        int min = Integer.MAX_VALUE;

        for (int i : arr) {
            min = Math.min(i, min);
        }
        return min;
    }

    // max
    static int max(List<Integer> arr) {
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            max = Math.max(i, max);
        }
        return max;
    }

    public static void main(String[] args) {

        // int[] x = { 1, 1, 1, 2, 2, 2, 2, 3, 3, 3 };
        // int[] y = { 1, 2, 3, 1, 2, 3, 5, 1, 2, 3 }; // 2

        // int [] x = {0,0,0,0,0,1,1,1,2,-1,-1,-2,-1};
        // int [] y = {-1,0,1,2,-2,0,1,-1,0,1,-1,0,0}; //5

        int[] x = { 0, -1, 0, 0, 3, 5, 4, 4, 4 };
        int[] y = { 0, 0, 1, -1, 0, 0, 1, -1, 0 }; // 2

        int ans = idealRobots(x, y);
        System.out.println(ans);

    }
}
