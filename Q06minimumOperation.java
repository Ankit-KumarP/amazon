// (09/05/2024, 17:26)
// you are given a binary string. Find the minimum number of operations required to reverse it. An operation is defined as :
// Remove a character from any index and append it to the end of the string.

// Eg :
// S = "00110101"
// 00110101 - 00101011 (index 3 was appended at the end)
// 00101011 - 01010110 (index 0 was appended at the end)
// 01010110 - 10101100 (index 0 was appended at the end)
// so the answer here is 3 operations

// constraints : 1<S.length<=1e5

package amazon;
import java.util.*;
import java.lang.*;
public class Q06minimumOperation{

    // Logic:
    // (I) ANSWER IS  (LENGTH OF STRING - LENGTH OF LONGEST PREFIX OF REVERSE ARRAY THAT IS A SUBSEQUENCE OF ORIGINAL ARRAY )
    // T = O(N) |  S = O(N)

    
    // function
    public static int minimumOperation(String s){

        String rev = "";
        int n = s.length(), ptr = n-1;

        while(ptr >= 0){
            rev = rev + s.charAt(ptr);
            ptr--;
        }

        int longestPrefix = 0;
        for(int i = 0;i<n;i++){
            if(s.charAt(i) == rev.charAt(longestPrefix)){
                longestPrefix++;
            }
        }

        return n - longestPrefix;

    }
    public static void main(String[] args){

        String s = "00110101";  // 3
        int ans = minimumOperation(s);
        System.out.println(ans);

    }
}