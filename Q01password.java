// (07/05/2024, 12:09 AM)
// The developers at Amazon employ several algorithms for encrypting passwords. In one algorithm, the developers aim to encrypt palindromic passwords. Palindromic passwords are ones that read the same forward and backward.
// The algorithm rearranges the characters to have the following characteristics:
// It is a rearrangement of the original palindromic password.
// It is also a palindrome.
// Among all such palindromic rearrangements. It is the lexicographically smallest.
// Given the original palindromic password that consists of lowercase English characters only, find the encrypted password.
// EXAMPLE:
//  S = babab  //  abbba
package amazon;

import java.util.*;
import java.lang.*;

public class Q01password {
    // LOGIC:
    // (I)USE FREQUENCY ARRAY AS A SORTED ARRAY THAT HAS FREQUENCY OF ALL CHARACTER
    // PRESENT IN STRING.
    // (II) TILL EVEN NUMBER OF OCCOURANCES ADD CHARACTER AT START AND END
    // SIMULTIONOUSLY.
    // (II) LASTLY ADD ALL ODD OCCOURANCES IN SORTED ORDER
    // T = O(N) | S = O(26)

    public static String encryptedPassword(String s) {

        int n = s.length();
        char[] ans = new char[n];
        int[] frq = new int[26];

        for (int i : s.toCharArray()) {
            frq[i - 'a']++;
        }

        int low = 0, high = n - 1;
        for (int i = 0; i < 26; i++) {
            if (frq[i] > 0) {
                char temp = (char) (i + 'a');
                int val = frq[i] - (frq[i] % 2);
                frq[i] = frq[i] % 2;
                int ptr = 0;
                while (ptr < (val / 2)) {
                    ans[low++] = temp;
                    ans[high--] = temp;
                    ptr++;
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if (frq[i] >= 0) {
                char temp = (char) (i + 'a');
                int ptr = 0;
                while (ptr < frq[i]) {
                    ans[low++] = temp;
                    ptr++;
                }
            }
        }

        return String.valueOf(ans);

    }

    public static void main(String[] args) {

        // String s = "yxxy"; // xyyx
        // String s = "ded"; // ded
        // String s = "babab"; // abbba
        // String s = "malayalam"; // aalmymlaa
        // String s = "evilisanameofafoemanasilive"; // aaeefiilmnosvavsonmliifeeaa
        String s = "deedoodooddeedoodooddeedoodooddeedoodoodeed"; //
        // ddddddddeeeeeoooooooodooooooooeeeeedddddddd

        String ans = encryptedPassword(s);
        System.out.println(ans);

    }
}
