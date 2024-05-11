// (07/05/2024. 22 :15)
// Find the power of each possible contiguous group of servers.
// ex- [2,1,3] - 27
// explanation -
// power[0,0] = min(2)*sum([2]) = 4
// power[0,1] = min(2,1)*sum([2,1]) = 3
// power[0,2] = min(2,1,3)*sum([2,1,3]) =6
// power[1,1] = min(1)*sum(1) = 1
// power[1,2] = min(1,3)*sum([1,3]) = 4
// power[2,2] = min(3)*sum([3]) = 9

// overall sum = 27

package amazon;

public class Q05serverpower {

    // LOGIC:
    // (I) USING CURRENT SUM TILL 'I' AND CURRENT MIN TILL 'I' VARUABLE FOR EACH
    // CONTIGUOUS GROUP POSSIBLE.
    // T = O(N^2) | S = O(1)

    // function
    public static int power(int arr[]) {

        int n = arr.length;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int cSum = 0, cMin = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                cSum += arr[j];
                cMin = Math.min(cMin, arr[j]);
                answer = answer + (cSum * cMin);
            }
        }

        return answer;

    }

    public static void main(String[] args) {

        int[] arr = { 2, 1, 3 }; // 27
        int ans = power(arr);
        System.out.println(ans);
    }

}