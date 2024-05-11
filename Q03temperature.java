// (07/05/2024, 20:45)
// Given the change in temperature data of n days, the aggregate temperature change evaluated on the ith day is the maximum of the sum of the changes in temperatures until the ith day, and the sum of the change in temperatures in the next (n- i) days, with the ith day temperature change included in both.
// Given the temperature data of n days, find the maximum aggregate temperature change evaluated among all the days.
// Example
// temperature change = {6,-2,5};  //9 
// maximum change in each days (9,4,9), maximum value in this is '9'.
package amazon;

public class Q03temperature {

    // LOGIC:
    // (I) USING TWO VARIABLE 'PREV' THAT KEEP SUM OF ALL PREVIOUS ELEMENT TILL
    // INDEX 'I'. 'AFTER' IT WILL KEEP SUM OF ALL VARIABLE THAT IS AFTER INDEX 'I.
    // T = O(N) | S = O(1)

    // function
    public static long maxChange(int arr[]) {

        long answer = Long.MIN_VALUE;
        int n = arr.length;

        long prev = arr[0];
        long after = 0;
        for (int i : arr) {
            after += i;
        }
        answer = Math.max(prev, after);
        for (int i = 1; i < n; i++) {
            prev += arr[i];
            after -= arr[i - 1];
            answer = Math.max(Math.max(prev, after), answer);
        }

        return answer;

    }

    public static void main(String[] args) {

        // int []arr = {6,-2,5}; //9;
        // int[] arr = { -1, 2, 3 }; // 5
        // int[] arr = { -6, -7, -8, 1, -6 }; // -5
        int[] arr = { -1, 2, 3 }; // 5

        long ans = maxChange(arr);
        System.out.println(ans);

    }
}